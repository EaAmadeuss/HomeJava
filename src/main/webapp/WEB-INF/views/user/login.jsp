<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row backgroundstyle" style="margin-top:5px;">
	
	<c:if test="${param.fail}">
		<div class="col-sm-12 col-xs-12 text-center">
			<h4 style="color:red;text-align:center;">Fail to authorize</h4>
			<h5 style="color:red;text-align:center;">Try again</h5>
		</div>
	</c:if>
	
	<div class="col-sm-3 col-xs-3 ">
	</div>
	
	<div class="col-sm-9 col-xs-9">
		<form:form class="form-horizontal" action="/login" method="POST" modelAttribute="purchaseInfo">
			<div class="form-group regText" style="margin-top:120px;">
    			<label    for="login" class="col-sm-2 control-label"  > <p style="color:red";> Login</p></label>
    			<div class="col-sm-4">
      				<input class="form-control" name="login" id="login">
    			</div>
  			</div>
			<div class="form-group regText">
    			<label for="password" class="col-sm-2 control-label"><p style="color:red";>Password</p></label>
    			<div class="col-sm-4">
      				<input type="password" class="form-control" name="password" autocomplete="off" id="password">
    			</div>
  			</div>
  			<div class="form-group">
  				<div class="col-sm-offset-2 col-sm-10 regText">
  					<div class="checkbox">
  						<label>
  							<input name="remember-me" type="checkbox"> Remember me
  						</label>
  					</div>
  				</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10" style="margin-bottom:100px;">
      				<button type="submit" class="btn btn-default">SIGN IN</button>
    			</div>
  			</div>
		</form:form>
		
		
	</div>
</div>