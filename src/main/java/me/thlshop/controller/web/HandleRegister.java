package me.thlshop.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.dto.UserDTO;
import me.thlshop.service.IUserService;
import me.thlshop.utils.EmailUtil;
import me.thlshop.utils.SesstionUtil;

@WebServlet(urlPatterns = { "/verify-email" })
public class HandleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	@Inject
	private IUserService userService;
	
	private String host;
	private String port;
	private String userName;
	private String password;

	public void init() {
		ServletContext context = getServletContext();
		this.host = context.getInitParameter("host");
		this.port = context.getInitParameter("port");
		this.userName = context.getInitParameter("userName");
		this.password = context.getInitParameter("password");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String code = EmailUtil.getRandomCode();
		SesstionUtil.getInstance().putValue(request, "codeVerify", code);
		
		UserDTO user = (UserDTO) SesstionUtil.getInstance().getValue(request, "userNeedVerify");
		Boolean isSuccess;
		try {
			String list = "Please verify your account using this code: " + code;

			isSuccess = EmailUtil.sendEmail(host, port, userName, password, user.getEmail(), "Verify email at THLShop",
					list);
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		}
		if (isSuccess) {
			RequestDispatcher rd = request.getRequestDispatcher("views/verifyEmail.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/dang-nhap?action=signup&message=singup_err&alert=danger");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codeVerifyEmail = request.getParameter("codeVerifyEmail");
		UserDTO user = (UserDTO) SesstionUtil.getInstance().getValue(request, "userNeedVerify");
		String code = (String) SesstionUtil.getInstance().getValue(request, "codeVerify");
		if(codeVerifyEmail == code || codeVerifyEmail.equals(code)) {
			if(user != null) {
				userService.save(user);
				SesstionUtil.getInstance().removeValue(request, "codeVerify");
				SesstionUtil.getInstance().removeValue(request, "userNeedVerify");
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=singup_success&alert=success");
			}
			
		}else {
			String message = "error_code";
			String alert = "danger";
			if(message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("views/verifyEmail.jsp");
			rd.forward(request, response);
		}
	}
}