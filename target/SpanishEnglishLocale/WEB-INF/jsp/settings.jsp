<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Settings</title>
</head>
<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<script type="text/javascript">

function establishmentstatus(){
	 window.location.href = "establishmentStatus.html";
}

function establishmentType(){
	 window.location.href = "establishmentType.html";
}

function spareParts(){
	 window.location.href="${pageContext.request.contextPath}/admin/spareParts.html";
}

function operatorstatus(){
	 window.location.href = "operatorStatus.html";
}

function machineProblems(){
	window.location.href = "machineProblemsList.html";
}
</script>
<body>
<button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="spareParts()" style="
    margin-right: 100px;
    margin-top: 100px;
"><i class="fa fa-plus-circle"></i>  <spring:message code="label.spareParts"/></button>
<button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="establishmentstatus()" style="
    margin-right: 100px;
    margin-top: 100px;
"><i class="fa fa-plus-circle"></i>  <spring:message code="label.establishmentstatus"/></button>
<button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="establishmentType()" style="
    margin-right: 100px;
    margin-top: 100px;
"><i class="fa fa-plus-circle"></i>  <spring:message code="label.establishmenttype"/></button>
<button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="operatorstatus()" style="
    margin-right: 100px;
    margin-top: 100px;
"><i class="fa fa-plus-circle"></i>  <spring:message code="label.operatorstatus"/></button>
<button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="machineProblems()" style="
    margin-right: 100px;
    margin-top: 100px;
"><i class="fa fa-plus-circle"></i>  <spring:message code="label.machineProblems"/></button>

</body>
</html>