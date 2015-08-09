<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shgt.logic.GoodsType"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物品分类管理</title>
</head>
<body>

<table align="center" width=1024 border = 1>
	<%
		GoodsType[] types = (GoodsType[]) request.getAttribute("types");
		int len = types.length;
		String del = "AdminView?reqname=deleteType&typeid=";
		String alt = "AdminView?reqname=alterType&typeid=";
	%>
	<%
		for (int i = 0; i < len; i++) {
	%>
	<tr>
		<td><%=types[i].getTypeName()%></td>
		<td><a href = <%=alt+types[i].getTypeid() %>>修改</a></td>
		<td><a href = <%=del+types[i].getTypeid() %>>删除</a></td>
	</tr>
	<%
		}
	%>
</table>

</body>
</html>