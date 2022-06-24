<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Item,bean.User"%>
<%
	String error = (String) request.getAttribute("error");
%>
<html>
<head>
<title>出品済商品一覧</title>
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
				<h2>出品済商品一覧</h2>
			</div>
		</div>
	</div>

	<hr class="subline"></hr>

	<%
		ArrayList<Item> list = (ArrayList<Item>) request.getAttribute("myitem_list");
	%>
	<form action="/sendItem">
		<table style="margin: 0 auto">
			<%
				if (error != null) {
			%>
			<tr>
				<td><%=error%> <%
 	}
 %></td>
			</tr>

			<tr>
				<th bgcolor="#39F" style="width: 200">商品名</th>
				<th bgcolor="#39F" style="width: 200">金額</th>
			</tr>
			<%
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						Item items = (Item) list.get(i);
			%>
			<tr>
				<td><%=items.getItemname()%></td>
				<td><%=items.getPrice()%>円</td>
				<%
					if (items.getStatus() == "1") {
				%>
				<td colspan=2 style="text-align: center">
					<!-- statusが1の時 --> <input type="submit" value="発送画面に行く">
				</td>
			</tr>
		</table>
		<input type="hidden" name="itemid" value="<%=items.getItemid()%> ">
	</form>
	<%
		}
			}
		}
	%>
	<%@include file="/common/footer.jsp"%>
</body>
</html>