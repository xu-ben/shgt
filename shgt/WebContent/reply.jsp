<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回复</title>
</head>
<body bgcolor="#C7EDCC"">

<form method="get" action="MemberView">
<p>标题： <input type="text" name="title"></p>
<p>内容： <input type="text" name="content"></p>
<p><input type="submit" value="发布"> <input
	type="reset" value="重置"></p>
<p>类别：<input name="posttype" type="radio" value=1 checked/>转让
<input name="posttype" type="radio" value=2 />求购</p>	
<div>
上传照片<input type="file"/>
</div>
<input type = "hidden" name = "reqname" value = "releasepost"/>
</form>

</body>
</html>