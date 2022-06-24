<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Sales,bean.User,bean.Item"%>
<%
	String error = (String) request.getAttribute("error");
%>
<html>
<head>
<title>取引情報画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div>
		<div>
			<div>
				<ul>
					<li><a href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー]</a></li>
				</ul>
			</div>
			<div>
				<h2>取引情報画面</h2>
			</div>
		</div>
	</div>

	<hr align="center" size="2" color="black" width="950"></hr>

	<%
		if (error != null) {
	%>

	<table align="center">
		<tr>
			<td><%=error%> <%
 	}
 %></td>
		</tr>
	</table>
	<%
		String send = "";
		String payMent = "";

		ArrayList<Item> itemlist = (ArrayList<Item>) request.getAttribute("item_list");
		ArrayList<Sales> saleslist = (ArrayList<Sales>) request.getAttribute("sales_list");
		if (saleslist != null) {
			for (int i = 0; i < saleslist.size(); i++) {
				Sales sales = (Sales) saleslist.get(i);

				for (int j = 0; i < itemlist.size(); j++) {
					Item item = (Item) itemlist.get(j);
	%>

	<table align="center" style="margin: 0 auto">
		<tr>
			<th bgcolor="#39F" style="width: 200">発送情報</th>
		</tr>
	</table>
	<%
		if (sales.getSend() == "1") {
						send = "完了";
	%>
	<table align="center" style="margin: 0 auto">
		<tr>
			<th bgcolor="#39F" style="width: 200">商品名</th>
		</tr>
		<tr>
			<td align="center" width="200"><%=item.getItemname()%> <%=send%></td>
		</tr>
	</table>
	<table style="margin: 0 auto">
		<tr>
			<th bgcolor="#39F" style="width: 200">入金情報</th>
		</tr>
	</table>
	<%
		}
					if (sales.getPayment() == "1") {
						payMent = "完了";
	%>
	<table style="margin: 0 auto">
		<tr>
			<th bgcolor="#39F" style="width: 200">入金情報</th>
		</tr>
		<tr>
			<th align="center" width="200"><%=item.getItemname()%> <%=payMent%></th>
		</tr>
	</table>
	<%
		}
					if (sales.getTransaction() == "1") {
	%>
	<table style="margin: 0 auto">
		<tr>
			<th bgcolor="#39F" style="width: 200">完了済情報</th>
		</tr>
		<tr>
			<th align="center" width="200"><%=item.getItemname()%></th>
		</tr>
	</table>
	<%
		}
				}
			}
		}
	%>
	<%@include file="/common/footer.jsp"%>
</body>
</html>