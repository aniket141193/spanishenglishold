<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript">
function editSchool(id,description){
	
	$("#Idd").val(id);
	$("#descriptionn").val(description);
	$("#machineProblemEdit").modal('show');
}
</script>
</head>
<body>
<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left"><spring:message code="label.machineHistory"/></h1>
                  
                </div>                                    
            </div>
        </div>
    </div>
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head"><spring:message code="label.machineHistory"/></span>
                       
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
    
                                <th width="10%"><spring:message code="label.machine"/></th>
                                <th width="10%"><spring:message code="label.machineWith"/></th>
                                <th width="10%"><spring:message code="label.date"/></th>
                            
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="machineHistory" items="${machineHistoryList}">
                                <tr>
                                  	
                                    <td>${machineHistory.machine.machineIMEI}</td>
                                    <c:if test="${not empty machineHistory.admin }">
                                    	<td>ADMIN : ${machineHistory.admin.adminUsername}</td>
                                    </c:if>
                                     <c:if test="${not empty machineHistory.operator }">
                                    	<td>OPERATOR : ${machineHistory.operator.name} </td>
                                    </c:if>
                                     <c:if test="${not empty machineHistory.establishment }">
                                    	<td>ESTABLISHMENT : ${machineHistory.establishment.establishmentName}</td>
                                    </c:if>
                                     
                                    
                                    <td><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${machineHistory.movementDate}" /></td>   

                            
                                 </tr>
                          	</c:forEach>                                                                                    
                          </tbody>
                        </table>
                    </div>
                </div>                                    
            </div>
        </div>
    </div>   
</div>






</body>
</html>