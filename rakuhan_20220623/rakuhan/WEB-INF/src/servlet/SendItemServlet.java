package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Sales;
import bean.User;
import dao.SalesDAO;

public class SendItemServlet extends HttpServlet {
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
		SalesDAO salesDao =new SalesDAO();

		Sales sales = new Sales();
		salesDao.to_transaction(sales);

		request.setAttribute("sales", sales);

		request.getRequestDispatcher("/view/sendItem.jsp").forward(request, response);

	}
}
