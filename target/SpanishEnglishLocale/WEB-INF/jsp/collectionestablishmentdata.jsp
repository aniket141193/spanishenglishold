<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>




</head>
<body>
<div class="form-horizontal">
<div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                	
                	<form action="${pageContext.request.contextPath}/operator/collectionfinal.html" method="post">
							
							
							<div class="modal-body">
								
									 <input type="hidden" id="machineID" name="machineID" value="${machineID}">
									 <input type="hidden" id="machineID" name="machineCollectionID" value="${machineCollectionId}">
								
								<div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="label.enterPaymentKey" /></label>
										<div class="col-sm-4">
										<input type="text" id="paymentKey" name="paymentKey" class="form-control" value="">
											
										</div>	
								</div>
								
								<div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="label.enterPlayerGift" /></label>
										<div class="col-sm-4">
										<input type="text" id="playerGift" name="playerGift" class="form-control" value="">
										</div>
								</div>
								
								<div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="label.enterOtherExpenses" /></label>
										<div class="col-sm-4">
										<input type="text" id="otherExpenses" name="otherExpenses" class="form-control" value="">
										</div>
								</div>
								
								<div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="label.enterFails" /></label>
										<div class="col-sm-4">
										<input type="text" id="fails" name="fails" class="form-control" value="">
										</div>
								</div>
								


								<div class="form-group">

									<label class="col-sm-3 control-label">
										<button type="submit" name="submitButton"
											class="btn btn-primary">

											<spring:message code="label.save" />
										</button>
									</label>
								</div>

							</div>
						</form>
                
                </div>
             </div>
          </div>
      </div>
</div>

</body>
</html>