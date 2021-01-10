<%@page import="com.entity.User"%>
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
				<div class="left02top_c"><a href="welcome.jsp">首页面</a></div>
			</div>
		<div class="left02down">
				      
		</div>		
			<form action="sendmessage.jhtml"class="form-horizontal" method="post" style="float: left;  position: absolute;left: 300px; top:150px;font-size:20px"> 
				<fieldset>
				  <div class="control-group">
				    <label class="control-label">接收者</label>
				    <div class="controls">
						 <table class="control-label">
						    <div><input name="reciver" type="text" class="input-large" id="receiver"></div>
					    </table>  
				    </div>				    
				  </div>
				  
				  <div class="control-group">
				    <label class="control-label" >消息内容</label>
				    <div class="controls">	    
				      	<textarea name="content" rows="10" cols="50"  style="resize:none;"></textarea>	 
				    </div>
				  </div>
				  
				  <div class="control-group">
				    <label class="control-label" for="fileInput">添加附件</label>
				    <div class="controls"><input class="input-file" id="fileInput" type="file"></div>
				  </div>
				</fieldset>
				
				<input name="sender" type="hidden" value=<%=request.getSession().getAttribute("User")%> />
				<div class="span10 listing-buttons">
					<input class="btn btn-info" type="submit" value="点击发送" >
				</div>
			</form>
		<div class="left02">
		
			<div class="left02top">
				<div class="left02top_right"></div>
				<div class="left02top_left"></div>
				<div class="left02top_c" id="menu1" onclick="showmenu('1')">通讯管理</div>
			</div>
			
			<div class="left02down" id="list1" style="display:none">
				<div class="left02down01"><a  onclick="show_menuB(82)" href="ListAllFriServlet"><div id="Bf082" class="left02down01_img"></div>通讯录管理</a></div>
				<div class="left02down01"><a href="sendmessage.jsp"><div class="left02down01_img"></div>发送邮件</a></div>
				<div class="left02down01"><a href="ListMessagesServlet"><div class="left02down01_img"></div>收件箱</a></div>			
			</div>
			
		</div>
		
		<div class="left02">		
			<div class="left02top" >
				<div class="left02top_right"></div>
				<div class="left02top_left"></div>
				<div class="left02top_c" id="menu2" onclick="showmenu('2')">个人管理</div>
			</div>			
		<div class="left02down" id="list2" style="display:none">
			<div class="left02down01"><a href="persononeServlet"><div class="left02down01_img"></div>个人信息</a></div>
			<div class="left02down01"><a href="#"><div class="left02down01_img"></div>头像设置</a></div>
			<div class="left02down01"><a href="modify.jsp"><div class="left02down01_img"></div>信息修改</a></div>
		</div>
		</div>
		
		<div class="left02">		
			<div class="left02top">
				<div class="left02top_right"></div>
				<div class="left02top_left"></div>
				<div class="left02top_c" id="menu3" onclick="showmenu('3')">企业管理</div>
			</div>			
			<div class="left02down" id="list3" style="display:none">
				<div class="left02down01"><a href="content.jsp"><div class="left02down01_img"></div>公司公告</a></div>
				<div class="left02down01"><a href="task.jsp"><div class="left02down01_img"></div>工作会议</a></div>		
			</div>			
		</div>
		<div class="left01">		
			<div class="left03_right"></div>
			<div class="left01_left"></div>
			<div class="left03_c"><a href="login.jsp">安全退出</a></div>	
		</div>
	</div>
	<div id="footer" style="position: absolute;left:0px; top:585px;">
		<div class="footer">
			<p color="black"><h2><small>&copy; 17211134130周铭琰|发件箱</small></h2></p>
		</div>
	</div>	
</body>
</html>
