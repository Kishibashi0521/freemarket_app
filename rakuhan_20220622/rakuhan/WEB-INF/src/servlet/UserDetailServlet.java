package servlet;

//東さん作成

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Usre;
import dao.UserDAO;

public class UserDetailServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			// エンコードの設定
			request.setCharacterEncoding("UTF-8");

			// 送信された情報の受け取り
			String isbn = request.getParameter("userid");
			cmd = request.getParameter("cmd");

			// UserDAOクラスのオブジェクト化
			UserDAO userDao = new UserDAO();

			//ユーザーの詳細情報を取得する
			User user = userDao.selectByUserid(userid);

			//
			if (user.getUserid() == null) {
				error = "表示対象のユーザーが存在しない為、詳細情報は表示できませんでした。";
				cmd = "user_list";
				return;
			}

			// ユーザーの詳細情報をuserという名前でリクエストスコープに登録
			request.setAttribute("user", user);

		} catch (IllegalStateException e) {
			if (cmd.equals("detail")) {
				error = "DB接続エラーの為、変更画面は表示できませんでした。";
			}
		} finally {
			if (cmd.equals("detail")) {
				request.getRequestDispatcher("/view/userdetail.jsp").forward(request, response);
				;

			} else if (cmd.equals("update")) {
				request.getRequestDispatcher("/view/userupdate.jsp").forward(request, response);
				;
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
			}
		}
	}
}

