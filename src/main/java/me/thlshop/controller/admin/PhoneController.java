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
import me.thlshop.service.ICategoryService;
import me.thlshop.service.IImageService;
import me.thlshop.service.IProductService;
import me.thlshop.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-phone"})
public class PhoneController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService productService;
	
	@Inject
	private ICategoryService categoryService;
	

	@Inject
	private IImageService imageService;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		String type = request.getParameter("type");
		String productId = request.getParameter("productId");
		if(type.equals(SystemConstant.LIST)) {
			request.setAttribute(SystemConstant.MODEL, productService.findAll());
			url = "views/admin/phone/phone.jsp";
		}else if(type.equals(SystemConstant.EDIT)) {
			if(productId != null) {
				request.setAttribute("PRODUCT", productService.findOne(Integer.parseInt(productId)));
			}
			url = "views/admin/phone/editPhone.jsp";
		}
		MessageUtil.showMessage(request);
		request.setAttribute("image", imageService.findAll());
		request.setAttribute("category", categoryService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
