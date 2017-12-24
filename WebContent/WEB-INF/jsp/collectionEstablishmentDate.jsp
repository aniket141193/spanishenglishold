<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>


  <script>
  $( function() {
    $( "#startDate" ).datepicker();
  } );
  $( function() {
	    $( "#endDate" ).datepicker();
	  } );
  
  
  </script>

  
  <div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                <form action="${pageContext.request.contextPath}/operator/machinecollection.html" method="post">
                    
                        	<input type="hidden" name="establishmentId" id="establishmentId" value="${establishmentId}" class="form-control" maxlength="50" >
                    
                   <%--  <div class="form-group">
                        <label class="col-sm-3 control-label"><spring:message code="label.startDateCollection"/> &#42;</label>
                    
	                    <div class="col-sm-8">
	                    	<input type="text" name="startDate" id="startDate" value="" class="form-control" maxlength="50" >
	                    </div>
                    </div> --%>
                    	
                   <div class="form-group">
                        <label class="col-sm-3 control-label"><spring:message code="label.endDateCollection"/> &#42;</label> 	
                    <div class="col-sm-8">
                    	<input type="text" name="endDate" id="endDate" value="" class="form-control" maxlength="50" >
                   </div>
                   </div>
                   
                   <div class="form-group">

									<label class="col-sm-3 control-label">
										<button type="submit" name="submitButton"
											class="btn btn-primary">

											<spring:message code="label.next" />
										</button>
									</label>
								</div>
                  </form>
                </div>                                    
            </div>
        </div>
  
    </div>
  
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
               
              
                                               
            </div>
        </div>
    </div>
   
</div>
  