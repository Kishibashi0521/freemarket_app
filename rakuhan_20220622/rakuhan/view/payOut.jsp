<html>

<!-- 村上作成 -->

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
		<form action="" method="POST">
			<h3>支払い方法と金額を入力してください。</h3>
			<p>
				支払い方法: 代金引換<input type="radio" name="paid" value="cush">
				カード支払い<input type="radio" name="paid" value="card">
			</p>
			<p>
				金額:<input type="text" name="amount" value="1500">円
			</p>
			<!-- 金額表示のパスを加筆 -->

			<input type="submit" value="決定">

		</form>
	</div>


</body>

</html>