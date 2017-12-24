<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

</head>
<body>

<form action="${pageContext.request.contextPath}/admin/countryBillValueConfig.html" method="post">
		<input type="hidden" value="${billValue.id}" id="billValueID" name="billValueID">
		<input type="hidden" value="${btid}" id="billTypeID" name="billTypeID">
       <div class="form-group">
       <label name="machineNumber" class="col-sm-3 control-label"><spring:message code="label.billValues"/> ${billValue.value} &#42;</label>
       			<div class="col-sm-8">
	       <c:forEach var="country" items="${countryList}">
	       		  <input type="hidden"  value="${country.id}" id="countryValuesID" name="countryValuesID" class="form-control"/>${country.country}  (in ${country.currency} )
	       		  <input type="text"  value="" id="countryValues" name="countryValues" class="form-control"/>
	       		  
	       </c:forEach>
	       <button type="submit" name="submitButton" class="btn btn-primary"><spring:message code="label.next"/></button>
	       </div>
	      </div>
	   </form>
	    
</body>
</html>