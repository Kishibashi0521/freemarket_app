<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Sales"%>

<!-- 新倉作成 -->

<%

String send = "";
String payMent = "";
String conp = "";


ArrayList<Sales> sales =(ArrayList<Sales>)request.getAttribute("sales_list");
if(sales != null){
	for(int i=0;i<sales.size();i++){
		Sales sales1 = (Sales)list.get(i);

if(sales1.getSend())

%>
<html>
	<head>
		<title>取引情報画面</title>
	</head>
	<body>
		<!--<%@include file= "/common/header.jsp"%>-->
			<table align="center" width="850">
			<tr>
				<td width="80">[<a href="<%=request.getContextPath() %>/view/login.jsp">メニュー</a>]</td>
				<td width="80">[<a href="<%=request.getContextPath() %>/view/menu.jsp">メニュー</a>]</td>
				<td width="508" align="center" ><font size="5">取引情報</font></td>
				<td width="80">&nbsp;</td>
				<td width="80">&nbsp;</td>
			</tr>
			</table>

		<hr align="center" size="2" color="black" width="950"></hr>


			<table align="center" style="margin: 0 auto">
				<tr>
					<th bgcolor="#39F"style="width: 200">発送情報</td>
				</tr>
				<tr>
					<th align="center" width="200">aaa<!--%=表示内容%--></th>
				</tr>
				</table>
				<table style="margin: 0 auto">
				<tr>
					<th bgcolor="#39F"style="width: 200">入金情報</td>
				</tr>
				<tr>
					<th align="center" width="200">aaa<!--%=表示内容%--></th>
				</tr>
				<tr>
					<th bgcolor="#39F"style="width: 200">完了済情報</td>
				</tr>
				<tr>
					<th align="center" width="200">aaa<!--%=表示内容%--></th>
				</tr>
			</table>
			<%
			}
	}
			%>
		<!--<%@include file= "/common/footer.jsp"%>-->
	</body>
</html>