package me.thlshop.controller.web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.converter.UserConverter;
import me.thlshop.dto.CartDTO;
import me.thlshop.dto.OrderDTO;
import me.thlshop.dto.UserDTO;
import me.thlshop.entity.UserEntity;
import me.thlshop.service.IOrderDetailService;
import me.thlshop.service.IOrderService;
import me.thlshop.utils.EmailUtil;
import me.thlshop.utils.SesstionUtil;

@WebServlet(urlPatterns = { "/payment" })
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IOrderService orderServlet;
	
	@Inject
	private IOrderDetailService orderDetailServlet;
	
	@Inject
	private UserConverter userConverter;
	
	private String host;
	private String port;
	private String userName;
	private String password;
	
	public void init() {
		ServletContext context = getServletContext();
		this.host = context.getInitParameter("host");
		this.port = context.getInitParameter("port");
		this.userName = context.getInitParameter("userName");
		this.password = context.getInitParameter("password");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SesstionUtil.getInstance().getValue(request, "USERMODEL");
		RequestDispatcher rd = request.getRequestDispatcher("views/web/payment.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		UserEntity userEntity = (UserEntity) SesstionUtil.getInstance().getValue(request, "USERMODEL");
		Long total = (Long) SesstionUtil.getInstance().getValue(request, "totalSum");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		CartDTO cart = (CartDTO) SesstionUtil.getInstance().getValue(request, "cart");

		if (address != null && phone != null && userEntity != null) {	
			Boolean isSuccess;
			try {
				String list = "Thanks for order: ";
				for(int i=0; i< cart.getCartDetails().size(); i++) {
						list += "x"+cart.getCartDetails().get(i).getQuantity()+" "+cart.getCartDetails().get(i).getProduct().getProductName()+ " - "+cart.getCartDetails().get(i).getTotal() +"VND";
						if(i < cart.getCartDetails().size() - 1) {
							list += ", ";
						}
				}
				
				isSuccess = EmailUtil.sendEmail(host, port, userName, password, 
						userEntity.getEmail(), "Order at THLShop", list);
				
				UserDTO userDTO = userConverter.toDto(userEntity);
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setUserId(userDTO.getUserId());
				orderDTO.setAddress(address);
				orderDTO.setOrderDate(new Timestamp(System.currentTimeMillis()));
				orderDTO.setPhone(phone);
				orderDTO.setTotal(total);
				orderDTO.setStatus(0);
				OrderDTO order =  orderServlet.save(orderDTO);
				orderDetailServlet.save(cart, order);
				
				SesstionUtil.getInstance().removeValue(request, "totalSum");
				SesstionUtil.getInstance().removeValue(request, "cart");
			}catch (Exception e) {
				e.printStackTrace();
				isSuccess = false;
			}
			if(isSuccess) {
				response.sendRedirect(request.getContextPath()+"/payment-thanks");
			}
		}
	}
}
