<%@page import="shgt.logic.Member"%>
<%@page import="shgt.logic.Comment"%>
<%@page import="shgt.logic.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%
		Post p = (Post) request.getAttribute("curpost");
		Comment[] coms = p.getAllComments();
		Member m = (Member)request.getAttribute("user");
	%>
	<head>
		<link rel="stylesheet" href="index2.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%=p.getTitle()%></title>
		<script type="text/javascript">
			function reply() {
				var a = window.prompt("请输入留言");
				var form = document.getElementById("replyform");
				var input = document.getElementById("content");
				input.value = a;
				form.submit();
			}
		</script>
	</head>
	<body>
	<header>
		<table align="center" width=1024 border=1>
			<tr>
				<td><%=p.getTitle()%></td>
			</tr>
			<tr>
				<td><%=p.getDetail_info()%></td>
			</tr>
		</table>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
			<%
				if(m.isVIP()) {
			%>
			<form action="MemberView" method="get" id="replyform">
					<input type ="hidden" name ="reqname" value = "reply" />
					<input type ="hidden" name ="postid" value = <%=p.getId()%> />
					<input type="hidden" name="content" id="content" />
					<p align ="center"><a href="#" onclick="JavaScript:reply()">回复</a></p>
			</form>
			<%
				}
			%>
		<table align="center" width=1024 border=1>
			<tr>
				<td>内容</td>
				<td>回复人</td>
			</tr>
			<%
				for (int i = 0; i < coms.length; i++) {
			%>
			<tr>
				<td><%=coms[i].getContent()%></td>
				<td><%=coms[i].getUserName() %></td>
			</tr>
			<%
				}
			%>
		</table>
		</header>
	</body>
</html>
