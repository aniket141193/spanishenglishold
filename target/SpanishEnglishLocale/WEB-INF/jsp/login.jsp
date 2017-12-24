<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title><spring:message code="label.titleMsg"/></title>
<!-- Bootstrap -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome/css/font-awesome.min.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.1.11.3.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular.min.1.2.27.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular-resource.min.1.2.27.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>
</head>

<body>


<body class="login-page">
	<div id="wrapper">
    	<div class="top-bg">
    		
				<span style="float: right">
					<a href="?lang=en">en</a> 
					| 
					<a href="?lang=es">es</a>
				</span>
    	</div>
    	<div class="container" id="loginPage" >
   			<div class="login-logo">
            	<img src="${pageContext.request.contextPath}/resources/images/logo/mylogo.png" id="logo">
          	</div>
                
            <div class="row">
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
                    <div id="loginBox" class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <spring:message code="label.welcomeMsg"/>
                        </div>
                        <div class="panel-body">
                        
                            <form:form id="loginForm" action="j_spring_security_check" method="post">
                                  <div class="form-group">
                                    <label> <i class="fa fa-user"></i> <spring:message code="label.accountMsg"/></label>
                                    <select name="account" class="form-control">
                                        <option value="ROLE_ADMIN"><spring:message code="label.userRole1"/></option>
                                        <option value="ROLE_OPERATOR"><spring:message code="label.userRole2"/></option>
                                        <option value="ROLE_ESTABLISHMENT"><spring:message code="label.userRole3"/></option>
                                        <option value="ROLE_TECHNICIAN"><spring:message code="label.userRole4"/></option>
                            		</select>
                                  </div>
                                  <div class="form-group">
                                    <!-- <label> <i class="fa fa-user"></i> Username</label> -->
                                    <form:label path="adminUsername"><i class="fa fa-user"></i><spring:message code="label.adminUsername"/></form:label>
                                   	<form:input path="adminUsername" class="form-control" />
                                   	<!-- <input type="text" name="username" class="form-control" placeholder="Username"> -->
                                  </div>
                                  <div class="form-group">
                                    <!-- <label for="inputPassword3"><i class="fa fa-lock"></i> Password</label>
                                    <input type="password" name="password"  class="form-control" placeholder="Password"> -->
                                     <form:label path="adminPassword"><i class="fa fa-user"></i><spring:message code="label.adminPassword"/></form:label>
                                   	<form:password path="adminPassword" class="form-control" />
                                  </div>
                                  <div id="message" class="form-group">                                  	
                						<span class="text-danger"> ${message}</span>
                               	   </div>     
									<c:if test="${error eq '1'}">
										<h5><span class="text-danger"> <spring:message code="label.error"/></span></h5>
									</c:if>                               	                                  
                                  <div class="form-group">
                                    <div class="row"> 
                                        <div class="col-xs-12 text-right">
                                            
                                            <div>
                                           	 <button type="submit" class="btn btn-grey" ><spring:message code="label.LogIn"/></button>
                                            </div>
                                        </div>
                                    </div>
                                  </div>
                                
                          </form:form>
                          
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="modal fade" id="schoolAdminId" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Password recovery</h4>
                        </div>
                        <div class="modal-body">
                            <form action="demo-recovery.php" id="sky-form2" class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">E-mail</label>
                                    <div class="col-sm-8">
                                    	<input type="email" name="email" id="email" class="form-control">
                                    </div>
                                </div>
           					</form>
                            <div class="form-group">
                                <i class="icon-ok"></i>
                                <p class="text-success">Your request successfully sent!</p>
                            </div>
                        </div>
                        <div class="modal-footer text-center">
                            <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                            <button type="submit" name="submit" class="btn btn-sky btn-sm" data-dismiss="modal">Save</button>
                        </div>
                    </div>
               	</div>
          	</div>
             
                
            </form>
      	</div>
	</div>
   	<div class="footer">
        <spring:message code="label.copyrightMsg"/>
    </div>        
</body>
</html>

