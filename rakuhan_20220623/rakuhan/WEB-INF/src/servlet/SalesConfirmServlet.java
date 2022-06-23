package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class SalesConfirmServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd  = "";
		//セッションから“ユーザー”を取得する
		HttpSession session =  request.getSession();
		User user = (User) session.getAttribute("user");
		if(user== null) {
			error = "";

		}

		ArrayList<Sales> sales_list = (ArrayList<Sales>) session.getAttribute("sales_list");

		ItemDAO itemDao = new ItemDAO();
		ArrayList<Item> item_list = new ArrayList<Item>();
		if(sales_list != null) {
			for (Sales sales : sales_list) {
				Item item = itemDao.selectByItemid(sales.getItemid());
				item_list.add(item);
			}
		}
		request.setAttribute("item_list", item_list);

		request.getRequestDispatcher("/view/salesconfirm.jsp").forward(request, response);



	}
}
