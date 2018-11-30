<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- head.jsp ----- start -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/rsa.js"></script>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/lightbox.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700'
	rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-msg.css">
<link rel="stylesheet" href="css/mainbody.css">
<link rel="stylesheet" href="css/mainpage.css">
<link id="css-preset" href="css/mintcss/mint.css" rel="stylesheet">

<c:if test="${pageName != 'index'}">
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link href="css/chart.css" rel="stylesheet">

	<style>
	ul {
		list-style: none;
	}
	</style>
	
	<style>
	#nav {
		line-height: 30px;
		width: 350px;
		float: left;
		padding: 10px;
	}
	
	#section {
		float: left;
		padding: 10px;
	}
	</style>
</c:if>

<!-- head.jsp ----- end -->