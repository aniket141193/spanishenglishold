<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>


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
	


</script>

<script type="text/javascript">



$('.dropdown-menu a').on('click', function(){    
    $('.dropdown-toggle').html($(this).html() + '<span class="caret"></span>');    
});







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
                    
                </div>                                    
            </div>
        </div>
       
    </div>
    
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                
				   
				   
				   <form action="${pageContext.request.contextPath}/admin/billsValueInfo.html" method="post">
				   <input type="hidden" name="action" id="action" value="addBillValue">
				   <input type="hidden" name="btid" id="btid" value="${btid}">
				   		<div class="form-group">
                        	<label  class="col-sm-3 control-label"><spring:message code="label.whatAcceptBills"/> &#42;</label>
                        	
                      		<div class="col-sm-8">
		                    	<select name="billValueType" id="billValueType" multiple = "true">
		                    		  <option value="100">100</option>
									   <option value="200">200</option>
									     <option value="300">300</option>
									   <option value="400">400</option>
									  <option value="500">500</option>
									   <option value="600">600</option>
									  <option value="800">800</option>
									   <option value="1000">1000</option>
									
		                    	</select>
                    		</div>
                   		</div>
                   		<button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.next"/></button>
				   </form>
				
				
				
				
				
                                     
                                     
                                     
                                                         
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                   
                </div>                                    
            </div>
        </div>
    </div>

</div>




