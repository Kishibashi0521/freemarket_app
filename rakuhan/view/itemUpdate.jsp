<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Item"%>

<%
	Item item = (Item) request.getAttribute("item");
%>

<html>
	<head>
        <title>出品商品情報変更</title>
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
                <h2>出品商品情報変更</h2>
            </div>
        </div>
    </div>

			<!-- コンテンツ部分 -->
			<div id="main" class="container">

				<!-- 変更画面 -->
				<form action="<%=request.getContextPath()%>/itemUpdate">
					<table class="input-table">
						<tbody>

							<tr>
								<th>商品名</th>
								<td><input type="text" name="itemname"></td>
								<input type="hidden" name="itemid" value="<%=item.getItemid() %>"></input>
								<input type="hidden" name="status" value="0"></input>
							</tr>
							<tr>
								<th>価格</th>
								<td><input type="text" name="price">円</td>
							</tr>
							<tr>
								<th>種類</th>
								<td>
								<select name="type">
								<option value="0">アクセサリー</option>
								<option value="1">食器</option>
								<option value="2">インテリア</option>
								<option value="3">おもちゃ</option>
								<option value="4">その他</option>
								</select>
								</td>
							</tr>
							<tr>
								<th>備考</th>
								<td><textarea name="comment" rows="5" cols="40"></textarea></td>
							</tr>
						</tbody>
					</table>
					<input type="hidden" name="itemid" value="<%=item.getItemid() %>">

					<input type="submit" value="商品情報変更">
				</form>

			</div>
	</body>
</html>
