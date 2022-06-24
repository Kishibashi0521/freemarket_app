<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>

<html>
<head>
<title>ユーザー登録情報変更</title>
</head>
<body>
	<div>
		<td><font>ユーザー情報登録</font></td>
	</div>
	<form action="<%=request.getContextPath() %>/InsertUserServlet"></form>
	<table>
		<tr>
			<td>
			<td>ユーザーID</td>
			<td><input type="text" name="userid" value=""></td>
			</td>
		</tr>
		<tr>
			<td>
			<td>本名</font></td>
			<td><input type="text" name="name" value=""></td>
			</td>
		</tr>
		<tr>
			<td>
			<td>ニックネーム</td>
			<td><input type="text" name="nickname" value=""></td>
			</td>
		</tr>
		<tr>
			<td>
			<td>住所</td>
			<td><input type="text" name="address" value=""></td>
			</td>
		</tr>
		<tr>
			<td>
			<td>メールアドレス</td>
			<td><input type="text" name="email" value=""></td>
		</tr>
	</table>
	<div>
		<button type="submit">ユーザー登録</button>
	</div>
</body>