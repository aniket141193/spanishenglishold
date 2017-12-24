<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript">
function getData(){
	var machineIDDe = document.getElementById("machineIDD");
	var machineIDDstrUser = machineIDDe.options[machineIDDe.selectedIndex].value;
	alert(machineIDDstrUser);
	
	var establishmentIDDe = document.getElementById("establishmentIDD");
	var establishmentIDDstrUser = establishmentIDDe.options[establishmentIDDe.selectedIndex].value;
	alert(establishmentIDDstrUser);
	
	var form = document.createElement("form");
	machineID = document.createElement("input");
	operatorID = document.createElement("input");
	establishmentID = document.createElement("input");
	
form.action = "unassignMachined.html";
form.method = "post"

machineID.type = "hidden";
machineID.name = "machineId";
machineID.value = machineIDDstrUser;
form.appendChild(machineID);

establishmentID.type = "hidden";
establishmentID.name = "establishmentId";
establishmentID.value = establishmentIDDstrUser;
form.appendChild(establishmentID);

document.body.appendChild(form);
form.submit();
}

function myFunction() {
    var x = document.getElementById("machineIDD").value;
   alert(x);
    $.ajax({
		 type: "POST",    
		  url: 'getMachineData.html',
		  data: {machineId:x},
		  success: function(response) {
			  alert("result: "+response)
			   var res = response.split(",");
			  alert(res);
			  
		   
		    
		    var select1 = document.getElementById('establishmentIDD');
			   var opt1 = document.createElement('option');
			   opt1.value = res[0];
			    opt1.innerHTML = res[1];
			    select1.appendChild(opt1);
			    if(res[0] != '0'){
			    	var opt1t = document.createElement('option');
					   opt1t.value = 0;
					    opt1t.innerHTML = "Unassigned";
					    select1.appendChild(opt1t);
			    }
		   
		  },
		  error: function(xhr) {
			  alert("error:"+xhr);
		    alert(xhr);
		  }
		});
}
</script>

</head>
<body>
<div class="form-horizontal">
<span class="panel-head"><spring:message code="label.assignmentMsg"/></span>
<div class="panel-body">
                    <div class="table-responsive">
                     <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            <th width="20%"><spring:message code="label.machine"/></th>
                             <th width="20%"><spring:message code="label.establishment"/></th>
                             <th width="20%"><spring:message code="label.assigned"/></th>
                            </tr>
                           </thead>
                            <tbody>
                            <tr>
                             <form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/operator/assignMachined.html">
                            <td>
                            <input type="hidden" name="action" id="action" value="assignMachine">
                            <select name="machineID" id="machineID" class="form-control" >
                            <c:forEach var="machine" items="${machineList}">
                        <option value="${machine.id}">${machine.nickName}</option>
                      </c:forEach>
                      </select>
                      </td>
                         <td>
                         <select name="establishmentID" id="operatorID" class="form-control" >
                         <c:forEach var="establishment" items="${establishmentList}">
                        <option value="${establishment.id}">${establishment.establishmentName}</option>
                      </c:forEach>
                      </select>
                      </td>
                      <td>
                      <button type="submit" class="btn btn-default btn-sm"><spring:message code="label.assigned"/></button>
                      </td>
                      </form>
                            </tr>
                         
                            </tbody>
                       </table>

                      
                      
                      </div>
                      </div>
                      
                        <!-- un assigned machine -->
                      <hr>
                      <span class="panel-head"><spring:message code="label.unassignmentMsg"/></span>
					
						<div class="panel-body">
                    <div class="table-responsive">
                     <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            <th width="20%"><spring:message code="label.machine"/></th>
                             <th width="20%"><spring:message code="label.establishment"/></th>
                             <th width="20%"><spring:message code="label.assigned"/></th>
                            </tr>
                           </thead>
                            <tbody>
                            <tr>
                             <form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/operator/unassignMachined.html">
                            <td>
                            <input type="hidden" name="action" id="action" value="unassignMachine">
                            <select name="machineIDD" id="machineIDD" class="form-control" onchange="myFunction()">
                            <option selected disabled hidden style='display: none' value=''></option>
                            <c:forEach var="machine" items="${machineSet}">
                        <option value="${machine.id}">${machine.nickName}</option>
                      </c:forEach>
                      </select>
                      </td>
                          <td>
                       
                       <select id="establishmentIDD" class="form-control"></select>
                      </td>
                      <td>
                      <button type="button" class="btn btn-default btn-sm" onclick = "getData();"><spring:message code="label.unassignMachine"/></button>
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