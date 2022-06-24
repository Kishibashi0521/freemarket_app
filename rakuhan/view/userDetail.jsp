<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>

<%
	User user = (User) request.getAttribute("user");
%>

<html>
<head>
<title>ユーザー詳細</title>
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
			<div>
				<h2>ユーザー詳細確認画面</h2>
			</div>
		</div>
	</div>

	<div id="main" class="container">

		<table class="detail-table">

			<tr>
				<th>ユーザーID</th>
				<td><%=user.getUserid()%></td>
			</tr>

			<tr>
				<th>本名</th>
				<td><%=user.getName()%></td>
			</tr>

			<tr>
				<th>ニックネーム</th>
				<td><%=user.getNickname()%></td>
			</tr>

			<tr>
				<th>住所</th>
				<td><%=user.getAddress()%></td>
			</tr>

			<tr>
				<th>メールアドレス</th>
				<td><%=user.getEmail()%></td>
			</tr>

		</table>

		<div class="detail-button">
					<form action="<%=request.getContextPath()%>/userDetail" class="inline-block">
						<input type="hidden" name="userid" value="<%=user.getUserid()%>">
						<input type="hidden" name="cmd" value="update"></input>
						<input type="submit" value="変更">
					</form>

					<form action="<%=request.getContextPath()%>/deleteUser" class="inline-block">
						<input type="hidden" name="userid" value="<%=user.getUserid() %>">
						<input type="submit" value="退会">
					</form>

				</div>

			</div>

		<%@include file="/common/footer.jsp"%>
	</body>
</html>