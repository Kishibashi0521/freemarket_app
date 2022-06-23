package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import bean.User;
import dao.ItemDAO;

public class InsertItemServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		// エラー変数準備
		String error = null;
		// エンコーディング
		request.setCharacterEncoding("UTF-8");
		// オブジェクト
		ItemDAO itemDao = new ItemDAO();
		// 格納オブジェクト
		Item item = new Item();
		// 入力パラメータ
		request.getParameter("itemname");
		request.getParameter("type");
		request.getParameter("comment");
		request.getParameter("price");

		String itemname = request.getParameter("itemname");
		String type = request.getParameter("type");
		String comment = request.getParameter("comment");


		// セッション準備
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//セッション切れか確認
		if(user == null){
		//セッション切れならerror.jspへフォワード
		request.setAttribute("error","セッション切れの為、メニュー画面が表示できませんでした。");
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);
		return;
		}

		String userid = user.getUserid();

		item.setUserid(userid);



				try {

					// 格納,エラー確認
					if (itemname.equals("")) {
						error = "商品名が未入力の為、出品は行えませんでした。";
						return;
					}
					if(itemname.length() >= 20) {
						error = "商品名が20文字以上の為、出品は行えませんでした。";
						return;
					}


					item.setItemname(itemname);


					// 格納,エラー確認
					if (!(type == "0") || !(type == "1") || !(type == "2") || !(type == "3") || !(type == "4")) {
						error = "不正な値が入力されました。選択してください。";
						return;
					}
					item.setType(type);


					// 格納,エラー確認
					if(comment.length() >= 500) {
						error = "商品説明は500文字までで入力してください。";
						return;
					}




					// 格納,エラー確認 price
					if (request.getParameter("price").equals("")) {
						error = "価格が未入力の為、出品は行えませんでした。";
						return;
					}

					try {
						Integer.parseInt(request.getParameter("price"));
					} catch (NumberFormatException e) {
						error = "価格の値が不正の為、出品は行えませんでした。";
						return;
					}
					item.setPrice(Integer.parseInt(request.getParameter("price")));



				} catch (IllegalStateException e) {
					error = "DB接続エラーの為、出品は行なえませんでした";
				} finally {
					if (error == null) {
						// メソッド呼び出し
						itemDao.insert(item);
						// フォワード
						request.setAttribute("item", item);
						request.getRequestDispatcher("/myItemList").forward(request, response);
					} else {
						request.setAttribute("error", error);
						request.getRequestDispatcher("/view/insertitem.jsp").forward(request, response);
					}
				}

			}

}
