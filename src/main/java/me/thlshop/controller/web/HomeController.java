package me.thlshop.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.entity.UserEntity;
import me.thlshop.service.IImageService;
import me.thlshop.service.IProductService;
import me.thlshop.service.IUserService;
import me.thlshop.utils.CookieUtil;
import me.thlshop.utils.FormUtil;
import me.thlshop.utils.SesstionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/dang-ky", "/logout"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService userService;
	
	@Inject
	private IProductService productService;
	
	@Inject
	private IImageService imageService;
	

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("listProduct", productService.findProductOutstanding());
		request.setAttribute("listImage", imageService.findAll());
		Cookie[] cookies = request.getCookies();
		String userIdCookie = CookieUtil.getCookieValue(cookies, "UserIdCookie");
		String action = request.getParameter("action");
		if(action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if(message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
			rd.forward(request, response);
		}else if(action != null && action.equals("signup")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if(message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("views/signup.jsp");
			rd.forward(request, response);
		}else if (action != null && action.equals("logout")){
			SesstionUtil.getInstance().removeValue(request, "USERMODEL");
			SesstionUtil.getInstance().removeValue(request, "totalSum");
			SesstionUtil.getInstance().removeValue(request, "cart");
			if(cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					cookie.setMaxAge(0);
		            response.addCookie(cookie);
				}
			}
			response.sendRedirect(request.getContextPath()+"/trang-chu");
		}else {
			if(userIdCookie == null || userIdCookie.equals("")) {
				
			}else {
				UserEntity userModel = userService.findOne(Integer.parseInt(userIdCookie));
				if(userModel != null) {
					SesstionUtil.getInstance().putValue(request, "USERMODEL", userModel);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Login thi`xu? ly' o? day

		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		Cookie[] cookies = request.getCookies();
		String userIdCookie = CookieUtil.getCookieValue(cookies, "UserIdCookie");
		if(action != null && action.equals("login")) {
			UserEntity userModel = FormUtil.toModel(UserEntity.class, request);
			userModel = userService.findByEmailPassword(userModel.getEmail(), userModel.getPassword());
			if(userModel != null) {
				SesstionUtil.getInstance().putValue(request, "USERMODEL", userModel);
				if(userIdCookie == null || userIdCookie.equals("")) {
					Cookie cookie = new Cookie("UserIdCookie",userModel.getUserId().toString());
					cookie.setMaxAge(60 * 60 * 24);
					response.addCookie(cookie);
				}
				if(userModel.getRole().getRoleName().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath()+"/admin-trang-chu");
				}else if(userModel.getRole().getRoleName().equals("USER")) {
					response.sendRedirect(request.getContextPath()+"/trang-chu");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=user_password_invalid&alert=danger");
			}
		}
	}
}
