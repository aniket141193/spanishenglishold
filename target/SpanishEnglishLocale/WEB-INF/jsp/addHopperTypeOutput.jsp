<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<script>
 
 function doneCoinsName(countryId){
	var code =  $("#code").val();
	var value = $("#value").val();
	var name = $("#name").val();
	 window.location.href = "addBillsDone.html?countryId="+countryId+"&code="+code+"&value="+value+"&name="+name;	
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

function editSchool(id,country,currency){
	
	$("#Idd").val(id);
	
	$("#countryy").val(country);
	$("#currencyy").val(currency);
	
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





$('.dropdown-menu a').on('click', function(){    
    $('.dropdown-toggle').html($(this).html() + '<span class="caret"></span>');    
});





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
        	country: {
                validators: {
                    notEmpty: {
                        message: 'The country name is required'
                    }
                }
            },
            currency: {
                validators: {
                    notEmpty: {
                        message: 'The currency is required'
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
        	country: {
                validators: {
                    notEmpty: {
                        message: 'The country name is required'
                    }
                }
            },
            currency: {
                validators: {
                    notEmpty: {
                        message: 'The currency is required'
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

                    <h1 class="page-head-text pull-left"><spring:message code="label.hopperType"/></h1>
                    <h3 class="page-head-text pull-left"><spring:message code="label.outputMoney"/></h3>
                    
                </div>                                    
            </div>
        </div>
        
    </div>
    
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                       
            <form:form action="${pageContext.request.contextPath}/admin/addHopperTypeOutput.html" method="post" commandName="outputMoneyHopperForm">
                
                     <input type="hidden" name="action" id="action" value="add">
                     <input type="hidden" name="hopperTypeId" id="hopperTypeId" value="${hopperTypeId}">
                     <div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.coin"/> &#42;</label>
                        <div class="col-sm-8">
                        <%--  <form:select path="coins" id="coins" class="form-control" multiple="true">
                        		<form:option value="">Select</form:option>
                            	<c:forEach var="coin" items="${coins}">
                               	<form:option value="${coin.id}">${coin.name},${coin.value},${coin.code}</form:option>
                        		</c:forEach>
                        </form:select> --%> 
                        <c:forEach var="coin" items="${coins}">
                       	 <form:checkbox path="coins" value="${coin.id}" />name: ${coin.name} , value: ${coin.value} , code: ${coin.code}
                        </c:forEach>
                        </div>
                        
                   	</div>
                     
                   <div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.note"/> &#42;</label>
                        <div class="col-sm-8">
                        <%-- <form:select path="notes" id="notes" class="form-control" multiple="true">
                        		<form:option value="">Select</form:option>
                            	<c:forEach var="note" items="${notes}">
                               	<form:option value="${note.id}">${note.name},${note.value},${note.code}</form:option>
                               	 
                        		</c:forEach>
                        </form:select> --%>
                        <c:forEach var="note" items="${notes}">
                       	 <form:checkbox path="notes" value="${note.id}" />name: ${note.name} , value: ${note.value} , code: ${note.code}
                        </c:forEach>
                        </div>
                   	</div>
                  	
                  	<div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.tokens"/> &#42;</label>
                        <div class="col-sm-8">
                        <%-- <form:select path="tokens" id="tokens" class="form-control" multiple="true">
                        		<form:option value="">Select</form:option>
                            	<c:forEach var="token" items="${tokens}">
                               	<form:option value="${token.id}">${token.name},${token.value},${token.code}</form:option>
                        		</c:forEach>
                        </form:select> --%>
                        <c:forEach var="token" items="${tokens}">
                       	 <form:checkbox path="tokens" value="${token.id}" />name: ${token.name} , value: ${token.value} , code: ${token.code}
                        </c:forEach>
                        </div>
                   	</div>
                   	
                   	<div class="form-group">
                        <label  class="col-sm-3 control-label"><spring:message code="label.bills"/> &#42;</label>
                        <div class="col-sm-8">
                       <%--  <form:select path="bills" id="bills" class="form-control" multiple="true">
                        		<form:option value="">Select</form:option>
                            	<c:forEach var="bill" items="${bills}">
                               	<form:option value="${bill.id}">${bill.name},${bill.value},${bill.code}</form:option>
                        		</c:forEach>
                        </form:select> --%>
                        <c:forEach var="bill" items="${bills}">
                       	 <form:checkbox path="bills" value="${bill.id}" />name: ${bill.name} , value: ${bill.value} , code: ${bill.code}
                        </c:forEach>
                        </div>
                   	</div>
             		
           	<div class="modal-footer text-center">
            	
            	<button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
                                         
                
           
          
        </form:form> 
                </div>                                    
            </div>
        </div>
    </div>   
</div>
