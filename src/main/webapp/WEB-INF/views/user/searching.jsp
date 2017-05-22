<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
	.filter .control-label{
		text-align: left;
	}
	.textRight{
		text-align: right;
	}
	.margTop{
		margin-top:50px;
	}
	.black-background {background-color:#000000;}
	.white {color:#ffffff;}
</style>
	
<div class="row">
	<div class="col-md-3 col-xs-3">
	<form:form class="form-horizontal filter" action="/user/searching" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="min, max, goodTypesId, goodsId, gpuTypesId, memoriesId, proccTypesId, ramTypesId, _goodTypesId, _goodsId, _gpuTypesId, _memoriesId, _proccTypesId, _ramTypesId"/>
			
			<div class="form-group">
				<div class="col-sm-4">
					<form:input path="min" class="form-control" placeholder="Min price"/>
				</div>
				<div class="col-sm-4">
					<form:input path="max" class="form-control" placeholder="Max price"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4">Category</label>
				<div class="col-sm-4">
					<form:checkboxes element="div" items="${goodTypes}" itemValue="id" itemLabel="type" path="goodTypesId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4">Color</label>
				<div class="col-sm-4">
					<form:checkboxes element="div" items="${goods}" itemValue="id" itemLabel="madeCountry" path="goodsId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4">Processors</label>
				<div class="col-sm-4">
					<form:checkboxes element="div" items="${gpuTypes}" itemValue="id" itemLabel="type" path="gpuTypesId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4">Memory Size Gb</label>
				<div class="col-sm-4">
					<form:checkboxes element="div" items="${memories}" itemValue="id" itemLabel="type" path="memoriesId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4">GPU Frequncy Hz</label>
				<div class="col-sm-4">
					<form:checkboxes element="div" items="${proccs}" itemValue="id" itemLabel="type" path="proccTypesId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4">RAM size Gb</label>
				<div class="col-sm-4">
					<form:checkboxes element="div" items="${rams}" itemValue="id" itemLabel="ramType" path="ramTypesId"/>
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary black-background white">APPLY</button>
			<a class="btn btn-primary black-background white" href="/user/searching/cancel">CANCEL</a>
			
		</form:form>
	</div>
	<div class="col-md-9 col-xs-9">
			<form:form class="form-horizontal" action="/user/searching" method="POST" modelAttribute="cartAdd">
		<c:forEach items="${page.content}" var="goodModel" >
	<div class="row">	
		<div class="col-md-4">
	
	
	<img src="/images/goodModels/${goodModel.id}.jpg?version=${goodModel.version}" width="100%" >
				
		

		
		</div>
		<div class="col-md-8">
			<p>Type: ${goodModel.goodType.type}</p>
			<br>
		<p>Model: ${goodModel.modelName}</p>
			<br>
			<p>Fruq: ${goodModel.gpuType.type} </p>
			<br>
			<p>Memory: ${goodModel.memoryType.type}</p>
			<br>
			<p>Ram: ${goodModel.ramType.ramType}</p>
			<br>
			<p>Color: ${goodModel.good.madeCountry}</p>
			<br>
			<p>Price: ${goodModel.price} $</p>
			<br>
						<sec:authorize access="isAuthenticated()">
			<div class="col-md-1 col-xs-1" style="margin-top:125px;margin-left:-150px">
				<a  class="btn btn-danger" href="/user/searching/addToCart/${goodModel.id}" id="addToCart">ADD TO CART</a>
			</div>
			</sec:authorize>
				
	
		</div>
	</div>
		</c:forEach>
		</form:form>
	
	</div>
	</div>
	
	
	
	<div class="col-md-2 col-xs-12" >
	
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Price asc" paramValue="price" />
								<custom:sort innerHtml="Price desc" paramValue="price,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
		</div>
	
	</div>
</div>

<!-- appld -->

<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>

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