package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.ItemDAO;
import bean.Item;

public class ItemDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		// 画面から送信されるitemid情報を受け取るためのエンコードを設定する
		response.setCharacterEncoding("UTF-8");
		String error = "";
		String cmd = "";

		try {
			// BookDAOクラスのオブジェクトを生成
			ItemDAO itemDao = new ItemDAO();

			// 画面から送信されるitemid情報を受け取る
			int itemid = Integer.parseInt(request.getParameter("itemid"));

			// エラー判定
			if (itemDao.selectByItemid(itemid).getItemid() == 0) {
				error = "削除対象の商品が存在しない為、出品商品削除処理は表示できませんでした。";
				cmd = "list";
				return;
			}

			// ItemDAOクラスに定義したdelete（）メソッドを利用して商品情報を削除する
			itemDao.delete(itemid);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、出品商品削除処理はできませんでした。";
			cmd = "menu";
		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/itemList").forward(request, response);
			}
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);
			request.getRequestDispatcher("/view/itemList").forward(request, response);
		}

	}

}
