<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="/resources/css/reservations.css">

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
        $("#datepicker1").datepicker();                    
        
        //From의 초기값을 오늘 날짜로 설정
        $('#datepicker1').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
    });
  	
  	</script>
</head>
<body>
	<script>
		$(function() {
			 $("#designer").change(function() {
				 $("#designerchg").val($(this).val());
			 });
		 });
		 $(function() {
			 $("#style").change(function() {
				 $("#stylechg").val($(this).val());
			 });
		 });
		 $(function() {
			 $("#time").change(function() {
				 $("#timechg").val($(this).val());
			 });
		 });
	</script>
    <!--login_modal-->
    
    	<!--  select box start - jaewoon -->
        <div class="reserve-area">
        	 <!--  modal calendar start -->
             <h1 class="modal-head">예약</h1>
             <div class = "form-group">
        	 <dl>
        	 	<dt>예약자 id</dt>
        	 	<dd>
        	 	<input type= "text" name = "reserveid" value = '<sec:authentication property="principal.username"/>' class="form-stye" readonly/>
        	 	
        	 	</dd>
        	 </dl>
        	 </div>
        	 <div class = "form-group">
        	 <dl>
        	 	<dt>예약날짜 선택</dt>
        	 	<dd><!--Date: --><input type="text" id="datepicker1" class="form-stye" readonly></dd>
        	 </dl>
        	 </div>
        	 <!--  modal calendar end -->
        	 <div class = "form-group">
        	 <dl>
                <dt>디자이너</dt>
                <dd>
                	<input type= "text" id = "designerchg" class="form-stye" readonly/>
                    <select id="designer"  onchange="designer" class="form-stye">
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
               		<input type= "text" id = "stylechg" class="form-stye" readonly/>
                    <select id="style"  onchange="style" class="form-stye">
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
                	<input type= "text" id = "timechg" class="form-stye" readonly/>
                    <select id="time"  onchange="time" class="form-stye">
                        <option value="">시간을 선택하십시오.</option>
                        <option value="10:00">10:00</option>
                        <option value="11:00">11:00</option>
                        <option value="12:00">12:00</option>
                        <option value="13:00">13:00</option>
                        <option value="14:00">14:00</option>
                        <option value="15:00">15:00</option>
                        <option value="16:00">16:00</option>
                        <option value="17:00">17:00</option>
                        <option value="18:00">18:00</option>
                        <option value="19:00">19:00</option>
                        <option value="20:00">20:00</option>
                    </select>
                </dd>
            </dl>
        	</div>
        	<!--  reserve time end -->
            <!--  select box end -->
            <div class="modal-top">
                <button id='modalReserveBtn' type="button" class="button btn-primary btn-submit">예약</button>
                <button id='modalCloseBtn' type="button" class="button btn-default">닫기 </button>
            </div>
            <div class="modal-bottom">
            </div>
        </div>
    <!--login_modal-->
		 <script>
		
$(document).ready(function() {
	 var modal = $(".modal");
  	 var modalInputReserver = modal.find("input[name = 'reserveid']");
  	 <sec:authorize access="isAuthenticated()">
      reserveid = '<sec:authentication property="principal.username"/>';   
   	 </sec:authorize>
      	$('#modalReserveBtn').click(function(e) {
      	    // Hide the modal
      	    $('#reserve_modal').css("display", "none");

      	    // Get the data from the form
      	    var resno = null;
      	    var date = $('#datepicker1').val();
      	    var title = $('#designer').val();
      	    var style = $('#style').val();
      	    var time = $('#time').val();

      	    var reservationExists = false;

      	    // Check reservation same ID already exists
      	  $.ajax({
      	    url: '/reservation/' + reserveid,
      	    type: 'GET',
      	    success: function(result, status, xhr) {
      	    	
      	        if (result.status === 409) {
      	        } else {
      	            // Check date, time, and designer already exists
      	            $.ajax({
      	                url: '/reservation/' + date + '/' + title + '/' + time,
      	                type: 'GET',
      	                success: function(result, status, xhr) {
      	                    if (result.status === 409) {
      	                    } else {
      	                        $.ajax({
      	                            url: 'reserve',
      	                            type: 'POST',
      	                            data: JSON.stringify({
      	                            	resno : resno,
      	                                reserveid : reserveid,
      	                                date: date,
      	                                title: title,
      	                                style: style,
      	                                time: time
      	                            }),
      	                            contentType : "application/json; charset=utf-8",
      	                            success: function(result) {
      	                                // Do something with the response
      	                                alert("예약이 정상적으로 처리되었습니다.");
      	                            },
      	                            error: function(xhr, status, error) {
      	                                console.log(error);
      	                            }
      	                        });
      	                    }
      	                },
      	                error: function(xhr, status, error) {
      	                	if (xhr.status === 409) {
      	                	alert("이미 다른 고객님의 예약이 있습니다");
      	                	} else {
      	                    console.log(error);
      	                	}
      	                }
      	            });
      	        }
      	    },
      	    error: function(xhr, status, error) {
      	    	if (xhr.status === 409) {
		            alert("이미 예약이 존재합니다.");
		            reservationExists = true;
		        } else {
		            console.log(error);
		        }
      	    }
      	});
   	});
 });
     	        
		 </script>
 	 </body>
 </html>