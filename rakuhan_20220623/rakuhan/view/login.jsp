<%@page contentType="text/html; charset=UTF-8"%>

<%
String userid ="";  //ユーザーを管理する変数
String pass ="";    //パスワードを管理する変数
String error =(String)request.getAttribute("error");	//エラーメッセージ用変数
Cookie[] userCookie = request.getCookies();
Cookie[] passwordCookie = request.getCookies(); //クッキーの取得


//クッキーがあるかどうかの判定
if(userCookie != null){
		for(int i = 0 ; i < userCookie.length; i++){
				//クッキーからユーザ情報の取得
				if(userCookie[i].getName().equals("userid")){
					userid = userCookie[i].getValue();
					}

				//クッキーからパスワード情報の取得
				if(userCookie[i].getName().equals("pass")){
					pass = passwordCookie[i].getValue();
				}
		}
}

if(error == null){
	error = "";
}
%>
<html>
	<head>
		<title>ログイン機能</title>
	</head>
	<body>
		<!--  ヘッダの読み込み  -->
		<%@include file = "/common/header.jsp"%>
		<p><%=error %></p>
		<form action="<%=request.getContextPath() %>/login" method="post">
		<table>
			<tr>
				<td>ユーザー</td>
				<td><input type="text"name="userid" ></input></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="text"name="pass" ></input></td>
			</tr>
			<tr>
				<td>
				<P align="center"><INPUT TYPE="SUBMIT" VALUE="&nbsp;ログイン&nbsp;"></INPUT></P>
				</td>
			</tr>

			<tr>
				<td><a href = "<%=request.getContextPath()%>/view/insertUser.jsp" >【新規登録はこちら】</a></td>
			</tr>
		</table>
		</form>
		<!-- フッタの読込 -->
		<%@include file = "/common/footer.jsp"%>
	</body>
</html>
