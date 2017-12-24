<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script
	src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
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
</script>
</head>
<body>
	<div class="form-horizontal">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">

						<form
							action="${pageContext.request.contextPath}/admin/assignFunds.html"
							method="post">
							<div class="modal-body">
								<div class="form-group">
									
									<label class="col-sm-3 control-label"><spring:message code="label.addFundInMachine" />(In ${currency} )</label>
									<input type="hidden" id="currency" name="currency"
										value="${currency}"> <input type="hidden"
										id="machineID" name="machineID" value="${machineID}">
									<input type="hidden" id="adminID" name="adminID"
										value="${adminID}">
										<input type="hidden" id="operatorID" name="operatorID"
										value="${operatorID}">
										<input type="hidden" id="establishmentID" name="establishmentID"
										value="${establishmentID}">
										
									<!-- <div class="col-sm-4">
										<input type="text" id="money" name="money"
											class="form-control" value="">
									</div> -->
								</div>
								
								<div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="label.machineFund" /></label>
										<div class="col-sm-4">
										<input type="text" id="machineFund" name="machineFund" class="form-control" value="" onkeypress = "return AllowNumber(event);">
											
										</div>	
								</div>
								
								<div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="label.establishmentFund" /></label>
										<div class="col-sm-4">
										<input type="text" id="establishmentFund" name="establishmentFund" class="form-control" value="" onkeypress = "return AllowNumber(event);">
										</div>
								</div>
								

								<%-- <div class="form-group">

									<label class="col-sm-3 control-label"><spring:message
											code="label.percentageOperator" /></label>
									<div class="col-sm-4">
										<input type="text" id="percentage" name="percentage"
											class="form-control" value="">
									</div>
								</div> --%>

								<div class="form-group">

									<c:if test="${machineControl eq 'yes'}">
										<label class="col-sm-3 control-label"><spring:message
												code="label.SIMnumber" /></label>
										<div class="col-sm-4">
											<input type="text" id="simNumber" name="simNumber"
												class="form-control" value="" onkeypress = "return AllowNumber(event);">
										</div>
									</c:if>
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