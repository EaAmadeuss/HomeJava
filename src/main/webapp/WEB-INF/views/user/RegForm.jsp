<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>


<div class="row backgroundstyle">
		
		<h1 class="regText" style="text-align: center;margin-left:130px;">SING UP , HUSTLER.</h1>
	
	<div class="col-sm-12 col-xs-9 col-md-offset-3">
		<form:form class="form-horizontal" action="/RegForm" method="POST" modelAttribute="user">
		
				<div class="form-group">
						<label style="color:red;text-align:left;" for="fName" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="firstName"/></label>
				</div>
		
			<div class="form-group regText" style="margin-top:20px;">
    			<label for="fName" class="col-sm-2 control-label">First Name</label>
    			<div class="col-sm-3">
      				<form:input class="form-control" path="firstName" id="fName"/>
    			</div>
  			</div>
  			
  			<div class="form-group">
						<label style="color:red;text-align:left;" for="lastName" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="lastName"/></label>
			</div>
  			
  			<div class="form-group regText">
    			<label for="lastName" class="col-sm-2 control-label">Last Name</label>
    			<div class="col-sm-3">
      				<form:input class="form-control" path="lastName" id="lastName"/>
    			</div>
  			</div>
  			
  			<div class="form-group">
						<label style="color:red;text-align:left;" for="email" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="email"/></label>
				</div>
  			
			<div class="form-group regText">
    			<label for="email" class="col-sm-2 control-label">Email</label>
    			<div class="col-sm-3">
      				<form:input class="form-control" path="email" id="email"/>
    			</div>
  			</div>
  			
  			<div class="form-group">
						<label style="color:red;text-align:left;" for="pw" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="password"/></label>
					</div>
  			
			<div class="form-group regText">
    			<label for="pw" class="col-sm-2 control-label">Password</label>
    			<div class="col-sm-3">
      				<form:password class="form-control" path="password" id="pw"/>
    			</div>
  			</div>
  			
  			<div class="form-group">
						<label style="color:red;text-align:left;" for="pwRep" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="repPassword"/></label>
					</div>
  			
			<div class="form-group regText">
    			<label for="pwRep" class="col-sm-2 control-label">Repeat Password</label>
    			<div class="col-sm-3">
      				<form:password class="form-control" path="repPassword" id="pwRep"/>
    			</div>
  			</div>
  			
  			<div class="form-group">
						<label style="color:red;text-align:left;" for="mobNum" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="mobilePhone"/></label>
					</div>
  			
  			<div class="form-group regText">
    			<label for="mobNum" class="col-sm-2 control-label">Mobile Phone Number</label>
    			<div class="col-sm-3">
      				<form:input class="form-control" path="mobilePhone" id="mobNum"/>
    			</div>
  			</div>
  			
  			<div class="form-group">
						<label style="color:red;text-align:left;" for="postCode" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="postCode"/></label>
					</div>
  			
  			<div class="form-group regText">
    			<label for="postCode" class="col-sm-2 control-label">Post Code</label>
    			<div class="col-sm-3">
      				<form:input class="form-control" path="postCode" id="postCode"/>
    			</div>
  			</div>
  			
  			
  			<div class="form-group">
						<label style="color:red;text-align:left;" for="country" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="deliveryAddressCountry"/></label>
					</div>
  			<div class="form-group regText">
    			<label for="country" class="col-sm-2 control-label">Country</label>
    			<div class="col-sm-3">
      				<form:input class="form-control" path="deliveryAddressCountry" id="country"/>
    			</div>
  			</div>
  			
  			<div class="form-group">
						<label style="color:red;text-align:left;" for="city" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="deliveryAddressCity"/></label>
					</div>
  			<div class="form-group regText">
    			<label for="city" class="col-sm-2 control-label">City</label>
    			<div class="col-sm-3">
      				<form:input class="form-control" path="deliveryAddressCity" id="city"/>
    			</div>
  			</div>
  			
  			<div class="form-group">
						<label style="color:red;text-align:left;" for="homeAddress" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="deliveryHomeAddress"/></label>
					</div>
  			<div class="form-group regText">
    			<label for="homeAddress" class="col-sm-2 control-label">Home Address</label>
    			<div class="col-sm-3">
      				<form:input class="form-control" path="deliveryHomeAddress" id="homeAddress"/>
    			</div>
  			</div>
  			
  			<div class="form-group regText">
    			<div class="col-sm-offset-2 col-sm-10" style="margin-left:370px;margin-bottom: 30px">
      				<button type="submit" class="btn btn-default">SIGN UP</button>
    			</div>
  			</div>
		</form:form>
		
	
	</div>
</div>
	
<script>
	$('label').each(function(){
		if(!$(this).html()) $(this).parent().hide();
	});
	
</script>
