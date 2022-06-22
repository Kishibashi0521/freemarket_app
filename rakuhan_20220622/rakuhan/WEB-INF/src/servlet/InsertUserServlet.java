package servlet;

//東さん作成

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


import bean.User;
import dao.UserDAO;

public class InsertUserServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			// 文字エンコーティングの指定
			request.setCharacterEncoding("UTF-8");

			// パラメータの取得
			String isbn = request.getParameter("userid");
			String title = request.getParameter("name");
			String strPrice = request.getParameter("price");
			String nickname=request.getParameter("nickname");
			String adress=request.getParameter("adress");
			String email=request.getParameter("email");

			// 入力されてるかの確認
			if (isbn.equals("")) {
				error = "ISBNが未入力の為、書籍登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			if (title.equals("")) {
				error = "タイトルが未入力の為、書籍登録処理は行えませんでした。";
				cmd = "list";
				return;
			}
			if (strPrice.equals("")) {
				error = "価格が未入力の為、書籍登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// DAOオブジェクト宣言
			UserDAO userDao = new UserDAO();

			// ISBNが重複している
			if (bookDao.selectByIsbn(isbn).getIsbn() != null) {
				error = "入力ISBNは既に登録済みの為、書籍登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			/*
			 * Userオブジェクト生成し、各setterメソッドを利用し、 isbn,title,priceを設定する。
			 */

			User user = new User();
			user.setUserid(userid);
			user.setName(name);
			user.setNickname(nickname);
			user.setAddress(adress);
			user.setEmail(email);
			// insertメソッドを呼び出し
			UserDao.insert(user);

		} catch (IllegalStateException e) {
			error = "DBに接続エラーの為、一覧表示はできませんでした。";
			cmd = "menu";
		} finally {
			if (error.equals("")) {

				request.getRequestDispatcher("/userlist").forward(request, response);
			} else {
				// エラーの有無でフォワード先を呼ぶ
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

			}
		}
	}
}

