<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<div class="row" style="margin-top:100px">
	<div class="col-md-3"></div>

	<div class="col-md-6">
	<c:choose>
		<c:when test="${totalPrice=='0'}">
			<div class="col-md-10" style="margin-bottom:50px;margin-left:150px;">
				<h2>YOUR CART IS EMPTY YET.</h2>	
				<h2>GO AND GRAB SOME STUFF.</h2>	
			</div>							
		</c:when>
		<c:otherwise>
		<div class="row">
			<div class="col-md-3 col-xs-3"><h3>Good Name</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Quantity</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Price</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Remove</h3></div>
			
		</div>
			<c:forEach items="${purchInfo}" var="info">
				<div class="row">
					<div class="col-md-2 col-xs-2">${info.goodName}</div>
					<div class="col-md-2 col-xs-2">${info.quantity}</div>
					<div class="col-md-2 col-xs-2">${info.totalPrice}</div>

					<div class="col-md-2 col-xs-2"><a href="/cart/remove/${info.id}" class="btn btn-warning text-center">REMOVE</a></div>
					
				</div>
			</c:forEach>
			<div class="row">
				<div class="col-md-6 col-xs-6" style="margin-left:280px"><b>TOTAL PRICE:</b> ${totalPrice}</div>	
			</div>
		<form:form class="form-horizontal" action="/cart/submittion" method="POST" modelAttribute="submit">	
			<div class="row">	
				<div class="col-md-3">
					<div class="form-group">
						<div style="margin-top:15px;margin-left:230px;margin-bottom:150px">	
							<a href="/cart/submittion" class="btn btn-danger text-center" id="checkout">PROCEED TO CHECKOUT</a>
						</div>
					</div>	
				</div>
			</div>	
		</form:form>
		</c:otherwise>
	</c:choose>	
	</div>


			<c:forEach items="${page.content}" var="infoplus" >
				<div class="row">
								<div class="col-md-3 col-xs-3">		<img src="/images/goodmodels/${infoplus.id}.jpg?version=${infoplus.version}"></div>
				<div class="col-md-10 col-xs-10">
					
				
						
				</div>
				</div>	
	</c:forEach>
	
</div>

<script type="text/javascript"> 
document.getElementById('checkout').addEventListener('click', function(){ 
alert("Thanks you for your order.\nWe will get in touch with you soon.\nYou also can check your e-mail for order details.") 
}); 
</script>