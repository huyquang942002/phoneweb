package me.thlshop.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.service.IOrderService;
import me.thlshop.service.IProductService;
import me.thlshop.service.IUserService;

@WebServlet(urlPatterns = {"/admin-dashboard"})
public class DashboardController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Inject
	private IOrderService orderService;
	
	@Inject
	private IUserService userService;
	
	@Inject
	private IProductService productService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("EARNING", orderService.getEarning());
		request.setAttribute("ORDERNUMBER", orderService.orderSuccessNumber());
		request.setAttribute("CUSTOMERNUMBER", userService.customerNumber());
		request.setAttribute("PRODUCTNUMBER", productService.productNumber());
		RequestDispatcher rd = request.getRequestDispatcher("views/admin/dashboard/dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
