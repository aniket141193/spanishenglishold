<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<script>
 var saveKara = 0;
  
 function showAlert(saveKara){
	 return saveKara;
 }
  
 function showBtn(){

	 if(saveKara == 0){
		 alert("Please select Atleast one Machine Type for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete MachineType(s)?");
		 if(result){
			 window.location.href = "deleteMachineTypesList.html?list="+saveKara;	 
		 }
		 	 
	 }
	 
 }
 
 
 
</script>

<script type="text/javascript">


 $(document).ready(function() {

    $('#example').dataTable( {
        "aaSorting": [[1,'asc']],
    aoColumnDefs: [
	                   {
	                      bSortable: false,
	                      aTargets: [ -1 ]
	                   }
	                 ]
      } );
} ); 




$(document).ready(function() {

    $('#example').DataTable();
    
    
} );

function setDateFormat(manu){
	 menu = menu.substring(0,menu.length -11);
	 return menu;
}

function deleteAllRow(source){  	
	 checkboxes = document.getElementsByName('myTextEditBox');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
		var id = checkboxes[i].getAttribute('id' );
	    checkboxes[i].checked = source.checked;
	    if(source.checked){
	    malaDeleteKara(id);
	    }else{
	    	removeString(id);
	    }
	  }	
}
	

function displayNote(evt){
	
	var el = evt.target || evt.srcElement;

	  if (el && el.type == 'checkbox' && el.checked == true) {
	   
	   	    malaDeleteKara(el.id);
	  }
	  else if(el && el.type == 'checkbox' && el.checked == false){
		  removeString(el.id);
	  }
	 
}
var saveKara = 0;
function malaDeleteKara(id){
	if(saveKara == 0){
		saveKara = id + ",";
	}
	else{
		saveKara = saveKara + id + ",";	
	}
	showAlert(saveKara);
}

function removeString(ch){
	ch = ch + ",";
	saveKara = saveKara.replace(ch,'');
	showAlert(saveKara);
}

</script>

<script type="text/javascript">




//called when user clicks login
function sendDataForUpdation(){
	var id = $("#id").val(); 
	
	 var userName = $("#userName").val();
	 var password = $("#password").val();
	 var firstName = $("#firstName").val();
	 var lastName = $("#lastName").val();
	 var birthDate = $("#birthDate").val();
	 var sex = $("#sex").val();
	 var maritalStatus = $("#maritalStatus").val();
	 var email = $("#email").val();
	 var address = $("#address").val();
	 var city = $("#city").val();
	 var state = $("#state").val();
	 var zip = $("#zip").val();
	 var country = $("#country").val();
	 var phone = $("#phone").val();
	 var designation = $("#designation").val();
	 var userRole = $("#userRole").val();
	 var rId = $("#rId").val();
	 var supervisor = $("#supervisor").val();
	 var sId = $("#sId").val();
	 if(id == null || id == "" || userName == null || userName == "" || password == null || password == "" || firstName == null || firstName == "" || lastName == null || lastName == "" || birthDate == null || birthDate == "" || sex == null || sex == "" || maritalStatus == null || maritalStatus == "" || email == null || email == "" || address == null || address == "" || city == null || city == "" || state == null || state == "" || zip == null || zip == "" || country == null || country == "" || phone == null || phone == "" || designation == null || designation == "" || userRole == null || userRole == ""){
			alert("some fields are empty");
		}else{
	 
	 var allData = id+","+userName+","+password+","+firstName+","+lastName+","+birthDate+","+sex+","+maritalStatus+","+email+","+address+","+city+","+state+","+zip+","+country+","+phone+","+designation+","+userRole+","+rId+","+supervisor+","+sId;
	 var formData = "accessList="+allData;
	 $.ajax({
		    type : "POST",
		    url : "${pageContext.request.contextPath}/admin/updateEmployee",
		    data : formData,
		    success : function(response) {	       
		       alert("Employee Profile Updated");
		    },
		    error : function(e) {
		       alert('Error: ' + e);
		    }
		});
	}
}

function editSchool(id,model,description,paymentDeviceType,wirelessControl,gprsModem,lockCode){
	
	$("#Idd").val(id);
	$("#modell").val(model);
	$("#descriptionn").val(description);
	$("#paymentDeviceTypee").val(paymentDeviceType);
	
	$("#wirelessControll").val(wirelessControl);
	$("#gprsModemm").val(gprsModem);
	$("#lockCodee").val(lockCode);
	
	$("#edit").modal('show');
}

function useHTML(id,data){
	 var id = "#" + id;
	var text = "";
	for (i = 0; i < data.length; i++) { 
		if(data[i] == "<"){
   	text += "<<span>";
		}else if(data[i] == ">"){
			text += "</span>>";
		}
		else{
			text += data[i];
		}
	}
	 $(id).val(text);
}


function sendDataForRegistration(){
	 var name=$("#schoolName").val();
	 var address=$("#address").val();
	 var details=$("#details").val();
	 var location=$("#location").val();
	 var city=$("#city1").val();
	 var allData = name+","+address+","+details+","+location+","+city;
	 
	 var formData = "accessList="+allData;
	 
	 $.ajax({
		    type : "POST",
		    url : "${pageContext.request.contextPath}/admin/addSchool",
		    data : formData,
		    success : function(response) {	       
		
		    	$("#schoolAdd").modal('hide');
		       alert("School Added"+response);
		       window.location.href="${pageContext.request.contextPath}/admin/parentList";
		       window.location.href="${pageContext.request.contextPath}/admin/schoolList";
		       //	window.location.reload();
		    },
		    error : function(e) {
		    	alert(e);
		       
		    }
		});
	}




$('.dropdown-menu a').on('click', function(){    
    $('.dropdown-toggle').html($(this).html() + '<span class="caret"></span>');    
});



function checkUsernameUpdate(){

	 var userName = $("#userName").val(); 
    $.ajax({url: "checkUserName?userName="+userName, 
    	dataType: "text",
    	
    	success: function(result){
        
        	if(result == "true"){
        		alert("This username "+ userName + " is not allowed.")
        		$("#userName").val("");
        		
        	}
        	else{
        		$("#err").text("");
        	}
    			
    }});
// }); 
}

function checkUsernameRegister(){

		 var userName = $("#uuserName").val(); 
	    $.ajax({url: "checkUserName?userName="+userName, 
	    	dataType: "text",
	    	
	    	success: function(result){
	        
	        	if(result == "true"){
	        		alert("This username "+ userName + " is not allowed.")
	        		$("#uuserName").val("");
	        	}
	        	else{
	        		$("#err").text("");
	        	}
	    			
	    }});
	}

$('#frm').submit(function(e) {
    $('#messages').removeClass('hide').addClass('alert alert-success alert-dismissible').slideDown().show();
    $('#messages_content').html('<h4>MESSAGE HERE</h4>');
    $('#modal').modal('show');
    e.preventDefault();
});



$(document).ready(function() {
    $('#frm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	model: {
                validators: {
                    notEmpty: {
                        message: 'The Model is required'
                    }
                }
            },
            description: {
                validators: {
                    notEmpty: {
                        message: 'The Description is required'
                    }
                }
            },
            paymentDeviceType: {
                validators: {
                    notEmpty: {
                        message: 'The Payment Device Types is required'
                    }
                }
            },
            
            wirelessControl: {
                validators: {
                    notEmpty: {
                        message: 'The Wireless Control is required'
                    }
                }
            },
            
            gprsModem: {
                validators: {
                    notEmpty: {
                        message: 'The GPRS Modem is required'
                    }
                }
            },
            
            lockCode: {
                validators: {
                    notEmpty: {
                        message: 'The Lock Code is required'
                    }
                }
            }
            
        }
    });
    
    $('#editForm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	model: {
                validators: {
                    notEmpty: {
                        message: 'The Model is required'
                    }
                }
            },
            description: {
                validators: {
                    notEmpty: {
                        message: 'The Description is required'
                    }
                }
            },
            paymentDeviceType: {
                validators: {
                    notEmpty: {
                        message: 'The Payment Device Types is required'
                    }
                }
            },
            
            wirelessControl: {
                validators: {
                    notEmpty: {
                        message: 'The Wireless Control is required'
                    }
                }
            },
            
            gprsModem: {
                validators: {
                    notEmpty: {
                        message: 'The GPRS Modem is required'
                    }
                }
            },
            
            lockCode: {
                validators: {
                    notEmpty: {
                        message: 'The Lock Code is required'
                    }
                }
            }
            
        }
    });
    
    
});
</script>



<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                <c:if test="${error == '1'}">
                   	<center>
                   	    <div class="alert alert-success" id="success-alert">
    					   <button type="button" class="close" data-dismiss="alert">x</button>
    					      <strong>ALERT! </strong>
   						     	Please remove Machine type from Machines.
						</div>
					</center>             	       
                    </c:if> 
                
                    <h1 class="page-head-text pull-left"><spring:message code="label.machineType"/></h1>
                    
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addMachineType"/></button>                    
                    <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="showBtn()" ><i class="fa fa-trash-o"></i> <spring:message code="label.delete"/></button>
                
                </div>                                    
            </div>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head"><spring:message code="label.machineTypeList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
    
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                               
                                <th width="10%"><spring:message code="label.model"/></th>
                                <th width="10%"><spring:message code="label.description"/></th>
                                 <th width="10%"><spring:message code="label.paymentDevices"/></th> 
                                <th width="10%"><spring:message code="label.wirelessControl"/></th>
                                <th width="10%"><spring:message code="label.gprsModem"/></th>
                                <th width="10%"><spring:message code="label.lockCode"/></th>
                                <th width="10%"><spring:message code="label.edit"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="machineType" items="${machineTypeList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${machineType.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${machineType.model}</td>
                                  	<td>${machineType.description}</td>
                                  	 <td><c:forEach var="paymentDeviceType" items="${machineType.paymentDeviceType}">${paymentDeviceType.model},<br></c:forEach></td> 
                                  	<td>${machineType.wirelessControl}</td>
                                  	<td>${machineType.gprsModem}</td>
                                  	<td>${machineType.lockCode}</td>
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${machineType.id}','${machineType.model}','${machineType.description}','${machineType.paymentDeviceType}','${machineType.wirelessControl}','${machineType.gprsModem}','${machineType.lockCode}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
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

 <div class="modal fade" id="schoolAdd" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
    <div class="modal-dialog">
    	<!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"><center><spring:message code="label.machineTypeDetails"/></center></h4>
            </div>
           
          <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/machineType.html" commandName="machineTypeForm">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                    <div class="form-group">
                        <form:label path="model" class="col-sm-3 control-label"><spring:message code="label.model"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="model" id="model" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="description" class="col-sm-3 control-label"><spring:message code="label.description"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="description" id="description" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                   
                     <div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.paymentDevices"/> &#42;</label>
                        <div class="col-sm-8">
                   		 <form:select path="paymentDeviceType" id="paymentDeviceType"  multiple="true">
                        		
                            	<c:forEach var="paymentDeviceType" items="${paymentDeviceTypeList}">
                               	<form:option value="${paymentDeviceType.id}">${paymentDeviceType.type},${paymentDeviceType.model},${paymentDeviceType.io}</form:option>
                        		</c:forEach>
                     	</form:select>
                     	</div>
                     </div> 

					<div class="form-group">
                        <form:label path="wirelessControl" class="col-sm-3 control-label"><spring:message code="label.wirelessControl"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:select path="wirelessControl" id="wirelessControl">
                       			 <option value="true">YES</option>
   								 <option value="false">NO</option>
                       		</form:select>
                       	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="gprsModem" class="col-sm-3 control-label"><spring:message code="label.gprsModem"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:select path="gprsModem" id="gprsModem">
                       			 <option value="true">YES</option>
   								 <option value="false">NO</option>
                       		</form:select>
                       	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="lockCode" class="col-sm-3 control-label"><spring:message code="label.lockCode"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:select path="lockCode" id="lockCode">
                       			 <option value="true">YES</option>
   								 <option value="false">NO</option>
                       		</form:select>
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

 <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><spring:message code="label.editMachineType"/> </h4>
      </div>
	   
	     
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/machineType.html" commandName="machineTypeForm">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>

					 <div class="form-group">
                        <form:label path="model" class="col-sm-3 control-label"><spring:message code="label.model"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="model" id="modell" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="description" class="col-sm-3 control-label"><spring:message code="label.description"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="description" id="descriptionn" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                   
                     <div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.paymentDevices"/> &#42;</label>
                        <div class="col-sm-8">
                   		 <form:select path="paymentDeviceType" id="paymentDeviceTypee"  multiple="true">
                        		
                            	<c:forEach var="paymentDeviceType" items="${paymentDeviceTypeList}">
                            	<form:option  value="${paymentDeviceType.id}">${paymentDeviceType.type},${paymentDeviceType.model},${paymentDeviceType.io} </form:option>
                               
                        		</c:forEach>
                     	</form:select>
                     	</div>
                     </div> 

					<div class="form-group">
                        <form:label path="wirelessControl" class="col-sm-3 control-label"><spring:message code="label.wirelessControl"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:select path="wirelessControl" id="wirelessControll">
                       			 <option value="true">YES</option>
   								 <option value="false">NO</option>
                       		</form:select>
                       	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="gprsModem" class="col-sm-3 control-label"><spring:message code="label.gprsModem"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:select path="gprsModem" id="gprsModemm">
                       			 <option value="true">YES</option>
   								 <option value="false">NO</option>
                       		</form:select>
                       	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="lockCode" class="col-sm-3 control-label"><spring:message code="label.lockCode"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:select path="lockCode" id="lockCodee">
                       			 <option value="true">YES</option>
   								 <option value="false">NO</option>
                       		</form:select>
                       	</div>
                    </div>            	        	

                  	
            </div>
                    
			
           	<div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
          
        </form:form>   
	      
   
  </div>
</div>

	   
	   