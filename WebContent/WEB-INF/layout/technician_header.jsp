<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<ul class="nav navbar-nav">
	<li id="homeActive" ><a href="${pageContext.request.contextPath}/technician/home"><spring:message code="label.home"/></a></li> 
	<li id="reportActive" ><a href="${pageContext.request.contextPath}/technician/machine.html"><spring:message code="label.machine"/></a></li>
	<li id="reportActive" ><a href="${pageContext.request.contextPath}/technician/repairs.html"><spring:message code="label.repair"/></a></li>
	<li id="settingActive" ><a href="${pageContext.request.contextPath}/technician/settings"><spring:message code="label.setting"/></a></li>
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