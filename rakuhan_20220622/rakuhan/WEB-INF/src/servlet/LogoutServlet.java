package servlet;

//高瀬作成

//インポート宣言
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException
	{
		//セッション破棄
		HttpSession session = request.getSession();
		session.invalidate();

		//ログイン失敗login.jspへフォワード
		request.setAttribute("message", "ログアウトしました。");
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);
	}
}

