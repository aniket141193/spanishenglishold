<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
<script>
function checkform() {
    if(document.frm.machineID.value == "") {
        alert("please select machine Id");
        return false;
    } else{
        document.frm.submit();
    }
}
</script>
<script type="text/javascript">
function getData(){
	var machineIDDe = document.getElementById("machineIDD");
	var machineIDDstrUser = machineIDDe.options[machineIDDe.selectedIndex].value;
	
	var operatorIDDe = document.getElementById("operatorIDD");
	var operatorIDDstrUser = operatorIDDe.options[operatorIDDe.selectedIndex].value;
	
	var establishmentIDDe = document.getElementById("establishmentIDD");
	var establishmentIDDstrUser = establishmentIDDe.options[establishmentIDDe.selectedIndex].value;
	
	
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

operatorID.type = "hidden";
operatorID.name = "operatorId";
operatorID.value = operatorIDDstrUser;
form.appendChild(operatorID);

establishmentID.type = "hidden";
establishmentID.name = "establishmentId";
establishmentID.value = establishmentIDDstrUser;
form.appendChild(establishmentID);

document.body.appendChild(form);
form.submit();
}

function myFunction() {
    var x = document.getElementById("machineIDD").value;
   
    $.ajax({
		 type: "POST",    
		  url: 'getMachineData.html',
		  data: {machineId:x},
		  success: function(response) {
			  
			   var res = response.split(".");
			  
			  var opRes = res[1].split(",");
		      
		      var opRes1 = res[0].split(",");
		   //$("#operatorIDD").val(res[1]);
		  
		   //$("#establishmentIDD").val(res[0]);
		   
		   var select = document.getElementById('operatorIDD');
		   var opt = document.createElement('option');
		   opt.value = opRes[0];
		    opt.innerHTML = opRes[1];
		    select.appendChild(opt);
		    if(opRes[0] != '0'){
		    	var optt = document.createElement('option');
				   optt.value = 0;
				    optt.innerHTML = "Unassigned";
				    select.appendChild(optt);
		    }
		    
		    var select1 = document.getElementById('establishmentIDD');
			   var opt1 = document.createElement('option');
			   opt1.value = opRes1[0];
			    opt1.innerHTML = opRes1[1];
			    select1.appendChild(opt1);
			    if(opRes1[0] != '0'){
			    	var opt1t = document.createElement('option');
					   opt1t.value = 0;
					    opt1t.innerHTML = "Unassigned";
					    select1.appendChild(opt1t);
			    }
		   
		  },
		  error: function(xhr) {
			  alert("error:"+xhr);
		    
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
                             <th width="20%"><spring:message code="label.operator"/></th>
                             <th width="20%"><spring:message code="label.establishment"/></th>
                             <th width="20%"><spring:message code="label.assigned"/></th>
                            </tr>
                           </thead>
                            <tbody>
                            <tr>
                             <form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/assignMachined.html">
                            <td>
                            <input type="hidden" name="action" id="action" value="assignMachine">
                            <select name="machineID" id="machineID" class="form-control" >
                            <option selected disabled hidden style='display: none' value=''></option>
                            <c:forEach var="machine" items="${machineList}">
                        <option value="${machine.id}">${machine.nickName}</option>
                      </c:forEach>
                      </select>
                      </td>
                         <td>
                         <select name="operatorID" id="operatorID" class="form-control" >
                         <option selected disabled hidden style='display: none' value=''></option>
                           <option value=""></option>
                         <c:forEach var="operator" items="${operatorList}">
                        <option value="${operator.id}">${operator.name}</option>
                      </c:forEach>
                      </select>
                      </td>
                      <td>
                         <select name="establishmentID" id="establishmentID" class="form-control" >
                         <option selected disabled hidden style='display: none' value=''></option>
                           <option value=""></option>
                         <c:forEach var="establishment" items="${establishmentList}">
                        <option value="${establishment.id}">${establishment.establishmentName}</option>
                      </c:forEach>
                      </select>
                      </td>
                      <td>
                      <button type="submit" class="btn btn-default btn-sm" onclick = "checkform();"><spring:message code="label.assigned"/></button>
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
                             <th width="20%"><spring:message code="label.operator"/></th>
                             <th width="20%"><spring:message code="label.establishment"/></th>
                             <th width="20%"><spring:message code="label.unassignMachine"/></th>
                            </tr>
                           </thead>
                            <tbody>
                            <tr>
                             <form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/admin/unassignMachined.html">
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
                         
                      <select id="operatorIDD" class="form-control"></select>
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