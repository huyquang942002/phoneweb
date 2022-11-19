package me.thlshop.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.thlshop.dto.ProductDTO;
import me.thlshop.dto.ProductDetailDTO;
import me.thlshop.service.IInformationService;
import me.thlshop.service.IProductService;
import me.thlshop.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-phone"})
public class PhoneAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductService productService;
	
	@Inject
	private IInformationService informationService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		ProductDetailDTO productDetailDTO = HttpUtil.of(request.getReader()).toModel(ProductDetailDTO.class);
		Integer infoId = informationService.save(productDetailDTO);
		
		productDetailDTO.setInfoId(infoId);
		productDetailDTO.setImageId(productDetailDTO.getImageId());
		
		productService.save(productDetailDTO);
		mapper.writeValue(response.getOutputStream(), "Thanh cong");
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		ProductDetailDTO productDetailDTO = HttpUtil.of(request.getReader()).toModel(ProductDetailDTO.class);
		informationService.update(productDetailDTO);
		productService.update(productDetailDTO);
		mapper.writeValue(response.getOutputStream(), "Thanh cong");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		ProductDTO productDTO = HttpUtil.of(request.getReader()).toModel(ProductDTO.class);
		productService.delete(productDTO.getProductId());
		mapper.writeValue(response.getOutputStream(), "thanhcong");
	}
}
