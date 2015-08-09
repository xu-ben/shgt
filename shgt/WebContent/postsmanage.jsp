<%@page import="shgt.logic.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子列表</title>
</head>
<body>
<%
	Post[] posts = (Post[]) request.getAttribute("posts");
%>
<%
	Integer totalPage = (Integer) request.getAttribute("totalPage");
	Integer curPage = (Integer) request.getAttribute("curPage");
%>
<table align="center" width=1024 border="1">
	<tr>
		<td>标题</td>
		<td>内容</td>
		<td>发表时间</td>
	</tr>
	<%
		int len = posts.length;
		String str = "VisitorView?reqname=showpost&postid=";
	%>
	<%
		for (int i = 0; i < len; i++) {
	%>
	<tr>
		<td><a href = <%=str+posts[i].getId()%>><%=posts[i].getTitle()%></a></td>
		<td><%=posts[i].getDetail_info()%></td>
		<td><%=posts[i].getReleaseDate()%></td>
	</tr>

	<%
		}
	%>
</table>
<p align="center"><span>第<%=curPage%>页</span> <span>共<%=totalPage%>页</span>
<span><a href="PageSelector?reqname=firstpage">首页</a></span> <span><a
	href="PageSelector?reqname=nextpage">下一页</a></span> <span><a
	href="PageSelector?reqname=lastpage">上一页</a></span></p>
</body>
</html>