package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import bean.*;

public class UserUpdateServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エンコードの設定
		request.setCharacterEncoding("UTF-8");

		String error = "";
		String cmd = "";

		try {

			// User情報を受け取り格納する
			String userid = request.getParameter("userid");
			String name = request.getParameter("name");
			String nickname = request.getParameter("nickname");
			String adress = request.getParameter("adress");
			String email = request.getParameter("email");

			// エラー判定
			if (name.equals("")) {
				error = "本名が未入力の為、書籍登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			if (nickname.equals("")) {
				error = "ニックネームが未入力の為、書籍登録処理は行えませんでした。";
				cmd = "list";
				return;
			}
			if (adress.equals("")) {
				error = "住所が未入力の為、書籍登録処理は行えませんでした。";
				cmd = "list";
				return;
			}
			if (email.equals("")) {
				error = "メールアドレスが未入力の為、書籍登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// UserDAOクラスのオブジェクト生成
			UserDAO userDao = new UserDAO();

			// Bookオブジェクトを生成する
			User user = new User();

			// 入力情報をBookオブジェクト格納
			user.setUserid(userid);
			user.setName(name);
			user.setNickname(nickname);
			user.setAddress(adress);
			user.setEmail(email);

			// メソッドの呼び出し
			user.update();
			userDao.update(user);
		} catch (IllegalStateException e) {
			error = "DBに接続エラーの為、一覧表示はできませんでした。";
		} finally {

			// エラーがない場合
			if (error.equals("")) {
				request.getRequestDispatcher("/userList").forward(request, response);
			}
			// エラーの有無でフォワード先を呼ぶ
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);
			request.getRequestDispatcher("/view/userlist.jsp").forward(request, response);
		}
	}
}
