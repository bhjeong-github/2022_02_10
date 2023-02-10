<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>
<%@include file="includes/header.jsp" %>
<link rel="stylesheet" href="/resources/css/reservations.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<div id="wrapper" class="banner main-contents relative">
	<div class="content one">
		<!--<img src="img/hair01.png" alt="hair01">-->
	</div>
	<div class="content two"></div>
	<div class="content three"></div>
</div>
<div id="wrapper" class="company relative">
	<div class="container">company</div>
</div>

<!--modal-->
<div id="reserve_modal">
	 <sec:authorize access="isAuthenticated()">
	<%@include file="modal.jsp" %>
	 </sec:authorize>
</div>
<!-- modify modal -->
<div id="reserve_get">
	<sec:authorize access="isAuthenticated()">
	<%@include file="reserveGet.jsp" %>
	</sec:authorize>
</div>
<!--login_modal-->
<!-- end modal -->

<%@include file="includes/footer.jsp" %>
