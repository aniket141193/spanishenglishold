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
	function addCoins(id) {

		//Create an input type dynamically.
		var element = document.createElement("input");

		//Assign different attributes to the element.
		element.setAttribute("type", "text");
		element.setAttribute("value", "");
		element.setAttribute("name", id);
		element.setAttribute("id",id);
		element.setAttribute("class","form-control");
		element.setAttribute('onkeypress','return AllowNumber(event);');
		element.setAttribute('maxlength','10');
		
		var foo = document.getElementById("fooBar");

		foo.appendChild(element);
	}

	</script>
</head>
<body>
	<div class="form-horizontal">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">

						<div class="panel-name">
                        <span class="panel-head"><spring:message code="label.machineCollection"/></span>
                    </div>                                        
						<form
							action="${pageContext.request.contextPath}/operator/machinecollectionestablishment.html"
							method="post">
							<div class="modal-body">
								
									 <input type="hidden" id="machineID" name="machineID" value="${machineID}">
									 <input type="hidden" id="machineCollectionID" name="machineCollectionID" value="${machineCollectionId}">
									 
								
								 <div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="label.coin" />  </label>
								<c:forEach var="coin" items="${coins}">
								<div class="col-sm-4">
									<label class="col-sm-3 control-label"><spring:message code="label.name" /> : ${coin.name}</label>
									<label class="col-sm-3 control-label"><spring:message code="label.value" /> : ${coin.value}</label>
									
									<input type="hidden" id="coinId" name="coinId" class="form-control" value="${coin.id}">
									<label class="col-sm-3 control-label"><spring:message code="label.noOfCoin" /></label>
									<input type="text" id="coinNo" name="coinNo" class="form-control" value="">
								</div>
								</c:forEach>
								</div>
								<br>
								
								 <div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="label.token" /></label>
								<c:forEach var="token" items="${tokens}">
								<div class="col-sm-4">
									<label class="col-sm-3 control-label"><spring:message code="label.name" /> : ${token.name}</label>
									<label class="col-sm-3 control-label"><spring:message code="label.value" /> : ${token.value}</label>
									
									<input type="hidden" id="tokenId" name="tokenId" class="form-control" value="${token.id}">
									<label class="col-sm-3 control-label"><spring:message code="label.noOfToken" /></label>
									<input type="text" id="tokenNo" name="tokenNo" class="form-control" value="">
								</div>
								</c:forEach>	
								</div>
								<br>
								
								 <div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="label.note" /></label>
								<c:forEach var="note" items="${notes}">
									
								<div class="col-sm-4">
									 
									<label class="col-sm-3 control-label"><spring:message code="label.name" /> : ${note.name}</label>
									<label class="col-sm-3 control-label"><spring:message code="label.value" /> : ${note.value}</label>
									
									<input type="hidden" id="noteId" name="noteId" class="form-control" value="${note.id}">
									<label class="col-sm-3 control-label"><spring:message code="label.noOfNote" /></label>
									<input type="text" id="noteNo" name="noteNo" class="form-control" value="">
								</div>
								
								</c:forEach>							
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