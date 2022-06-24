package servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.ItemDAO;
import bean.Item;

public class ItemListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
	throws ServletException ,IOException{

		// エラー文を格納する変数error
		// 遷移先を示すcmd
		String error = "";
		String cmd = "";

		try {

			ItemDAO itemDao = new ItemDAO();

			ArrayList<Item> list = itemDao.selectAll();

			// item_listという名前のリクエストスコープに登録
			request.setAttribute("item_list", list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "menu";
		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/view/itemList.jsp").forward(request, response);
			}
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);
			request.getRequestDispatcher("/view/menu.jsp").forward(request, response);
		}
	}
}
