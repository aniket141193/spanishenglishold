<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
  
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
 

<script>
$( function() {
    $( "#d" ).datepicker();
  } );
</script>




<script type="text/javascript">

function uniqueUserName(userName){
	
	$.ajax({
		 type: 'POST',    
		  url: 'checkUniqueUserName.html',
		  data: 'userName='+userName,
		  success: function(response) {
			  
			  if(response == "false"){
		   alert("User Name is already present");
		   $("#establishmentUsername").val("");
		   document.getElementById("submitButtonAdd").disabled = true;
		   
			  }
		  },
		  error: function(xhr) {
		    alert(xhr);
		  }
		});
}

function checkUserNameNull(){
	var x = document.forms["frm"]["establishmentUsername"].value;
	
	if((x == null && x == "") ){
		
		document.getElementById("submitButtonAdd").disabled = true;
		
		
	}else{
		
		document.getElementById("submitButtonAdd").disabled = false;
		
	}
}



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

function AllowHours(e)
{
	  isIE = document.all ? 1 : 0
	  keyEntry = !isIE ? e.which : e.keyCode;
	  if (keyEntry == '48' || keyEntry == '49' || keyEntry == '50' || keyEntry == '51'|| keyEntry == '52' || keyEntry == '53' || keyEntry == '54' || keyEntry == '55' || keyEntry == '56' || keyEntry == '57')
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
	  if (keyEntry == '48' || keyEntry == '49' || keyEntry == '50' || keyEntry == '51'|| keyEntry == '52' || keyEntry == '53' || keyEntry == '54' || keyEntry == '55' || keyEntry == '56' || keyEntry == '57')
	     return true;
	  else
		{
	    	alert('Please Enter Only numbers between 1 to 60.');
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


</script>
  
<script type="text/javascript">
 var saveKara = 0;
  
 function showAlert(saveKara){
	 return saveKara;
 }
  
 function showBtn(){

	 if(saveKara == 0){
		 alert("Please select Atleast one Establishment for delete");
	 }
	 else{
	
		 var result = confirm("Are you sure, you wan to delete establishment(s)?");
		 if(result){
			 window.location.href = "deleteEstablishmentList.html?list="+saveKara;	 
		 }
		 	 
	 }
	 
 }

</script>

<script type="text/javascript">

/*This code used for hide button on page load and show when check box is chechked
$(document).ready(function() {
    
    var $submit = $("#btn").hide(),
        $cbs = $('input[name="myTextEditBox"]').click(function() {
            $submit.toggle( $cbs.is(":checked") );
        });

}); */




 $(document).ready(function() {
	 
	 $('#frm').submit(function() {
			
			var x = document.forms["frm"]["establishmentUsername"].value;
			if(x== null || x == ""){
				
				document.getElementById("submitButtonAdd").disabled = true;
				return false;	
			}else{
				
				document.getElementById("submitButtonAdd").disabled = false;
				return true;
			}
		});

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

console.log(saveKara);


</script>

<script type="text/javascript">




function editSchool(id,establishmentName,establishmentOwner,geolocation,phone,address,username,password,sector,population,province,dischargeDate,percentage,establishmentsType,status,openTime,closeTime,loans,withdrawals,prepayments,fund){

	$("#Idd").val(id);

	$("#establishmentName").val(establishmentName);
	$("#establishmentOwner").val(establishmentOwner);
	$("#geolocation").val(geolocation);
	$("#telephone").val(phone);
	$("#address").val(address);
	$("#username").val(username);
	$("#password").val(password);
	$("#sector").val(sector);
	$("#population").val(population);
	$("#province").val(province);
	$("#dischargeDate").val(dischargeDate);
	$("#percentage").val(percentage);
	$("#establishmentsType").val(establishmentsType);
	$("#status").val(status);
	var array1 = openTime.split(':'),
    a1 = array1[0], b1 = array1[1];
	$("#openingHourss").val(a1);
	$("#openinMinss").val(b1);
	var array2 = closeTime.split(':'),
    a2 = array2[0], b2 = array2[1];
	$("#closeingHourss").val(a2);
	$("#closeingMinss").val(b2);
	$("#loans").val(loans);
	$("#withdrawals").val(withdrawals);
	$("#prepayments").val(prepayments);
	$("#fund").val(fund);
	//$("#edit").modal('show');
	window.location.href = "editEstablishment.html?id="+id;
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



f

$('#frm').submit(function(e) {
    $('#messages').removeClass('hide').addClass('alert alert-success alert-dismissible').slideDown().show();
    $('#messages_content').html('<h4>MESSAGE HERE</h4>');
    $('#modal').modal('show');
    e.preventDefault();
});




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
<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                	<div class="panel-name">
                        
                         <c:if test="${added == 'added'}">
                   	<center>
                   	    <div class="alert alert-success" id="success-alert">
    					   <button type="button" class="close" data-dismiss="alert">x</button>
    					      <strong>Success! </strong>
   						     	Establishment Added Successfully
						</div>
					</center>             	       
                    </c:if> 
                    </div>  
                    <h1 class="page-head-text pull-left"><spring:message code="label.establishment"/></h1>
                    
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i>  <spring:message code="label.addEstablishment"/></button>                    
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
                               <span class="panel-head"><spring:message code="label.establishmentList"/></span>                          
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
    
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                               
                                <th width="10%"><spring:message code="label.establishmentName"/></th>
                                <th width="10%"><spring:message code="label.establishmentOwner"/></th>
                                <th width="10%"><spring:message code="label.geolocation"/></th>
                                <th width="10%"><spring:message code="label.telephone"/></th>
                                <th width="10%"><spring:message code="label.address"/></th>
                                <th width="20%"><spring:message code="label.username"/></th>   
                                 <th width="10%"><spring:message code="label.password"/></th>  
                                 <th width="10%"><spring:message code="label.sector"/></th>
                                <%-- <th width="10%"><spring:message code="label.population"/></th>  --%>
                                 <th width="10%"><spring:message code="label.province"/></th> 
                                 <th width="10%"><spring:message code="label.dischargeDate"/></th>
                                <th width="10%"><spring:message code="label.percentage"/></th>
                                <th width="10%"><spring:message code="label.establishmentsType"/></th>   
                                 <th width="10%"><spring:message code="label.status"/></th> 
                                 <th width="10%"><spring:message code="label.openTime"/></th>
                                 <th width="10%"><spring:message code="label.closeTime"/></th>
                                <th width="10%"><spring:message code="label.loans"/></th>   
                                 <th width="10%"><spring:message code="label.withdrawals"/></th> 
                                 <th width="10%"><spring:message code="label.prepayments"/></th>   
                                 <th width="10%"><spring:message code="label.fund"/></th> 
                                 <%-- <th width="10%"><spring:message code="label.countryName"/></th>  --%>
                                 
                                <th width="10%"><spring:message code="label.edit"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="establishment" items="${establishmentList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${establishment.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${establishment.establishmentName}</td>
                                    <td>${establishment.establishmentOwner}</td>
                                    <td>${establishment.geolocation}</td>
                                    <%-- <td>${establishment.telephone}</td> --%>
                                    <td><c:forEach var="phone" items="${establishment.phones}">${phone.type}:${phone.no},<br></c:forEach></td>
                                    <td>${establishment.address}</td>
                                    <td>${establishment.establishmentUsername}</td>
                                    <td>${establishment.establishmentPassword}</td>
                                    <td>${establishment.sector}</td>
                                    <%-- <td>${establishment.population}</td> --%>
                                     
                                    <td>${establishment.province}</td>
                                    <td>${establishment.dischargeDate}</td>
                                    <td>${establishment.percentage}</td>
                                    <td>${establishment.typesEstablishment.name}</td>
                                    <td>${establishment.statusEstablishment.name}</td>
                                     <td>${establishment.openTime}</td>
                                      <td>${establishment.closeTime}</td>
                                    <td>${establishment.loans}</td>
                                     <td>${establishment.withdrawals}</td>
                                    <td>${establishment.prepayments}</td>
                                     <td>${establishment.fund}</td>
                                  <%-- <td>${establishment.countryName}</td> --%>
                                  
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${establishment.id}','${establishment.establishmentName}','${establishment.establishmentOwner}','${establishment.geolocation}','${establishment.telephone}','${establishment.address}','${establishment.establishmentUsername}','${establishment.establishmentPassword}','${establishment.sector}','${establishment.population}','${establishment.province}','${establishment.dischargeDate}','${establishment.percentage}','${establishment.establishmentsType}','${establishment.status}','${establishment.openTime}','${establishment.closeTime}','${establishment.loans}','${establishment.withdrawals}','${establishment.prepayments}','${establishment.fund}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
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
                <h4 class="modal-title"><center><spring:message code="label.establishmentDetails"/></center></h4>
            </div>
            
            
	
	
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/establishmentList.html" commandName="establishment">
            <div class="modal-body">
                
                      	<input type="hidden" name="action" id="action" value="add">
                    <div class="form-group">
                        <form:label path="establishmentName" class="col-sm-3 control-label"><spring:message code="label.establishmentName"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.establishmentNamePH" var="i18nTooltip"/> 
                       		<form:input type="text" path="establishmentName" id="a" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="50" onblur = "checkUserNameNull()"/>
                       	</div>
                    </div>
                  	
                  	 <div class="form-group">
                        <form:label path="establishmentOwner" class="col-sm-3 control-label"><spring:message code="label.establishmentOwner"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.establishmentOwnerPH" var="i18nTooltip"/> 
                       		<form:input type="text" path="establishmentOwner" id="a" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="50" onblur = "checkUserNameNull()"/>
                       	</div>
                    </div>
                   	</div>
                    <div class="form-group">
                        <form:label path="geolocation" class="col-sm-3 control-label"><spring:message code="label.geolocation"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.geolocationPH" var="i18nTooltip"/>
                            <form:input type="text" path="geolocation" id="c" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="60" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="telephone" class="col-sm-3 control-label"><spring:message code="label.telephone"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.establshment_telephonePH" var="i18nTooltip"/>
                           
                            <INPUT type="button" value="${i18nTooltip}" onclick="addPhone()"/>
                            <br>
                            <span id="fooBar"><br/></span>
                     	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.establishment_addressPH" var="i18nTooltip"/> 
                            <form:input type="text" path="address" id="e" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                     	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="establishmentUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.establishmentUsernamePH" var="i18nTooltip"/> 
                            <form:input type="text" path="establishmentUsername" id="establishmentUsername" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur="uniqueUserName(this.value)"/>
                      	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="establishmentPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.establishmentPasswordPH" var="i18nTooltip"/> 
                            <form:input type="text" path="establishmentPassword" id="g" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="sector" class="col-sm-3 control-label"><spring:message code="label.sector"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.establishment_sectorPH" var="i18nTooltip"/> 
                            <form:input type="text" path="sector" id="h" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                    
                    
                    <div class="form-group">
                        <form:label path="province" class="col-sm-3 control-label"><spring:message code="label.province"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.establishment_provincePH" var="i18nTooltip"/> 
                            <form:input type="text" path="province" id="j" value="" placeholder="${i18nTooltip}" class="form-control"  onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    <div class="form-group">
                        <form:label path="dischargeDate" class="col-sm-3 control-label"><spring:message code="label.dischargeDate"/> &#42;</form:label>
                        <div class="col-sm-8">
                        	<spring:message code="tooltip.dischargeDatePH" var="i18nTooltip"/> 
                            <form:input type="text" path="dischargeDate" id="d" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" />
                     	</div>
                    </div>
                   
                    <div class="form-group">
                        <form:label path="percentage" class="col-sm-3 control-label"><spring:message code="label.percentage"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.percentagePH" var="i18nTooltip"/> 
                            <form:input type="text" path="percentage" id="k" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                    
                    <div class="form-group">
                        <form:label path="establishmentsType" class="col-sm-3 control-label"><spring:message code="label.establishmentsType"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<%-- <spring:message code="tooltip.establishmentsTypePH" var="i18nTooltip"/> 
                            <form:input type="text" path="establishmentsType" id="k" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/> --%>
                            <form:select path="typesEstablishment.id" id="typesEstablishmentId" class="form-control" >
                        		<form:option value="">Select</form:option>
                            	<c:forEach var="type" items="${typeList}">
                               	<form:option value="${type.id}">${type.name}</form:option>
                        		</c:forEach>
                        	</form:select>
                      	</div>
                    </div>
                    
                    
                  
                    
                    <div class="form-group">
                        <form:label path="statusEstablishment" class="col-sm-3 control-label"><spring:message code="label.status"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.statusPH" var="i18nTooltip"/> 
                           <%--  <form:input type="text" path="status" id="k" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('k').value)"/> --%>
                      <%-- 		<form:select path="statusEstablishment" id="k">
		                    		   <option value="open"><spring:message code="label.open"/></option>
									   <option value="close"><spring:message code="label.close"/></option>
		                    	</form:select> --%>
		                    	<form:select path="statusEstablishment.id" id="machineTypeId" class="form-control" >
                        		<form:option value="">Select</form:option>
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
            						<input type="text" name="openingHours" class="form-first-name" placeholder="${i18Tooltip}" maxlength="2" onkeypress="return AllowHours(event);" onblur = "checkUserNameNull()"/>&nbsp;
            					<spring:message code="tooltip.mins" var="i18Tooltip"/>
            						<input type="text" name="openingMins" class="form-last-name" placeholder="${i18Tooltip}" maxlength="2" onkeypress="return AllowMins(event);" onblur = "checkUserNameNull()"/>
        						</td>
    							
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="closeTime" class="col-sm-3 control-label"><spring:message code="label.closeTime"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                           
        						<td>
        						<spring:message code="tooltip.hours" var="i18Tooltip"/>
            						<input type="text" name="closeingHours" class="form-first-name" placeholder="${i18Tooltip}" maxlength="2" onkeypress="return AllowHours(event);" onblur = "checkUserNameNull()"/>&nbsp;
            					<spring:message code="tooltip.mins" var="i18Tooltip"/>
            						<input type="text" name="closeingMins" class="form-last-name" placeholder="${i18Tooltip}" maxlength="2" onkeypress="return AllowMins(event);" onblur = "checkUserNameNull()"/>
        						</td>

                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="loans" class="col-sm-3 control-label"><spring:message code="label.loans"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.loansPH" var="i18nTooltip"/> 
                            <form:input type="text" path="loans" id="k" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="withdrawals" class="col-sm-3 control-label"><spring:message code="label.withdrawals"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.withdrawalsPH" var="i18nTooltip"/> 
                            <form:input type="text" path="withdrawals" id="k" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="prepayments" class="col-sm-3 control-label"><spring:message code="label.prepayments"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		<spring:message code="tooltip.prepaymentsPH" var="i18nTooltip"/> 
                            <form:input type="text" path="prepayments" id="k" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                    
                    <div class="form-group">
                        <form:label path="fund" class="col-sm-3 control-label"><spring:message code="label.fund"/> &#42;</form:label>
                     	<div class="col-sm-8">	
                     		<spring:message code="tooltip.fundPH" var="i18nTooltip"/> 
                            <form:input type="text" path="fund" id="k" value="" placeholder="${i18nTooltip}" class="form-control" maxlength="20" onblur = "checkUserNameNull()"/>
                      	</div>
                    </div>
                    
                   
                    
                    <%-- <div class="form-group">
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
				   
            
            
        
           			<input type="hidden" name="action" value="add" />
           			 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><spring:message code="label.cancel"/></button>
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
        <h4 class="modal-title"><spring:message code="label.editEstablishment"/> </h4>
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/establishmentList.html" commandName="establishment">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>
                    <div class="form-group">
                        <form:label path="establishmentName" class="col-sm-3 control-label"><spring:message code="label.establishmentName"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		
                       		<form:input type="text" path="establishmentName" id="establishmentName" value=""  class="form-control" maxlength="100" />
                       	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="establishmentOwner" class="col-sm-3 control-label"><spring:message code="label.establishmentOwner"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		
                       		<form:input type="text" path="establishmentOwner" id="establishmentOwner" value=""  class="form-control" maxlength="100" />
                       	</div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="geolocation" class="col-sm-3 control-label"><spring:message code="label.geolocation"/> &#42;</form:label>
                        <div class="col-sm-8">
                             
                            <form:input type="text" path="geolocation" id="geolocation" value=""  class="form-control" maxlength="100" />
                      	</div>
                   	</div>
                    <div class="form-group">
                        <form:label path="telephone" class="col-sm-3 control-label"><spring:message code="label.telephone"/> &#42;</form:label>
                        <div class="col-sm-8">
                            
                            <form:input type="text" path="telephone" id="telephone" value=""  class="form-control" maxlength="60" />
                      	</div> 
                      	</div>              
                     <div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label"><spring:message code="label.address"/> &#42;</form:label>
                        <div class="col-sm-8">
                            
                            <form:input type="text" path="address" id="address" value=""  class="form-control" maxlength="100" onblur = "useHTML(this.id,document.getElementById('location').value)"/>
                     	</div>
                    </div>
                    </div>
                    <div class="form-group">
                        <form:label path="establishmentUsername" class="col-sm-3 control-label"><spring:message code="label.username"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="establishmentUsername" id="username" value=""  class="form-control" maxlength="100" />
                      	</div>
                    </div>
                     <div class="form-group">
                        <form:label path="establishmentPassword" class="col-sm-3 control-label"><spring:message code="label.password"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="establishmentPassword" id="password" value=""  class="form-control" maxlength="100" />
                      	</div>
                    </div>                   
                    <div class="form-group">
                        <form:label path="sector" class="col-sm-3 control-label"><spring:message code="label.sector"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="sector" id="sector" value=""  class="form-control" maxlength="100" />
                      	</div>s
                    </div>
                    
                     <%-- <div class="form-group">
                        <form:label path="population" class="col-sm-3 control-label"><spring:message code="label.population"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="population" id="population" value=""  class="form-control" maxlength="100" />
                      	</div>
                    </div> --%>
                    
                    <div class="form-group">
                        <form:label path="province" class="col-sm-3 control-label"><spring:message code="label.province"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="province" id="province" value=""  class="form-control"  />
                      	</div>
                    </div>                 
                     <div class="form-group">
                        <form:label path="dischargeDate" class="col-sm-3 control-label"><spring:message code="label.dischargeDate"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="dischargeDate" id="dischargeDate" value=""  class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="percentage" class="col-sm-3 control-label"><spring:message code="label.percentage"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="percentage" id="percentage" value="" class="form-control" maxlength="20" />
                      	</div>
                    </div> 
                    
                     <div class="form-group">
                        <form:label path="establishmentsType" class="col-sm-3 control-label"><spring:message code="label.establishmentsType"/> &#42;</form:label>
                     	<div class="col-sm-8">
                     		
                            <form:input type="text" path="establishmentsType" id="establishmentsType" value=""  class="form-control" maxlength="100" />
                      	</div>
                    </div>  
                    
                     <div class="form-group">
                        <form:label path="status" class="col-sm-3 control-label"><spring:message code="label.status"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <%-- <form:input type="text" path="status" id="status" value=""  class="form-control" maxlength="20" /> --%>
                            <form:select path="status" id="status">
		                    		   <option value="open"><spring:message code="label.open"/></option>
									   <option value="close"><spring:message code="label.close"/></option>
		                    	</form:select>
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="openTime" class="col-sm-3 control-label"><spring:message code="label.openTime"/> &#42;</form:label>
                     	<div class="col-sm-8">
                                
        						<td>
        						<spring:message code="tooltip.hours" var="i18Tooltip"/>
            						<input type="text" name="openingHourss" class="form-first-name" placeholder="${i18Tooltip}" maxlength="2" onkeypress="return AllowHours(event);"/>&nbsp;
            					<spring:message code="tooltip.mins" var="i18Tooltip"/>
            						<input type="text" name="openingMinss" class="form-last-name" placeholder="${i18Tooltip}" maxlength="2" onkeypress="return AllowMins(event);"/>
        						</td>
    							
                      	</div>
                    </div>
                    
                     <div class="form-group">
                        <form:label path="closeTime" class="col-sm-3 control-label"><spring:message code="label.closeTime"/> &#42;</form:label>
                     	<div class="col-sm-8">
                           
        						<td>
        						<spring:message code="tooltip.hours" var="i18Tooltip"/>
            						<input type="text" name="closeingHourss" class="form-first-name" placeholder="${i18Tooltip}" maxlength="2" onkeypress="return AllowHours(event);"/>&nbsp;
            					<spring:message code="tooltip.mins" var="i18Tooltip"/>
            						<input type="text" name="closeingMinss" class="form-last-name" placeholder="${i18Tooltip}" maxlength="2" onkeypress="return AllowMins(event);"/>
        						</td>

                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="loans" class="col-sm-3 control-label"><spring:message code="label.loans"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="loans" id="loans" value=""  class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="withdrawals" class="col-sm-3 control-label"><spring:message code="label.withdrawals"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="withdrawals" id="withdrawals" value=""  class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                      <div class="form-group">
                        <form:label path="prepayments" class="col-sm-3 control-label"><spring:message code="label.prepayments"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="prepayments" id="prepayments" value=""  class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="fund" class="col-sm-3 control-label"><spring:message code="label.fund"/> &#42;</form:label>
                     	<div class="col-sm-8">
                            
                            <form:input type="text" path="fund" id="fund" value=""  class="form-control" maxlength="20" />
                      	</div>
                    </div>
                    
                  
                   
           			<input type="hidden" name="action" value="edit" />
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
	   
	   