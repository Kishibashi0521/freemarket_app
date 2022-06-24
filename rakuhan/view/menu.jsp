<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.*,bean.*,dao.*"%>

<!-- 高瀬作成 -->
<HTML>
	<HEAD>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<TITLE>Menu</TITLE>
	</HEAD>

	<BODY>
		<!-- ヘッダの読込 -->
		<%@include file = "/common/header.jsp"%>

		<!-- ログイン者情報の表示 -->
		<%@include file = "/common/userinfo.jsp"%>



		<%
		//管理者か一般ユーザかでメニューを切り替える
		User user = (User)session.getAttribute("user");

		if(user.getAuthority().equals("0")){
			//権限が「0」なら管理者
		%>
			<P align="center"><FONT size="5">管理者MENU</FONT></P>
		<HR align="center" size="3" color="BLACK" width="950"></HR>

			<TABLE>
				<TR><TD><A href="<%=request.getContextPath()%>/userList">【ユーザー一覧表示】</A></TD></TR>
				<TR><TD>&nbsp;</TD></TR>
				<TR><TD><A href="<%=request.getContextPath()%>/showCart">【商品一覧】</A></TD></TR>
				<TR><TD>&nbsp;</TD></TR>
				<TR><TD><A href="<%=request.getContextPath()%>/salesConfirm">【売上確認】</A></TD></TR>
				<TR><TD>&nbsp;</TD></TR>
				<TR><TD>&nbsp;</TD></TR>
				<TR><TD><A href="<%=request.getContextPath()%>/logout">【ログアウト】</A></TD></TR>
			</TABLE>
		<%
		}else{
			//権限が「1」ならユーザー
		%>
			<P align="center"><FONT size="5">ユーザーMENU</FONT></P>
		<HR align="center" size="3" color="BLACK" width="950"></HR>
			<TABLE>
				<TR><TD><A href="<%=request.getContextPath()%>/itemList">【商品一覧】</A></TD></TR>
				<TR><TD>&nbsp;</TD></TR>
				<TR><TD><A href="<%=request.getContextPath()%>/view/insert.jsp">【出品】</A></TD></TR>
				<TR><TD>&nbsp;</TD></TR>
				<TR><TD><A href="<%=request.getContextPath()%>/boughtItemList">【購入済商品一覧】</A></TD></TR>
				<TR><TD>&nbsp;</TD></TR>
				<TR><TD><A href="<%=request.getContextPath()%>/userDetail">【ユーザー情報詳細(自身)】</A></TD></TR>
				<TR><TD>&nbsp;</TD></TR>

				<TR><TD>&nbsp;</TD></TR>
				<TR><TD>&nbsp;</TD></TR>

				<TR><TD><A href="<%=request.getContextPath()%>/logout">【ログアウト】</A></TD></TR>
			</TABLE>
		<%
		}
		%>
		<!-- フッタの読込 -->
		<%@include file = "/common/footer.jsp"%>
    </BODY>

</HTML>