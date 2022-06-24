package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Item;
import bean.Sales;
import dao.ItemDAO;
import dao.SalesDAO;

public class BuyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";

		try {


			// ItemDAOオブジェクト生成
			ItemDAO itemDao = new ItemDAO();

			//SalesDAOオブジェクト生成
			SalesDAO salesDao = new SalesDAO();

			// useridのパラメータを取得
			String userid = (String) request.getParameter("userid");

			// 購入商品をパラメータより取得
			Item boughtItem = itemDao.selectByItemid(Integer.parseInt(userid));

			//購入商品の詳細情報を登録
			Sales sales = new Sales();
			sales.setItemid(boughtItem.getItemid());
			sales.setUserid(boughtItem.getUserid());
			sales.setSend("0");
			sales.setPayment("0");
			sales.setTransaction("0");

			//購入商品をデータベースに登録
			salesDao.insert(sales);

		} catch (IllegalStateException e) {

			error = "DB接続エラーの為、書籍詳細は表示できませんでした。";

		} finally {
			// errorがないとき
			if (error.equals("")) {

				// エラーがないときBoughtItemListServlet.javaにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/BoughtItemServletList.java");
				dispatcher.forward(request, response);

			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
