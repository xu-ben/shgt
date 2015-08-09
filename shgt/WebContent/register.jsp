<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<style type="text/css">
@import url("images/style2.css");
body {
	background-image: url(images/bg.jpg);
}
.main .main_bg #main_neiye .main_right .neiye_detail_content div .tuijian_pro .bigpic {
	background-image: url(images/1.jpg);
}
.main .main_bg #main_neiye .main_left #box0 .box_m div {
	border-top-width: 2px;
	border-right-width: 2px;
	border-bottom-width: 20px;
	border-left-width: 2px;
	border-top-color: #CCC;
	border-right-color: #CCC;
	border-bottom-color: #CCC;
	border-left-color: #CCC;
}
.main .main_bg #main_neiye .neiye_detail_content .register #script #screpttex fieldset p {
	font-family: "微软雅黑";
	font-size: 14px;
	color: #600;
}
.main .main_bg #main_neiye .neiye_detail_content .register #script h1 {
	font-family: "微软雅黑";
	font-size: 18px;
	font-weight: bold;
	color: #F60;
}
.main .main_bg #main_neiye .neiye_detail_content .register #script #screpttex p {
	font-family: "微软雅黑";
	font-size: 14px;
	color: #600;
}
</style>
</head>

<body background="images/bg1.jpg">

<style>.main{background-attachment:scroll; background-image:url(images/bg1.jpg)}</style>
<div class=main ><!--header  begin-->
<div id=header>
<div class=logo><IMG alt="logo" src="images/logo.png"></div>
<div class=Hcenter>
<div class=hot_line>　　　　
</div>
<div>
<div id=search>
<div class=left>搜索&nbsp;</div>
<div class=right>

<form action="MemberView" method="get">
<input type="text" name="keyword"></input>
<button type="submit">提交</button>
<input type="hidden" name="reqname" value="search"></input>
</form>
</div></div>

</div></div>
<div class=Hright>
<div class=sign><a 
href="login.asp"><b>欢迎你，游客！　</b></a>
<a href="../Shgt/login.html"><b>登录　</b></a>
<a href="register.html"><b>注册</b></a>

</div>
<div class=bcount><a id=shop_car 
href="http://www.mobanku.com/test/02457/shopcart.asp">购物车&nbsp;<FONT  
color=#ff0000><b>0</b></FONT>&nbsp;件</a></div></div></div>
<div class=clear></div><!--header  begin--><!--nav  begin-->
<div>
<div id=global-header>
<div class=nav>
<UL>
  <LI id=index_nav><a href="http://www.mobanku.com/test/02457/index.asp">首页</a> 
  </LI>
  <LI id=newslist_nav><a 
  href="http://www.mobanku.com/test/02457/newslist.asp">新闻</a> </LI>
  <LI><a href="http://www.mobanku.com/test/02457/products.asp?bid=30">办公用品</a> 
  </LI>
  <LI id=products_nav><a 
  href="http://www.mobanku.com/test/02457/products.asp?bid=1">家居用品</a> </LI>
  <LI id=products_nav><a 
  href="http://www.mobanku.com/test/02457/products.asp?bid=27">电子产品</a> </LI>
  <LI id=products_nav><a 
  href="http://www.mobanku.com/test/02457/products.asp?bid=28">饮料饮品</a> </LI>
  <LI id=products_nav><a 
  href="http://www.mobanku.com/test/02457/products.asp?bid=29">护肤产品</a> </LI>
  <LI id=products_nav><a 
  href="http://www.mobanku.com/test/02457/products.asp?bid=30">户外用品</a> </LI>
  <LI><a href="http://www.mobanku.com/test/02457/products.asp?bid=30">服装配饰</a> 
  </LI></UL></div></div>
<SCRIPT language=javascript>
 	var geturl=window.location.pathname;
		switch (geturl){
			case '/index.asp':
			document.getElementbyId('index_nav').className='on';
			break
			case '/about.asp':
			 document.getElementbyId('about_nav').className='on';
			break
			case '/showabout.asp':
			 document.getElementbyId('about_nav').className='on';
			break
			case '/newslist.asp':
			 document.getElementbyId('newslist_nav').className='on';
			break
			case '/news.asp':
			 document.getElementbyId('newslist_nav').className='on';
			break
			case '/links.asp':
			 document.getElementbyId('links_nav').className='on';
			break
			case '/products.asp':
			document.getElementbyId('products_nav').className='on';
			break
			case '/productshow.asp':
			document.getElementbyId('products_nav').className='on';
			break
		


			case '/service.asp':
			document.getElementbyId('service_nav').className='on';
			break
			case '/showservice.asp':
			 document.getElementbyId('service_nav').className='on';
			break
			case '/sales.asp':
			document.getElementbyId('sales_nav').className='on';
			break
			case '/showsales.asp':
			document.getElementbyId('sales_nav').className='on';
			break
			case '/down.asp':
			document.getElementbyId('down_nav').className='on';
			break
			case '/showdown.asp':
			document.getElementbyId('down_nav').className='on';
			break
			case '/anli.asp':
			document.getElementbyId('anli_nav').className='on';
			break
			case '/showanli.asp':
			document.getElementbyId('anli_nav').className='on';
			break
			case '/support.asp':
			document.getElementbyId('support_nav').className='on';
			break
			case '/showsupport.asp':
			 document.getElementbyId('support_nav').className='on';
			break
			case '/contact.asp':
			 document.getElementbyId('contact_nav').className='on';
			break
			case '/showcontact.asp':
			 document.getElementbyId('contact_nav').className='on';
			break
			case '/liuyan.asp':
			 document.getElementbyId('liuyan_nav').className='on';
			break
			case '/liuyanlist.asp':
			 document.getElementbyId('liuyan_nav').className='on';
			break

			default:
			document.getElementbyId('index_nav').className='on';
			
		}
</SCRIPT>
</div><!--nav  end--><!--灰色主要内容部分-->
<div class=main_bg><!--公告部分   开始-->
<div id=gonggao>
<div class=title>网站公告：</div>
<div class=content>
<MaRQUEE onmouseover=this.stop() onmouseout=this.start() width=750 
scrollamount=2>欢迎来到SHGT校园易物网！请在这里挑选你喜欢的二手商品！同时欢迎发帖出售物品！</MaRQUEE></div></div>
<div class=clear></div><!--公告部分  结束-->

<!--左侧列表和右侧详细 部分-->
<div id=main_neiye>
<!--当前位置   begin-->
	<div class=neiye_detail_content>
		<div>


		</div>
		
			<div class=register>

				<div id="script" align="center">
                    <h1>用户注册</h1>
                    <p>&nbsp;</p>
                  <form name="scriptex" id="screpttex" action="MemberView" method="post">
                     <div>
                     <fieldset>
                    
                        <p>&nbsp;</p>
                        <p>
                          <label for="username">用　户　名　　　:</label>
                          <input name="username" type="text" id="username" /></p>
                      <p>&nbsp;</p>
                        <p>
                          <label for="password">密　　　码　　　:</label>
                      <input type="password" name="password" id="password" /></p>
                      <p>&nbsp;</p>
                      <p>
                        <label for="password_S">确　认　密　码　:</label>
                      <input type="password" name="password_S" id="password_S" /></p>
                      <p>&nbsp;</p>
                      <p>
                        <label for="email">电　子　邮　箱　:</label>
                      <input type="text" name="email" id="email" /></p>
                        <p>&nbsp;</p>
                      </fieldset>
                      </div>
                      <div >
                        <fieldset>
                      
                        <p>&nbsp;</p>
                        <p>
                          <label for="sex">性　　　　　别　:　</label>
                          <input name="sex" type="radio" value=1 id="Mann"/>
                          <label for="Mann">♂　  　　　</label>
                          <input name="sex" type="radio" value=0 id="Frau" checked/><label for="Frau">♀</label></p>
                        <p>&nbsp;</p>
                        <p class="clear">
                          <label for="identityid">身　份　证　号　: </label><input type="text" name="identityid" id="identityid" /></p>
                        <p>&nbsp;</p>
                        <p>
                          <label for="telephone">电　话　号　码　:</label>
                          <input type="text" name="telephone" id="telephone" /></p>
                        <p>&nbsp;</p>
                        </fieldset>
                        </div>
                    <div id="divCode" style="background-color:White; width:250px; height:50px; padding:5px; text-align:center; vertical-align:middle; letter-spacing:10px; font-size: 40px; border:solid 2px blue; border-left-width: medium;">
                        <span></span><span></span><span></span><span ></span><span ></span><span ></span>
                        </div >
                        <p>&nbsp;</p>
                        <p>请输入验证码:
                        <input type="text" id="codeinput"/>
                        <input id="switch" type="button" value="换一张" onclick="JavaScript:validteCode()"/> 
                        </p>
                    <p>&nbsp;</p>
                        <p>
                          <input type="hidden" name="reqname" value="register" />
                          <input type="button" value="确定" onclick="validate();" /> 
                          　　　
                          <input type="reset" value="重填" />
                        </p>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                  </form>
                </div>
                <div id="mailto">
                    
                 </center>
</div>
                
            
<script language="JavaScript" type="text/JavaScript">
	var code; //在全局 定义验证码
	function validteCode() {
		code = "";
		var codes = new Array(6); //用于存储随机验证码 
		var str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		var chars = str.split("");
		var colors = new Array("Red", "Green", "Gray", "Blue", "Maroon",
				"Aqua", "Fuchsia", "Lime", "Olive", "Silver");
		for ( var i = 0; i < codes.length; i++) {//获取随机验证码 
			codes[i] = chars[Math.floor(Math.random() * 62)];
			code += codes[i];
		}
		var spans = document.getElementById("divCode").getElementsByTagName("span");
		for ( var i = 0; i < spans.length; i++) {
			spans[i].innerHTML = codes[i];		
			spans[i].style.color = colors[Math.floor(Math.random() * 10)]; //随机设置验证码颜色 
		}
	}
	function validate() {
		var inputusername = document.getElementById("username").value;//用户名判断
		var inputpassword = document.getElementById("password").value;//密码判断
		var inputpassword_S = document.getElementById("password_S").value;//确认密码判断
		var inputCode = document.getElementById("codeinput").value;//验证码判断
		var inputemail = document.getElementById("email").value;//电子邮箱判断
		var inputidentityid = document.getElementById("identityid").value;//身份证判断
		var inputtelephone = document.getElementById("telephone").value;//电话号码判断
		var form=document.getElementById("screpttex");
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;

		if(inputusername.length <= 0){
			alert("请输入用户名");
		} else if(inputpassword.length <= 0){
			alert("请输入密码");
		} else if (inputpassword.length > 0 && inputpassword.length < 6){
			alert("密码长度不能小于6位，请重新输入！");
		} else if (inputpassword_S.length <= 0){
			alert("请确认密码");
		} else if (inputpassword_S.toLowerCase() != inputpassword.toLowerCase()){
			alert("两次密码不匹配，请重新输入密码！");
		} else if ( inputemail.length <= 0){
			alert("请输入电子邮箱地址!");
		} else if (!reg.test(inputemail)){
			alert("邮箱格式不正确！");
		} else if (inputidentityid.length > 0 && inputidentityid.length < 15){
			alert("身份证号码不能小于15位！");
		} else if (inputtelephone.length > 0 && inputtelephone.length < 7){
			alert("电话号码不能小于7位！");
		} else if (inputCode.length <= 0) {
			alert("请输入验证码！");
		} else if (inputCode.toLowerCase() != code.toLowerCase()) {
			alert("验证码错误！");
			validteCode();//刷新验证码
		} else {
			form.submit();
		}
	}
	document.onload = validteCode();
</script>
</div>
</div></div>


<!--当前位置  end--></div>
<DIV class=clear></DIV><!--左侧列表和右侧详细   部分-->
<DIV><IMG alt="" src="images/box2_t.gif"><IMG alt="" src="images/box2_t.gif"><IMG alt="" src="images/box2_t.gif"><IMG alt="" src="images/box2_t.gif"><IMG alt="" src="images/box2_t.gif"></DIV><!--灰色主要内容部分--><DIV class=clear></DIV><!--地底部导航  开始-->
<DIV><!-- help nav start --><!-- help nav end -->
<TABLE id=index_help border=0 cellSpacing=0 cellPadding=0 align=center>
  <TBODY>
  <TR>
    <TD class="dl_1 td" vAlign=top align=middle>
      <TABLE border=0 cellSpacing=0 cellPadding=0 align=center><!-- 大类 start -->
        <TBODY>
        <TR>
          <TD class=help_big vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?typeid=1">责任声明</A></TD></TR><!-- 大类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=1">网站版规</A></TD></TR><!-- 小类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=41">责任声明</A></TD></TR><!-- 小类 end --></TBODY></TABLE></TD>
    <TD class="dl_2 td" vAlign=top align=middle>
      <TABLE border=0 cellSpacing=0 cellPadding=0 align=center><!-- 大类 start -->
        <TBODY>
        <TR>
          <TD class=help_big vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?typeid=5">关于网站</A></TD></TR><!-- 大类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=16">常见问题</A></TD></TR><!-- 小类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=32">疑难解答</A></TD></TR><!-- 小类 end --></TBODY></TABLE></TD>
    <TD class="dl_3 td" vAlign=top align=middle>
      <TABLE border=0 cellSpacing=0 cellPadding=0 align=center><!-- 大类 start -->
        <TBODY>
        <TR>
          <TD class=help_big vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?typeid=8">关于举报</A></TD></TR><!-- 大类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=39">举报条款</A></TD></TR><!-- 小类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=40">举报方式</A></TD></TR><!-- 小类 end --></TBODY></TABLE></TD>
    <TD class="dl_4 td" vAlign=top align=middle>
      <TABLE border=0 cellSpacing=0 cellPadding=0 align=center><!-- 大类 start -->
        <TBODY>
        <TR>
          <TD class=help_big vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?typeid=3">新手上路</A></TD></TR><!-- 大类 end --><!-- 小类 start --><!-- 小类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=34">怎样购物</A></TD></TR><!-- 小类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=38">网站声明</A></TD></TR><!-- 小类 end --></TBODY></TABLE></TD>
    <TD class="dl_5 td" vAlign=top align=middle>
      <TABLE border=0 cellSpacing=0 cellPadding=0 align=center><!-- 大类 start -->
        <TBODY>
        <TR>
          <TD class=help_big vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?typeid=7">申请合作</A></TD></TR><!-- 大类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=31">申请区块管理</A></TD></TR><!-- 小类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=37">友情合作</A></TD></TR><!-- 小类 end --></TBODY></TABLE></TD>
    <TD class="dl_6 td" vAlign=top align=middle>
      <TABLE border=0 cellSpacing=0 cellPadding=0 align=center><!-- 大类 start -->
        <TBODY>
        <TR>
          <TD class=help_big vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?typeid=4">关于我们</A></TD></TR><!-- 大类 end --><!-- 小类 start --><!-- 小类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=35">联系我们</A></TD></TR><!-- 小类 end --><!-- 小类 start -->
        <TR>
          <TD class=help_small vAlign=top align=left><A 
            href="http://www.mobanku.com/test/02457/help.asp?id=36">诚聘英才</A></TD></TR><!-- 小类 end --></TBODY></TABLE></TD></TR></TBODY></TABLE></DIV><!--地底部导航   end--><!--版权和友情链接  开始-->
<DIV id=footer>
<div class=copyright>&copy; 北京林业大学计算机08-2班 第一软件工程小组 版权所有</div>
</div><!--版权和友情链接 end-->
</div>

</body>
</html>
