<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
            
            
           	 	 <li >
                    <a href="FindCourseAction">
                        <i class="pe-7s-note2"></i>
                        <p>課程管理</p>
                    </a>
                </li>
                <li class="active">
                    <a href="#">
                        <i class="pe-7s-bell"></i>
                        <p>学院管理</p>
                    </a>
                </li>
                <li >
                    <a href="FindStudentAction">
                        <i class="pe-7s-user"></i>
                        <p>學生管理</p>
                    </a>
                </li>
                <li>
                    <a href="FindTeacherAction">
                        <i class="pe-7s-science"></i>
                        <p>教师管理</p>
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
                    <a class="navbar-brand" href="#">学院管理</a>
                </div>
                <div class="collapse navbar-collapse">

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                           <a href="">
                               管理员， 欢迎登陆选课系统
                            </a>
                        </li>
                        
                        <li>
                            <a href="userLogin.jsp">
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
                                <h4 class="title">学院列表</h4>
                                <p class="category">可以添加学院以及更新学院信息</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>学院ID</th>
                                    	<th>学院名称</th>
                                    	<th>修改</th>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="colleges" var="college">
                                    	 <tr>
                                        	<td><s:property value="#college.Coid"/></td>
                                        	<td><s:property value="#college.Coname"/></td>
                                        	<td><a href="updateCollege?Coid=<s:property value="#college.Coid"/>">修改</a></td>
                                        </tr>
                                    </s:iterator>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>


                        <div >
								<nav aria-label="Page navigation" >
								<ul class="pagination" >
									<li><a href="FindCollegeAction" aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
									<c:forEach begin="1" end="${sessionScope.result.totalPage}" step="1" var="pageIndex">
										<li><a href="FindCollegeAction?pageNum=${pageIndex}">${pageIndex} </a></li>
									</c:forEach>
									<li><a href="FindCollegeAction?pageNum=<s:property value="#session.result.totalPage"/>" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
								</nav>
						</div>


                </div>
            </div>
        </div>
			<div style='position:absolute z-index:999; top:0;'>
				<button type="button" class="btn btn-default btn-lg btn-block"  onclick="window.location.href='Create-College.jsp'">添加学院</button>
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
