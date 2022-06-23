<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>

<%
	User user = (User) request.getAttribute("user");
	String error = (String) request.getAttribute("error");
%><
<html>
<head>
<title>ユーザー詳細</title>
</head>
<body>
	<div align="center">
		<td><font>ユーザー詳細画面</font></td>
	</div>

	<%
		if (user != null) {
	%>
	<table>
		<tr>
			<td>
			<td>ユーザーID</td>
			<td><%=user.getUserid()%></td>
			</td>
		</tr>
		<tr>
			<td>
			<td>本名</font></td>
			<td><%=user.getName()%></td>
			</td>
		</tr>
		<tr>
			<td>
			<td>ニックネーム</td>
			<td><%=user.getNickname()%></td>
			</td>
		</tr>
		<tr>
			<td>
			<td>住所</td>
			<td><%=user.getAddress()%></td>
			</td>
		</tr>
		<tr>
			<td>
			<td>メールアドレス</td>
			</td>
			<td><%=user.getEmail()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<tr>
		<td>
			<button>登録情報変更</button>
			<button>退会</button>
</body>