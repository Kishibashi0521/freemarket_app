<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>

<%
	User user = (User) request.getAttribute("user");
%>
<html>
<head>
<title>ユーザー登録情報変更</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="/common/header.jsp"%>
	<div>
		<div>
			<div>
				<ul>
					<li><a href="<%=request.getContextPath()%>/userList">[一覧に戻る]</a></li>
				</ul>
			</div>
			<h2>ユーザー登録情報変更</h2>
		</div>
	</div>
	<div id="main" class="container">
		<form action="<%=request.getContextPath()%>/userUpdate">
			<table class="input-table">
				<tbody>

					<tr>
						<th>ユーザーID</th>
						<td><input type="text" name="userid"
							value="<%=user.getUserid()%>"></td>
					</tr>
					<tr>
						<td>
						<td>本名</td>
						<td><input type="text" name="name"></input></td>

					</tr>
					<tr>
						<td>
						<td>ニックネーム</td>
						<td><input type="text" name="nickname"></input></td>

					</tr>
					<tr>
						<td>
						<td>住所</td>
						<td><input type="text" name="address"></input></td>
					</tr>
					<tr>
						<td>
						<td>メールアドレス</td>
						<td><input type="text" name="email"></input></td>
					</tr>
			</table>
			<input type="hidden" name="userid" value="<%=user.getUserid()%>">

			<input type="submit" value="変更">
		</form>

	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>