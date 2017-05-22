<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
        <h2>Model: ${model.modelName}</h2>
        
        
		<%-- 	<c:forEach items="${model}" var="model" >
				<div class="row">
				
				<div class="col-md-10 col-xs-10">
					
					<img src="/images/goodmodels/${model.id}.jpg?version=${model.version}">
						
				
				</div>
			</div>
		</c:forEach>  --%>		
        
 <c:forEach items="${modelTypes}" var="type">
	<div>
	<b>Type: </b>${type.type}

	</div>
</c:forEach>
        
<c:forEach items="${procc_types}" var="procc_type">
	<div>
	<b>Processor: </b>${procc_type.type}
	</div>
</c:forEach>

<c:forEach items="${gpu_types}" var="gpu_type">
	<div>
	<b>GPU: </b>${gpu_type.type}
	</div>
</c:forEach>

<c:forEach items="${ram_types}" var="ram_type">
	<div>
	<b>RAM: </b>${ram_type.ramType}
	</div>
</c:forEach>

<c:forEach items="${memory_types}" var="memory_type">
	<div>
	<b>Memory: </b>${memory_type.type}
	</div>
</c:forEach>


<c:forEach items="${goods}" var="good">
	<div>
	<b>Color </b>${good.madeCountry}
	</div>
</c:forEach>

<h5><b>Total price = $${model.price}</b></h5>

		

<sec:authorize access="isAuthenticated()">
	<a class="btn btn-danger" href="/addToCart/${model.id}" style="margin-bottom:50px;" id="addToCart">ADD TO CART</a>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
	<a class="btn btn-danger" href="/login" style="margin-bottom:50px;" id="logOrReg">ADD TO CART</a>
</sec:authorize>

<c:if test="${empty types}">
	<h3>Model does not exist yet</h3>
</c:if>

<script type="text/javascript"> 
document.getElementById('addToCart').addEventListener('click', function(){ 
alert("Selected item was added to your shopping cart.") 
}); 
</script>

<script type="text/javascript"> 
document.getElementById('logOrReg').addEventListener('click', function(){ 
alert("Please sing in or sing up for purchasing.") 
}); 
</script>