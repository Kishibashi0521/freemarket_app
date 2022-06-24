<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User"%>

<%
	ArrayList<User> user_list = (ArrayList<User>) request.getAttribute("user_list");
%>

<html>
<head>
<title>ユーザー一覧画面(管理者)</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ヘッダー部分 -->
	<%@include file="/common/header.jsp"%>
	<table>
		<tr>
			<td>[<a href="<%=request.getContextPath()%>>/view/login.jps">ログイン</a>]
			</td>
			<td>[<a href="<%=request.getContextPath()%>>/view/menu.jsp">メニュー</a>]
			</td>
			<td><font>ユーザー一覧画面(管理者)</font></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>


	<table>
		<tr>
			<th>ユーザーID</th>
			<th>ニックネーム</th>
		</tr>
		<%
			if (user_list != null) {
				for (int i = 0; i < user_list.size(); i++) {
					User user = user_list.get(i);
		%>
		<tr>
		<tr>
			<td><a
				href="<%=request.getContextPath()%>/userDetail?userid=<%=user.getUserid()%>&cmd=detail"><%=user.getUserid()%></a></td>
			<td><%=user.getNickname()%></td>
		</tr>


		<%
			}
			}
		%>
	</table>
	<%@include file="/common/footer.jsp"%>
</body>
</html>