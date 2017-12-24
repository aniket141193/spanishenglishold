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
		 alert("Please select Atleast one Country for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete country(s)?");
		 if(result){
			 window.location.href = "deleteCountryList.html?list="+saveKara;	 
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




function editSchool(id,country,currency){
	
	$("#Idd").val(id);
	
	$("#countryy").val(country);
	$("#currencyy").val(currency);
	
	$("#edit").modal('show');
}

function viewMoney(id){
	window.location.href = "viewMoney.html?country="+id;
}

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
    
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
        $("#success-alert").alert('close');
    });

});

</script>



<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    
                    <c:if test="${countryPresent == 'already'}">
                   	<center>
                   	    <div class="alert alert-success" id="success-alert">
    					   <button type="button" class="close" data-dismiss="alert">x</button>
    					      <!-- <strong>Success! </strong> -->
   						     Country is already present
						</div>
					</center>             	       
                    </c:if> 
                    <h1 class="page-head-text pull-left"><spring:message code="label.country"/></h1>
                    
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addCountry"/></button>                    
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
                        <span class="panel-head"><spring:message code="label.countryList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
                            
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                                <th width="10%"><spring:message code="label.country"/></th>
                                <th width="10%"><spring:message code="label.currency"/></th>
                                <th width="10%"><spring:message code="label.edit"/></th>
                                <th width="10%"><spring:message code="label.viewMoney"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="country" items="${countryList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${country.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${country.country}</td>
                                    <td>${country.currency}</td>
                                   
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${country.id}','${country.country}','${country.currency}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="viewMoney('${country.id}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.viewMoney"/></button></td>
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
                <h4 class="modal-title"><center><spring:message code="label.countryDetails"/></center></h4>
            </div>
            
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/country.html" commandName="country">
            <div class="modal-body">
                
                     <input type="hidden" name="action" id="action" value="add">
                     
                    <div class="form-group">
                       <%--  <form:label path="country" class="col-sm-3 control-label"><spring:message code="label.country"/> &#42;</form:label> --%>
                         <label class="col-xs-3 control-label"><spring:message code="label.country"/></label>
				        <div class="col-xs-5">
				            <form:select class="form-control" path="country" name="country">
				                <option value="US">United States</option>
				                <option value="BG">Bulgaria</option>
				                <option value="BR">Brazil</option>
				                <option value="CN">China</option>
				                <option value="CZ">Czech Republic</option>
				                <option value="DK">Denmark</option>
				                <option value="FR">France</option>
				                <option value="DE">Germany</option>
				                <option value="IN">India</option>
				                <option value="MA">Morocco</option>
				                <option value="NL">Netherlands</option>
				                <option value="PK">Pakistan</option>
				                <option value="RO">Romania</option>
				                <option value="RU">Russia</option>
				                <option value="SK">Slovakia</option>
				                <option value="ES">Spain</option>
				                <option value="TH">Thailand</option>
				                <option value="AE">United Arab Emirates</option>
				                <option value="GB">United Kingdom</option>
				                <option value="VE">Venezuela</option>
				            </form:select>
				        </div>
                    </div>
                  	<div class="form-group">
                        <form:label path="currency" class="col-sm-3 control-label"><spring:message code="label.currency"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="currency" id="currency" name="currency" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
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
        <h4 class="modal-title"><spring:message code="label.editCountry"/> </h4>
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/country.html" commandName="country">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>
                    <div class="form-group">
                        <form:label path="country" class="col-sm-3 control-label"><spring:message code="label.country"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="country" id="countryy" name="countryy" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="currency" class="col-sm-3 control-label"><spring:message code="label.currency"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="currency" id="currencyy" name="currencyy" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                   	
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
                                         
                
           
          </div>
        </form:form>   
	   
	   
	   
	   
    <!-- </form> --> 
  </div>
</div>
</div>
