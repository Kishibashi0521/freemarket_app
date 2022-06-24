package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

public class UserListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

			// DAOクラスのオブジェクトの生成
			UserDAO userDao = new UserDAO();

			// selectAllメソッドの呼び出し
			ArrayList<User> userList = userDao.selectAll();

			// 受け散った数値をuserに格納
			request.setAttribute("user_list", userList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ユーザー一覧表示は行えませんでした。";
			cmd = "menu";
		} finally {
			if (error.equals("")) {

				request.getRequestDispatcher("/view/userList.jsp").forward(request, response);
			} else {

				// error.jspに判断
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/userList.jsp").forward(request, response);
			}
		}

	}
}
