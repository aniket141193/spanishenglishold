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
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>


</head>
<body>
<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left"><spring:message code="label.collection"/></h1>
                    
                                       
                   
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" onClick="goMachine('${machineID}')"><i class="fa fa-plus-circle"></i>  <spring:message code="label.newCollection"/></button> 
                </div>                                    
            </div>
        </div>
        
    </div>
    
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head"><spring:message code="label.collectionList"/></span>
                    </div>                                        
                </div>
                
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
    
         	
                               
                                <th width="10%"><spring:message code="label.startDate"/></th>
                                <th width="10%"><spring:message code="label.endDate"/></th>
                                <th width="10%"><spring:message code="label.machineCollection"/></th>
                                <th width="10%"><spring:message code="label.manualCollection"/></th>
                                <th width="10%"><spring:message code="label.differentInMoney"/></th>
                                <th width="10%"><spring:message code="label.differentInPercentage"/></th>   
                                <th width="10%"><spring:message code="label.paymentKey"/></th> 
                                <th width="10%"><spring:message code="label.fails"/></th> 
                                 <th width="10%"><spring:message code="label.playersGift"/></th>
                                 <th width="10%"><spring:message code="label.otherExpenses"/></th>
                                <th width="10%"><spring:message code="label.netTotal"/></th> 
                                 <th width="10%"><spring:message code="label.establishmentMoney"/></th>
                                <th width="10%"><spring:message code="label.adminMoney"/></th> 
                                <th width="10%"><spring:message code="label.operatorMoney"/></th>
                                <th width="10%"><spring:message code="label.machine"/></th>
                            </tr>
                          </thead>
                            <tbody>
                          	<c:forEach var="mc" items="${mcList}">
                                <tr>
                                  
                                    <td>${mc.startDate}</td>
                                    <td>${mc.endDate}</td>
                                    <td>${mc.machineCollection}</td>
                                    <td>${mc.manualCollection}</td>
                                    <td>${mc.differentInMoney}</td>
                                    <td>${mc.differentInPercentage}</td>
                                    <td>${mc.paymentKey}</td>
                                    <td>${mc.fails}</td>
                                    <td>${mc.playersGift}</td>
                                    <td>${mc.otherExpenses}</td>
                                    <td>${mc.netTotal}</td>
                                    <td>${mc.establishmentMoney}</td>
                                    <td>${mc.adminMoney}</td>
                                    <td>${mc.operatorMoney}</td>
                                  	<td>${mc.machine.nickName}</td>
                                  
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
function goMachine(id){
	 window.location.href="${pageContext.request.contextPath}/operator/newcollection.html?machineId="+id;
 }
</script>
</body>
</html>