package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;
import dao.UserDAO;

public class UserDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		String error = "";

		// パラメータを取得
		String userid = request.getParameter("userid");
		String cmd = request.getParameter("cmd");

		try {
			// DTOオブジェクト宣言
			User user = new User();

			// DAOクラスのオブジェクト化
			UserDAO userDao = new UserDAO();

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

			// userという名前のリクエストスコープに登録
			request.setAttribute("user", user);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "menu";
		} finally {
			if (cmd.equals("detail")) {
				request.getRequestDispatcher("/view/userDetail.jsp").forward(request, response); // 詳細画面に遷移
			} else if (cmd.equals("update")) {
				request.getRequestDispatcher("/view/userUpdate.jsp").forward(request, response); // 更新画面に遷移
			} else if (!error.equals("")) {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/userList.jsp").forward(request, response);
			}
		}

	}
}