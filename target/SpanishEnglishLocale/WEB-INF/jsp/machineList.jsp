<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>


  <script>
  $( function() {
    $( "#manufacturingDate" ).datepicker();
  } );
  $( function() {
	    $( "#manufacturingDatee" ).datepicker();
	  } );
  
  
  </script>
 
 <script type="text/javascript">
 
 function AllowNumber(e)
 {
   isIE = document.all ? 1 : 0
   keyEntry = !isIE ? e.which : e.keyCode;
   if (keyEntry == '48' || keyEntry == '49' || keyEntry == '50' || keyEntry == '51'|| keyEntry == '52' || keyEntry == '53' || keyEntry == '54' || keyEntry == '55' || keyEntry == '56' || keyEntry == '57')
      return true;
   else
 	{
     	alert('Please Enter Only numbers .');
     	return false;
     }
 }

function yesnoCheck() {
    if (document.getElementById('machineControlYES').checked) {
        document.getElementById('ifmachineControlYES').style.display = 'block';
    }
    else {
    	document.getElementById('ifmachineControlYES').style.display = 'none';
    }
    if(document.getElementById('machinelockYES').checked){
    	document.getElementById('ifmachinelockYES').style.display = 'block';
    }else{
    	document.getElementById('ifmachinelockYES').style.display = 'none';
    }

}

function yesnoCheckk() {
	
    if (document.getElementById('machineControlYESS').checked) {
        document.getElementById('ifmachineControlYESS').style.display = 'block';
    }
    else {
    	document.getElementById('ifmachineControlYESS').style.display = 'none';
    }
    if(document.getElementById('machinelockYESS').checked){
    	document.getElementById('ifmachinelockYESS').style.display = 'block';
    }else{
    	document.getElementById('ifmachinelockYESS').style.display = 'none';
    }

}
</script>
 


<script>
 var saveKara = 0;
  
 function showAlert(saveKara){
	 return saveKara;
 }
  
 function showBtn(){

	 if(saveKara == 0){
		 alert("Please select Atleast one Machine for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete Machine(s)?");
		 if(result){
			 window.location.href = "deleteMachine.html?list="+saveKara;	 
		 }
		 	 
	 }
	 
 }
 
 function goMachine(){
	 window.location.href="${pageContext.request.contextPath}/admin/assignMachines.html";
 }
 
 function machineProblems(){
	 window.location.href="${pageContext.request.contextPath}/admin/machineProblems.html";
 }
 function unAssign(){
	 window.location.href="${pageContext.request.contextPath}/admin/unassignMachines.html";
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

console.log(saveKara);


</script>

<script type="text/javascript">


function editSchool(id,manufacturingDate,nickName,color,machineIMEI,machineInput,machineOutput,machineStatus,machineControl,controlNumber,machineType,paymentKey,machinelock,lockDays,collectionLimits,creditValue,comments){
	
	$("#Idd").val(id);
	
	$("#manufacturingDatee").val(manufacturingDate);
	$("#nickNamee").val(nickName);
	$("#colorr").val(color);
	$("#machineIMEII").val(machineIMEI);
	$("#machineInputt").val(machineInput);
	$("#machineOutputt").val(machineOutput);
	$("#machineStatuss").val(machineStatus);
	$("#machineControll").val(machineControl);
	$("#paymentKeyy").val(paymentKey);
	if(machineControl=='yes'){
		$("#machineControlYESS").prop("checked", true)
	}
	if(machineControl=='no'){
		$("#machineControlNOO").prop("checked", true)
	}
	$("#machineControlNumberr").val(controlNumber);
	$("#machineTypeIdd").val(machineType);
	$("#machinelockk").val(machinelock);
	
	if(paymentKey=='yes'){
		$("#paymentKeyYESS").prop("checked", true);
	}
	if(paymentKey=='no'){
		$("#paymentKeyNOO").prop("checked", true);
	}
	
	if(machinelock=='yes'){
		$("#machinelockYESS").prop("checked", true)
	}
	if(machinelock=='no'){
		$("#machinelockNOO").prop("checked", true)
	}
	$("#lockDayss").val(lockDays);
	$("#collectionLimitss").val(collectionLimits);
	$("#creditValuee").val(creditValue);
	$("#commentss").val(comments);
	$("#editMachineForm").modal('show');
}

function reportProblem(id){
	
	window.location.href = "viewHistory.html?machineId="+id;
	
}

function viewHistory(id){
	window.location.href = "viewMachineHistory.html?machineId="+id;
	
}

function percentageDistribution(id,status){
	if(status == 'inStock'){
		alert('Not Assign Operator or Establishment');
	}else{
		window.location.href = "percentageDistribution.html?machineId="+id;
	}
}
	
function status(){
	 window.location.href = "machineStatus.html";
}

function resolved(){
	
		var form = document.createElement("form");
		userId = document.createElement("input");
		role = document.createElement("input");

		var x = $("#userId").val();
		
		form.action = "${pageContext.request.contextPath}/admin/repairs.html";
		form.method = "post"

			userId.type = "hidden";
		userId.name = "userId";
		userId.value = x;
		form.appendChild(userId);

		role.type = "hidden";
		role.name = "role";
		role.value = "admin";
		form.appendChild(role);

		document.body.appendChild(form);
		form.submit();
		
	//window.location.href = "repairs.html";
}

function uniqueNickName(nickName){
	
	$.ajax({
		 type: 'POST',    
		  url: 'checkUniqueNickName.html',
		  data: 'nickName='+nickName,
		  success: function(response) {
			  
			  if(response == "false"){
		   alert("Nick Name is already present");
		   $("#nickName").val("");
		   $("#nickNamee").val("");
		   document.getElementById("submitButtonAdd").disabled = true;
		   document.getElementById("submitButtonEdit").disabled = true;
			  }
		  },
		  error: function(xhr) {
		    alert(xhr);
		  }
		});
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



$('.dropdown-menu a').on('click', function(){    
    $('.dropdown-toggle').html($(this).html() + '<span class="caret"></span>');    
});


function checkNickNameNull(){
	var x = document.forms["frm"]["nickName"].value;
	var y = document.forms["editForm"]["nickNamee"].value;
	if((x == null && x == "") || (y == null && y == "")){
		
		document.getElementById("submitButtonAdd").disabled = true;
		document.getElementById("submitButtonEdit").disabled = true;
		
	}else{
		
		document.getElementById("submitButtonAdd").disabled = false;
		document.getElementById("submitButtonEdit").disabled = false;
	}
}


$(document).ready(function() {
	
	$('#frm').submit(function() {
		
		var x = document.forms["frm"]["nickName"].value;
		if(x== null || x == ""){
			
			document.getElementById("submitButtonAdd").disabled = true;
			return false;	
		}else{
			
			document.getElementById("submitButtonAdd").disabled = false;
			return true;
		}
	});
	
    $('#frm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	manufacturingDate: {
                validators: {
                    notEmpty: {
                        message: 'The manufacturingDate is required'
                    }
                }
            },
            color: {
                validators: {
                    notEmpty: {
                        message: 'The color is required'
                    }
                }
            },
            machineIMEI: {
                validators: {
                    notEmpty: {
                        message: 'The machineIMEI is required'
                    }
                }
            },
            
            machineInput: {
                validators: {
                    notEmpty: {
                        message: 'The machineInput is required'
                    }
                }
            },
            
            machineOutput: {
                validators: {
                    notEmpty: {
                        message: 'The machineOutput is required'
                    }
                }
            },
            
            machineStatus: {
                validators: {
                    notEmpty: {
                        message: 'The machineStatus is required'
                    }
                }
            },
            
            machineControl: {
                validators: {
                    notEmpty: {
                        message: 'The machineControl is required'
                    }
                }
            },
            
            machineType: {
                validators: {
                    notEmpty: {
                        message: 'The machineType is required'
                    }
                }
            },
            
            machinelock: {
                validators: {
                    notEmpty: {
                        message: 'The machinelock is required'
                    }
                }
            },
            
            collectionLimits: {
                validators: {
                    notEmpty: {
                        message: 'The collectionLimits is required'
                    }
                }
            },
            
            creditValue: {
                validators: {
                    notEmpty: {
                        message: 'The creditValue is required'
                    }
                }
            },
            
            nickName: {
                validators: {
                    notEmpty: {
                        message: 'The Nick Name is required'
                    }
                }
            },
            
            machineType: {
                validators: {
                    notEmpty: {
                        message: 'The Machine Type is required'
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
        	schoolName: {
                validators: {
                    notEmpty: {
                        message: 'The schoolName is required'
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
            details: {
                validators: {
                    notEmpty: {
                        message: 'The Details is required'
                    }
                }
            },
            
            location: {
                validators: {
                    notEmpty: {
                        message: 'The Location is required'
                    }
                }
            },
            
            city: {
                validators: {
                    notEmpty: {
                        message: 'The city is required'
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
                    <h1 class="page-head-text pull-left"><spring:message code="label.machine"/></h1>
                   <%--  <button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="status()"><i class="fa fa-plus-circle"></i>  <spring:message code="label.status"/></button> --%>
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addMachine"/></button>                    
                    <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="showBtn()" ><i class="fa fa-trash-o"></i> <spring:message code="label.delete"/></button>
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="goMachine()"><i class="fa fa-plus-circle"></i>  <spring:message code="label.assignUnassignMachine"/></button>
                   
                   <%--  <button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="spareParts()"><i class="fa fa-plus-circle"></i>  <spring:message code="label.spareParts"/></button> --%>
                     <button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="resolved()"><i class="fa fa-plus-circle"></i>  <spring:message code="label.repair"/></button>
 
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
                        <span class="panel-head"><spring:message code="label.machineList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
    
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                               
                               <th width="10%"><spring:message code="label.manufacturingDate"/></th>
                                <th width="10%"><spring:message code="label.nickName"/></th>
                                <th width="10%"><spring:message code="label.color"/></th>
                                <th width="10%"><spring:message code="label.machineIMEI"/></th>
                                <th width="10%"><spring:message code="label.machineInput"/></th>
                                <th width="10%"><spring:message code="label.machineOutput"/></th>
                                <th width="10%"><spring:message code="label.machineStatus"/></th>   
                                <th width="10%"><spring:message code="label.machineControl"/></th> 
                                <th width="10%"><spring:message code="label.machineControlNumber"/></th> 
                                 <th width="10%"><spring:message code="label.machineType"/></th>
                                 <th width="10%"><spring:message code="label.paymentKey" /></th>
                                 <th width="10%"><spring:message code="label.machinelock"/></th>
                                <th width="10%"><spring:message code="label.machineLockDays"/></th> 
                                 <th width="10%"><spring:message code="label.collectionLimits"/></th>
                                <th width="10%"><spring:message code="label.creditValue"/></th> 
                                <th width="10%"><spring:message code="label.comments"/></th>
                                <th width="10%"><spring:message code="label.operator"/></th>
                                <th width="10%"><spring:message code="label.establishment"/></th>
                                <th width="10%"><spring:message code="label.edit"/></th>
                                <th width="10%"><spring:message code="label.reportProblem"/></th>
                                <th width="10%"><spring:message code="label.viewHistory"/></th>
                                <th width="10%"><spring:message code="label.percentageDistribution"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="machine" items="${machineList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${machine.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <%-- <td>${machine.manufacturingDate}</td> --%>
                                    <td><fmt:formatDate pattern="dd/MM/yyyy"
value="${machine.manufacturingDate}" /></td>
									<td>${machine.nickName}</td>
                                    <td>${machine.color}</td>
                                    <td>${machine.machineIMEI}</td>
                                    <td>${machine.machineInput}</td>
                                    <td>${machine.machineOutput}</td>
                                    <td>${machine.machineStatus}</td>
                                    <td>${machine.machineControl}</td>
                                    <td>${machine.controlNumber}</td>
                                    <td>${machine.machineType.model}</td>
                                    <td>${machine.paymentKey}</td>
                                    <td>${machine.machinelock}</td>
                                    <td>${machine.lockDays}</td>
                                    <td>${machine.collectionLimits}</td>
                                    <td>${machine.creditValue}</td>
                                  	<td>${machine.comments}</td>
                                  	<c:if test="${not empty machine.operator}">
                                  	<td>${machine.operator.name}</td>
                                  	</c:if>
                                  	<c:if test="${ empty machine.operator}">
                                  	<td>Not Present</td>
                                  	</c:if>
                                  	<c:if test="${not empty machine.establishment}">
                                  	<td>${machine.establishment.establishmentName}</td>
                                  	</c:if>
                                  	<c:if test="${ empty machine.establishment}">
                                  	<td>Not Present</td>
                                  	</c:if>
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${machine.id}','${machine.manufacturingDate}','${machine.nickName}','${machine.color}','${machine.machineIMEI}','${machine.machineInput}','${machine.machineOutput}','${machine.machineStatus}','${machine.machineControl}','${machine.controlNumber}','${machine.machineType}','${machine.paymentKey}','${machine.machinelock}','${machine.lockDays}','${machine.collectionLimits}','${machine.creditValue}','${machine.comments}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
                                 	<td><button type="submit" class="btn btn-default btn-sm" onClick="reportProblem('${machine.id}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.reportProblem"/></button></td>
                                 	<td><button type="submit" class="btn btn-default btn-sm" onClick="viewHistory('${machine.id}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.viewHistory"/></button></td>
                               		<td><button type="submit" class="btn btn-default btn-sm" onClick="percentageDistribution('${machine.id}','${machine.machineStatus}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.percentageDistribution"/></button></td>
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
                <h4 class="modal-title"><center><spring:message code="label.machineDetails"/></center></h4>
            </div>
           
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/machine.html" commandName="machine">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                      	<input type="hidden" name="userId" id="userId" value="${userId}">
                    <div class="form-group">
                        <form:label path="manufacturingDate" class="col-sm-3 control-label"><spring:message code="label.manufacturingDate"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="manufacturingDate" id="manufacturingDate" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	
                  	 <div class="form-group">
                        <form:label path="nickName" class="col-sm-3 control-label"><spring:message code="label.nickName"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="nickName" id="nickName" value="" class="form-control" maxlength="60" onblur="uniqueNickName(this.value)"/>
                      	</div>
                    </div>
                   	
                    <div class="form-group">
                        <form:label path="color" class="col-sm-3 control-label"><spring:message code="label.color"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="color" id="color" value="" class="form-control" maxlength="60" onblur = "checkNickNameNull()"/>
                      	</div>
                    </div>
                    
                    
                    
                    <div class="form-group">
                        <form:label path="machineIMEI" class="col-sm-3 control-label"><spring:message code="label.machineIMEI"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="machineIMEI" id="machineIMEI" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
                     	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="machineInput" class="col-sm-3 control-label"><spring:message code="label.machineInput"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="machineInput" id="machineInput" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()" onkeypress = "return AllowNumber(event);"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="machineOutput" class="col-sm-3 control-label"><spring:message code="label.machineOutput"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="machineOutput" id="machineOutput" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()" onkeypress = "return AllowNumber(event);"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                    <form:label path="machineStatus" class="col-sm-3 control-label"><spring:message code="label.machineStatus"/> &#42;</form:label>
                    	<div class="col-sm-8">
		                    	<form:select path="machineStatus" id="machineStatus">
		                    		   <option value="inStock"><spring:message code="label.inStock"/></option>
									   <%-- <option value="assigned"><spring:message code="label.assigned"/></option> --%>
		                    	</form:select>
                    	</div>
                    </div>
                    
                  
                    
                     <div class="form-group">
                    	<div class="col-sm-8">
                       		<form:label path="machineControl" class="col-sm-3 control-label"><spring:message code="label.machineControl"/> &#42;</form:label>
                       		<form:radiobutton path="machineControl" value="yes" name="yesno" onclick="javascript:yesnoCheck();" id="machineControlYES" />YES <form:radiobutton path="machineControl" value="no" name="yesno" onclick="javascript:yesnoCheck();" id="machineControlNO" />NO 
					
                       	</div>
                     </div>
                    
                     <div id="ifmachineControlYES" style="display:none">
	                     <div class="form-group">
	                        <form:label path="controlNumber" class="col-sm-3 control-label"><spring:message code="label.machineControlNumber"/> &#42;</form:label>
	                     	<div class="col-sm-8">
	                            <form:input type="text" path="controlNumber" id="machineControlNumber" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
	                      	</div>
	                    </div> 
                    </div>
                    
                    
                    
                    
                     <div class="form-group">
                        <form:label path="machineType" class="col-sm-3 control-label"><spring:message code="label.machineType"/> &#42;</form:label>
                     	<div class="col-sm-8">
                           
                    		<%-- <form:select path="machineType" id="machineType" class="form-control" items="${machineTypeList}" /> --%>
                    		<form:select path="machineType.id" id="machineTypeId" class="form-control" >
                        		<form:option value="">Select</form:option>
                            	<c:forEach var="machineType" items="${machineTypeList}">
                               	<form:option value="${machineType.id}">${machineType.model}</form:option>
                        		</c:forEach>
                        	</form:select>
							
                      	</div>
                    </div>
                    
                
                    
                    <div class="form-group">
                    	<div class="col-sm-8">
                       		<form:label path="paymentKey" class="col-sm-3 control-label"><spring:message code="label.paymentKey"/> &#42;</form:label>
                       		<form:radiobutton path="paymentKey" value="yes" name="yesno"  id="paymentKeyYES" />YES <form:radiobutton path="paymentKey" value="no" name="yesno"  id="paymentKeyNO" />NO 
					
                       	</div>
                     </div>
                    
                    <div class="form-group">
                    	<div class="col-sm-8">
                       		<form:label path="machinelock" class="col-sm-3 control-label"><spring:message code="label.machinelock"/> &#42;</form:label>
                       		<form:radiobutton path="machinelock" value="yes" name="yesno" onclick="javascript:yesnoCheck();" id="machinelockYES" />YES <form:radiobutton path="machinelock" value="no" name="yesno" onclick="javascript:yesnoCheck();" id="machinelockNO" />NO 
					
                       	</div>
                     </div>
                    
                    <div id="ifmachinelockYES" style="display:none">
	                    <div class="form-group">
	                        <form:label path="lockDays" class="col-sm-3 control-label"><spring:message code="label.lockDays"/> &#42;</form:label>
	                     	<div class="col-sm-8">
	                            <form:input type="text" path="lockDays" id="lockDays" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
	                      	</div>
	                    </div>
                    </div>
                     <div class="form-group">
                        <form:label path="collectionLimits" class="col-sm-3 control-label"><spring:message code="label.collectionLimits"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="collectionLimits" id="collectionLimits" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="creditValue" class="col-sm-3 control-label"><spring:message code="label.creditValue"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="creditValue" id="creditValue" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="comments" class="col-sm-3 control-label"><spring:message code="label.comments"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="comments" id="comments" value="" class="form-control"  onblur = "checkNickNameNull()"/>
                      	</div>
                    </div>
                    
                    
                   
                   
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButtonAdd" id="submitButtonAdd" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
           
          </div>
        </form:form>    
        </div>
          
	</div>
</div>

<div class="modal fade" id="editMachineForm" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
    <div class="modal-dialog">
    	<!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"><center><spring:message code="label.machineDetails"/></center></h4>
            </div>
           
             <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/machine.html" commandName="machine">
            <div class="modal-body">
                
                         <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>
                    <div class="form-group">
                        <form:label path="manufacturingDate" class="col-sm-3 control-label"><spring:message code="label.manufacturingDate"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	
                       		<form:input type="text" path="manufacturingDate" id="manufacturingDatee" value="" class="form-control" maxlength="50" onblur = "checkNickNameNull()"/>
                       	</div>
                    </div>
                  	
                   	
                   	 <div class="form-group">
                        <form:label path="nickName" class="col-sm-3 control-label"><spring:message code="label.nickName"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="nickName" id="nickNamee" value="" class="form-control" maxlength="60" onblur="uniqueNickName(this.value)"/>
                      	</div>
                    </div>
                    
                    
                   	
                    
                    <div class="form-group">
                        <form:label path="color" class="col-sm-3 control-label"><spring:message code="label.color"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="color" id="colorr" value="" class="form-control" maxlength="60" onblur = "checkNickNameNull()"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="machineIMEI" class="col-sm-3 control-label"><spring:message code="label.machineIMEI"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="machineIMEI" id="machineIMEII" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
                     	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="machineInput" class="col-sm-3 control-label"><spring:message code="label.machineInput"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="machineInput" id="machineInputt" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()" onkeypress = "return AllowNumber(event);"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="machineOutput" class="col-sm-3 control-label"><spring:message code="label.machineOutput"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="machineOutput" id="machineOutputt" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()" onkeypress = "return AllowNumber(event);"/>
                      	</div>
                    </div>
                    
                    <%-- <div class="form-group">
                    <form:label path="machineStatus" class="col-sm-3 control-label"><spring:message code="label.machineStatus"/> &#42;</form:label>
                    	<div class="col-sm-8">
		                    	<form:select path="machineStatus" id="machineStatuss">
		                    		   <option value="inStock"><spring:message code="label.inStock"/></option>
									   <option value="assigned"><spring:message code="label.assigned"/></option>
		                    	</form:select>
                    	</div>
                    </div> --%>
                    
                  
                    
                     <div class="form-group">
                    	<div class="col-sm-8">
                       		<form:label path="machineControl" class="col-sm-3 control-label"><spring:message code="label.machineControl"/> &#42;</form:label>
                       		<form:radiobutton path="machineControl" value="yes" name="yesno" onclick="javascript:yesnoCheckk();" id="machineControlYESS" />YES <form:radiobutton path="machineControl" value="no" name="yesno" onclick="javascript:yesnoCheckk();" id="machineControlNOO" />NO 
					
                       	</div>
                     </div>
                    
                     <div id="ifmachineControlYESS" style="display:none">
	                     <div class="form-group">
	                        <form:label path="controlNumber" class="col-sm-3 control-label"><spring:message code="label.machineControlNumber"/> &#42;</form:label>
	                     	<div class="col-sm-8">
	                            <form:input type="text" path="controlNumber" id="machineControlNumberr" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
	                      	</div>
	                    </div> 
                    </div>
                    
                    
                    
                    
                     <div class="form-group">
                        <form:label path="machineType" class="col-sm-3 control-label"><spring:message code="label.machineType"/> &#42;</form:label>
                     	<div class="col-sm-8">
                           
                    		<%-- <form:select path="machineType" id="machineType" class="form-control" items="${machineTypeList}" /> --%>
                    		<form:select path="machineType.id" id="machineTypeIdd" class="form-control" >
                        		<form:option value="">Select</form:option>
                            	<c:forEach var="machineType" items="${machineTypeList}">
                               	<form:option value="${machineType.id}">${machineType.model}</form:option>
                        		</c:forEach>
                        	</form:select>
							
                      	</div>
                    </div>
                    
                   
                    
                    <div class="form-group">
                    	<div class="col-sm-8">
                       		<form:label path="paymentKey" class="col-sm-3 control-label"><spring:message code="label.paymentKey"/> &#42;</form:label>
                       		<form:radiobutton path="paymentKey" value="yes" name="yesno"  id="paymentKeyYESS" />YES <form:radiobutton path="paymentKey" value="no" name="yesno"  id="paymentKeyNOO" />NO 
					
                       	</div>
                     </div>
                    
                    <div class="form-group">
                    	<div class="col-sm-8">
                       		<form:label path="machinelock" class="col-sm-3 control-label"><spring:message code="label.machinelock"/> &#42;</form:label>
                       		<form:radiobutton path="machinelock" value="yes" name="yesnoo" onclick="javascript:yesnoCheckk();" id="machinelockYESS" />YES <form:radiobutton path="machinelock" value="no" name="yesnoo" onclick="javascript:yesnoCheckk();" id="machinelockNOO" />NO 
					
                       	</div>
                     </div>
                    
                    <div id="ifmachinelockYESS" style="display:none">
	                    <div class="form-group">
	                        <form:label path="lockDays" class="col-sm-3 control-label"><spring:message code="label.lockDays"/> &#42;</form:label>
	                     	<div class="col-sm-8">
	                            <form:input type="text" path="lockDays" id="lockDayss" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
	                      	</div>
	                    </div>
                    </div>
                     <div class="form-group">
                        <form:label path="collectionLimits" class="col-sm-3 control-label"><spring:message code="label.collectionLimits"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="collectionLimits" id="collectionLimitss" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="creditValue" class="col-sm-3 control-label"><spring:message code="label.creditValue"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="creditValue" id="creditValuee" value="" class="form-control" maxlength="20" onblur = "checkNickNameNull()"/>
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="comments" class="col-sm-3 control-label"><spring:message code="label.comments"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="comments" id="commentss" value="" class="form-control"  onblur = "checkNickNameNull()"/>
                      	</div>
                    </div>
                    
                   
                   
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButtonEdit" id="submitButtonEdit" class=" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
           
          </div>
        </form:form>    
        </div>
          
	</div>
</div>


	   