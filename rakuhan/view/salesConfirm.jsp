<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,bean.Sales,dao.*"%>

<%
	ArrayList<Sales> sales_list = (ArrayList<Sales>) request.getAttribute("sales_list");
%>
<html>
<head>
<title>売上確認</title>
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
				</ul>
			</div>
			<div>
				<h2>売上確認画面</h2>
			</div>
		</div>
	</div>

	<table>


		<tr>
			<th>商品名</th>
			<th>金額</th>
			<th>手数料金額</th>
		</tr>

		<%
			int total = 0;

			if (sales_list != null) {
				for (int i = 0; i < sales_list.size(); i++) {
		%>
		<tr>
			<td><%=sales_list.get(i)%>
	</table>
	<table>
		<tr>
			<th>全件金額合計</th>
			<td><%=total%></td>
			<th>売上金額合計</th>
			<td><%=total / 10%></td>
		</tr>
	</table>
	<%
		}
		}
	%>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>