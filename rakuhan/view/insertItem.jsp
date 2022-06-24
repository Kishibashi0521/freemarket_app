<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>出品登録</title>
</head>
<body>
<!-- <include file="/common/header.jsp" %> -->
	<div>
		<div>
			<div>
				<ul>
					<li><a href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー]</a></li>
		<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>出品登録</title>
</head>
<body>
<!-- <include file="/common/header.jsp" %> -->
	<div>
		<div>
			<div>
				<ul>
					<li><a href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー]</a></li>
				</ul>
			</div>
			<div>
				<h2>出品登録</h2>
			</div>
		</div>
	</div>
	<hr align="center" size="2" color="black" width="950"></hr>

	<form action="<%=request.getContextPath()%>/insertItem">
		<table style="margin: 0 auto">
			<tr>
				<td bgcolor="#39F" style="width: 100">商品名</td>
				<td><input type=text size="30" name="itemname"></input></td>
			</tr>
			<tr>
				<td bgcolor="#39F" style="width: 100">価格</td>
				<td><input type=text size="30" name="price"></input></td>
			</tr>
			<tr>
				<td bgcolor="#39F" style="width: 100">種類</td>
				<td><select name="type" style="width: 248">
						<option value="0">アクセサリー</option>
						<option value="1">食器</option>
						<option value="2">インテリア</option>
						<option value="3">おもちゃ</option>
						<option value="4">その他</option>
				</select></td>
			</tr>
			<tr>
				<td bgcolor="#39F" style="width: 100">商品説明
				</th>
				<td><input type=text size="30" name="comment"></td>
			</tr>
			<tr>
				<td colspan=2 style="text-align: center"><input type="submit"
					value="出品"></td>
			</tr>
		</table>
	</form>
	<!--<include file="/common/footer.jsp"%>-->
</body>
</html>		</ul>
			</div>
			<div>
				<h2>出品登録</h2>
			</div>
		</div>
	</div>
	<hr align="center" size="2" color="black" width="950"></hr>

	<form action="<%=request.getContextPath()%>/insertItem">
		<table style="margin: 0 auto">
			<tr>
				<td bgcolor="#39F" style="width: 100">商品名</td>
				<td><input type=text size="30" name="itemname"></input></td>
			</tr>
			<tr>
				<td bgcolor="#39F" style="width: 100">価格</td>
				<td><input type=text size="30" name="price"></input></td>
			</tr>
			<tr>
				<td bgcolor="#39F" style="width: 100">種類</td>
				<td><select name="type" style="width: 248">
						<option value="0">アクセサリー</option>
						<option value="1">食器</option>
						<option value="2">インテリア</option>
						<option value="3">おもちゃ</option>
						<option value="4">その他</option>
				</select></td>
			</tr>
			<tr>
				<td bgcolor="#39F" style="width: 100">商品説明
				</th>
				<td><input type=text size="30" name="comment"></td>
			</tr>
			<tr>
				<td colspan=2 style="text-align: center"><input type="submit"
					value="出品"></td>
			</tr>
		</table>
	</form>
	<!--<include file="/common/footer.jsp"%>-->
</body>
</html>