<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {

	  
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){

        $("#success-alert").alert('close');

    });
    
} );

  function AllowNumber(event)
  {
     isIE = document.all ? 1 : 0
    keyEntry = !isIE ? event.which : event.keyCode; 
    
    if (keyEntry == '48' || keyEntry == '49' || keyEntry == '50' || keyEntry == '51'|| keyEntry == '52' || keyEntry == '53' || keyEntry == '54' || keyEntry == '55' || keyEntry == '56' || keyEntry == '57')
       return true;
    else
  	{
      	alert('Please Enter Only numbers .');
      	return false;
      }
  }
  </script>

<div>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><spring:message code="label.editTechnician"/> </h4>
        <c:if test="${updated == 'updated'}">
                   	<center>
                   	    <div class="alert alert-success" id="success-alert">
    					   <button type="button" class="close" data-dismiss="alert">x</button>
    					      <strong>Success! </strong>
   						     	Technician updated Successfully
						</div>
					</center>             	       
                    </c:if> 
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/technician.html" commandName="technician">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd" value="${technician.id}" />
                     <input type="hidden" name="action" id="action" value="edit"/>
                    <div class="form-group">
                        <form:label path="technicianName" class="col-sm-3 control-label"><spring:message code="label.technicianName"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="technicianName" id="technicianNamee" value="${technician.technicianName}" class="form-control"  onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="technicianUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="technicianUsername" id="technicianUsername" value="${technician.technicianUsername}" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="technicianPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="technicianPassword" id="technicianPassword" value="${technician.technicianPassword}" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="address" id="addresss" value="${technician.address}" class="form-control"  onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                    <div class="form-group">
                        <form:label path="telephone" class="col-sm-3 control-label"><spring:message code="label.telephone"/> &#42;</form:label>
                        <div class="col-sm-8">
                           <c:forEach var="phone" items="${technician.phones}" >
                        	    <input type="text" value="${phone.type}" name="telephoneType" readonly></input>:<input type="text" name="telephone" value="${phone.no}" maxlength="10" onkeypress="return AllowNumber(event);"></input>
                        		<br>
                        	</c:forEach> 
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
