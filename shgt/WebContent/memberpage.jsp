<%@page import="shgt.logic.GoodsType"%>
<%@page import="shgt.logic.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>浏览帖子</title>
	<link rel="stylesheet" href="images/style.css">
</head>

<body>
		<%
			Member m = (Member)request.getAttribute("user");
		%>
	<header>
		<div id="logo">
		  <img src="images/logo.png" alt="logo" width="392" height="60">
		</div>

		<%
			if(!m.isVIP()) {
		%>
		<div align="center">用户：<%=m.getUsername() %> <a
			href="#">登录</a> <a
			href="register.jsp">注册</a>
		</div>
		<%
			} else {
		%>
		<div align="center">用户：<%=m.getUsername() %> <a
			href="MemberView?reqname=alter">修改个人信息</a> <a
			href="MemberView?reqname=quit">退出</a>
			<a href="MemberView?reqname=toreleasepage">发帖</a>
		</div>
		<%
			}
		%>
        
	    <div id="search">
	<form action="MemberView" method="get"><input type="text"
		name="keyword"></input>
	<button type="submit">搜索</button>
	<input type="hidden" name="reqname" value="search"></input>
	</form>
		</div>
	</header>
	
    <p>&nbsp;</p>
	<div id="container">
	
		<nav>
		  <h3>物品中心</h3>
	<%
		GoodsType[] types = (GoodsType[]) request.getAttribute("types");
		int len = types.length;
		String str = "MemberView?reqname=cleanbytype&typeid=";
	%>
	<%
		for(int i = 0; i < len; i++) {
	%>
	  	<a href = <%=str+types[i].getTypeid()%>><%=types[i].getTypeName()%></a>
	  <%
		}
	  %> 
	  </nav>
		
		<section>
			<article>
				<header>
					<h1>产品展示</h1>
				</header>
				<table align="center" cellpadding="2" cellspacing="2">
  				<tbody>
  					<tr>
					<td align="center">
					<div class="show_pro">
					<table width="220" border="0" cellpadding="0" cellspacing="0" height="300">
					<tbody>
        				<tr>
          				<td valign="top" align="center"><br><img src="images/s_003.jpg" width="182" border="0" height="190">
                        </td>
                        </tr>
        				<tr>
          				<td style="padding-left: 18px;" valign="top" align="left">
            			<p class="title2"><b>Pba芭蓓萃控油紧致乳液</b></p>
            			<p class="marketprice">原价：￥350</p>
            			<p class="memberprice">二手价：<font color="#ff0000">￥28</font></p>
                        </td>
                        </tr>
					</tbody>
					</table>
                    </div>
                    </td>
					<td align="center">
      				<div class="show_pro">
					<table width="220" border="0" cellpadding="0" cellspacing="0" height="300">
					<tbody>
						<tr>
						<td valign="top" align="center"><br><img src="images/s_015.jpg" width="182" border="0" height="190">
						</td>
						</tr>
						<tr>
						<td style="padding-left: 18px;" valign="top" align="left">
						<p class="title2"><b>希思黎sisley美颈霜50m</b></p>
						<p class="marketprice">原价：￥350</p>
						<p class="memberprice">二手价：<font color="#ff0000">￥28</font></p>
						</td>
						</tr>
					</tbody>
					</table>
					</div>
					</td>
					<td align="center">
					<div class="show_pro">
					<table width="220" border="0" cellpadding="0" cellspacing="0" height="300">
					<tbody>
					<tr>
					<td valign="top" align="center"><br><img src="images/s_017.jpg" width="182" border="0" height="190">
					</td>
					</tr>
					<tr>
					<td style="padding-left: 18px;" valign="top" align="left">
					<p class="title2"><b>相宜本草幼白精华面膜</b></p>
					<p class="marketprice">原价：￥350</p>
					<p class="memberprice">二手价：<font color="#ff0000">￥28</font></p></td></tr></tbody></table></div></td></tr></tbody></table>
			</article>
			
			<article>
				<header>
					<h1>帖子信息</h1>
				</header>
				<jsp:include page="skimpost.jsp" flush="true"></jsp:include>
				
			</article>
		</section>
		
				
		<footer>
			<h2>Footer</h2>
		</footer>
		
</div>
</body>
</html>