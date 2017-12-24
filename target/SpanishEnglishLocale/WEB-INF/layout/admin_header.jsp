<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<ul class="nav navbar-nav">
	<li id="homeActive" ><a href="${pageContext.request.contextPath}/admin/home.html"><spring:message code="label.home"/></a></li>
	<li id="schoolsActive" ><a href="${pageContext.request.contextPath}/admin/operators.html"><spring:message code="label.operator"/></a></li>
 	<li id="schoolAdminActive" ><a href="${pageContext.request.contextPath}/admin/establishment.html"><spring:message code="label.establishment"/></a></li> 
	<li id="reportActive" ><a href="${pageContext.request.contextPath}/admin/machine.html"><spring:message code="label.machine"/></a></li>
	<li id="settingActive" ><a href="${pageContext.request.contextPath}/admin/country.html"><spring:message code="label.country"/></a></li>
	<li id="settingActive" ><a href="${pageContext.request.contextPath}/admin/machineType.html"><spring:message code="label.machineType"/></a></li>
	<li id="settingActive" ><a href="${pageContext.request.contextPath}/admin/paymentDevices.html"><spring:message code="label.paymentDevices"/></a></li>
	 <li id="settingActive" ><a href="${pageContext.request.contextPath}/admin/users.html"><spring:message code="label.users"/></a></li>
	 <li id="schoolAdminActive" ><a href="${pageContext.request.contextPath}/admin/settings.html"><spring:message code="label.settings"/></a></li> 
	<%-- <li id="settingActive" ><a href="${pageContext.request.contextPath}/admin/coinValidatorType.html"><spring:message code="label.cvType"/></a></li>
	<li id="settingActive" ><a href="${pageContext.request.contextPath}/admin/billValidatorType.html"><spring:message code="label.bvType"/></a></li> --%>
</ul>


<script>
$(function(){
	if("${homeActive}" == 'homeActive'){
		$("#homeActive").addClass("active");
	}else if("${schoolsActive}" == 'schoolsActive'){
		$("#schoolsActive").addClass("active");
	}else if(("${schoolAdminActive}" == 'schoolAdminActive')){
		$("#schoolAdminActive").addClass("active");
	}else if(("${reportActive}" == 'reportActive')){
		$("#reportActive").addClass("active");
	}else if(("${settingActive}" == 'settingActive')){
		$("#settingActive").addClass("active");
	}
	
})
</script>