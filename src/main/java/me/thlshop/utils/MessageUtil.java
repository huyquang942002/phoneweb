package me.thlshop.utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request) {
		if(request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if(message.equals("insert_success")) {
				messageResponse = "Insert Success";
				alert = "success";
			} else if(message.equals("update_success")) {
				messageResponse = "Update Success";
				alert = "success";
			}else if(message.equals("delete_success")) {
				messageResponse = "Delete Success";
				alert = "success";
			}else if(message.equals("error_system")) {
				messageResponse = "Error System";
				alert = "danger";
			}
			request.setAttribute("messageResponse", messageResponse);
			request.setAttribute("alert", alert);
		}
	}
}
