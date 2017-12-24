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
		 alert("Please select Atleast one Payment Device for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete PaymentDevice(s)?");
		 if(result){
			 window.location.href = "deletePaymentDevices.html?list="+saveKara;	 
		 }
		 	 
	 }
	 
 }
 
 function addHopperType(){
	 window.location.href = "${pageContext.request.contextPath}/admin/addHopperType.html";
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

function editSchool(id,type,model,io){
	
	$("#Idd").val(id);
	$("#typee").val(type);
	$("#modell").val(model);
	if(io == 'input'){
		$("#ioi").prop("checked",true);
	}
	if(io == 'output'){
		$("#ioo").prop("checked",true);
	}
	if(io == 'inputoutput'){
		$("#ioio").prop("checked",true);
	}
	
	$("#edit").modal('show');
}

function viewPaymentDeviceMoney(id){
	 window.location.href = "viewPaymentDeviceMoney.html?paymentDeviceId="+id;
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
        	type: {
                validators: {
                    notEmpty: {
                        message: 'The type is required'
                    }
                }
            },
            model: {
                validators: {
                    notEmpty: {
                        message: 'The model is required'
                    }
                }
            },
            io: {
                validators: {
                    notEmpty: {
                        message: 'The Input-Output is required'
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
        	type: {
                validators: {
                    notEmpty: {
                        message: 'The type is required'
                    }
                }
            },
            model: {
                validators: {
                    notEmpty: {
                        message: 'The model is required'
                    }
                }
            },
            io: {
                validators: {
                    notEmpty: {
                        message: 'The Input-Output is required'
                    }
                }
            }
            
        }
    });
    
    
});
</script>
<script type="text/javascript">

function yesnoCheck() {
    if (document.getElementById('yesInput').checked) {
        document.getElementById('ifInput').style.display = 'block';
        document.getElementById('ifOutput').style.display = 'none';
    }
    else if (document.getElementById('yesOutput').checked) {
        document.getElementById('ifOutput').style.display = 'block';
        document.getElementById('ifInput').style.display = 'none';
    }else if (document.getElementById('yesInputOutput').checked) {
        document.getElementById('ifOutput').style.display = 'block';
        document.getElementById('ifInput').style.display = 'block';
    }
    

}

</script>


<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left"><spring:message code="label.paymentDevices"/></h1>
                    
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addPaymentDevice"/></button>                    
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
                        <span class="panel-head"><spring:message code="label.paymentDeviceTypeList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
    
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                               
                                <th width="10%"><spring:message code="label.type"/></th>
                                <th width="10%"><spring:message code="label.model"/></th>
                                <th width="10%"><spring:message code="label.io"/></th>
                                <th width="10%"><spring:message code="label.viewMoney"/></th>
                                <th width="10%"><spring:message code="label.edit"/></th> 
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="paymentDeviceType" items="${paymentDeviceTypeList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${paymentDeviceType.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${paymentDeviceType.type}</td>
                                  	<td>${paymentDeviceType.model}</td>
                                  	<td>${paymentDeviceType.io}</td>
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="viewPaymentDeviceMoney('${paymentDeviceType.id}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.viewMoney"/></button></td>
                                	<td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${paymentDeviceType.id}','${paymentDeviceType.type}','${paymentDeviceType.model}','${paymentDeviceType.io}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
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
                <h4 class="modal-title"><center><spring:message code="label.paymentDeviceDetails"/></center></h4>
            </div>
           
          <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/addPaymentDevice.html" commandName="paymentDeviceTypeForm">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                    <div class="form-group">
                        <form:label path="type" class="col-sm-3 control-label"><spring:message code="label.name"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="type" id="name" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="model" class="col-sm-3 control-label"><spring:message code="label.model"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="model" id="model" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                    <div class="form-group">
                    	<div class="col-sm-8">
                       		<!-- Input <input type="radio" onclick="javascript:yesnoCheck();" name="yesno" id="yesInput"> Output <input type="radio" onclick="javascript:yesnoCheck();" name="yesno" id="yesOutput"> Input/Output <input type="radio" onclick="javascript:yesnoCheck();" name="yesno" id="yesInputOutput"><br> -->
                       		<form:radiobutton path="io" value="input" name="yesno" onclick="javascript:yesnoCheck();" id="yesInput" />Input <form:radiobutton path="io" value="output" name="yesno" onclick="javascript:yesnoCheck();" id="yesOutput" />Output <form:radiobutton path="io" value="inputoutput" name="yesno" onclick="javascript:yesnoCheck();" id="yesInputOutput" />Input/Output
					
                       	</div>
                     </div>
                    <div id="ifInput" style="display:none">
                    		<div class="form-group">
                    			<h3 class="page-head-text pull-left"><spring:message code="label.inputMoney"/></h3>
                    		</div>
                    		<div class="form-group">
                    			<div class="col-sm-8">
                    			<h5 class="page-head-text pull-left"><spring:message code="label.inputMoneyMsg"/></h5>
                    			</div>
                    		</div>
                    		<div class="form-group">
	                        	<label  class="col-sm-3 control-label"><spring:message code="label.coin"/> &#42;</label>
    		                    <div class="col-sm-8">
    		                  	   <c:forEach var="coin" items="${coins}">
                       	 				<form:checkbox path="inputCoins" value="${coin.id}" />name: ${coin.name} , value: ${coin.value} , code: ${coin.code}<br>
                        			</c:forEach>
                        		</div>
            	        	</div>
            	        	<div class="form-group">
	                        	<label  class="col-sm-3 control-label"><spring:message code="label.note"/> &#42;</label>
    		                    <div class="col-sm-8">
    		                  	  <c:forEach var="note" items="${notes}">
                       	 				<form:checkbox path="inputNotes" value="${note.id}" />name: ${note.name} , value: ${note.value} , code: ${note.code}<br>
                        		  </c:forEach>
                        		</div>
            	        	</div>
            	        	<div class="form-group">
	                        	<label  class="col-sm-3 control-label"><spring:message code="label.tokens"/> &#42;</label>
    		                    <div class="col-sm-8">
    		                  	   <c:forEach var="token" items="${tokens}">
                       	 				<form:checkbox path="inputTokens" value="${token.id}" />name: ${token.name} , value: ${token.value} , code: ${token.code}<br>
                        			</c:forEach>
                        		</div>
            	        	</div>
            	        	<%-- <div class="form-group">
	                        	<label  class="col-sm-3 control-label"><spring:message code="label.bills"/> &#42;</label>
    		                    <div class="col-sm-8">
    		                  	    <c:forEach var="bill" items="${bills}">
                       	 				<form:checkbox path="inputBills" value="${bill.id}" />name: ${bill.name} , value: ${bill.value} , code: ${bill.code}<br>
                        			</c:forEach>
                        		</div>
            	        	</div> --%>
            	        
                    </div>
                    
                     <div id="ifOutput" style="display:none">
                    		<div class="form-group">
                    			<h3 class="page-head-text pull-left"><spring:message code="label.outputMoney"/></h3>
                    		</div>
                    		<div class="form-group">
                    			<div class="col-sm-8">
                    			<h5 class="page-head-text pull-left"><spring:message code="label.outputMoneyMsg"/></h5>
                    			</div>
                    		</div>
                    		<div class="form-group">
	                        	<label  class="col-sm-3 control-label"><spring:message code="label.coin"/> &#42;</label>
    		                    <div class="col-sm-8">
    		                  	   <c:forEach var="coin" items="${coins}">
                       	 				<form:checkbox path="outputCoins" value="${coin.id}" />name: ${coin.name} , value: ${coin.value} , code: ${coin.code}<br>
                        			</c:forEach>
                        		</div>
            	        	</div>
            	        	<div class="form-group">
	                        	<label  class="col-sm-3 control-label"><spring:message code="label.note"/> &#42;</label>
    		                    <div class="col-sm-8">
    		                  	  <c:forEach var="note" items="${notes}">
                       	 				<form:checkbox path="outputNotes" value="${note.id}" />name: ${note.name} , value: ${note.value} , code: ${note.code}<br>
                        		  </c:forEach>
                        		</div>
            	        	</div>
            	        	<div class="form-group">
	                        	<label  class="col-sm-3 control-label"><spring:message code="label.tokens"/> &#42;</label>
    		                    <div class="col-sm-8">
    		                  	   <c:forEach var="token" items="${tokens}">
                       	 				<form:checkbox path="outputTokens" value="${token.id}" />name: ${token.name} , value: ${token.value} , code: ${token.code}<br>
                        			</c:forEach>
                        		</div>
            	        	</div>
            	        	<<%-- div class="form-group">
	                        	<label  class="col-sm-3 control-label"><spring:message code="label.bills"/> &#42;</label>
    		                    <div class="col-sm-8">
    		                  	    <c:forEach var="bill" items="${bills}">
                       	 				<form:checkbox path="outputBills" value="${bill.id}" />name: ${bill.name} , value: ${bill.value} , code: ${bill.code}<br>
                        			</c:forEach>
                        		</div>
            	        	</div> --%>
            	        
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
		        <h4 class="modal-title"><spring:message code="label.editPaymentDeviceType"/> </h4>
		    </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/editPaymentDevice.html" commandName="paymentDeviceTypeForm">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>

					<div class="form-group">
                        <form:label path="type" class="col-sm-3 control-label"><spring:message code="label.name"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="type" id="typee" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="type" class="col-sm-3 control-label"><spring:message code="label.model"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="model" id="modell" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                    <div class="form-group">
                    	<div class="col-sm-8">
                       
                       		<form:radiobutton path="io" id="ioi" value="input" name="yesnoedit" />Input <form:radiobutton path="io" id="ioo" value="output" name="yesnoedit"  />Output <form:radiobutton path="io" id="ioio" value="inputoutput" name="yesnoedit"  />Input/Output
					
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
</div> 

	   
	   