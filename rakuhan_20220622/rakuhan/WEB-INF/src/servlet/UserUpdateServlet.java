package servlet;

//東さん作成

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

public class UserUpdateServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

			// 文字コード
			request.setCharacterEncoding("UTF-8");

			// 情報の取得
			String isbn = request.getParameter("userid");
			String title = request.getParameter("name");
			String strPrice = request.getParameter("price");
			String nickname=request.getParameter("nickname");
			String adress=request.getParameter("adress");
			String email=request.getParameter("email");



			// 入力の確認
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

			int price;
			try {
				// 価格が数値以外
				price = Integer.parseInt(strPrice);
			} catch (NumberFormatException e) {
				error = "価格の値が不正の為、書籍登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// BookDAOクラスのオブジェクト生成
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
			userDao.update(user);
		} catch (IllegalStateException e) {
			error = "DBに接続エラーの為、一覧表示はできませんでした。";
		} finally {

			// エラーがない場合
			if (error.equals("")) {
				request.getRequestDispatcher("/view/userlist.jsp").forward(request, response);
			}
			// エラーの有無でフォワード先を呼ぶ
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);

		}
	}
}


