<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<script type="text/javascript">
function unlockedMachine(){
	
	
	/* $('#unlockMachine').css({
        'display': 'block'
    }); */
	
	var inputKey =  $("#inputKey").val();
	var machineID =  $("#machineID").val();
	
	
	
	
	window.location.href  = "generateOutputKey.html?machineId="+machineID+"&inputKey="+inputKey;
	
	
	//
}
</script>

</head>
<body>
	<div class="form-horizontal">
		<span class="panel-head"><spring:message code="label.unlockMachineMsg" />
		</span>
				
		<div class="panel-body">
			<div class="table-responsive">
				<table id="example"
					class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th width="20%"><spring:message code="label.machine" /></th>
							<th width="20%"><spring:message code="label.inputKey" /></th>
							<th width="20%"><spring:message code="label.submit" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<form >
								<td><input type="hidden" name="action" id="action"
									value="unlockMachine"> <select name="machineID"
									id="machineID" class="form-control">
										<option selected disabled hidden style='display: none'
											value=''></option>
										<c:forEach var="machine" items="${machineList}">
											<option value="${machine.id}">${machine.nickName}</option>
										</c:forEach>
								</select></td>
								<td>
								
								<input type="text" name="inputKey" id="inputKey" value="" class="form-control" maxlength="50" />
								</td>
								
								<td>
									<button type="button" class="btn btn-default btn-sm"
										onclick="unlockedMachine();">
										<spring:message code="label.generateOutputKey" />
									</button>
								</td>
								
							</form>
						</tr>

					</tbody>
				</table>
			</div>
			<div id="unlockMachine" style="display:none">
			   <label><spring:message code="label.outputKey" />: </label>
			   <span id="showOutputKey"></span>
			   <br>
			   <label><spring:message code="label.outputKeyMsg" />: </label>
			   <c:if test="${not empty machine}">
			   <input type="text" name="outputLockKey" id="outputLockKey" value="${machine.outputLockKey}" class="form-control" maxlength="50" style="width: 33%;"/>
			   </c:if>
			   <br>
			   <button type="button" class="btn btn-default btn-sm"
										onclick="unlockedMachine();">
										<spring:message code="label.submit" />
									</button>
			</div>
		</div>




	</div>
</body>
</html>