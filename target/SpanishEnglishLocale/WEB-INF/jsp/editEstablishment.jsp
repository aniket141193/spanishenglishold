<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
	<!-- <script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
	<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script> -->

<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
  <script>
  $( function() {
    $( "#dischargeDate" ).datepicker();
  } );
  
  
  </script>
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
	        	establishmentName: {
	                validators: {
	                    notEmpty: {
	                        message: 'The Establishment Name is required'
	                    }
	                }
	            },
	            establishmentOwner: {
	                validators: {
	                    notEmpty: {
	                        message: 'The Owner is required'
	                    }
	                }
	            },
	            geolocation: {
	                validators: {
	                    notEmpty: {
	                        message: 'The geolocation is required'
	                    }
	                }
	            },
	            
	            telephone: {
	                validators: {
	                    notEmpty: {
	                        message: 'The telephone is required'
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
	            
	            establishmentUsername: {
	                validators: {
	                    notEmpty: {
	                        message: 'The username is required'
	                    }
	                }
	            },
	            
	            establishmentPassword: {
	                validators: {
	                    notEmpty: {
	                        message: 'The password is required'
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
	            
	            dischargeDate: {
	                validators: {
	                    notEmpty: {
	                        message: 'The dischargeDate is required'
	                    }
	                }
	            },
	            
	            percentage: {
	                validators: {
	                    notEmpty: {
	                        message: 'The percentage is required'
	                    }
	                }
	            },
	            
	            establishmentsType: {
	                validators: {
	                    notEmpty: {
	                        message: 'The establishmentsType is required'
	                    }
	                }
	            },
	            
	            statusEstablishment: {
	                validators: {
	                    notEmpty: {
	                        message: 'The status is required'
	                    }
	                }
	            },
	            
	            openTime: {
	                validators: {
	                    notEmpty: {
	                        message: 'The Open Time is required'
	                    }
	                }
	            },
	            
	            closeTime: {
	                validators: {
	                    notEmpty: {
	                        message: 'The Close Time is required'
	                    }
	                }
	            },
	            
	            loans: {
	                validators: {
	                    notEmpty: {
	                        message: 'The loans is required'
	                    }
	                }
	            },
	            
	            withdrawals: {
	                validators: {
	                    notEmpty: {
	                        message: 'The withdrawals is required'
	                    }
	                }
	            },
	            
	            prepayments: {
	                validators: {
	                    notEmpty: {
	                        message: 'The prepayments is required'
	                    }
	                }
	            },
	            
	            fund: {
	                validators: {
	                    notEmpty: {
	                        message: 'The fund is required'
	                    }
	                }
	            }	
	            
	        }
	    });
	    
	    
	});


  function uniqueUserName(userName){
		var name = $("#establishmentUsernameHidden").val();
		
		if(name != userName){
			$.ajax({
				 type: 'POST',    
				  url: 'checkUniqueUserName.html',
				  data: 'userName='+userName,
				  success: function(response) {
					  
					  if(response == "false"){
				   alert("User Name is already present");
				   
				   $("#establishmentUsername").val("");
				   
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
		
		var y = document.forms["editForm"]["establishmentUsername"].value;
		if((x == null && x == "") || (y == null && y == "")){
			document.getElementById("submitButtonEdit").disabled = true;
		}else{
			document.getElementById("submitButtonEdit").disabled = false;
		}
	}
  $(document).ready(function() {

	  $('#editForm').submit(function() {
			
			var x = document.forms["editForm"]["establishmentUsername"].value;
			
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

  function gotoEstablishment(){
	  window.location.href = "establishment.html";
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
  
  function AllowHours(e)
  {
    isIE = document.all ? 1 : 0
    keyEntry = !isIE ? e.which : e.keyCode;
    if (keyEntry == '48' || keyEntry == '49' || keyEntry == '50' || keyEntry == '51'|| keyEntry == '52' || keyEntry == '53' || keyEntry == '54' || keyEntry == '55' || keyEntry == '56' || keyEntry == '57' || keyEntry == '96'|| keyEntry == '97'|| keyEntry == '98'|| keyEntry == '99'|| keyEntry == '100'|| keyEntry == '101'|| keyEntry == '102'|| keyEntry == '103'|| keyEntry == '104' || keyEntry == '105' )
       return true;
    else
  	{
      	alert('Please Enter Only numbers between 1 to 24.');
      	return false;
      }
  }

  function AllowMins(e)
  {
    isIE = document.all ? 1 : 0
    keyEntry = !isIE ? e.which : e.keyCode;
    if (keyEntry == '48' || keyEntry == '49' || keyEntry == '50' || keyEntry == '51'|| keyEntry == '52' || keyEntry == '53' || keyEntry == '54' || keyEntry == '55' || keyEntry == '56' || keyEntry == '57' || keyEntry == '96'|| keyEntry == '97'|| keyEntry == '98'|| keyEntry == '99'|| keyEntry == '100'|| keyEntry == '101'|| keyEntry == '102'|| keyEntry == '103'|| keyEntry == '104' || keyEntry == '105' )
       return true;
    else
  	{
      	alert('Please Enter Only numbers between 1 to 60.');
      	return false;
      }
  }

  </script>

<style>
{
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}
.form-address-1 {
	width: 100%;
}

.form-first-name, .form-last-name {
	width: 46%;
}

.form-last-name {
	float: right;
}
</style>
<div>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><spring:message code="label.editEstablishment"/> </h4>
         <c:if test="${updated == 'updated'}">
                   	<center>
                   	    <div class="alert alert-success" id="success-alert">
    					   <button type="button" class="close" data-dismiss="alert">x</button>
    					      <strong>Success! </strong>
   						     	Establishment Updated Successfully
						</div>
					</center>             	       
                    </c:if> 
      </div>	
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/establishmentList.html" commandName="establishment">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd" value="${establishment.id}" />
                     <input type="hidden" name="action" id="action" value="edit"/>
                    <div class="form-group">
                        <form:label path="establishmentName" class="col-sm-3 control-label"><spring:message code="label.establishmentName"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		
                       		<form:input type="text" path="establishmentName" id="establishmentName" value="${establishment.establishmentName}"  class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                       	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="establishmentOwner" class="col-sm-3 control-label"><spring:message code="label.establishmentOwner"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		
                       		<form:input type="text" path="establishmentOwner" id="establishmentOwner" value="${establishment.establishmentOwner}"  class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                       	</div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="geolocation" class="col-sm-3 control-label"><spring:message code="label.geolocation"/> &#42;</form:label>
                        <div class="col-sm-8">
                             
                            <form:input type="text" path="geolocation" id="geolocation" value="${establishment.geolocation}"  class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                   	</div>
                    <div class="form-group">
                        <form:label path="telephone" class="col-sm-3 control-label"><spring:message code="label.telephone"/> &#42;</form:label>
                        <div class="col-sm-8">
                            
                            <c:forEach var="phone" items="${establishment.phones}" >
                        	    <input type="text" value="${phone.type}" name="telephoneType" readonly></input>:<input type="text" name="telephone" value="${phone.no}" maxlength="10" onkeypress="return AllowNumber(event);" onblur = "checkUserNameNull()"></input>
                        		<br>
                        	</c:forEach> 
                      	</div> 
                      	</div>              
                     <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                            
                            <form:input type="text" path="address" id="address" value="${establishment.address}"  class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                     	</div>
                    </div>
                  
                    <div class="form-group">
                        <form:label path="establishmentUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="establishmentUsername" id="establishmentUsername" value="${establishment.establishmentUsername}"  class="form-control" maxlength="100" onblur="uniqueUserName(this.value)"/>
                            <input type="hidden" name="establishmentUsernameHidden" id="establishmentUsernameHidden" value="${establishment.establishmentUsername}" />
                      	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="establishmentPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="establishmentPassword" id="password" value="${establishment.establishmentPassword}"  class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>                   
                    <div class="form-group">
                        <form:label path="sector" class="col-sm-3 control-label"><spring:message code="label.sector"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="sector" id="sector" value="${establishment.sector}"  class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>s
                    </div>
                    
                 
                    
                    <div class="form-group">
                        <form:label path="province" class="col-sm-3 control-label"><spring:message code="label.province"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="province" id="province" value="${establishment.province}"  class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>                 
                     <div class="form-group">
                        <form:label path="dischargeDate" class="col-sm-3 control-label"><spring:message code="label.dischargeDate"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="dischargeDate" id="dischargeDate" value="${establishment.dischargeDate}"  class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="percentage" class="col-sm-3 control-label"><spring:message code="label.percentage"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="percentage" id="percentage" value="${establishment.percentage}" class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div> 
                    
                     <div class="form-group">
                        <form:label path="establishmentsType" class="col-sm-3 control-label"><spring:message code="label.establishmentsType"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		
                           <form:select path="typesEstablishment.id" id="machineTypeId" class="form-control" >
                        		<form:option value="">Select</form:option>
                            	<form:option value="${establishment.typesEstablishment.id}">${establishment.typesEstablishment.name}</form:option>
                            	<c:forEach var="type" items="${typeList}">
                               	 <form:option value="${type.id}">${type.name}</form:option>
                        		</c:forEach>
                        	</form:select>
                      	</div>
                    </div>  
                    
                     <div class="form-group">
                        <form:label path="statusEstablishment" class="col-sm-3 control-label"><spring:message code="label.status"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                           <%--  <form:input type="text" path="status" id="status" value="${establishment.status}"  class="form-control" maxlength="20" /> --%>
                             <form:select path="statusEstablishment.id" id="machineTypeId" class="form-control" >
                        		<form:option value="">Select</form:option>
                            	<form:option value="${establishment.statusEstablishment.id}">${establishment.statusEstablishment.name}</form:option>
                            	<c:forEach var="status" items="${statusList}">
                               	 <form:option value="${status.id}">${status.name}</form:option>
                        		</c:forEach>
                        	</form:select>
                      	</div>
                    </div>
                    
                                          <div class="form-group">
                        <form:label path="openTime" class="col-sm-3 control-label"><spring:message code="label.openTime"/> &#42;</form:label>
                     	<div class="col-sm-8">
                                
        						<td>
        						<spring:message code="tooltip.hours" var="i18Tooltip"/>
            						<input type="text" name="openingHourss" class="form-first-name" placeholder="${i18Tooltip}" maxlength="2" value="${openHours}" onkeypress="return AllowHours(event);" onblur = "checkUserNameNull()"/>&nbsp;
            					<spring:message code="tooltip.mins" var="i18Tooltip"/>
            						<input type="text" name="openingMinss" class="form-last-name" placeholder="${i18Tooltip}" maxlength="2" value="${openMins}" onkeypress="return AllowMins(event);" onblur = "checkUserNameNull()"/>
        						</td>
    							
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="closeTime" class="col-sm-3 control-label"><spring:message code="label.closeTime"/> &#42;</form:label>
                     	<div class="col-sm-8">
                           
        						<td>
        						<spring:message code="tooltip.hours" var="i18Tooltip"/>
            						<input type="text" name="closeingHourss" class="form-first-name" placeholder="${i18Tooltip}" maxlength="2" value="${closeHours}" onkeypress="return AllowHours(event);" onblur = "checkUserNameNull()"/>&nbsp;
            					<spring:message code="tooltip.mins" var="i18Tooltip"/>
            						<input type="text" name="closeingMinss" class="form-last-name" placeholder="${i18Tooltip}" maxlength="2" value="${closeMins}" onkeypress="return AllowMins(event);" onblur = "checkUserNameNull()"/>
        						</td>

                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="loans" class="col-sm-3 control-label"><spring:message code="label.loans"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="loans" id="loans" value="${establishment.loans}"  class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="withdrawals" class="col-sm-3 control-label"><spring:message code="label.withdrawals"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="withdrawals" id="withdrawals" value="${establishment.withdrawals}"  class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="prepayments" class="col-sm-3 control-label"><spring:message code="label.prepayments"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="prepayments" id="prepayments" value="${establishment.prepayments}"  class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="fund" class="col-sm-3 control-label"><spring:message code="label.fund"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="fund" id="fund" value="${establishment.fund}"  class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                      
           			<input type="hidden" name="action" value="edit" />
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" onclick="gotoEstablishment()" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButtonEdit" id="submitButtonEdit" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
        </div>
         </form:form>   
          </div>
       
	      
 
  </div>
</div>

	   
	   