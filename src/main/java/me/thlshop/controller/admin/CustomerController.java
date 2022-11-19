package me.thlshop.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.constant.SystemConstant;
import me.thlshop.service.IRoleService;
import me.thlshop.service.IUserService;
import me.thlshop.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-customer"})
public class CustomerController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService userService;
	
	@Inject
	private IRoleService roleService;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "";
		String type = request.getParameter("type");
		String userId = request.getParameter("userId");
		if(type.equals(SystemConstant.LIST)) {
			request.setAttribute(SystemConstant.MODEL, userService.findAll());
			url = "views/admin/customer/customer.jsp";
		}else if(type.equals(SystemConstant.EDIT)) {
			if(userId != null) {
				request.setAttribute("USER", userService.findOne(Integer.parseInt(userId)));
			}
			url = "views/admin/customer/editCustomer.jsp";
		}
		MessageUtil.showMessage(request);
		
		request.setAttribute("role", roleService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
