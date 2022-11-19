package me.thlshop.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.thlshop.dto.ImageDTO;
import me.thlshop.service.IImageService;
import me.thlshop.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-image"})
public class ImageAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IImageService imageService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		ImageDTO imageDTO = HttpUtil.of(request.getReader()).toModel(ImageDTO.class);
		imageService.delete(imageDTO.getImageId());
		mapper.writeValue(response.getOutputStream(), "thanhcong");
	}
}