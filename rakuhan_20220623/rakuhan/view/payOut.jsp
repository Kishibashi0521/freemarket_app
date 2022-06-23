<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Item" %>

<% Item item = (Item) request.getAttribute("item");
%>
<html>
<head>
<title>支払い方法</title>
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
					<li><a href="<%=request.getContextPath()%>/view/itemlist.jsp">[購入一覧に戻る]</a></li>
					<li><a href="<%=request.getContextPath()%>/view/trade.jsp">[取引表示]</a></li>
				</ul>
			</div>
			<div>
				<h2>支払い画面</h2>
			</div>
		</div>
	</div>
	<div>

		<form action="<%=request.getContextPath()%>/buy" method="POST">
			<h3>支払金額を入力してください。</h3>

			<p>
				金額:<input type="text" name="amount" value="<%= item.getPrice()%>">円
			</p>


			<input type="submit" value="決定">

		</form>
	</div>

<%@ include file="/common/footer.jsp"%>
</body>

</html>