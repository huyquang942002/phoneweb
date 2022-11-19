package me.thlshop.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.converter.ProductConverter;
import me.thlshop.dto.CartDTO;
import me.thlshop.dto.ProductDTO;
import me.thlshop.entity.ProductEntity;
import me.thlshop.service.ICartService;
import me.thlshop.service.IImageService;
import me.thlshop.service.IProductService;
import me.thlshop.utils.SesstionUtil;

@WebServlet(urlPatterns = { "/cart" })
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IProductService productService;
	
	@Inject
	private ProductConverter productConverter;

	@Inject
	private ICartService cartSevlet;
	
	@Inject
	private IImageService imageService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listImage", imageService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("views/web/cart.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		CartDTO cart = (CartDTO) SesstionUtil.getInstance().getValue(request, "cart");
		if (SesstionUtil.getInstance().getValue(request, "USERMODEL") == null) {
			response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
		} else if (action == null) {
			if (productId != null) {
				ProductEntity prod = productService.findOne(productId);
				ProductDTO product = productConverter.toDto(prod);
				cart = cartSevlet.addProductToCart(cart, product, quantity);
				SesstionUtil.getInstance().putValue(request, "cart", cart);
			}
			SesstionUtil.getInstance().putValue(request, "totalSum", cart.getSumTotal());
			SesstionUtil.getInstance().putValue(request, "sumQuantity", cart.getSumQuantity());
			response.sendRedirect(request.getContextPath() + "/product-detail?productId=" + productId);
		} else if (action.equals("editQuantity")) {
			ProductEntity prod = productService.findOne(productId);
			ProductDTO product = productConverter.toDto(prod);
			cartSevlet.editQuantity(cart, product, quantity);
			SesstionUtil.getInstance().putValue(request, "totalSum", cart.getSumTotal());
			SesstionUtil.getInstance().putValue(request, "sumQuantity", cart.getSumQuantity());
			this.doGet(request, response);
		} else if (action.equals("deleteProduct")) {
			cartSevlet.deleteFromCart(cart, productId);
			SesstionUtil.getInstance().putValue(request, "sumQuantity", cart.getSumQuantity());
			SesstionUtil.getInstance().putValue(request, "totalSum", cart.getSumTotal());
			this.doGet(request, response);
		}
	}
}
