<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!-- 임시 적용(기본적 include - header.jsp) / 시작 /  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SB Admin 2 - Bootstrap Admin Theme</title>
    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 임시 적용(기본적 include - header.jsp) / 끝 /  -->
	<div class="container">
		<div class="row">
			<div class="col-md4 col-md-offser-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">회원정보수정</h3>
					</div>
					<div class="panel-body">
						<!--  c:if 추가-->
						<form role="form" method="post" action="/customModify">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="이름" name="userName" type="text" readonly>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="아이디" name="userId" type="text" readonly>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="비밀번호" name="userPw" type="password" value="" required>
								</div>
								<div class="form-group">
									<!-- 추후 다음 주소 검색 입력 api를 통해 추가할 예정입니다.  -->
									<input class="form-control" placeholder="회원 주소" name="address" type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="전화번호" name="phone" type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="이메일" name="email" type="text">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-default">수정하기</button>
									<button type="reset" class="btn btn-warning">재작성</button>
								</div>
							</fieldset>
							<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>
	<script src="/resources/dist/js/sb-admin-2.js"></script>
	<script>
		
		$(".btn-success").on("click", function(e){
				e.preventDefault();
		$("form").submit();
				});
	</script>
	<c:if test="${param.logout != null}">
		<script>
			$(document).ready(function(){
				alert("로그아웃하였습니다. ");
			});
		</script>
	</c:if>
	<script>
		function check(){
			if(document.form.userPw.value ==""){
				alert("비밀번호를 입력해주세요. ");
				document.form.userPw.focus();
				return false;
			}
		}
	</script>
</body>
</html>