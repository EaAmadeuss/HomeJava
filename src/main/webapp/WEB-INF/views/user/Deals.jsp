<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
     <div class="row">	
					<div class="col-md-10 text-center col-md-offset-1" style="margin-top:-45px">
						<h2 style="margin-top:40px"><b style="color:#444">HUSTLE DEALS</b></h2>
						
					</div>
				</div>
				
				<div style="background-color:#f5f5f5">
					<div class="row">
						<div class="col-md-4 text-left" style="margin-top:220px">
							<div  style="margin-left:70px">
							<h3 style="color:#444"><b>GET WHAT YOU REALLY WANTED.</b></h3>
							<p><h4 style="color:#444">Here’s to guilt-free self-gifting. Save up to $419 on Hustler's PCs.

							</h4></p>
							</div>
						</div>
						<div class="col-md-8" style="margin-left:-20px">
							<img src="https://s29.postimg.org/dtaikpvw7/aurora_ink.png" width="100%">
						</div>
					</div>
				</div>
				<hr>
				<div >
				
					
				
				<div style="background-color:#121212">
					<div class="row">
						<div class="col-md-5 text-left" style="margin-top:180px">
							<div  style="margin-left:50px">
							<h3 style="color:#f5f5f5"><b>PLAY MORE. SPEND LESS.</b></h3>
							<p><h5 style="color:#f5f5f5">For a limited time, save $100 off select Alienware PCs $999+ with coupon <b>100OFF999</b>.
							</h5></p>
							<div class="row">
								<div class="col-md-8">
										<c:forEach items="${types}" var="type">
								<c:choose>
									<c:when test="${type.id=='2'}">
										<p><a href="/type/${type.id}" class="ShopNow"><b>SHOP NOW</b></a></p>
									</c:when>
								</c:choose>
							</c:forEach>	
<!-- 									<p><a href="C:\Users\unwis\Desktop\html\project_S\new 1.html" class="getNow text-center"><b>SHOP NOW</b></a></p> -->
								</div>	
							</div>
							</div>
						</div>
						<div class="col-md-7">
							<img src="https://s29.postimg.org/vkttoourb/alienware_homepage_premigration_day01_Module_5a.jpg" width="100%">
						</div>
					</div>
				</div>
				
			

			
			
			</div>
			<hr>