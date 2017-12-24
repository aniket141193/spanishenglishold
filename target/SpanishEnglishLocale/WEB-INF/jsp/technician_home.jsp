<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container-fluid">
    <div class="page-dashboard">
        <div class="row">            
           
            
        
            
            <div class="col-md-2 col-sm-3">
            	<a href="${pageContext.request.contextPath}/technician/machine.html" class="menu-link">
                    <div class="menu-block m-block4">
                        <div class="menu-icon"><i class="fa fa-file-text-o"></i></div>
                        <div class="menu-name"><spring:message code="label.machine"/></div>
                    </div>
                </a>
            </div>
            
            <div class="col-md-2 col-sm-3">
            	<a href="${pageContext.request.contextPath}/technician/repairs.html" class="menu-link">
                    <div class="menu-block m-block4">
                        <div class="menu-icon"><i class="fa fa-file-text-o"></i></div>
                        <div class="menu-name"><spring:message code="label.repair"/></div>
                    </div>
                </a>
            </div>
            
            <div class="col-md-2 col-sm-3">
               <a href="${pageContext.request.contextPath}/technician/settings" class="menu-link">
                    <div class="menu-block m-block5">
                        <div class="menu-icon"><i class="fa fa-cog"></i></div>
                        <div class="menu-name"><spring:message code="label.setting"/></div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>