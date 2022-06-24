<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<html>
<body>
	<%
		session = request.getSession();
		User user = (User) session.getAttribute("user");
		//セッション切れか確認
	    if (user == null) {
	        //セッション切れならerror.jspへフォワード
	        request.setAttribute("error", "セッション切れの為、メニュー表示できませんでした。");
	        request.setAttribute("cmd", "logout");
	        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
	        return;
	    }
	%>
	<table class="userTable" summary="ユーザー情報">
		<tr>
			<td>名前：<%=user.getUserid()%></td>
		</tr>
		<%
			if (user.getAuthority().equals("1")) {
		%>
		<tr>
			<td>権限：一般ユーザー</td>
		</tr>
		<%
			} else {
		%>
		<tr>
			<td>権限：管理者</td>
		</tr>
		<%
			}
		%>
	</table>

	<hr size="2" color="black" width="950">
</body>
</html>

