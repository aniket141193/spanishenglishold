<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>


 
<script type="text/javascript">

 var saveKara = 0;
  
 function showAlert(saveKara){
	 return saveKara;
 }
  
 function showBtn(){

	 if(saveKara == 0){
		 alert("Please select Atleast one Operator for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete operator(s)?");
		 if(result){
			 window.location.href = "deleteOperatorList.html?list="+saveKara;	 
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

$('#frm').submit(function() {
		
		var x = document.forms["frm"]["operatorUsernamee"].value;
		if(x== null || x == ""){
			
			document.getElementById("submitButtonAdd").disabled = true;
			return false;	
		}else{
			
			document.getElementById("submitButtonAdd").disabled = false;
			return true;
		}
	});
	
    $('#example').DataTable();
    
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){

        $("#success-alert").alert('close');

    });
    
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
function addPhone() {

		//Create an input type dynamically.
		var element = document.createElement("input");

		//Assign different attributes to the element.
		element.setAttribute("type", "text");
		element.setAttribute("value", "");
		element.setAttribute("name", "telephone");
		element.setAttribute("id","telephone");
		element.setAttribute("class","form-control");
		element.setAttribute('onkeypress','return AllowNumber(event);');
		element.setAttribute('maxlength','10');
		
		var foo = document.getElementById("fooBar");

		//Append the element in page (in span).
		
		var langArray = [
		                 {value: "home", text: "home no"},
		                 {value: "office", text: "office no"},
		                 {value: "mobile", text: "mobile no"}
		             ];
		var select = document.createElement('select'),
	    option,
	    i = 0,
	    il = langArray.length;
		select.setAttribute("name", "telephoneType");
		for (; i < il; i += 1) {
		    option = document.createElement('option');
		    option.setAttribute('value', langArray[i].value);
		    option.appendChild(document.createTextNode(langArray[i].text));
		    select.appendChild(option);
		}
		
		
		foo.appendChild(select);
		foo.appendChild(element);
	}



function editSchool(id,business,name,email,telephone,address,username,password,sector,population,province,identity_card){
	
	$("#Idd").val(id);
	
	$("#business").val(business);
	$("#name").val(name);
	$("#email").val(email);
	$("#telephone").val(telephone);
	$("#address").val(address);
	$("#operatorUsername").val(username);
	$("#operatorPassword").val(password);
	$("#sector").val(sector);
	$("#population").val(population);
	$("#province").val(province);
	$("#identity_card").val(identity_card);
	var phones = telephone;
	var type = 'operator';
	//$("#edit").modal('show');
	window.location.href = "editOperator.html?id="+id;
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


function uniqueUserName(userName){
	
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

$('#frm').submit(function(e) {
    $('#messages').removeClass('hide').addClass('alert alert-success alert-dismissible').slideDown().show();
    $('#messages_content').html('<h4>MESSAGE HERE</h4>');
    $('#modal').modal('show');
    e.preventDefault();
});

function resetAddData(){

	 $(':input[type=text]','#frm').val("");

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
    // Revalidate phone number when changing the country
       /*  .on('change', '[name="countrySelectBox"]', function(e) {
            $('#phoneForm').formValidation('revalidateField', 'telephone');
        }); */
    
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
            operatorPassword: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
                }
            },
            operatorUsername: {
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
                    <h1 class="page-head-text pull-left"><spring:message code="label.operator"/></h1>
                    
                     <c:if test="${added == 'added'}">
                   	<center>
                   	    <div class="alert alert-success" id="success-alert">
    					   <button type="button" class="close" data-dismiss="alert">x</button>
    					      <strong>Success! </strong>
   						     	Operator Added Successfully
						</div>
					</center>             	       
                    </c:if> 
                     
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addOperator"/></button>                    
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
                        <span class="panel-head"><spring:message code="label.operatorList"/></span>
                    </div>                                        
                </div>
          
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
                            
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                                <th width="10%"><spring:message code="label.business"/></th>
                                <th width="10%"><spring:message code="label.name"/></th>
                                <th width="10%"><spring:message code="label.email"/></th>
                                <th width="10%"><spring:message code="label.telephone"/></th>
                                <th width="10%"><spring:message code="label.address"/></th>
                                <th width="10%"><spring:message code="label.username"/></th>   
                                 <th width="10%"><spring:message code="label.password"/></th>  
                                 <th width="10%"><spring:message code="label.sector"/></th>
                                <%-- <th width="10%"><spring:message code="label.population"/></th> --%>
                                <th width="10%"><spring:message code="label.identity_card"/></th>   
                                 <th width="10%"><spring:message code="label.province"/></th> 
                                                               
                                <th width="10%"><spring:message code="label.edit"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="operator" items="${operatorList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${operator.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${operator.business}</td>
                                    <td>${operator.name}</td>
                                    <td>${operator.email}</td>
                                    <td><c:forEach var="phone" items="${operator.phones}">${phone.type}:${phone.no},<br></c:forEach></td>
                                    
                                    <td>${operator.address}</td>
                                    <td>${operator.operatorUsername}</td>
                                    <td>${operator.operatorPassword}</td>
                                    <td>${operator.sector}</td>
                                
                                    <td>${operator.identity_card}</td>
                                    <td>${operator.province}</td>
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${operator.id}','${operator.business}','${operator.name}','${operator.email}','${operator.phones}','${operator.address}','${operator.operatorUsername}','${operator.operatorPassword}','${operator.sector}','${operator.population}','${operator.province}','${operator.identity_card}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
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
                <h4 class="modal-title"><center><spring:message code="label.operatorDetails"/></center></h4>
            </div>
            
            
	
	
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/operatorsList.html"  commandName="operator">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                    <div class="form-group">
                        <form:label path="business" class="col-sm-3 control-label"><spring:message code="label.business"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.bussinessPH" var="i18nTooltip"/> 
                       		<form:input type="text" path="business" id="businesss" name="businesss" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="name" class="col-sm-3 control-label"><spring:message code="label.name"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.namePH" var="i18nTooltip"/>
                            <form:input type="text" path="name" id="namee" name="namee" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                   	</div>
                    <div class="form-group">
                        <form:label path="email" class="col-sm-3 control-label"><spring:message code="label.email"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.emailPH" var="i18nTooltip"/>
                            <form:input type="text" path="email" id="emaill" name="emaill" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="60" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                   <%--  <div class="form-group">
				        <label class="col-xs-3 control-label">Country</label>
				        <div class="col-xs-5">
				            <form:select class="form-control" path="countryName" name="countryName">
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
				    </div> --%>
                    <div class="form-group">
                        <form:label path="telephone" class="col-sm-3 control-label"><spring:message code="label.telephone"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.telephonePH" var="i18nTooltip"/>
                            <%-- <form:input type="text" path="telephone" id="telephonee" name="telephonee" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('d').value)"/> --%>
                            <INPUT type="button" value="${i18nTooltip}" onclick="addPhone()"/>
                            <br>
                            <span id="fooBar"><br/></span>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.addressPH" var="i18nTooltip"/>
                            <form:input type="text" path="address" id="addresss" name="addresss" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="operatorUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.usernamePH" var="i18nTooltip"/>
                            <form:input type="text" path="operatorUsername" id="operatorUsernamee" name="operatorUsernamee" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="100" onblur="uniqueUserName(this.value)"/>
                      	</div>
                    </div>
                    <div class="form-group">
                    	
                        <form:label path="operatorPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.passwordPH" var="i18nTooltip"/>
                            <form:input type="text" path="operatorPassword" id="operatorPasswordd" name="operatorPasswordd" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                    
                     <div class="form-group">
                        <form:label path="sector" class="col-sm-3 control-label"><spring:message code="label.sector"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.sectorPH" var="i18nTooltip"/>
                            <form:input type="text" path="sector" id="sectorr" name="sectorr" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                   
                    
                    <div class="form-group">
                        <form:label path="province" class="col-sm-3 control-label"><spring:message code="label.province"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.provincePH" var="i18nTooltip"/>
                            <form:input type="text" path="province" id="provincee" name="provincee" value="" placeholder="${i18nTooltip}" class="form-control"  onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                     
                    <div class="form-group">
                        <form:label path="identity_card" class="col-sm-3 control-label"><spring:message code="label.identity_card"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.identityCardPH" var="i18nTooltip"/>
                            <form:input type="text" path="identity_card" id="identity_cardd" name="identity_cardd" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="100" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
           			<input type="hidden" name="action" value="add" />
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" id="resetAdd" onclick="resetAddData()" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButtonAdd" id="submitButtonAdd" class="btn btn-primary"><spring:message code="label.save"/></button>
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
        <h4 class="modal-title"><spring:message code="label.editOperator"/> </h4>
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/operatorsList.html" commandName="operator">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>
                    <div class="form-group">
                        <form:label path="business" class="col-sm-3 control-label"><spring:message code="label.business"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="business" id="business" value="" class="form-control" maxlength="50" />
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="name" class="col-sm-3 control-label"><spring:message code="label.name"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="name" id="name" value="" class="form-control" maxlength="50" />
                      	</div>
                   	</div>
                    <div class="form-group">
                        <form:label path="email" class="col-sm-3 control-label"><spring:message code="label.email"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="email" id="email" value="" class="form-control" maxlength="60" />
                      	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="telephone" class="col-sm-3 control-label"><spring:message code="label.telephone"/> &#42;</form:label>
                        <div class="col-sm-8">
                           <%--  <form:input type="text" path="telephone" id="telephone" value="" class="form-control" maxlength="20" /> --%>
                           <%-- <c:forEach var="paymentDeviceType" items="${paymentDeviceTypeList}">
                               	<form:option value="${paymentDeviceType.id}">${paymentDeviceType.type},${paymentDeviceType.model},${paymentDeviceType.io}</form:option>
                        	</c:forEach> --%>
                        	<%-- <c:forEach var="phone" items="${phones}" >
                        		<input type="text" value="${phone.no}"></input>
                        	</c:forEach> --%>
                        	 <form:input type="text" path="phones" id="telephone" value="" class="form-control"  />
                        	 
                     	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="address" id="address" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('location').value)"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="operatorUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="operatorUsername" id="operatorUsername" value="" class="form-control" maxlength="20"  onblur="uniqueNickName(this.value)"/>
                      	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="operatorPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="operatorPassword" id="operatorPassword" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                    
                    <div class="form-group">
                        <form:label path="sector" class="col-sm-3 control-label"><spring:message code="label.sector"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="sector" id="sector" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                   <%--   <div class="form-group">
                        <form:label path="population" class="col-sm-3 control-label"><spring:message code="label.population"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="population" id="population" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div> --%>
                    
                    <div class="form-group">
                        <form:label path="province" class="col-sm-3 control-label"><spring:message code="label.province"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="province" id="province" value="" class="form-control" />
                      	</div>
                    </div>
                    
                    
                     <div class="form-group">
                        <form:label path="identity_card" class="col-sm-3 control-label"><spring:message code="label.identity_card"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            <form:input type="text" path="identity_card" id="identity_card" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
           			<input type="hidden" name="action" value="edit" />
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
            	<button type="submit" name="submitButtonEdit" id="submitButtonEdit" class="btn btn-primary"><spring:message code="label.save"/></button>
            </div>
                                         
                
           
          </div>
        </form:form>   
  </div>
</div>
</div>
