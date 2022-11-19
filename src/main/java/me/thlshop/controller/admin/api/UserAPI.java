package me.thlshop.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.thlshop.dto.UserDTO;
import me.thlshop.service.IUserService;
import me.thlshop.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		UserDTO userDTO = HttpUtil.of(request.getReader()).toModel(UserDTO.class);
		userService.save(userDTO);
		mapper.writeValue(response.getOutputStream(), "Thanh Cong");
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		UserDTO userModel = HttpUtil.of(request.getReader()).toModel(UserDTO.class);
		userService.update(userModel);
		mapper.writeValue(response.getOutputStream(), "Thanh cong");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		UserDTO shoeModel = HttpUtil.of(request.getReader()).toModel(UserDTO.class);
		userService.delete(shoeModel.getUserId());
		mapper.writeValue(response.getOutputStream(), "thanhcong");
	}
}