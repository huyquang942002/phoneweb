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
import me.thlshop.service.IOrderDetailService;
import me.thlshop.service.IOrderService;
import me.thlshop.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-order"})
public class OrderController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOrderService orderService;
	
	@Inject
	private IOrderDetailService orderDetailService;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		String type = request.getParameter("type");
		String orderId = request.getParameter("orderId");
		if(type.equals(SystemConstant.LIST)) {
			request.setAttribute(SystemConstant.MODEL, orderService.findAll());
			url = "views/admin/order/order.jsp";
		}else if(type.equals(SystemConstant.EDIT)) {
			if(orderId != null) {
				request.setAttribute("orderDetail", orderDetailService.findByOrder(Integer.parseInt(orderId)));
			}
			url = "views/admin/order/editOrder.jsp";
		}else if(type.equals(SystemConstant.FILTER)){
			String status = request.getParameter("status");
			if(status.equals("0")) {
				request.setAttribute(SystemConstant.MODEL, orderService.findByStatus(Integer.parseInt(status)));
			}else if(status.equals("1")) {
				request.setAttribute(SystemConstant.MODEL, orderService.findByStatus(Integer.parseInt(status)));
			}else {
				request.setAttribute(SystemConstant.MODEL, orderService.findAll());
			}
			url = "views/admin/order/order.jsp";
		}
		MessageUtil.showMessage(request);
		
		request.setAttribute("OrderDetail", orderDetailService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}