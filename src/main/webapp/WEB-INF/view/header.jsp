<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- header.jsp ----- start -->
<div class="main-nav">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand">
				<h1><img src="images/sclogo.png"></h1>
			</a> 
			<c:choose>
		      <c:when test="${pageName == 'index'}">
		      	<a class="navbar-brand" href="${contextPath}/">
		      </c:when>
		      <c:otherwise>
		      	<a class="navbar-brand" href="../main/">
		      </c:otherwise>
   			 </c:choose>
				<h2><img class="img-responsive" src="images/logo.png" alt="logo"></h2>
				</a>
			</div>
			<div class="collapse navbar-collapse">
				<c:choose>
			      <c:when test="${pageName == 'index'}">
			      	<ul class="nav navbar-nav navbar-right">
						<li><a class="cd-signin" href="${contextPath}/login">로그인</a></li>
					</ul>
			      </c:when>
			      <c:otherwise>
			      	<li class="dropdown">
			      		<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> 
			      			<i class="fa fa-user"></i> 
			      			%{ name }<span class="caret"></span>
						</a>
					<ul class="dropdown-menu">
						<li class="dropdown-menu-title"><span>${ email }</span></li>
						<li>
							<a data-target="#pwinput" data-toggle="modal">
							<i class="halflings-icon user"></i> Profile</a>
						</li>
						<li>
							<a href="../login/logout.jsp">
							<i class="halflings-icon off"></i> Logout</a>
						</li>
					</ul></li>
			      </c:otherwise>
	   			 </c:choose>
			</div>
		</div>
	</div>
	<div class="preloader">
		<i class="fa fa-circle-o-notch fa-spin"></i>
	</div>
<!-- header.jsp ----- end -->
