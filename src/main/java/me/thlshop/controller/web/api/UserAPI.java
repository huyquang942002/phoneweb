package me.thlshop.controller.web.api;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.thlshop.dto.UserDTO;
import me.thlshop.entity.UserEntity;
import me.thlshop.service.IUserService;
import me.thlshop.utils.HttpUtil;
import me.thlshop.utils.SesstionUtil;

@WebServlet(urlPatterns = {"/api-user"})
public class UserAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		UserDTO userDTO = HttpUtil.of(request.getReader()).toModel(UserDTO.class);
		List<UserEntity> user = userService.findByEmail(userDTO.getEmail());
		if(user.size() > 0) {
			mapper.writeValue(response.getOutputStream(), "emailExisted");	
		}else {
			SesstionUtil.getInstance().putValue(request, "userNeedVerify", userDTO);
			mapper.writeValue(response.getOutputStream(), "thanhCong");		
		}
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		UserDTO userModel = HttpUtil.of(request.getReader()).toModel(UserDTO.class);
		userService.update(userModel);
		SesstionUtil.getInstance().putValue(request, "USERMODEL", userService.findOne(userModel.getUserId()));
		mapper.writeValue(response.getOutputStream(), "Thanh cong");
	}
}
