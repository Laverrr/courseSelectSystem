<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8" />
	<link rel="icon" type="image/png" href="img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>选课系统</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="img/sidebar-5.jpg">

    <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    	選課系統
                </a>
            </div>

            <ul class="nav">
                <li class="active">
                    <a href="#">
                        <i class="pe-7s-user"></i>
                        <p>更新個人信息</p>
                    </a>
                </li>
                <li>
                    <a href="jumpStudentTable">
                        <i class="pe-7s-note2"></i>
                        <p>學院課程</p>
                    </a>
                </li>
                <li>
                    <a href="StuSelectedAction?sid=<s:property value="#session.student.sid"/>">
                        <i class="pe-7s-news-paper"></i>
                        <p>我的課程</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">更新個人信息</a>
                </div>
                <div class="collapse navbar-collapse">

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                           <a href="">
                                <s:property value="#session.student.Sname"/>同学， 欢迎登陆选课系统
                            </a>
                        </li>
                        <li>
                            <a href="StuLogout">
                                  退出系统
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">编辑个人资料</h4>
                            </div>
                            <div class="content">
                                <form action="updateStu" method="post">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>ID</label>
                                                <input type="text" name="id" class="form-control"  value="<s:property value="#session.student.Sid"/>" readonly>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>姓名</label>
                                                <input type="text" class="form-control" placeholder="姓名" name="name" value="<s:property value="#session.student.Sname"/>">
                                            </div>
                                            <s:fielderror fieldName="nameERROR"/>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>密碼</label>
                                                <input type="password" name="password1" class="form-control" placeholder="密碼">
                                            </div>
                                            <s:fielderror fieldName="pwd1ERROR"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>確認密碼</label>
                                                <input type="password" name="password2" class="form-control" placeholder="確認密碼">
                                            </div>
                                            <s:fielderror fieldName="pwd2ERROR"/>
                                        </div>
                                    </div>
									<s:fielderror fieldName="pwdERROR"/>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="dropdown ">
                                            <label>學院</label>
							<select class="input-md form-control" name="coid">
								<s:iterator value="colleges" var="college">
										<option value="<s:property value="#college.Coid"/>"><s:property
												value="#college.Coname" /></option>
									</s:iterator>
							</select>
											</div>   
										</div>   
                                    </div>
                                    <button type="submit" class="btn btn-info btn-fill pull-right">更新資料</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <p class="copyright pull-right">
                   &copy; 2017 <a href="http://weibo.com/fxcklaver" target="_blank">Laver</a>, All rights reserved. 
                </p>
            </div>
        </footer>

    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="js/bootstrap-checkbox-radio-switch.js"></script>

	<!--  Charts Plugin -->
	<script src="js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="js/demo.js"></script>

</html>
