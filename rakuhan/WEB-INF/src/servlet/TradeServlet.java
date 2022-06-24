package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import dao.*;

public class TradeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

				// エラー文を格納する変数error
				// 遷移先を示すcmd
				String error = "";

				// セッション準備
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				//セッション切れか確認
				if(user == null){
				//セッション切れならerror.jspへフォワード
				request.setAttribute("error","セッション切れの為、メニュー画面が表示できませんでした。");
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);
				return;
				}


				try {

					ItemDAO itemDao = new ItemDAO();

					SalesDAO salesDao = new SalesDAO();

					ArrayList<Item> item_list = new ArrayList<Item>();

					ArrayList<Sales> sales_list = new ArrayList<Sales>();


					item_list = itemDao.selectByUser(user);

					sales_list = salesDao.selectByUser(user);


					// item_list,sales_listという名前のリクエストスコープに登録

					request.setAttribute("item_list", item_list);

					request.setAttribute("sales_list", sales_list);



				} catch (IllegalStateException e) {
					error = "DB接続エラーの為、取引情報表示はできませんでした。";

				} finally {
					if (error.equals("")) {
						request.getRequestDispatcher("/view/trade.jsp").forward(request, response);
					}
					request.setAttribute("error", error);

					request.getRequestDispatcher("/view/trade.jsp").forward(request, response);
				}
			}
		}