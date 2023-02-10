<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <script src = "/resources/vendor/jquery/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  	<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/css/reservations2.css">

    </head>
  	<script>
  	
  	$(function() {
        //모든 datepicker에 대한 공통 옵션 설정
        $.datepicker.setDefaults({
            dateFormat: 'yy-mm-dd' //Input Display Format 변경
            ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
            ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
            ,changeYear: true //콤보박스에서 년 선택 가능
            ,changeMonth: true //콤보박스에서 월 선택 가능                
            ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
            ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
            ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
            ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
            ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
            ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
            ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
            ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
            ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
            ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
            ,maxDate: "+3M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                    
        });

        //input을 datepicker로 선언
        $("#datepicker2").datepicker();                    
        
        //From의 초기값을 오늘 날짜로 설정
        $('#datepicker2').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
    });
  	
  	
  	
  	</script>
</head>
<body>
	
    <!--login_modal-->
    
    	<!--  select box start - jaewoon -->
        <div class="modify-area">
        	 <!--  modal calendar start -->
             <h1 class="modify-head">예약 조회</h1>
             <div class = "form-group">
        	 <dl>
        	 	<dt>예약자 id</dt>
        	 	<dd>
        	 	<input type= "text" name = "reserveid"  class="form-stye" readonly/>
        	 	</dd>
        	 </dl>
        	 </div>
        	 <div class = "form-group">
        	 <dl>
        	 	<dt>예약날짜 선택</dt>
        	 	<dd>
        	 	<input type="text" id="datepicker2" class="form-stye">
        	 	</dd>
        	 </dl>
        	 </div>
        	 <!--  modal calendar end -->
        	 <div class = "form-group">
        	 <dl>
                <dt>디자이너</dt>
                <dd>
                    <select id="designer"  onchange="designer" class="form-stye" disabled>
                        <option value="">디자이너를 선택하십시오.</option>
                        <option value="보노쌤">보노쌤</option>
                        <option value="동수쌤">동수쌤</option>
                        <option value="재운쌤">재운쌤</option>
                    </select>
                </dd>
            </dl>
        	 </div>
        	 <!--  designer end -->
        	<div class = "form-group">
            <dl>
                <dt>스타일</dt>
                <dd>
                    <select id="style"  onchange="style" class="form-stye" disabled>
                        <option value="">스타일을 선택하십시오.</option>
                        <option value="커트">커트</option>
                        <option value="펌">펌</option>
                        <option value="염색">염색</option>
                        <option value="클리닉">클리닉</option>
                        <option value="샴푸">샴푸</option>
                        <option value="스타일상담">스타일상담</option>
                    </select>
                </dd>
            </dl>
        	</div>
        	<!-- style end -->
        	<div class = "form-group last-area">
            <dl>
                <dt>시간</dt>
                <dd>
                    <select id="time"  onchange="time" class="form-stye" disabled>
                        <option value="">시간을 선택하십시오.</option>
                        <option value="10:00:00">10:00</option>
                        <option value="11:00:00">11:00</option>
                        <option value="12:00:00">12:00</option>
                        <option value="13:00:00">13:00</option>
                        <option value="14:00:00">14:00</option>
                        <option value="15:00:00">15:00</option>
                        <option value="16:00:00">16:00</option>
                        <option value="17:00:00">17:00</option>
                        <option value="18:00:00">18:00</option>
                        <option value="19:00:00">19:00</option>
                        <option value="20:00:00">20:00</option>
                    </select>
                </dd>
            </dl>
        	</div>
        	<!--  reserve time end -->
            <!--  select box end -->
            <div class="modify-top">
                <button id='modalDeleteBtn' type="button" class="button btn-primary btn-submit">삭제</button>
                <button id='modalCloseBtn' type="button" class="button btn-default">확인</button>
            </div>
            <div class="modify-bottom">
            </div>
        </div>
    <!--login_modal-->
		 <script>
		 $(document).ready(function(){
	      	  <sec:authorize access="isAuthenticated()">
	            reserveid = '<sec:authentication property="principal.username"/>';   
	       	  </sec:authorize>
	       	  var csrfHeaderName ="${_csrf.headerName}"; 
		      var csrfTokenValue="${_csrf.token}";
		      $(document).ajaxSend(function(e, xhr, options) {
//		           console.log("requestHeader...csrf");
	         	xhr.setRequestHeader(csrfHeaderName, csrfTokenValue); 
	       	});
	       
	    		$('.reserve-show').click(function() {
	   			 
			$('#reserve_get').css("display", "block");
			$.ajax({
				  url: '/reserves/' + reserveid,
				  type: 'GET',
				  success: function(result) {
				    $('input[name=reserveid]').val(result.reserveid);
				    $('#datepicker2').val(result.date);
				    $('#designer option[value=' + result['title'] + ']').attr('selected', 'true');
				    $('#style option[value=' + result.style + ']').attr('selected', 'true');
				    $('#time option[value="' + result.time.toString() + '"]').attr('selected', 'true');
				    
				  },
				  error: function(xhr, status, error) {
				    console.log(error);
				  }
			});
			
	    		$('#modalDeleteBtn').click(function(e) {
	    			
	    			$('#reserve_get').css("display", "none");
	    		        $.ajax({
	    		            url : '/reserves/' + reserveid,
	    		            type : 'DELETE',
    		           		data : JSON.stringify({reserveid: reserveid}),
    		           		contentType : "application/json; charset=utf-8",
	    		            success: function(result) {
	    		                alert('Reservation deleted successfully!');
	    		                location.reload();
	    		            },
	    		            error: function(xhr, status, error) {
	    		                alert('Error deleting reservation: ' + error);
	    		            }
	    		        });
	    		});
    		});
		});
		 </script>
 	 </body>
 </html>