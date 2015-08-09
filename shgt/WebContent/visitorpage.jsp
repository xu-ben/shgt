<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>二手物品交易</title>
</head>
<body bgcolor="#C7EDCC"">

<div><jsp:include page="skimtype.jsp" flush="true"></jsp:include></div>
<br/><br/><br/><br/>
<div align="center">
<form action="MemberView" method="get">
<input type="text" name="keyword"></input>
<button type="submit">搜索</button>
<input type="hidden" name="reqname" value="search"></input>
</form>
</div>
<div><jsp:include page="skimpost.jsp" flush="true"></jsp:include></div>

 <div align="center"><a href="register.jsp">注册</a> 
 <a href="login.jsp">登录</a></div>
<br />
 <div align="center"><font color="blue">
&copy;2011 北京林业大学计算机08-2班软件工程实习第一小组 版权所有 </font></div>
</body>
</html>
