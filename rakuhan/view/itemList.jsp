<!--<%@page contentType="text/html;charset=UTF-8" %>-->
<%@page import="java.util.ArrayList,bean.Item"%>

<!--原作成 -->
<%
	ArrayList<Item> item_list = (ArrayList<Item>) request.getAttribute("item_list");
%>

<html>
    <head>
        <title>出品商品一覧</title>
        <link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
    </head>
    <body>
            <div>
        <div>
            <div>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー]</a></li>
                    <li><a href="<%=request.getContextPath()%>/view/trade.jsp">[新規出品登録]</a></li>
                </ul>
            </div>
            <div>
                <h2>出品商品</h2>
            </div>
        </div>
    </div>

 				<!-- 出品情報リスト -->
				<table class="list-table">
					<tbody>
						<%
						if (item_list != null) {
							for (Item item : item_list) {
						%>
						<tr>
							<td><a href="<%=request.getContextPath()%>/itemDetail?itemid=<%=item.getItemid()%>&cmd=detail"><%=item.getItemid() %></a></td>
							<td><%=item.getItemname() %></td>
						</tr>
						<%
							}
						}
						%>
					</tbody>
				</table>
			</div>

		</div>
	</body>
</html>
