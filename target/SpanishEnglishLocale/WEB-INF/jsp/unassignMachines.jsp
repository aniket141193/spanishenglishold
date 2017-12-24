<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<script type="text/javascript">
 $(document).ready(function() {

    $('#example').dataTable( {
        "aaSorting": [[1,'asc']],
    aoColumnDefs: [
	                   {
	                      bSortable: false,
	                      aTargets: [ -1 ]
	                   }
	                 ]
      } );
} ); 
 
 $(document).ready(function() {

	    $('#example').DataTable();
	    
	    
	} );

</script>







<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                   
                </div>                                    
            </div>
        </div>
       
    </div>
   
           
    <div class="row">                        
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head"><spring:message code="label.machineList"/></span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            
    
         	<th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
  			<th width="10%"><spring:message code="label.nickName"/></th>                               

            <th width="10%"><spring:message code="label.operator"/></th>  
            <th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
            <th width="10%"><spring:message code="label.establishment"/></th>                        
            <th width="3%" class="text-center no-sort"><input type="checkbox"  onClick="deleteAllRow(this)" ></th>
                            </tr>
                          </thead>
                          <tbody>
                          	<c:forEach var="machine" items="${machineList}">
                                <tr>
                                  	<td class="text-center"><input type="checkbox" id="${machine.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    <td>${machine.nickName}</td>
                                    <td>${machine.operator.name}</td>
									<td class="text-center"><input type="checkbox" id="${machine.operator.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
									<td>${machine.establishment.name}</td>
									<td class="text-center"><input type="checkbox" id="${machine.establishment.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                    
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





	   