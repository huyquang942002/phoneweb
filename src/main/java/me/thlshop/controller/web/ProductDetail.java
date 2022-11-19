package me.thlshop.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.dao.IProductDAO;
import me.thlshop.entity.ProductEntity;

@WebServlet(urlPatterns = { "/product-detail"})
public class ProductDetail extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductDAO productDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		if(productId != null) {
			ProductEntity product = productDao.findOne(productId);
			
			request.setAttribute("product", product);
			RequestDispatcher rd = request.getRequestDispatcher("views/web/productDetail.jsp");
			
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
