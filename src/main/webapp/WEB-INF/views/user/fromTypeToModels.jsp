<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
    
    <h2>Category: ${type.type}</h2>

<div class="row">
	<div class="col-md-3 col-xs-12">
	
		
		
	</div>
	<div class="col-md-7 col-xs-12">
		<c:forEach items="${models}" var="goodModel">
			<div>

				

				<div class="row">
					<div class="col-md-12 col-xs-12">
<img src="/images/goodmodels/${goodModel.id}.jpg?version=${goodModel.version}">
							<div class="row">		
								<div class="col-md-4 col-xs-12" style="margin-left:-50px;">
									<a href="/model/${goodModel.id}" class="modClick"><h3>  ${goodModel.modelName}</h3></a>
								</div>
								<div class="col-md-4 col-xs-12"></div>
								<div class="col-md-4 col-xs-12" style="margin-bottom:35px;">
									<h3 style="margin-left:40px;">$${goodModel.price}</h3>
								</div>
							</div>	
							<hr>
					</div>
				</div>




			</div>


		</c:forEach>
	</div>
	
	<div class="col-md-2 col-xs-12">
	
		
		
	</div>
	
</div>



<c:if test="${empty models}">
	<h3>Category is empty</h3>
</c:if>