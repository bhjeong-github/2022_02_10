<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Prospect</title>
    <link rel="stylesheet" href="/resources/css/style.css">
    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
      <script>
      	
        $(document).ready(function(){
        	
      	  var modal = $(".modal");
      	  var modalInputReserver = modal.find("input[name = 'reserveid']");
      	  var reserveid = null;
      	  <sec:authorize access="isAuthenticated()">
            reserveid = '<sec:authentication property="principal.username"/>';   
        	  </sec:authorize>
            $('#gnb li').mouseover(function(){
            	$(".lnb").css("display", "block");
                $('.lnb').stop().animate({height: '300px'}, 100);
            });
            $("#gnb li").mouseout(function(){
                $(".lnb").css("display", "none");
                $("#gnb li .lnb").stop().animate({height: '0'}, 100);
            });
          //modal-reserve
    		$('.modal-show').click(function() {
    			 if(!reserveid) {
      			 alert("로그인 후 이용하세요.");
      			 modal.modal("hide");
      			 return;
      		 }
    			$('#reserve_modal').css("display", "block");
    		});
    		$("#modalCloseBtn").on("click", function(e) {
    			$('#reserve_modal').css("display", "none");
    		});
        });
      </script>
      <!--header-->
      <header id="wrapper" class="header_border">
          <div id="wrapper" class="topmenu">
              <div class="container">
                  <ul class="tnb">
                  <sec:authorize access="hasRole('ADMIN')">
                     	<li><a href="#">관리</a></li>
                  </sec:authorize>
                  <sec:authorize access="isAuthenticated()">
                  <li><a href="#" class="reserve-show"><strong>예약 조회</strong></a></li>
                  </sec:authorize>
				  <sec:authorize access="isAuthenticated()">
                     	<li><a href="/customLogout">로그아웃</a></li>
                     	<!-- <li><a href="/customModify"><i class="fa fa-sign-out fa-fw"></i>정보수정</a></li> -->
                  </sec:authorize>
                  <sec:authorize access="isAnonymous()">
                     	<li><a href="/customLogin">로그인</a></li>
                     	<li><a href="/customRegister">회원가입</a></li>
                  </sec:authorize>
                  </ul>
              </div>
          </div>
          <div class="container header">
                  <h1 class="logo">
                      <!--<img src="https://via.placeholder.com/300x100" alt="main_logo The Prospect">-->
                      <a href="/">The Prospect</a>
                  </h1>
                  <nav id="gnb">
                      <ul>
                          <li><a href="#"><strong>CS</strong></a>
                              <div class="lnb">
                                  <div class="container">
                                      <ul>
                                          <li><a href="#">가격표</a></li>
                                          <li><a href="#">스타일리스트 소개</a></li>
                                      </ul>
                                  </div>
                              </div>
                          </li>
                          <li><a href="#" class="modal-show"><strong>예약</strong></a></li>
                          <li><a href="/board/list"><strong>후기</strong></a></li>
                      </ul>
                  </nav>
          </div>
      </header>
