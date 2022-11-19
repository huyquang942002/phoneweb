package me.thlshop.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.service.IProductService;

@WebServlet(urlPatterns = { "/all-product-by-brand", "/all-product-by-category" })
public class AllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Inject
	private IProductService productService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brandId = request.getParameter("brandId");
		String categoryId = request.getParameter("categoryId");
		if (brandId != null) {
			request.setAttribute("products", productService.findByBrand(Integer.parseInt(brandId)));
		} else if (categoryId != null) {
			request.setAttribute("products", productService.findByCategory(Integer.parseInt(categoryId)));
		} else {
			String keyWord = request.getParameter("keyWord");
			if (keyWord != null) {
				request.setAttribute("products", productService.search(keyWord));
			} else {
				request.setAttribute("products", productService.findAll());
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("views/web/allProduct.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
