<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>

<html>
<head>
<title>ユーザー登録情報変更</title>
</head>
<body>
<%@include file="/common/header.jsp"%>
	<div>
		<font>ユーザー情報登録</font>
	</div>
	<form action="<%=request.getContextPath() %>/InsertUser"></form>
	<table>
		<tr>
			<td>
			<td>ユーザーID</td>
			<td><input type="text" name="userid"></input></td>

		</tr>
		<tr>
			<td>
			<td>本名</td>
			<td><input type="text" name="name" ></input></td>

		</tr>
		<tr>
			<td>
			<td>ニックネーム</td>
			<td><input type="text" name="nickname"></input></td>

		</tr>
		<tr>
			<td>
			<td>住所</td>
			<td><input type="text" name="address" ></input></td>

		</tr>
		<tr>
			<td>
			<td>メールアドレス</td>
			<td><input type="text" name="email" ></input></td>
		</tr>
	</table>
	<div>
	 <input type="submit" value="ユーザー登録">
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>