
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>企业系统管理_首页周铭琰</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function showmenu(id) {
	 var list = document.getElementById("list"+id);
	 var menu = document.getElementById("menu"+id)
	 if (list.style.display=="none") {
	 	document.getElementById("list"+id).style.display="block";
	 	menu.className = "left02top_c1";
	 }
	 else {
	 	document.getElementById("list"+id).style.display="none";
	 	menu.className = "left02top_c";
	 }
} 
</script>
</head>

<body>
<div class="header">
	<div class="header03"></div>
	<div class="header01"></div>
	<div class="header02">企业信息管理系统</div>
</div>
<h1 align="center" size="20"><font face="STKaiti">欢迎来到企业管理系统</font></h1>
<div class="left" id="LeftBox">
	<div class="left01">
		<div class="left01_right"></div>
		<div class="left01_left"></div>
		<% String name = (String)session.getAttribute("u"); %>
		<div class="left01_c"><a>当前用户：Hi,<%=name %></a></div>
	</div>
	
	<div class="left02">
		<div class="left02top">
			<div class="left02top_right"></div>
			<div class="left02top_left"></div>
			<div class="left02top_c"><a  href="welcome.jsp">首页面</a></div>
		</div>
	  <div class="left02down">      
	</div>
<div class="left02">
		<div class="left02top">
			<div class="left02top_right"></div>
			<div class="left02top_left"></div>
			<div class="left02top_c" id="menu1" onclick="showmenu('1')"><a href="#">通讯管理</a></div>
		</div>
		<div class="left02down" id="list1" style="display:none">
			<div class="left02down01"><a  onclick="show_menuB(82)" href="ListAllUsersServlet"><div id="Bf082" class="left02down01_img"></div>通讯录管理</a></div>
			<div class="left02down01"><a href="sendmessage.jsp"><div class="left02down01_img"></div>发送邮件</a></div>
			<div class="left02down01"><a href="ListMessagesServlet" ><div class="left02down01_img"></div>收件箱</a></div>
			
		</div>
	</div>
	<div class="left02">
		<div class="left02top">
			<div class="left02top_right"></div>
			<div class="left02top_left"></div>
			<div class="left02top_c" id="menu2" onclick="showmenu('2')"><a href="#">个人管理</a></div>
		</div>
		<div class="left02down" id="list2" style="display:none">
			<div class="left02down01"><a href="#"><div class="left02down01_img"></div>个人信息</a></div>
			<div class="left02down01"><a href="#"><div class="left02down01_img"></div>头像设置</a></div>
			<div class="left02down01"><a href="#"><div class="left02down01_img"></div>信息修改</a></div>
		</div>
	</div>
	<div class="left02">
		<div class="left02top">
			<div class="left02top_right"></div>
			<div class="left02top_left"></div>
			<div class="left02top_c"id="menu3" onclick="showmenu('3')""><a href="#">企业管理</a></div>
		</div>
		<div class="left02down" id="list3" style="display:none">
			<div class="left02down01"><a href="#"><div class="left02down01_img"></div>公司公告</a></div>
			<div class="left02down01"><a href="#"><div class="left02down01_img"></div>工作会议</a></div>
	
		</div>
	</div>
	<div class="left01">
		<div class="left03_right"></div>
		<div class="left01_left"></div>
		<div class="left03_c"><a href="login.jsp">安全退出</a></div>
	</div>
</div>
<div id="section" class="center" style="position: absolute;left:300px;width:320px;top:130px;">
	<form action="add.jhtml" name="add" method="post">
		<table class="add">
			<tr>
		        <td width="96px">
		        	<font face="黑体" size="5px">添加新联</font>
		        </td>
		        <td><font face="黑体" size="5px">系人</font></td>
		    </tr>
		    <tr>
		        <td width="96px">姓名：</td>
		        <td width="65%">
		            <input type="text" name="name" id="name"/>
		        </td>
		    </tr>
		    <tr>
		    <tr>
		        <td>性别</td>
		        <td>
		            <input type="text" name="sex" id="sex"/>
		        </td>
		    </tr>
		    <tr>
		        <td>电话</td>
		        <td>
		            <input type="text" name="phone" id="phone"/>
		        </td>
		    </tr>
		    <tr>
		        <td>Email</td>
		        <td>
		            <input type="text" name="email" id="email"/>
		        </td>
		    </tr>
		    <tr>
		        <td>QQ</td>
		        <td>
		            <input type="text" name="qq" id="qq"/>
		        </td>
		    </tr>
		    <tr>
		        <td>单位</td>
		        <td>
		            <input type="text" name="job" id="job"/>
		        </td>
		    </tr>
		    <tr>
		        <td>地址</td>
		        <td>
		            <input type="text" name="location" id="location"/>
		        </td>
		    </tr>
		    <tr>
		        <td>邮编</td>
		        <td>
		            <input type="text" name="postcode" id="postcode"/>
		        </td>
		    </tr>
		    <tr>
		        <td>
		            <input type="submit" name="submit" value="新增联系人"/>
		        </td>
		    </tr>
		</table>
	</form>
</div>
<div id="footer" style="position: absolute;left:0px; top:585px;">
		<div class="footer">
			<p color="black"><h2><small>&copy; 17211134130周铭琰|新增联系人</small></h2></p>
		</div>
	</div>			
</body>
</html>