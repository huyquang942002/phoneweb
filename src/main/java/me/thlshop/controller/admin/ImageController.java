package me.thlshop.controller.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.thlshop.constant.SystemConstant;
import me.thlshop.entity.ImageEntity;
import me.thlshop.entity.ProductEntity;
import me.thlshop.service.IImageService;
import me.thlshop.service.IProductService;
import me.thlshop.utils.ImageUtil;
import me.thlshop.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-image" })
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IImageService imageService;
	
	@Inject
	private IProductService productService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		String type = request.getParameter("type");
		String imageId = request.getParameter("imageId");
		if (type.equals(SystemConstant.LIST)) {
			request.setAttribute(SystemConstant.MODEL, imageService.findAll());
			url = "views/admin/image/image.jsp";
		} else if (type.equals(SystemConstant.EDIT)) {
			if (imageId != null) {
				request.setAttribute("IMAGE", imageService.findOne(Integer.parseInt(imageId)));
			}
			url = "views/admin/image/editImage.jsp";
		}
		MessageUtil.showMessage(request);
		request.setAttribute("PRODUCT", productService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ServletContext sc = this.getServletConfig().getServletContext();
		String realPath = sc.getRealPath("/images/imageProduct");
		HashMap<String, String> fields = ImageUtil.mageHandle(request, realPath);

		if (fields.get("imageId") == null || fields.get("imageId").equals("")) {
			// Add
			ImageEntity imageEntity = new ImageEntity();
			imageEntity.setImageBig(fields.get("imageBig"));
			imageEntity.setImageSmall(fields.get("imageSmall"));
			imageService.save(imageEntity);
			response.sendRedirect(request.getContextPath()+"/admin-image?type=edit&message=insert_success");
		} else {
			// Update
			ImageEntity imageEntity = imageService.findOne(Integer.parseInt(fields.get("imageId")));
			if (fields.get("imageBig") == null || fields.get("imageBig").equals("")) {

			}else {
				imageEntity.setImageBig(fields.get("imageBig"));
			}
			if(fields.get("imageSmall") == null || fields.get("imageSmall").equals("")){
				
			}else {
				imageEntity.setImageSmall(fields.get("imageSmall"));
			}
			imageService.update(imageEntity);
			ProductEntity productEntity = productService.findOne(Integer.parseInt(fields.get("productId")));
			productEntity.setImageId(imageEntity);
			productService.updateByImage(productEntity);
			response.sendRedirect(request.getContextPath()+"/admin-image?type=edit&message=update_success");
		}

	}
}
