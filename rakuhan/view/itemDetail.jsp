<!--<%@page contentType="text/html;charset=UTF-8" %>-->
<%@page import="bean.Item"%>

<%
	Item item = (Item) request.getAttribute("item");
%>

<html>
	<head>
        <title>出品商品詳細</title>
        <link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
    </head>
    <body>
            <div>
        <div>
            <div>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/itemList">[一覧に戻る]</a></li>
                </ul>
            </div>
            <div>
                <h2>出品商品詳細</h2>
            </div>
        </div>
    </div>
			<!-- 商品詳細情報コンテンツ部分 -->
			<div id="main" class="container">

				<table class="detail-table">
					<tr>
						<th>商品名</th>
						<td><%=item.getItemname() %></td>
					</tr>
					<tr>
						<th>価格</th>
						<td><%=item.getPrice() %></td>
					</tr>
					<tr>
						<th>種類</th>
						<td><%=item.getType()%></td>
					</tr>
					<tr>
						<th>備考</th>
						<td><%=item.getComment()%></td>
					</tr>
				</table>

				<div class="detail-button">
					<form action="<%=request.getContextPath()%>/itemDetail" class="inline-block">
						<input type="hidden" name="itemid" value="<%=item.getItemid()%>">
						<input type="hidden" name="cmd" value="update"></input>
						<input type="submit" value="変更">
					</form>

					<form action="<%=request.getContextPath()%>/itemDelete" class="inline-block">
						<input type="hidden" name="itemid" value="<%=item.getItemid() %>">
						<input type="submit" value="出品取り下げ">
					</form>

					<form action="<%=request.getContextPath()%>/buy" class="inline-block">
						<input type="hidden" name="itemid" value="<%=item.getItemid() %>">
						<input type="submit" value="購入">
					</form>
				</div>

			</div>

		</div>
	</body>
</html>