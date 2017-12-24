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
		 alert("Please select Atleast one Machine for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete Bill(s)?");
		 if(result){
			 window.location.href = "deleteBillsList.html?list="+saveKara;	 
		 }
		 	 
	 }
	 
 }
 
 function goUsersRole(){
	 window.location.href = "${pageContext.request.contextPath}/admin/usersRole.html";
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


 function editSchool(id,name,userRole,username,password){
		
		$("#Idd").val(id);
		$("#namee").val(name);
		$("#userRolee").val(userRole);
		$("#usernamee").val(username);
		$("#passwordd").val(password);
		
		$("#edit").modal('show');
	}

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
                    <h1 class="page-head-text pull-left"><spring:message code="label.usersRole"/></h1>
                    
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addUsersRole"/></button>                    
                    <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="showBtn()" ><i class="fa fa-trash-o"></i> <spring:message code="label.delete"/></button>
                </div>                                    
            </div>
        </div>
    </div>
        
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head"><spring:message code="label.usersRoleList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
         						<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                                <th width="10%"><spring:message code="label.usersRole"/></th>
                                <th width="10%"><spring:message code="label.edit"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="userRole" items="${usersRoleList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${userRole.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${userRole.userRole}</td>
                                  	
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${userRole.id}','${userRole.userRole}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
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
                <h4 class="modal-title"><center><spring:message code="label.usersRoleDetails"/></center></h4>
            </div>
           
          <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/usersRole.html" commandName="usersRole">
            <div class="modal-body">
                
                    <input type="hidden" name="action" id="action" value="add">
                    <div class="form-group">
                        <form:label path="userRole" class="col-sm-3 control-label"><spring:message code="label.usersRole"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="userRole" id="userRole" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
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
        <h4 class="modal-title"><spring:message code="label.editUsersRole"/> </h4>
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/usersRole.html" commandName="usersRole">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>

					<div class="form-group">
                        <form:label path="userRole" class="col-sm-3 control-label"><spring:message code="label.usersRole"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="userRole" id="userRolee" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
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
	   
	   