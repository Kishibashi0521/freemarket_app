package servlet;

//東さん作成

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class DeleteUserServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			// エンコードの設定
			request.setCharacterEncoding("UTF-8");
			// ISBN情報の受け取り
			String userid = (String) request.getParameter("userid");

			// BookDAOクラスのオブジェクトの生成
			UserDAO userDao = new UserDAO();

			if (userDao.selectByUserid(userid).getUserid() == null) {
				error = "削除対象のユーザー情報が存在しない為、削除処理は行えませんでした。";
				cmd = "user_list";
				return;
			}
			// deleteメソッドを利用し、書籍情報を削除
			userDao.delete(userid);
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ユーザー情報の削除処理は行えませんでした。";
			cmd = "menu";
		} finally {

			if (error.equals("")) {
				// ListServletへフォワード
				request.getRequestDispatcher("/view/userlist.jsp").forward(request, response);
			} else {

				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

			}
		}
	}
}
