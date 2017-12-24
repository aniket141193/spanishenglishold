<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

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
		 alert("Please select Atleast one Money for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete Money?");
		 if(result){
			 var paymentDeviceTypeId = $("#paymentDeviceTypeId").val();
			 window.location.href = "deletePaymentDeviceMoney.html?list="+saveKara+"&paymentDeviceTypeId="+paymentDeviceTypeId;	 
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

console.log(saveKara);


</script>

<script type="text/javascript">

function editSchool(id,name,value,code,type){
	alert("hi");
	$("#Idd").val(id);
	$("#namee").val(name);
	$("#valuee").val(value);
	$("#codee").val(code);
	$("#typee").val(type);
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
                    <h1 class="page-head-text pull-left"><spring:message code="label.money"/></h1>
                    
                      <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addMoney"/></button>                    
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
                        <span class="panel-head"><spring:message code="label.moneyList"/></span>
                    </div>                                        
                </div>
                
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
                            
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                                <th width="10%"><spring:message code="label.name"/></th>
                               <th width="10%"><spring:message code="label.value"/></th>
                               <th width="10%"><spring:message code="label.code"/></th>
                               <th width="10%"><spring:message code="label.type"/></th>
								<th width="10%"><spring:message code="label.moneyType"/></th>                                                               
                                <%-- <th width="10%"><spring:message code="label.edit"/></th> --%>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="money" items="${moneyList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${money.id}-${money.type}-${money.moneyType}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${money.name}</td>
									<td>${money.value}</td>                                   
                                    <td>${money.code}</td>
                                    <td>${money.type}</td>   
                                    <td>${money.moneyType}</td>   
                                    <%-- <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${money.id}','${money.name}','${money.value}','${money.code}','${money.type}' );"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td> --%>
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
                <h4 class="modal-title"><center><spring:message code="label.moneyDetails"/></center></h4>
            </div>
            
            
	
	
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/addPaymentDeviceMoney.html" commandName="money">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                      	<div class="form-group">
                      		 <label  class="col-sm-3 control-label"><spring:message code="label.money"/> &#42; </label>
                      		 <div class="col-sm-12">
                      		 <input type="hidden" name="paymentDeviceTypeId" id="paymentDeviceTypeId" value="${paymentDeviceTypeId}">
                      	 <form:select path="moneyAdd" id="moneyAdd">
                        		
                            	<c:forEach var="money" items="${modelSet}">
                               	<form:option value="${money.id},${money.type},${money.moneyType}"><label><spring:message code="label.name"/></label> : ${money.name}, <label><spring:message code="label.value"/></label> : ${money.value}, <label><spring:message code="label.code"/></label> : ${money.code}, <label><spring:message code="label.type"/></label> : ${money.type} , <label><spring:message code="label.moneyType"/></label> : ${money.moneyType}</form:option>
                        		</c:forEach>
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


 <%-- <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><spring:message code="label.editMoney"/> </h4>
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/addMoney.html" commandName="money">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>
            
            			<input type="hidden" name="countryId" id="countryId" value="${countryId}">
            			<form:input path="type" type="hidden" id="typee" value=""/>
                     
                    	
                    <div class="form-group">
                        <form:label path="name" class="col-sm-3 control-label"><spring:message code="label.name"/> &#42; </form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="name" id="namee" value="" class="form-control"  />
                       	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="value" class="col-sm-3 control-label"><spring:message code="label.value"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="value" id="valuee" value="" class="form-control"  />
                       	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="code" class="col-sm-3 control-label" ><spring:message code="label.code"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="code" id="codee" value="" class="form-control"  />
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
 --%>