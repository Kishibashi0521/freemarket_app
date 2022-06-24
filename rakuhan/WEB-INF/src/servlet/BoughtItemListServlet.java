package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Item;
import bean.Sales;
import bean.User;
import dao.ItemDAO;
import dao.SalesDAO;

public class BoughtItemListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";

		try {

			// セッションオブジェクトの取得
			HttpSession session = request.getSession();

			// セッションからuserデータを取得
			User user = (User) session.getAttribute("user");

			// セッション切れの場合
			if (user == null) {
				error = "セッション切れの為、購入は出来ません。";

				return;

			}

			// Salesオブジェクト生成
			SalesDAO salesDao = new SalesDAO();

			// ItemDAOオブジェクト生成
			ItemDAO itemDao = new ItemDAO();

			// 購入対象の商品が存在しない場合
			if (salesDao.selectByUser(user) == null) {
				error = "更新対象の書籍が存在しない為、書籍更新処理は行えませんでした。";

				return;
			}

			// 購入済み商品の一覧を取得
			ArrayList<Sales> boughtItemList = salesDao.selectByUser(user);

			// ユーザーの購入済み商品のリストを取得
			ArrayList<Item> ItemList = itemDao.selectAll();

			// リクエストスコープに購入済み商品のリストを登録
			request.setAttribute("boughtItemList", boughtItemList);

			// リクエストスコープに購入済み商品のリストを登録
			request.setAttribute("ItemList", ItemList);

		} catch (IllegalStateException e) {

			error = "DB接続エラーの為、書籍詳細は表示できませんでした。";

		} finally {
			// errorがないとき
			if (error.equals("")) {

				// エラーがないときboughtItemList.jspにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/boughtItemList.jsp");
				dispatcher.forward(request, response);

			} else {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
