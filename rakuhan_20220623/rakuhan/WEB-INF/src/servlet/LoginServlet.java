package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException
	{
		try{
			//文字コード指定
			request.setCharacterEncoding("UTF-8");

			//オブジェクト宣言
			User	user	   = new User();
			UserDAO	userDao = new UserDAO();

			//フォーム値を取得(User,PassWord)
			String userid = request.getParameter("userid");
			String pass = request.getParameter("pass");

			//DBから該当ユーザ情報を検索
			user = userDao.selectByUserid(userid);


			if(user.getUserid() == null || !user.getPassword().equals(pass) ){
				//ログイン失敗login.jspへフォワード
				request.setAttribute("message", "入力データが間違っています！");
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);

			}else{
				//セッションにuser情報をセットする
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				//クッキーにユーザ名を保存
				Cookie cookieName = new Cookie("userid",URLEncoder.encode(user.getUserid(),"UTF-8"));

				//クッキー保存日数:5日
				cookieName.setMaxAge(60*60*24*5);
				response.addCookie(cookieName);

				//クッキーにパスワードを保存
				Cookie cookiePass = new Cookie("pass",URLEncoder.encode(user.getPassword(),"UTF-8"));

				//クッキー保存日数:5日
				cookiePass.setMaxAge(60*60*24*5);
				response.addCookie(cookiePass);

				//ログイン成功menu.jspへフォワード
				request.getRequestDispatcher("/view/menu.jsp").forward(request, response);

			}

		} catch (IllegalStateException e) {
			//エラー情報を持ってerror.jspにフォワード
			String error ="DB接続エラーの為、ログインは出来ません。";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/login.jsp").forward(request, response);
		} catch(Exception e){
			String error ="予期せぬエラーが発生しました。"+e;
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/login.jsp").forward(request, response);
		}
	}

}
