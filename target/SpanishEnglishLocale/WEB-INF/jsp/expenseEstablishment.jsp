<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<script
	src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script
	src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<script type="text/javascript">
	function AllowNumber(e) {
		isIE = document.all ? 1 : 0
		keyEntry = !isIE ? e.which : e.keyCode;
		if (keyEntry == '48' || keyEntry == '49' || keyEntry == '50'
				|| keyEntry == '51' || keyEntry == '52' || keyEntry == '53'
				|| keyEntry == '54' || keyEntry == '55' || keyEntry == '56'
				|| keyEntry == '57')
			return true;
		else {
			alert('Please Enter Only numbers .');
			return false;
		}
	}

	function buttonActive() {

		document.getElementById("submitButton").disabled = false;
	}

	function checkTotal() {
		/* var a1 = $("#agreedPercentageAdmin").val();
		var a2 = $("#agreedPercentageOperator").val();
		var a3 = $("#agreedPercentageEstablishment").val();
		
		var b1 = $("#playersGiftAdmin").val();
		var b2 = $("#playersGiftOperator").val();
		var b3 = $("#playersGiftEstablishment").val(); */

		var c1 = $("#otherExpensesAdmin").val();
		var c2 = $("#otherExpensesOperator").val();
		var c3 = $("#otherExpensesEstablishment").val();

		/* var a11 = parseInt(a1);
		var a22 = parseInt(a2);
		var a33 = parseInt(a3);
		var b11 = parseInt(b1);
		var b22 = parseInt(b2);
		var b33 = parseInt(b3); */
		var c11 = parseInt(c1);
		var c22 = parseInt(c2);
		var c33 = parseInt(c3);

		if ((c11 + c22 + c33 != 100)) {
			alert("not equal to 100")
			document.getElementById("submitButton").disabled = true;
			return false;
		} else {

			document.getElementById("submitButton").disabled = false;
			return true;
		}

	}

	$(document).ready(function() {
		$('#frm').submit(function() {

		});
	});
</script>
</head>
<body>
	<div class="form-horizontal">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">

						<form
							action="${pageContext.request.contextPath}/admin/assignestablishmentExpense.html"
							method="post" name="frm" id="frm">
							<div class="modal-body">
								<div class="form-group">



									<c:if test="${not empty op}">
										<input type="hidden" id="operatorID" name="operatorID"
											value="${op.id}">
									</c:if>
									<c:if test="${ empty op}">
										<input type="hidden" id="operatorID" name="operatorID"
											value="0">
									</c:if>

									<c:if test="${not empty est}">
										<input type="hidden" id="establishmentID"
											name="establishmentID" value="${est.id}">
									</c:if>
									<c:if test="${ empty est}">
										<input type="hidden" id="establishmentID"
											name="establishmentID" value="0">
									</c:if>
								</div>


								<table>
									<caption>
										<spring:message code="label.expenseDistributionMsg"></spring:message>
										:
									</caption>
									<tr>
										<td></td>
										<th scope="col"><spring:message code="label.admin" /> :
											${admin.adminUsername}</th>
										<c:if test="${not empty op}">
											<th scope="col"><spring:message code="label.operator" />
												: ${op.name}</th>
										</c:if>
										<c:if test="${empty op}">
											<th scope="col"><spring:message code="label.operator" />
												: Not Present</th>
										</c:if>
										<c:if test="${not empty est}">
											<th scope="col"><spring:message
													code="label.establishment" /> : ${est.establishmentName}</th>
										</c:if>
										<c:if test="${ empty est}">
											<th scope="col"><spring:message
													code="label.establishment" /> : Not Present</th>
										</c:if>
									</tr>

									<tr>
										<th scope="row"><spring:message code="label.oe" /></th>
										<td><input type="text" id="otherExpensesAdmin"
											name="otherExpensesAdmin" class="form-control" value=""
											onkeypress="buttonActive();return AllowNumber(event);"></td>
										<td><input type="text" id="otherExpensesOperator"
											name="otherExpensesOperator" class="form-control" value=""
											onkeypress="buttonActive();return AllowNumber(event);"></td>
										<td><input type="text" id="otherExpensesEstablishment"
											name="otherExpensesEstablishment" class="form-control"
											value=""
											onkeypress="buttonActive();return AllowNumber(event);"></td>

									</tr>


								</table>





								<div class="form-group">

									<label class="col-sm-3 control-label">
										<button type="submit" name="submitButton" id="submitButton"
											class="btn btn-primary" onclick="checkTotal()">

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