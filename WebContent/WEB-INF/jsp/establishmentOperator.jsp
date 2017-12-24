<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
  

<style>
{
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}
.form-address-1 {
	width: 100%;
}

.form-first-name, .form-last-name {
	width: 46%;
}

.form-last-name {
	float: right;
}
</style>
<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                	<div class="panel-name">
                    </div>  
                    <h1 class="page-head-text pull-left"><spring:message code="label.establishment"/></h1>
                </div>                                    
            </div>
        </div>
    </div>
   
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                               <span class="panel-head"><spring:message code="label.establishmentList"/></span>                          
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                                <th width="10%"><spring:message code="label.establishmentName"/></th>
                                <th width="10%"><spring:message code="label.establishmentOwner"/></th>
                                <th width="10%"><spring:message code="label.geolocation"/></th>
                                <th width="10%"><spring:message code="label.telephone"/></th>
                                <th width="10%"><spring:message code="label.address"/></th>
                                <th width="20%"><spring:message code="label.username"/></th>   
                                 <th width="10%"><spring:message code="label.password"/></th>  
                                 <th width="10%"><spring:message code="label.sector"/></th>
                                 <th width="10%"><spring:message code="label.province"/></th> 
                                 <th width="10%"><spring:message code="label.dischargeDate"/></th>
                                <th width="10%"><spring:message code="label.percentage"/></th>
                                <th width="10%"><spring:message code="label.establishmentsType"/></th>   
                                 <th width="10%"><spring:message code="label.status"/></th> 
                                 <th width="10%"><spring:message code="label.openTime"/></th>
                                 <th width="10%"><spring:message code="label.closeTime"/></th>
                                <th width="10%"><spring:message code="label.loans"/></th>   
                                 <th width="10%"><spring:message code="label.withdrawals"/></th> 
                                 <th width="10%"><spring:message code="label.prepayments"/></th>   
                                 <th width="10%"><spring:message code="label.fund"/></th> 
                                <th width="10%"><spring:message code="label.collection"/></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="establishment" items="${establishmentList}">
                                <tr>
                                    <td>${establishment.establishmentName}</td>
                                    <td>${establishment.establishmentOwner}</td>
                                    <td>${establishment.geolocation}</td>
                                    <td><c:forEach var="phone" items="${establishment.phones}">${phone.type}:${phone.no},<br></c:forEach></td>
                                    <td>${establishment.address}</td>
                                    <td>${establishment.establishmentUsername}</td>
                                    <td>${establishment.establishmentPassword}</td>
                                    <td>${establishment.sector}</td>
                                     
                                    <td>${establishment.province}</td>
                                    <td>${establishment.dischargeDate}</td>
                                    <td>${establishment.percentage}</td>
                                    <td>${establishment.typesEstablishment.name}</td>
                                    <td>${establishment.statusEstablishment.name}</td>
                                     <td>${establishment.openTime}</td>
                                      <td>${establishment.closeTime}</td>
                                    <td>${establishment.loans}</td>
                                     <td>${establishment.withdrawals}</td>
                                    <td>${establishment.prepayments}</td>
                                     <td>${establishment.fund}</td>
                                  
                                    <td><button type="submit" class="btn btn-default btn-sm" onClick="gotoCollection('${establishment.id}');"><i class="fa fa-pencil-square-o"></i> <spring:message code="label.collection"/></button></td>
                                 </tr>
                          	</c:forEach>                                                                                    
                          </tbody>
                        </table>
                    </div>
                </div>                                    
            </div>
        </div>
    </div>
</div>
<script>
function gotoCollection(id){
	 window.location.href="${pageContext.request.contextPath}/operator/newcollection.html?establishmentId="+id;
 }
</script>




	   
	   