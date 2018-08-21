<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>选课系统</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
	
	<script type="text/javascript">
	function changeAction(){
                                //默认是login.action，当select改变时同时改变from的action属性
                                //我这里直接把列表的value赋值到form的action，你可以根据需要改改
		var selectValue=document.getElementById('select').value;
		document.forms[0].action=selectValue;
	}
	</script>
</head>
<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">欢迎登陆选课系统</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="StuLogin" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input type="text" class="form-control" id="id" name="id" placeholder="学生ID/教师ID/管理员ID">
		            	<p class="bg-danger text-danger"><s:fielderror fieldName="IDERROR"/></p>
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" id="password" name="password1" placeholder="密码">
		            	<p class="bg-danger text-danger"><s:fielderror fieldName="PWDERROR"/></p>
		            </div>
		          </div>
		        </div>
		        <div>
		        	<s:fielderror fieldName="error" />
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="submit" value="登陸" class="btn btn-info">
		          		<div class="dropdown pull-right">
							<select class="input-md form-control" id="select" onchange="changeAction();">
								<option value="StuLogin">學生</option>
								<option value="TeaLogin">教師</option>
								<option value="AdminLogin">管理員</option>
							</select>
						</div>
		          	</div>
		          </div>
		        </div>
		       
		      </form>
		      <div class="text-center">
		      	<a href="CreateUser" class="templatemo-create-new">创建新用户 <i class="fa fa-arrow-circle-o-right"></i></a>	
		      </div>
		</div>
	</div>
</body>
</html>