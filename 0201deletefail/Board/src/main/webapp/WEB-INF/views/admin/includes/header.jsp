<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>
    <link rel="stylesheet" href="/resources/css/admin.css" />

</head>

<body>
	 <!--header.jsp-->
    <div class="admin-wrapper">
    <div class="admin-top">
        <div class="admin-logout">
            <ul>
            <sec:authorize access="hasRole('ADMIN')">
                <li>현재 관리자모드에 접속중입니다. </li>
                <li><a href="../customLogout">로그아웃</a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
    <div class="admin-left">
		<h1 class="admin-logo"><a href="#">ADMIN PAGE</a></h1>
        <nav class="admin-nav">
            <ul>
                <li><a href="#">관리자 정보</a></li>
                <li><a href="#">회원관리</a></li>
                <li><a href="#">예약관리</a></li>
                <li><a href="#">공지사항</a></li>
                <li><a href="#">게시물 관리</a></li>
            </ul>
        </nav>
	</div>
	</div>
    <!--header.jsp-->
        
        
