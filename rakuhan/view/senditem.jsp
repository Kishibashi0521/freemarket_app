<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.*" %>

<% User user = (User) request.getAttribute("user");
	Sales sales = (Sales) request.getAttribute("sales");
%>

<html>
<head>
<title>発送画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ヘッダー部分 -->
	<%@ include file="/common/header.jsp"%>

	<div>
		<div>
			<div>
				<ul>
					<li><a href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー]</a></li>
					<li><a href="<%=request.getContextPath()%>/view/itemlist.jsp">[出品一覧]</a></li>
				</ul>
			</div>
			<div>
				<h2>発送画面</h2>
			</div>
		</div>
	</div>


<table>
<%
String transaction_completed=sales.getTransaction();
if(transaction_completed.equals("1")){
%>
<tr>
	<td>この商品はすでに出品済みです</td>
</tr>
<%
}else{
%>
	<tr>
		<th>送り先名</th>
		<td><%=user.getName() %></td>
	</tr>
	<tr>
		<th>送り先住所</th>
		<td><%=user.getAddress() %></td>
	</tr>
</table>
<form action="<%=request.getContextPath()%>/sendItem" method="GET">
<input type="submit" value="決定">
</form>
<%
}
%>

</body>
<%@ include file="/common/footer.jsp"%>
</html>