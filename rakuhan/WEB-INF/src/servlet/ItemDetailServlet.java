package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.ItemDAO;
import bean.Item;


public class ItemDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");

		// エラー文を格納する変数error
		String error = "";

		// パラメータの取得
		int itemid = Integer.parseInt(request.getParameter("itemid"));
		String cmd = request.getParameter("cmd");

		try {
			// DTOオブジェクト宣言
			Item item = new Item();

			// オブジェクト宣言
			ItemDAO itemDao = new ItemDAO();

			// エラー判定
			if (itemDao.selectByItemid(itemid).getItemid() == 0  && cmd == "detail") {
				error = "表示対象の商品が存在しない為、出品商品詳細情報は表示できませんでした。";
				cmd = "list";
				return;
			} else if (itemDao.selectByItemid(itemid).getItemid() == 0 && cmd == "update") {
				error = "更新対象の商品が存在しない為、出品変更画面は表示できませんでした。";
				cmd = "list";
				return;
			}

			// 1件検索メソッドを呼び出し
			item = itemDao.selectByItemid(itemid);

			// itemという名前のリクエストスコープに登録
			request.setAttribute("item", item);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "menu";
		} finally {
			if (cmd.equals("detail")) {
				request.getRequestDispatcher("/view/itemDetail.jsp").forward(request, response); // 詳細画面に遷移
			} else if (cmd.equals("update")) {
				request.getRequestDispatcher("/view/itemUpdate.jsp").forward(request, response); // 更新画面に遷移
			}
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);
			request.getRequestDispatcher("/view/itemList.jsp").forward(request, response);
		}
	}

}
