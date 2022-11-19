package me.thlshop.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.thlshop.dto.OrderDTO;
import me.thlshop.service.IOrderService;
import me.thlshop.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-order"})
public class OrderAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IOrderService orderService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		OrderDTO orderDTO = HttpUtil.of(request.getReader()).toModel(OrderDTO.class);
		orderService.update(orderDTO);
		mapper.writeValue(response.getOutputStream(), "Thanh cong");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		OrderDTO orderDTO = HttpUtil.of(request.getReader()).toModel(OrderDTO.class);
		orderService.delete(orderDTO.getOrderId());
		mapper.writeValue(response.getOutputStream(), "thanhcong");
	}
}
