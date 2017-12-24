<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


    
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript">
function reportProblem(id){
	window.location.href = "reportProblem.html?machineId="+id;	
}

function viewHistory(id){
	window.location.href = "viewHistory.html?machineId="+id;
}
</script>
</head>
<body>
<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left"><spring:message code="label.machine"/></h1>
                    
                                       
                   
                   <%--  <button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="goMachine()"><i class="fa fa-plus-circle"></i>  <spring:message code="label.assignMachine"/></button> --%> 
                </div>                                    
            </div>
        </div>
    </div>
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head"><spring:message code="label.machineList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
    
         	
                               
                                <th width="10%"><spring:message code="label.manufacturingDate"/></th>
                                <th width="10%"><spring:message code="label.color"/></th>
                                <th width="10%"><spring:message code="label.machineIMEI"/></th>
                                <th width="10%"><spring:message code="label.machineInput"/></th>
                                <th width="10%"><spring:message code="label.machineOutput"/></th>
                                <th width="10%"><spring:message code="label.machineStatus"/></th>   
                                <th width="10%"><spring:message code="label.machineControl"/></th> 
                                <th width="10%"><spring:message code="label.machineControlNumber"/></th> 
                                 <th width="10%"><spring:message code="label.machineType"/></th>
                                 <th width="10%"><spring:message code="label.machinelock"/></th>
                                <th width="10%"><spring:message code="label.machineLockDays"/></th> 
                                 <th width="10%"><spring:message code="label.collectionLimits"/></th>
                                <th width="10%"><spring:message code="label.creditValue"/></th> 
                                <th width="10%"><spring:message code="label.comments"/></th>
                                 <th width="10%"><spring:message code="label.reportProblem"/></th>
                                <th width="10%"><spring:message code="label.viewHistory"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="machine" items="${machineList}">
                                <tr>
                                  	
                                    <td>${machine.manufacturingDate}</td>
                                    <td>${machine.color}</td>
                                    <td>${machine.machineIMEI}</td>
                                    <td>${machine.machineInput}</td>
                                    <td>${machine.machineOutput}</td>
                                    <td>${machine.machineStatus}</td>
                                    <td>${machine.machineControl}</td>
                                    <td>${machine.controlNumber}</td>
                                    <td>${machine.machineType.model}</td>
                                    <td>${machine.machinelock}</td>
                                    <td>${machine.lockDays}</td>
                                    <td>${machine.collectionLimits}</td>
                                    <td>${machine.creditValue}</td>
                                  	<td>${machine.comments}</td>
                                   <td><button type="submit" class="btn btn-default btn-sm" onClick="reportProblem('${machine.id}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.reportProblem"/></button></td>
                                 	<td><button type="submit" class="btn btn-default btn-sm" onClick="viewHistory('${machine.id}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.viewHistory"/></button></td>
                                 
                                    
                                 </tr>
                          	</c:forEach>                                                                                    
                          </tbody>
                        </table>
                    </div>
                </div>                                    
            </div>
        </div>
    </div>
<!-- / row -->   
</div>
<!-- <script>
function goMachine(){
	 window.location.href="${pageContext.request.contextPath}/establishment/assignMachines.html";
 }
</script> -->
</body>
</html>