package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class PayOutServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error ="";
		String cmd = "";

		try {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user== null) {
			error = "";
		}

		ArrayList<Item> item_list = (ArrayList<Item>) session.getAttribute("item_list");


		if(item_list == null || item_list.isEmpty()) {
			return;
		}



		}finally {

		}
	}
}
