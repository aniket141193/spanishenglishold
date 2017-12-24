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
function editSchool(id,description){
	$("#Idd").val(id);
	$("#descriptionn").val(description);
	$("#machineProblemEdit").modal('show');
}

function myFunction() {
    var x = document.getElementById("machineTypeId").value;
 	if(x == 0){
 		 document.getElementById('otherProblem').style.display = 'block'; 
 	}else{
 		document.getElementById('otherProblem').style.display = 'none'; 
 	}	
}

function myFunctionEdit() {
    var x = document.getElementById("machineTypeIdd").value;
 	if(x == 0){
 		 document.getElementById('otherProblemm').style.display = 'block'; 
 	}else{
 		document.getElementById('otherProblemm').style.display = 'none'; 
 	}	
}
</script>
</head>
<body>
<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left"><spring:message code="label.repair"/></h1>
                     <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addMachineProblems"/></button> 
                </div>                                    
            </div>
        </div>
    </div>
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head"><spring:message code="label.repairHistory"/></span>
                       
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
    
                                <th width="10%"><spring:message code="label.machine"/></th>
                                <th width="10%"><spring:message code="label.reportedBy"/></th>
                                <th width="10%"><spring:message code="label.reportedTime"/></th>
                                <th width="10%"><spring:message code="label.status"/></th>
                                <th width="10%"><spring:message code="label.resolvedBy"/></th>
                                <th width="10%"><spring:message code="label.resolvedTime"/></th>
                                <th width="10%"><spring:message code="label.spareParts"/></th>
                                <th width="10%"><spring:message code="label.machineProblems"/></th>
                                <th width="10%"><spring:message code="label.edit"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="repairHistory" items="${repairHistoryList}">
                                <tr>
                                  	
                                    <td>${repairHistory.machine.nickName}</td>
                                    <c:if test="${not empty repairHistory.reportedByAdmin }">
                                    	<td>ADMIN:${repairHistory.reportedByAdmin.adminUsername}</td>
                                    </c:if>
                                     <c:if test="${not empty repairHistory.reportedByOperator }">
                                    	<td>OPERATOR:${repairHistory.reportedByOperator.name}</td>
                                    </c:if>
                                     <c:if test="${not empty repairHistory.reportedByEstablishment }">
                                    	<td>ESTABLISHMENT:${repairHistory.reportedByEstablishment.establishmentName}</td>
                                    </c:if>
                                     <c:if test="${not empty repairHistory.reportedByTechnician }">
                                    	<td>TECHNICIAN:${repairHistory.reportedByTechnician.technicianName}</td>
                                    </c:if>
                                    <td>${repairHistory.reportedTimeStr}</td>
                                    <td>${repairHistory.status}</td>
                                     <c:if test="${not empty repairHistory.resolvedByAdmin }">
                                    	<td>ADMIN:${repairHistory.resolvedByAdmin.adminUsername}</td>
                                    </c:if>
                                    <c:if test="${not empty repairHistory.resolvedByOperator }">
                                    	<td>OPERATOR:${repairHistory.resolvedByOperator.name}</td>
                                    </c:if>
                                    <c:if test="${not empty repairHistory.resolvedByEstablishment }">
                                    	<td>ESTABLISHMENT:${repairHistory.resolvedByEstablishment.establishmentName}</td>
                                    </c:if>
                                    <c:if test="${empty repairHistory.resolvedByEstablishment && empty repairHistory.resolvedByEstablishment && empty repairHistory.resolvedByAdmin }">
                                    	<td>NA</td>
                                    </c:if>
                                    <c:if test="${not empty repairHistory.resolvedTimeStr }">
									<td>${repairHistory.resolvedTimeStr}</td>            
									</c:if> 
									<c:if test="${empty repairHistory.resolvedTimeStr }">
									<td>NA</td>            
									</c:if>                      
                                    <c:if test="${not empty repairHistory.spareParts}">                             
                                    <td><c:forEach var="rh" items="${repairHistory.spareParts}">${rh.description},<br></c:forEach></td>
                                 	</c:if>
                                 	<c:if test="${empty repairHistory.spareParts}">   
                                 	<td>NA</td>
                                 	</c:if>
                                 	  
                                 	<c:if test="${empty repairHistory.machineProblems}">   
                                 	<td>NA</td>
                                 	</c:if>
                                 	<c:if test="${not empty repairHistory.machineProblems}">
                                 <%--    <td><c:forEach var="mp" items="${repairHistory.machineProblems}">${mp.description},<br></c:forEach></td> --%>
                                 <td>${repairHistory.machineProblems.description }</td>
                                 </c:if>
                                        <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${repairHistory.id}','${repairHistory.machineProblems.id}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
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


<div class="modal fade" id="schoolAdd" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
    <div class="modal-dialog">
    	<!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"><center><spring:message code="label.machineProblemsDetails"/></center></h4>
            </div>
            
            
	
	
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/machineProblems.html" commandName="machineProblemsDTO">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                      	<input type="hidden" name="role" id="role" value="${role}">
                      	<input type="hidden" name="machineID" id="machineID" value="${machineId}">
                      	<input type="hidden" name="userId" id="userId" value="${userId}">
	                    <div class="form-group">
	                        <form:label path="machineProbleId" class="col-sm-3 control-label"><spring:message code="label.description"/> &#42;</form:label>
	                       
	                       	
	                       	<div class="col-sm-8">
	                       	<form:select path="machineProbleId" id="machineTypeId" class="form-control" onchange="myFunction()">
                        		
                            	<c:forEach var="problem" items="${machineProblemsList}">
                               	<form:option value="${problem.id}">${problem.description}</form:option>
                        		</c:forEach>
                        		<c:if test="${role eq 'admin'}">
                        		<form:option value="0" style="background-color: #f8d310;">Add Other Problems</form:option>
                        		</c:if>
                        	</form:select>
                        	</div>
                        </div>
                        <div id="otherProblem" style="display:none">
                        <div class="form-group">
                        	 <label  class="col-sm-3 control-label"><spring:message code="label.descriptionMsg"/> &#42;</label>
                        	<div class="col-sm-8">
                        		<input type="text" class="form-control" id="description" name="description">
                        	</div>     
                        	</div>
                        	
	                	</div>    
                  	
                    
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
                                         
                
           
          </div>
        </form:form>    
        </div>
          
	</div>
</div>


<div class="modal fade" id="machineProblemEdit" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
    <div class="modal-dialog">
    	<!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"><center><spring:message code="label.machineProblemsDetails"/></center></h4>
            </div>
            
            
	
	
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/machineProblems.html" commandName="machineProblemsDTO">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="edit">
                      	 <input type="hidden" name="machineID" id="machineID" value="${machineId}"> 
                      	<input type="hidden" name="userId" id="userId" value="${userId}">
                      	<input type="hidden" name="role" id="role" value="${role}">
                      	<input type="hidden" name="Idd" id="Idd" value="">
                    <div class="form-group">
	                        <form:label path="machineProbleId" class="col-sm-3 control-label"><spring:message code="label.description"/> &#42;</form:label>
	                       
	                       	
	                       	<div class="col-sm-8">
	                       	<form:select path="machineProbleId" id="machineTypeIdd" class="form-control" onchange="myFunctionEdit()">
                        		
                            	<c:forEach var="problem" items="${machineProblemsList}">
                               	<form:option value="${problem.id}">${problem.description}</form:option>
                        		</c:forEach>
                        		<c:if test="${role eq 'admin'}">
                        		<form:option value="0" style="background-color: #f8d310;">Add Other Problems</form:option>
                        		</c:if>
                        	</form:select>
                        	</div>
                        </div>
                        <div id="otherProblemm" style="display:none">
                        <div class="form-group">
                        	 <label  class="col-sm-3 control-label"><spring:message code="label.descriptionMsg"/> &#42;</label>
                        	<div class="col-sm-8">
                        		<input type="text" class="form-control" id="description" name="description">
                        	</div>     
                        	</div>
                        	
	                	</div>    
                  	
                  	
                    
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
                                         
                
           
          </div>
        </form:form>    
        </div>
          
	</div>
</div>
</body>
</html>