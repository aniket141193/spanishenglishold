<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container-fluid">
    <div class="page-dashboard">
        <div class="row">            
            <div class="col-md-2 col-sm-3 col-md-offset-2">
            	<a href="${pageContext.request.contextPath}/admin/operatorsList.html" class="menu-link">
                    <div class="menu-block m-block2">
                        <div class="menu-icon"><i class="fa fa-building"></i></div>
                        <div class="menu-name"><spring:message code="label.operator"/></div>
                    </div>
                </a>
            </div>
            
           <div class="col-md-2 col-sm-3">
            	<a href="${pageContext.request.contextPath}/admin/establishmentList.html" class="menu-link">
                    <div class="menu-block m-block3">
                        <div class="menu-icon"><i class="fa fa-user"></i></div>
                        <div class="menu-name"><spring:message code="label.establishment"/></div>
                    </div>
                </a>
            </div> 
            
            <div class="col-md-2 col-sm-3">
            	<a href="${pageContext.request.contextPath}/admin/machine.html" class="menu-link">
                    <div class="menu-block m-block4">
                        <div class="menu-icon"><i class="fa fa-file-text-o"></i></div>
                        <div class="menu-name"><spring:message code="label.machine"/></div>
                    </div>
                </a>
            </div>
            
            <div class="col-md-2 col-sm-3">
               <a href="${pageContext.request.contextPath}/admin/machineType.html" class="menu-link">
                    <div class="menu-block m-block5">
                        <div class="menu-icon"><i class="fa fa-cog"></i></div>
                        <div class="menu-name"><spring:message code="label.machineType"/></div>
                    </div>
                </a>
            </div>
            
            <div class="col-md-2 col-sm-3">
               <a href="${pageContext.request.contextPath}/admin/country.html" class="menu-link">
                    <div class="menu-block m-block5">
                        <div class="menu-icon"><i class="fa fa-cog"></i></div>
                        <div class="menu-name"><spring:message code="label.country"/></div>
                    </div>
                </a>
            </div>
           
            <div class="col-md-2 col-sm-3">
            	<a href="${pageContext.request.contextPath}/admin/paymentDevices.html" class="menu-link">
                    <div class="menu-block m-block3">
                        <div class="menu-icon"><i class="fa fa-user"></i></div>
                        <div class="menu-name"><spring:message code="label.paymentDevices"/></div>
                    </div>
                </a>
            </div> 
             <div class="col-md-2 col-sm-3">
            	<a a href="${pageContext.request.contextPath}/admin/users.html" class="menu-link">
                    <div class="menu-block m-block3">
                        <div class="menu-icon"><i class="fa fa-user"></i></div>
                        <div class="menu-name"><spring:message code="label.users"/></div>
                    </div>
                </a>
            </div> 
            
             <div class="col-md-2 col-sm-3">
            	<a href="${pageContext.request.contextPath}/admin/settings.html" class="menu-link">
                    <div class="menu-block m-block3">
                        <div class="menu-icon"><i class="fa fa-user"></i></div>
                        <div class="menu-name"><spring:message code="label.settings"/></div>
                    </div>
                </a>
            </div>  
           <%-- <div class="col-md-2 col-sm-3">
            	<a a href="${pageContext.request.contextPath}/admin/coinValidatorType.html" class="menu-link">
                    <div class="menu-block m-block3">
                        <div class="menu-icon"><i class="fa fa-user"></i></div>
                        <div class="menu-name"><spring:message code="label.cvType"/></div>
                    </div>
                </a>
            </div> 
            
            <div class="col-md-2 col-sm-3">
            	<a a href="${pageContext.request.contextPath}/admin/billValidatorType.html" class="menu-link">
                    <div class="menu-block m-block3">
                        <div class="menu-icon"><i class="fa fa-user"></i></div>
                        <div class="menu-name"><spring:message code="label.bvType"/></div>
                    </div>
                </a>
            </div>  --%>
            
        </div>
    </div>
</div>