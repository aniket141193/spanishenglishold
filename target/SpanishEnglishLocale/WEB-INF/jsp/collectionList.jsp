<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>


 
<script type="text/javascript">




 
 </script>
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
 
 function addCollection(){
	 var machineID = $("#machineID").val();
	 window.location.href = "addCollection.html?machineID="+machineID;	
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





function editSchool(id,date,period,theoreticalCollection,manualCollection,diffrence,differenceInPercentage,currency,profitMarginInPercenatge){
	
	$("#Idd").val(id);
	$("#datee").val(date);
	$("#periodd").val(period);
	
	$("#theoreticalCollectionn").val(theoreticalCollection);
	$("#manualCollectionn").val(manualCollection);
	$("#diffrencee").val(diffrence);
	
	$("#differenceInPercentagee").val(differenceInPercentage);
	$("#currencyy").val(currency);
	$("#profitMarginInPercenatgee").val(profitMarginInPercenatge);
	
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
                    <h1 class="page-head-text pull-left">Collection</h1>
                    
                    <!-- <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#schoolAdd"><i class="fa fa-plus-circle"></i> Add Collection</button> -->                    
                    <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="addCollection()" ><i class="fa fa-plus-circle"></i> <spring:message code="label.addCollection"/></button>
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
                        <span class="panel-head"><spring:message code="label.collectionList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
                            
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                                
                                <th width="10%"><spring:message code="label.collectionDate"/></th>
                                <th width="10%"><spring:message code="label.collectionPeriod"/></th>
                                <th width="10%"><spring:message code="label.collectionTheoretical"/></th>
                                <th width="10%"><spring:message code="label.collectionManual"/></th>
                                <th width="10%"><spring:message code="label.collectionDifference"/></th>
                                <th width="10%"><spring:message code="label.collectionDifferenceInPercentage"/></th>
                                <th width="10%"><spring:message code="label.collectionCurrency"/></th>
                                <!-- <th width="10%">Profit Margin</th> -->
                                <th width="10%"><spring:message code="label.collectionProfitInPercentage"/></th>
                                                               
                                <th width="10%"><spring:message code="label.edit"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="collection" items="${collectionList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${collection.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${collection.date}</td>
                                    <td>${collection.period}</td>
                                    <td>${collection.theoreticalCollection}</td>
                                    <td>${collection.manualCollection}</td>
                                    <td>${collection.diffrence}</td>
                                    <td>${collection.differenceInPercentage}</td>
                                    <td>${collection.currency}</td>
                                    <td>${collection.profitMarginInPercenatge}</td>
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="editSchool('${collection.id}','${collection.date}','${collection.period}','${collection.theoreticalCollection}','${collection.manualCollection}','${collection.diffrence}','${collection.differenceInPercentage}','${collection.currency}','${collection.profitMarginInPercenatge}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.edit"/></button></td>
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
                <h4 class="modal-title"><center><spring:message code="label.collectionDetails"/></center></h4>
            </div>
            
             <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/operator/collection.html" commandName="collection">
            <div class="modal-body">
                
                     <input type="hidden" name="action" id="action" value="add">
                     <input type="hidden" name="machineID" id="machineID" value="${machineID}"> 
                     
                    <div class="form-group">
                        <form:label path="date" class="col-sm-3 control-label"><spring:message code="label.collectionDate"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="date" id="date" name="date" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="period" class="col-sm-3 control-label"><spring:message code="label.collectionPeriod"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="period" id="period" name="period" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                   	<div class="form-group">
                        <form:label path="theoreticalCollection" class="col-sm-3 control-label"><spring:message code="label.collectionTheoretical"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="theoreticalCollection" id="theoreticalCollection" name="theoreticalCollection" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                   	
                   	 <div class="form-group">
                        <form:label path="manualCollection" class="col-sm-3 control-label"><spring:message code="label.collectionManual"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="manualCollection" id="manualCollection" name="manualCollection" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="diffrence" class="col-sm-3 control-label"><spring:message code="label.collectionDifference"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="diffrence" id="diffrence" name="diffrence" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                   	<div class="form-group">
                        <form:label path="differenceInPercentage" class="col-sm-3 control-label"><spring:message code="label.collectionDifferenceInPercentage"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="differenceInPercentage" id="differenceInPercentage" name="differenceInPercentage" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                   	
                   	 <div class="form-group">
                        <form:label path="currency" class="col-sm-3 control-label"><spring:message code="label.collectionCurrency"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="currency" id="currency" name="currency" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	<%-- <div class="form-group">
                        <form:label path="profitMargin" class="col-sm-3 control-label">Profit Margin &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="profitMargin" id="profitMargin" name="profitMargin" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div> --%>
                   	<div class="form-group">
                        <form:label path="profitMarginInPercenatge" class="col-sm-3 control-label"><spring:message code="label.collectionProfitInPercentage"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="profitMarginInPercenatge" id="profitMarginInPercenatge" name="profitMarginInPercenatge" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
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
        <h4 class="modal-title"><spring:message code="label.collectionEdit"/> </h4>
      </div>
	   
	        <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/operator/collection.html" commandName="collection">
            <div class="modal-body">
                
                     
                     <form:input type="hidden" path="id" id="Idd"  />
                     <input type="hidden" name="action" id="action" value="edit"/>
                     <input type="hidden" name="machineID" id="machineID" value="${machineID}"> 
                    
                            <div class="form-group">
                        <form:label path="date" class="col-sm-3 control-label"> <spring:message code="label.collectionDate"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="date" id="datee" name="datee" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="period" class="col-sm-3 control-label"><spring:message code="label.collectionPeriod"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="period" id="periodd" name="periodd" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                   	<div class="form-group">
                        <form:label path="theoreticalCollection" class="col-sm-3 control-label"><spring:message code="label.collectionTheoretical"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="theoreticalCollection" id="theoreticalCollectionn" name="theoreticalCollectionn" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                   	
                   	 <div class="form-group">
                        <form:label path="manualCollection" class="col-sm-3 control-label"><spring:message code="label.collectionManual"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="manualCollection" id="manualCollectionn" name="manualCollectionn" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	<div class="form-group">
                        <form:label path="diffrence" class="col-sm-3 control-label"><spring:message code="label.collectionDifference"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="diffrence" id="diffrencee" name="diffrencee" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                   	<div class="form-group">
                        <form:label path="differenceInPercentage" class="col-sm-3 control-label"><spring:message code="label.collectionDifferenceInPercentage"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="differenceInPercentage" id="differenceInPercentagee" name="differenceInPercentagee" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div>
                   	
                   	 <div class="form-group">
                        <form:label path="currency" class="col-sm-3 control-label"><spring:message code="label.collectionCurrency"/> &#42;</form:label>
                        <div class="col-sm-8">
                       		<form:input type="text" path="currency" id="currencyy" name="currencyy" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('a').value)"/>
                       	</div>
                    </div>
                  	<%-- <div class="form-group">
                        <form:label path="profitMargin" class="col-sm-3 control-label">Profit Margin &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="profitMargin" id="profitMarginn" name="profitMarginn" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
                      	</div>
                   	</div> --%>
                   	<div class="form-group">
                        <form:label path="profitMarginInPercenatge" class="col-sm-3 control-label"><spring:message code="label.collectionProfitInPercentage"/> &#42;</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="profitMarginInPercenatge" id="profitMarginInPercenatgee" name="profitMarginInPercenatgee" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('b').value)"/>
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
