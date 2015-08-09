<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
	<body bgcolor="green">
		<form method="post" action="GetLogin">
		<p>用户名： <input type="text" name="username"></p>
		<p>密码： <input type="password" name="pwd"></p>
		<p><input type="submit" value="登录"> <input
		type="reset" value="重置"></p>
		<p><a href="register.jsp">注册</a></p>
		</form>
	</body>

<script language="JavaScript" type="text/JavaScript">
	var inputusername = document.getElementById("username").value;
	var inputpwd = document.getElementById("pwd").value;
	var form=document.getElementById("screpttex");
	
	if (inputusername.length <= 0) {
		alert("用户名不能为空！");
	} else if (inputpwd.length <= 0) {
		alert("请输入密码");
	}  else {
		form.submit();
	}
}
</script>
</html>
