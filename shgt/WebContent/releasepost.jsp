<%@page import="shgt.logic.GoodsType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>发布帖子</title>
		<link rel="stylesheet" href="index2.css"/>
	</head>
	<body>
	<header>
		<%
			GoodsType[] types = (GoodsType[])request.getAttribute("types");
		%>	
		<form method="post" action="MemberView" enctype="multipart/form-data">
			<div>
				<p>标题： <input type="text" name="title"></p>
				<p>内容： <input type="text" name="content"></p>
				<p>类别：<input name="posttype" type="radio" value=1 checked/>转让
				<input name="posttype" type="radio" value=2 />求购</p>
			</div>	
			<div>
				<p>物品信息：</p>
				<p>名称：<input type="text" name="name"/></p>
				<p>价格：<input type="text" name="price"/></p>
				<p>描述：<input type="text" name="description"/></p>
				<p>物品分类：
				<select name="goodstype" size=1>
					<%
						for(int i = 0; i < types.length; i++) {
					%>
						<option value=<%=types[i].getTypeName()%>><%=types[i].getTypeName()%></option>
					<%
						}
					%>
				</select>
				</p>
				<p>上传照片：<input type="file" name="picname"/></p>
				<p><input type="submit" value="发布">
				 <input	type="reset" value="重置">
				 </p>
			</div>
			<input type = "hidden" name = "reqname" value = "releasepost"/>
		</form>		
		</header>
	</body>
</html>
