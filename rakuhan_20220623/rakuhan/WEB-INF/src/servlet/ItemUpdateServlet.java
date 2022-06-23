package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.ItemDAO;
import bean.Item;
import java.util.Date;

public class ItemUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		// 日本語に対応させるためエンコーディング
		request.setCharacterEncoding("UTF-8");
		// エラー文と遷移先の指定を格納するための変数
		String error = "";
		String cmd = "";

		try {

			// 画面からの入力情報を受け取り、Itemオブジェクトに格納する
			int itemid = Integer.parseInt(request.getParameter("itemid"));
			String itemname = request.getParameter("itemname");
			String strPrice = request.getParameter("price");
			String type = request.getParameter("type");
			String comment = request.getParameter("comment");
			String status = request.getParameter("status");

			// エラー判定
			if (itemname.equals("")) {
				error = "商品名が未入力の為、出品変更処理が行えませんでした。";
				cmd = "list";
				return;
			}else if(itemname.length() > 20) {
				error = "20文字以下で入力してください。";
				cmd = "list";
				return;
			}

			if (strPrice.equals("")) {
				error = "価格が未入力の為、出品変更処理が行えませんでした。";
				cmd = "list";
				return;
			}

			/*if (type.equals("")) {
				error = "種類が未入力の為、出品更新処理が行えませんでした。";
				cmd = "list";
				return;
			}

			if (comment.equals("")) {
				error = "備考が未入力の為、出品更新処理が行えませんでした。";
				cmd = "list";
				return;
			}else if(comment.length() > 200) {
				error = "200文字以下で入力してください。";
				cmd = "list";
				return;
			}

			*/

			int price;
			try {
				price = Integer.parseInt(strPrice); // String型からint型にキャスト
			} catch (NumberFormatException e) {
				error = "価格の値が不正の為、出品商品変更処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// BookDAOクラスのオブジェクトを生成する
			ItemDAO itemDao = new ItemDAO();

			if (itemDao.selectByItemid(itemid).getItemid() == 0) {
				error = "更新対象の商品が存在しない為、出品商品変更処理は表示できませんでした。";
				cmd = "list";
				return;
			}

			// 更新後の商品情報を格納するItemオブジェクトを生成する
			Item item = new Item();
			item.setItemid(itemid);
			item.setItemname(itemname);
			item.setPrice(price);
			item.setType(type);
			item.setComment(comment);
			item.setStatus(status);
			item.update();

			// update（）メソッドを利用してItemオブジェクトに格納された書籍データで更新する
			itemDao.update(item);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、出品商品更新処理はできませんでした。";
			cmd = "menu";
		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/itemList").forward(request, response);
			}
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);
			request.getRequestDispatcher("/itemList").forward(request, response);
		}
	}

}
