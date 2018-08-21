<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
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
	
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">
	<h1 class="margin-bottom-15">创建新用户</h1>
	<div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="UserCreate" method="post">
				<div class="form-inner">
					<div class="form-group">
			          <div class="col-md-6">		          	
			            <label for="id" class="control-label">ID</label>
			            <input type="text" name="id" class="form-control" id="first_name" placeholder="">		            		            		            
			          	<p><s:fielderror fieldName="iderror"/></p>
			          	<p><s:fielderror fieldName="idERROR"/></p>
			          </div>  
			        </div>
			        <div class="form-group">
			          <div class="col-md-6">		          	
			            <label for="username" class="control-label">姓名</label>
			            <input type="text" name="name" class="form-control" id="email" placeholder="">		            		            		            
			          <p><s:fielderror fieldName="nameERROR"/>  </p>    
			          </div>      
			        </div>
					<div class="form-group">
						<div class="col-md-6">
							<div class="dropdown ">
								<label>學院</label>
								 <select class="input-md form-control"
									name="coid">
									<s:iterator value="colleges" var="college">
										<option value="<s:property value="#college.Coid"/>"><s:property
												value="#college.Coname" /></option>
									</s:iterator>
								</select>
							</div>
						</div>
						<div class="col-md-6 templatemo-radio-group">
							<label class="radio-inline"> <input type="radio"
								name="identify" id="optionsRadios1" value="student"
								checked="checked"> 学生
							</label>
							 <label class="radio-inline"> <input type="radio"
								name="identify" id="optionsRadios2" value="teacher">
								老师
							</label>
						</div>
					</div>
					<div class="form-group">
			          <div class="col-md-6">
			            <label for="password" class="control-label">密码</label>
			            <input type="password" name="password1" class="form-control" id="password" placeholder="">
			          <p><s:fielderror fieldName="pwd1ERROR"/> </p>
			          </div>
			          <div class="col-md-6">
			            <label for="password" class="control-label">确认密码</label>
			            <input type="password" name="password2" class="form-control" id="password_confirm" placeholder="">
			          <p><s:fielderror fieldName="pwd2ERROR"/> </p>
			          </div>
			        </div>
			        <s:fielderror fieldName="pwdERROR"/> 
			        <div class="form-group">
			          <div class="col-md-12">
			            <input type="submit" value="创建用户" class="btn btn-info">
			            <a href="userLogin.jsp" class="pull-right">登陆</a>
			          </div>
			        </div>	
				</div>				    	
		      </form>		      
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">Terms of Service</h4>
	      </div>
	      <div class="modal-body">
	      	<p>This form is provided by <a rel="nofollow" href="http://www.cssmoban.com/page/1">Free HTML5 Templates</a> that can be used for your websites. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
	        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Aenean lacinia bibendum nulla sed consectetur. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Donec sed odio dui. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
	        <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>