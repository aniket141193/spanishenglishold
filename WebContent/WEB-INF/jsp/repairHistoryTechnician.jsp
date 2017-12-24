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

$(function() {
    $('#spareParts').change(function(e) {
        var selected = $(e.target).val();
        console.dir(selected);
       
        var valueVar = selected.find(checkZero);
      
        if(valueVar == 0){
        document.getElementById('otherProblem').style.display = 'block';
        }
        else{
        	document.getElementById('otherProblem').style.display = 'none';
        }
    }); 
});

function checkZero(zeroValue) {
	
    return zeroValue == 0;
}

function editSchool(id,description){
	
	$("#Idd").val(id);
	$("#description").val(description);
	$("#edit").modal('show');
}
$(document).ready(function(){
    $('#machineProblems').on('change', function() {
      if ( this.value == '1')
      {
        $("#business").show();
      }
      else
      {
        $("#business").hide();
      }
    });
});
</script>
</head>
<body>
<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left"><spring:message code="label.repair"/></h1> 
                </div>                                    
            </div>
        </div>
    </div>
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head"><spring:message code="label.repairPendingList"/></span>
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
                                <th width="10%"><spring:message code="label.solved"/></th>
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
                                    <td>${repairHistory.resolvedByAdmin.adminUsername}</td>
                                    </c:if>
                                    <c:if test="${not empty repairHistory.resolvedByOperator }">
                                    <td>${repairHistory.resolvedByOperator.name}</td>
                                    </c:if>
                                    <c:if test="${not empty repairHistory.resolvedByEstablishment }">
                                    <td>${repairHistory.resolvedByEstablishment.establishmentName}</td>
                                    </c:if>
                                    <c:if test="${empty repairHistory.resolvedByEstablishment && empty repairHistory.resolvedByEstablishment && empty repairHistory.resolvedByAdmin }">
                                    	<td>Not Present</td>
                                    </c:if>
                                    <c:if test="${not empty repairHistory.resolvedTimeStr}">
									<td>${repairHistory.resolvedTimeStr}</td>     
									</c:if>
									 <c:if test="${ empty repairHistory.resolvedTimeStr}">
									<td>Not Present</td>     
									</c:if>
									<c:if test="${not empty repairHistory.spareParts}">                             
                                    <td><c:forEach var="rh" items="${repairHistory.spareParts}">${rh.description},<br></c:forEach></td>
                                 	</c:if>
                                 	<c:if test="${empty repairHistory.spareParts}">   
                                 	<td>Not Present</td>
                                 	</c:if>
                                 <td>${repairHistory.machineProblems.description }</td>
                                   <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${repairHistory.id}','${repairHistory.machineProblems.description}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.solved"/></button></td>
                                  
                                    
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

<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><spring:message code="label.addDescription"/> </h4>
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/repairs.html" commandName="repairHistoryForm">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                      	<input type="hidden" name="Idd" id="Idd" value="">
                      	<input type="hidden" name="userId" id="userId" value="${userId}">
                      	<input type="hidden" name="role" id="role" value="${role}">
                    <div class="form-group">
                        <form:label path="description" class="col-sm-3 control-label"><spring:message code="label.description"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="description" id="description" value="" class="form-control"  onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                    
                     <div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.spareParts"/> &#42;</label>
                        <div class="col-sm-8">
                   		 <form:select path="spareParts" id="spareParts"  multiple="true" >
                        		
                            	<c:forEach var="spareParts" items="${sparePartsList}">
                               	<form:option value="${spareParts.id}">${spareParts.description}</form:option>
                        		</c:forEach>
                        		<c:if test="${role eq 'admin'}">
                        		<form:option value="0" style="background-color: #f8d310;">Add Other Spare Parts</form:option>
                        		</c:if>
                     	</form:select>
                     	</div>
                     </div> 
                      <div id="otherProblem" style="display:none">
                        <div class="form-group">
                        	 <label  class="col-sm-3 control-label"><spring:message code="label.sparePartsDescriptionMsg"/> &#42;</label>
                        	<div class="col-sm-8">
                        		<input type="text" class="form-control" id="sparePartdescription" name="sparePartdescription">
                        	</div>     
                        	</div>
                        	
	                	</div>    
                     <%--  <div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.machineProblems"/> &#42;</label>
                        <div class="col-sm-8">
                   		 <form:select path="machineProblems" id="machineProblems" >
                        		
                            	<c:forEach var="machineProblems" items="${machineProblemsList}">
                               		<form:option value="${machineProblems.id}">${machineProblems.description}</form:option>
                        		</c:forEach>
                     	</form:select>
                     	<select name="machineProblems" id="machineProblems" class="form-control" >
                         		<c:forEach var="machineProblems" items="${machineProblemsList}">
                        			<option value="${machineProblems.id}">${machineProblems.description}</option>
                      			</c:forEach>
                      		</select>
                     	</div>
                     	
                     	<div style='display:none;' id='business'>
                     	<div class="form-group">
                        <form:label path="otherMachineProblems" class="col-sm-3 control-label"><spring:message code="label.otherMachineProblems"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="otherMachineProblems" id="otherMachineProblems" value="" class="form-control"  onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                       	</div>
                    </div>
                     </div>  --%>
                    
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