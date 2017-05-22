<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
	.filter .control-label{
		text-align: left;
	}
</style>


    
   <div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/Types">Category</a></li>
					<li class="active"><a href="/admin/Models<custom:allParams/>">Product Models</a></li>
					<li><a href="/admin/Color">Color</a></li>
					<li><a href="/admin/gpuTypes">Processor Model</a></li>
					<li><a href="/admin/memoryTypes">Memory </a></li>
					<li><a href="/admin/proccTypes">Frequency Processor</a></li>
					<li><a href="/admin/ramTypes">Ram size</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

	
<div class="row">
	<div class="col-md-2 col-xs-12">
	
		<form:form class="form-horizontal filter" action="/admin/Models" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="min, max, TypesId, colorId, gpuTypesId, memoriesId, nvidiaId ,screanId , proccTypesId, ramTypesId, _goodTypesId, _goodsId, _gpuTypesId, _memoriesId, _nvidiaId , _screanId , _proccTypesId, _ramTypesId"/>
			
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="min" class="form-control" placeholder="Min"/>
				</div>
				<div class="col-sm-6">
					<form:input path="max" class="form-control" placeholder="Max"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Type</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${goodTypes}" itemValue="id" itemLabel="type" path="TypesId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Color</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${goods}" itemValue="id" itemLabel="color" path="colorsId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Proc Model</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${gpuTypes}" itemValue="id" itemLabel="type" path="gpuTypesId"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-12">Frequncy</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${proccs}" itemValue="id" itemLabel="type" path="proccTypesId"/>
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-12">Memory </label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${memories}" itemValue="id" itemLabel="type" path="memoriesId"/>
				</div>
			</div>
			
			
			
			<div class="form-group">
				<label class="control-label col-sm-12">RAM </label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${rams}" itemValue="id" itemLabel="ramType" path="ramTypesId"/>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Go</button>
		</form:form>
	
	</div>
	<div class="col-md-8 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/Models" method="POST" modelAttribute="goodModel" enctype="multipart/form-data">
					<custom:hiddenInputs excludeParams="Type, modelName, gpuType, memoryType,  nvidiaType, screanType , proccType, ramType, price, color, file"/>
			
  					<div class="form-group">
						<label style="color:red;text-align:left;" for="mtype" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="goodType"/></label>
					</div>
					<div class="form-group">
    					<label for="mtype" class="col-sm-2 control-label">Model Type</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="Type" id="mtype" items="${Types}" itemValue="id" itemLabel="type"/>
    					</div>
  					</div>
  					
  					
  					<div class="form-group">
						<label style="color:red;text-align:left;" for="name" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="modelName"/></label>
					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Model Name</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="modelName" id="name"/>
    					</div>
  					</div>
  					
  					
  					<div class="form-group">
    					<label for="mg" class="col-sm-2 control-label">Model Processor</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="gpuType" id="mg" items="${gpuTypes}" itemLabel="type" itemValue="id"/>
    					</div>
  					</div>
  					
  					
  					
  					<div class="form-group">
    					<label for="mp" class="col-sm-2 control-label">GPU frequncy</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="proccType" id="mp" items="${proccs}" itemLabel="type" itemValue="id"/>
    					</div>
  					</div>
  					
  					
  					
  					
  					
  					
  					<div class="form-group">
    					<label for="mm" class="col-sm-2 control-label"> Memory</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="memoryType" id="mm" items="${memories}" itemLabel="type" itemValue="id"/>
    					</div>
  					</div>
  					
  					
  					
  				
  					
  					
  					<div class="form-group">
    					<label for="mr" class="col-sm-2 control-label"> RAM</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="ramType" id="mr" items="${rams}" itemLabel="ramType" itemValue="id"/>
    					</div>
  					</div>
  					
  					<div class="form-group">
						<label style="color:red;text-align:left;" for="mprice" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="price"/></label>
					</div>
  					
  					<div class="form-group">
    					<label for="mprice" class="col-sm-2 control-label">Model Price</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="price" id="mprice"/>
    					</div>
  					</div>
  					
  					
  					
  					<div class="form-group">
    					<label for="mk" class="col-sm-2 control-label">Color </label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="good" id="mk" items="${color}" itemLabel="color" itemValue="id"/>
    					</div>
  					</div>
  					
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Photo</label>
    					<div class="col-sm-10">
      						<input name="file" type="file" id="name">
    					</div>
  					</div>
				
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-primary">Create/Update</button>
      						<a class="btn btn-primary" href="/admin/Models/cancel">Cancel</a>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
		
		
			<div class="col-md-1 col-xs-1"><h4>Type   </h4></div>
			<div class="col-md-2 col-xs-2"><h4>Name   </h4></div>
			<div class="col-md-1 col-xs-1"><h4>GPU    </h4></div>
			<div class="col-md-1 col-xs-1"><h4>Memory </h4></div>
			<div class="col-md-1 col-xs-1"><h4>Processor</h4></div>
			<div class="col-md-1 col-xs-1"><h4>RAM      </h4></div>
			<div class="col-md-1 col-xs-1"><h4>Made     </h4></div>
			<div class="col-md-2 col-xs-2"><h4>Price    </h4></div>
			<div class="col-md-1 col-xs-1"><h4>Update    </h4></div>
			<div class="col-md-1 col-xs-1"><h4>Delete    </h4></div>
		</div>
		
		
		

		
			<c:forEach items="${page.content}" var="Models" >
						<div class="row">
					<!-- <div class="col-md-2 col-xs-2"> </div> -->
					<div class="col-md-1 col-xs-1">${Models.goodType.type}</div>
					<div class="col-md-2 col-xs-2">${Models.modelName}</div>
					<div class="col-md-1 col-xs-1">${Models.gpuType.type}</div>
					<div class="col-md-1 col-xs-1">${Models.memoryType.type}</div>
					<div class="col-md-1 col-xs-1">${Models.proccType.type}</div>
					<div class="col-md-1 col-xs-1">${Models.ramType.ramType}</div>
					<div class="col-md-1 col-xs-1">${Models.good.madeCountry}</div>
					<div class="col-md-2 col-xs-2">${Models.price} $</div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning" href="/admin/Models/update/${Models.id}<custom:allParams/>">update</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-danger" href="/admin/Models/delete/${Models.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
			
	</div>
	

<c:forEach items="${page.content}" var="Models">	
	
<div class="row">
<div class="col-md-2 col-xs-2">

</div>
					



<div class="col-md-8 col-xs-8">
${goodModel.modelName}
<img src="/images/Models/${Models.id}.jpg?version=${Models.version}"  >

</div>


<div class="col-md-2 col-xs-2">

</div>

</div>
</c:forEach>	
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
								<custom:sort innerHtml="Model name asc" paramValue="modelName" />
								<custom:sort innerHtml="Model name desc" paramValue="modelName,desc" />
								<custom:sort innerHtml="Type asc" paramValue="Type.type" />
								<custom:sort innerHtml="Type desc" paramValue="Type.type,desc" />
								<custom:sort innerHtml="Color asc" paramValue="Color.Color" />
								<custom:sort innerHtml="Color desc" paramValue="color.Color,desc" />
								<custom:sort innerHtml="GPU Type asc" paramValue="gpuType.type" />
								<custom:sort innerHtml="GPU Type desc" paramValue="gpuType.type,desc" />
								<custom:sort innerHtml="Memory Type desc" paramValue="memoryType.type,desc" />
								<custom:sort innerHtml="Memory Type desc" paramValue="memoryType.type,desc" />
								<custom:sort innerHtml="Procc Type desc" paramValue="proccType.type,desc" />
								<custom:sort innerHtml="Procc Type desc" paramValue="proccType.type,desc" />
								<custom:sort innerHtml="RAM Type desc" paramValue="ramType.ramType,desc" />
								<custom:sort innerHtml="RAM Type desc" paramValue="ramType.ramType,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
		</div>
	
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>

<script>
	$('label').each(function(){
		if(!$(this).html()) $(this).parent().hide();
	});
	
</script>