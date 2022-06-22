package servlet;

//島津作成

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;

public class BoughtItemListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String error = "";

        // セッションから"user"を取得する
                    HttpSession session = request.getSession();
                    User user = (User) session.getAttribute("user");

                    // セッション切れの場合はerror.jspに遷移する
                    if (user == null) {
                        error = "セッション切れの為、購入は出来ません。";
                        return;
                    }

        //購入済み商品のオブジェクトboughtを取得して



    }
}