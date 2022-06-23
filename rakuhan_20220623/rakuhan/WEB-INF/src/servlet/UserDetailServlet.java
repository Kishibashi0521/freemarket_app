package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import dao.*;

public class UserDetailServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		String error = "";
		String cmd = "";

		try {
			// DTOオブジェクト宣言
			User user = new User();

			// UserDAOクラスのオブジェクト化
			UserDAO userDao = new UserDAO();

			// 送信された情報の受け取り
			String userid = request.getParameter("userid");
			cmd = request.getParameter("cmd");

			// エラー判定
			if (userDao.selectByUserid(userid).getUserid() == null && cmd == "detail") {
				error = "表示対象のユーザーが存在しない為、詳細情報は表示できませんでした。";
				cmd = "list";
				return;
			} else if (userDao.selectByUserid(userid).getUserid() == null & cmd == "update") {
				error = "更新対象の商品が存在しない為、詳細変更画面は表示できませんでした。";
				cmd = "list";
				return;
			}
			// 1件検索メソッドを呼び出し
			user = userDao.selectByUserid(userid);

			// itemという名前のリクエストスコープに登録
			request.setAttribute("user", user);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "menu";
		} finally {
			if (cmd.equals("detail")) {
				request.getRequestDispatcher("/userDetail").forward(request, response); // 詳細画面に遷移
			} else if (cmd.equals("update")) {
				request.getRequestDispatcher("/view/userUpdate.jsp").forward(request, response); // 更新画面に遷移
			}
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);
			request.getRequestDispatcher("/view/userList.jsp").forward(request, response);
		}
	}
}