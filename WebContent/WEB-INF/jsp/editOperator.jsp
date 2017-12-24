<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

  <script type="text/javascript">
  $(document).ready(function() {
		
	    $('#editForm').formValidation({
	        framework: 'bootstrap',
	        excluded: ':disabled',
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	business: {
	                validators: {
	                    notEmpty: {
	                        message: 'The bussiness name is required'
	                    }
	                }
	            },
	            name: {
	                validators: {
	                    notEmpty: {
	                        message: 'The name is required'
	                    }
	                }
	            },
	            email: {
	                validators: {
	                    notEmpty: {
	                        message: 'The email is required'
	                    },
	                    emailAddress: {
	                        message: 'The value is not a valid email address'
	                    },
	                    regexp: {
	                        regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
	                        message: 'The value is not a valid email address'
	                    }
	                }
	            },         
	            address: {
	                validators: {
	                    notEmpty: {
	                        message: 'The address is required'
	                    }
	                }
	            },
	            operatorUsername: {
	                validators: {
	                    notEmpty: {
	                        message: 'The password is required'
	                    }
	                }
	            },
	            operatorPassword: {
	                validators: {
	                    notEmpty: {
	                        message: 'The username is required'
	                    }
	                }
	            },
	            sector: {
	                validators: {
	                    notEmpty: {
	                        message: 'The sector is required'
	                    }
	                }
	            },
	            population: {
	                validators: {
	                    notEmpty: {
	                        message: 'The population is required'
	                    }
	                }
	            },
	            province: {
	                validators: {
	                    notEmpty: {
	                        message: 'The city is required'
	                    }
	                }
	            },
	            
	            identity_card: {
	                validators: {
	                    notEmpty: {
	                        message: 'The identity_card is required'
	                    }
	                }
	            },
	            
	            telephone: {
	            	validators: {
	            		notEmpty: {
	            			message: 'The Telephone is required'
	            		}
	            	}
	            }
	            
	        }
	    })
  });
  function uniqueUserName(userName){
		var name = $("#operatorUsernameHidden").val();
		
		if(name != userName){
			$.ajax({
				 type: 'POST',    
				  url: 'checkUniqueUserName.html',
				  data: 'userName='+userName,
				  success: function(response) {
					  
					  if(response == "false"){
				   alert("User Name is already present");
				   $("#operatorUsernamee").val("");
				   $("#operatorUsername").val("");
				   document.getElementById("submitButtonAdd").disabled = true;
				   document.getElementById("submitButtonEdit").disabled = true;
					  }
				  },
				  error: function(xhr) {
				    alert(xhr);
				  }
				});
		}
	}

	function checkUserNameNull(){
		var x = document.forms["frm"]["operatorUsernamee"].value;
		var y = document.forms["editForm"]["operatorUsername"].value;
		if((x == null && x == "") || (y == null && y == "")){
			
			document.getElementById("submitButtonAdd").disabled = true;
			document.getElementById("submitButtonEdit").disabled = true;
			
		}else{
			
			document.getElementById("submitButtonAdd").disabled = false;
			document.getElementById("submitButtonEdit").disabled = false;
		}
	}

  $(document).ready(function() {

	  $('#editForm').submit(function() {
			
			var x = document.forms["editForm"]["operatorUsername"].value;
			
			if(x== null || x == ""){
				
				document.getElementById("submitButtonEdit").disabled = true;
				return false;	
			}else{
				
				document.getElementById("submitButtonEdit").disabled = false;
				return true;
			}
		});
	  
	    $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){

	        $("#success-alert").alert('close');

	    });
	    
	} );
  
  function goToOperator(){
	  window.location.href = "operators.html";	 
  }
  
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

 <div >
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><spring:message code="label.editOperator"/> </h4>
         <c:if test="${updated == 'updated'}">
                   	<center>
                   	    <div class="alert alert-success" id="success-alert">
    					   <button type="button" class="close" data-dismiss="alert">x</button>
    					      <strong>Success! </strong>
   						     	Operator updated Successfully
						</div>
					</center>             	       
                    </c:if> 
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/operatorsList.html" commandName="operator">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd" value="${operator.id}"  />
                     <input type="hidden" name="action" id="action" value="edit"/>
                    <div class="form-group">
                        <form:label path="business" class="col-sm-3 control-label"><spring:message code="label.business"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="business" id="business" value="bussinees" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="name" class="col-sm-3 control-label"><spring:message code="label.name"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="name" id="name" value="${operator.name}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                   	</div>
                    <div class="form-group">
                        <form:label path="email" class="col-sm-3 control-label"><spring:message code="label.email"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="email" id="email" value="${operator.email}" class="form-control" maxlength="60" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="phones" class="col-sm-3 control-label"><spring:message code="label.telephone"/> &#42;</form:label>
                        <div class="col-sm-8">
                         
                        	 <c:forEach var="phone" items="${operator.phones}" >
                        	    <input type="text" value="${phone.type}" name="telephoneType" readonly></input>:<input type="text" name="telephone" value="${phone.no}" maxlength="10" onkeypress="return AllowNumber(event);" onblur = "checkUserNameNull()"></input>
                        		<br>
                        	</c:forEach> 
                        	
                       </div>
                    </div>
                     <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="address" id="address" value="${operator.address}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="operatorUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="operatorUsername" id="operatorUsername" value="${operator.operatorUsername}" class="form-control" maxlength="100" onblur="uniqueUserName(this.value)"/>
                            <input type="hidden" name="operatorUsernameHidden" id="operatorUsernameHidden" value="${operator.operatorUsername}" />
                            
                      	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="operatorPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="operatorPassword" id="operatorPassword" value="${operator.operatorPassword}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                    
                    <div class="form-group">
                        <form:label path="sector" class="col-sm-3 control-label"><spring:message code="label.sector"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="sector" id="sector" value="${operator.sector}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                    
                    
                    <div class="form-group">
                        <form:label path="province" class="col-sm-3 control-label"><spring:message code="label.province"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="province" id="province" value="${operator.province}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="identity_card" class="col-sm-3 control-label"><spring:message code="label.identity_card"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="identity_card" id="identity_card" value="${operator.identity_card}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
           			<input type="hidden" name="action" value="edit" />
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" onclick ="goToOperator()" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButtonEdit" id="submitButtonEdit" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
       
          </div>
        </form:form>   
  </div>
</div>
</div>
