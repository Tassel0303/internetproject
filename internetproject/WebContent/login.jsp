<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title></title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
<style>
body {
	background: url(4.jpg) center center;
	background-size: cover;
	background-attachment: fixed;
	background-color: #CCCCCC;
	margin: 0 auto;
	margin: 0px;
	padding: 0px;
	overflow-x: hidden;
}
.web_login .login-box{
  background: rgba(255,255, 255, 0.5);
}
</style>
<script type="text/javascript">
	function loginClick(){
		var name=document.getElementById("name");
		var password=document.getElementById("password");
		console.log(password);
		if(name.value=="" ||password.value==""){
			alert("用户名或者密码不能为空！");
			return false;
		}
		else{
			return true;
		}
	}
</script>
</head>
<body>
<h1><sup></sup></h1>

<div class="login" style="margin-top:50px;background:rgba(255,255, 255, 0.5);">
    
    <div class="header" style="background:rgba(255,255, 255, 0);">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">登录</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a>
			<div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 270px; background:rgba(255,255, 255, 0);">    
        <!--登录-->
        <div class="web_login" id="web_login" style="background:rgba(255,255, 255, 0); height:300px;">
             <div class="login-box" style="background:rgba(255,255, 255, 0);" >
    			<div class="login_form" onsubmit="return loginClick()">
					<form action="login.jhtml" name="post" accept-charset="utf-8" id="login_form" class="loginForm" method="post" >
						<input type="hidden" name="did" value="0"/>
		                <input type="hidden" name="to" value="log"/>
		                <div class="uinArea" id="uinArea">
		              		<label class="input-tips" for="u">帐号：</label>
			                <div class="inputOuter" id="uArea">	                    
			                    <input type="text" id="name" name="name" class="inputstyle"/>
		                	</div>
	              		</div>
	              		
		               <div class="pwdArea" id="pwdArea">               
			               <label class="input-tips" for="p">密码：</label> 	               
			               <div class="inputOuter" id="pArea">                    
			                    <input type="password" id="password" name="password" class="inputstyle"/>
			               </div>
		               </div>
	               		<div class="uinArea" id="uinArea">
							 <label class="input-tips">验证码</label>
							<input type="text" class="inputstyle" id="code" placeholder="验证码" autocomplete="off" name="code">
							<div class="ss" style="top:700px;left:300px">
							<img width=100px height=50px src="code.jhtml" onclick="javascript:this.src='/wgqyxx/code.jhtml?id='+new Date().getMilliseconds()">
							</div>
						</div>
						
		                <div  class="uinArea" id="uinArea" style="padding-left:50px;margin-top:20px;">
		                	<input type="submit" value="登 录" style="width:150px;" href="welcome.jsp"class="button_blue"/>
		                </div>
              		</form>
				</div>           
            </div>              
	      </div>
	 <!--登录end-->
	</div>


<div class="login" style="margin-top:50px;background:rgba(255,255, 255, 0);">
<!--注册-->
	<div class="qlogin" id="qlogin" style="display: none; ">   
   	  <div class="web_login">
   		<form name="form2" id="regUser" accept-charset="utf-8"  action="regist.jhtml" method="post">
	    	<input type="hidden" name="to" value="reg"/>
			<input type="hidden" name="did" value="0"/>
      		<ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">快速注册</div>
                <li>
                	<label for="user"  class="input-tips2">*用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="userName" maxlength="16" class="inputstyle2" placeholder="由英文字母和数字组成的4-16位字符，以字母开头"/>
                    </div>                   
                </li>  
                            
                <li>
                <label for="passwd" class="input-tips2">*密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="pwd" name="pwd" maxlength="16" class="inputstyle2" placeholder="由英文字母和数字组成的4-10位字符"/>
                    </div>                    
                </li>
                
                <li>
                <label for="passwd2" class="input-tips2">*确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="pwd2" name="pwd2" maxlength="16" class="inputstyle2" placeholder="确认密码" />
                    </div>                   
                </li>
                
                 <li>
                 <label for=email" class="input-tips2">邮箱：</label>
                    <div class="inputOuter2">                      
                        <input type="text" id="email" name="email"  class="inputstyle2" placeholder="邮箱账号@域名。如good@tom.com、whj@sina.com.cn"/>
                    </div>                   
                </li>
                
                <li>
                <label for="phone" class="input-tips2">电话：</label>
                    <div class="inputOuter2">
                        <input type="text" id="phone" name="phone" maxlength="16" class="inputstyle2" placeholder="由数字组成的11位字符"/>
                    </div>                    
                </li>
                
                <li>
                <label for="yb" class="input-tips2">邮编：</label>
                    <div class="inputOuter2">
                        <input type="text" id="yb" name="yb" maxlength="7" class="inputstyle2" placeholder="由数字组成的5位字符"/>
                    </div>
                    
                </li>  
                    
                <li>
                    <div class="inputArea">
                        <input type="submit" id="reg"  href="regsuc.jsp" name ="submit"style="margin-top:10px;margin-left:85px;" class="button_blue" value="提交"/>
                    </div>                    
                </li>
                <div class="cl"></div>
            </ul>
		</form>   
    </div>
</div>
<!--注册end-->
</div>
</div>
<div class="jianyi" style="padding-top: 60px; clear: both;">
	<div class="col-md-12 text-center">
		<p><small>&copy; 17211134130周铭琰</small></p>
	</div>
</div>
</body>
</html>