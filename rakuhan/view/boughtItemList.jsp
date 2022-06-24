<!--<%@page contentType="text/html; charset=UTF-8" %>-->
<%@page import="java.util.ArrayList,bean.Sales,dao.SalesDAO,bean.Item"%>

<%
	ArrayList<Sales> boughtItemlist = (ArrayList<Sales>) request.getAttribute("boughtItemList");
	ArrayList<Item> list = (ArrayList<Item>) request.getAttribute("ItemList");
%>
<html>
<head>
<title>購入済み商品リスト</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<table align="center" width="850">
		<tr>
			<td>[<a>ログイン</a>]
			</td>
			<td>[<a>メニュー</a>]
			</td>
			<td><font size="5">購入済み商品リスト</font></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>

	<hr align="center" size="2" color="black" width="950"></hr>

	<form action="<%=request.getContextPath()%>/view/payout.jsp"
		method="get"">
		<%
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < boughtItemlist.size(); j++) {
					Sales boughtItem = (Sales) boughtItemlist.get(i);
					Item item = (Item) list.get(i);

					if (boughtItem.getItemid() == item.getItemid()) {
		%>
		<table>
			<tr>
				<td bgcolor="#39F" style="width: 60">商品名</td>
				<td><%=item.getItemname()%></td>

				<td bgcolor="#39F" style="width: 60">金額</td>
				<td><%=item.getPrice()%></td>

				<td colspan=2 style="text-align: center"><input type="submit"
					value="入金画面に行く"></td>

			</tr>
		</table>
	</form>
	<form action="<%=request.getContextPath()%>/view/trade.jsp"
		method="get"">
		<table style="margin: 0 auto">
			<tr>
				<td colspan=2 style="text-align: center"><input type="submit"
					value="取引完了しました"></td>
			</tr>
		</table>
	</form>
	<%
		}

			}
		}
	%>

	<%@include file="/common/footer.jsp"%>
</body>
</html>