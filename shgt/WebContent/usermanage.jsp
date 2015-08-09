<%@page import="shgt.logic.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>

<table align="center" width=1024 border = 1>
	<%
		Member [] users = (Member[]) request.getAttribute("users");
		int len = users.length;
		String del = "AdminView?reqname=deleteMember&userid=";
		String alt = "AdminView?reqname=alterMember&userid=";
	%>
	<%
		for (int i = 0; i < len; i++) {
	%>
	<tr>
		<td><%=users[i].getUsername()%></td>
		<td><a href = <%=alt+users[i].getId()%>>修改</a></td>
		<td><a href = <%=del+users[i].getId()%>>删除</a></td>
	</tr>
	<%
		}
	%>
</table>

</body>
</html>