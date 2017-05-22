<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>








		<div class="raw">
			<div class="col-md-4 col-sm-4">
	<c:forEach items="${types}" var="type">
				<a href="/type/${type.id}">${type.type}</a>
	</c:forEach>
			</div>	
		</div>






<p><a href="/hustleMain">Hustle  Main page</a></p>






