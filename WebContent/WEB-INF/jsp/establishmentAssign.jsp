<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script
	src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script
	src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
<script>
function checkform() {
    if(document.frm.operatorID.value == "") {
        alert("please select operator Id");
        return false;
    } else{
        document.frm.submit();
    }
}
</script>

</head>
<body>
	<div class="form-horizontal">
		<span class="panel-head"><spring:message
				code="label.establishmentassignmentMsg" /></span>
		<div class="panel-body">
			<div class="table-responsive">
				<table id="example"
					class="table table-bordered table-striped table-hover">
					<thead>
						<tr>

							<th width="20%"><spring:message code="label.operator" /></th>
							<th width="20%"><spring:message code="label.establishment" /></th>
							<th width="20%"><spring:message code="label.assigned" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<form id="frm" class="form-horizontal" method="POST" name="frm"
								action="${pageContext.request.contextPath}/admin/establshmentExpense.html">
								
								<td><select name="operatorId" id="operatorId"
									class="form-control">
										<option selected disabled hidden style='display: none'
											value=''></option>
										<option value=""></option>
										<c:forEach var="operator" items="${operatorList}">
											<option value="${operator.id}">${operator.name}</option>
										</c:forEach>
								</select></td>
								<td>
								<input type="hidden" id="establishmentId" name="establishmentId" value="${esta.id}"></input>
								<label>${esta.establishmentName}</label>
								</td>
								<td>
									<button type="submit" class="btn btn-default btn-sm"
										onclick="checkform();">
										<spring:message code="label.assigned" />
									</button>
								</td>
							</form>
						</tr>

					</tbody>
				</table>



			</div>
		</div>



	</div>
</body>
</html>