<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/reservations3.css"/>
<script src = "/resources/vendor/jquery/jquery-3.6.3.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.5.0/main.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.5.0/main.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }
  .fc-daygrid-event-harness{cursor:pointer;}
  

</style>
  <script type="text/javascript">
  $(document).ready(function() {
	  var csrfHeaderName ="${_csrf.headerName}"; 
      var csrfTokenValue="${_csrf.token}";
      $(document).ajaxSend(function(e, xhr, options) {
//           console.log("requestHeader...csrf");
          xhr.setRequestHeader(csrfHeaderName, csrfTokenValue); 
    });
    var calendarEl = document.getElementById('calendar');
    var resno = null;
    var title = null;
    var start = null;
    var end   = null;
    var price = null
    var calendar = null;
   	$.getJSON("/calendar/event/" + resno,
		function(data) {
	   		calendar = new FullCalendar.Calendar(calendarEl, {
	   		headerToolbar: {
   	        left: 'prev,next today',
   	        center: 'title',
   	        right: 'dayGridMonth,timeGridWeek,timeGridDay'
			},
	        initialView: 'dayGridMonth',
	        locale:'ko',
	        selectable: true,
	        selectMirror: true,
	        editable: false,
	        events: data,
// 	        eventClick: function(calEvent, jsEvent) {
// 		           var title = prompt('일정 수정:', calEvent.title, {
// 		               buttons: {
// 		                   Ok: true,
// 		                   Cancel: false
// 		               }
// 		           });
// 	        }
	        eventClick: function(info) {
	        	alert(resno);
	        	$('#admin_modal').show();
	        	$('#modalSaveBtn').click(function(e) {
	        		$('#admin_modal').css("display", "none");
	        		console.log($('#price').val());
	        	$.getJSON("/calendar/sell/" + info.event.id,
	        			{price: $('#price').val()},
	        			function(data) {
	        	});
	        	alert("저장이 완료되었습니다.");
// 	                $('#admin_modal').show();
	                //css("display", "block");
				});
	        	$('#modalAdminDeleteBtn').click(function(e) {
	        		$('#admin_modal').css("display", "none");
	        		$.ajax({
    		            url : '/delete/' + info.event.id,
    		            type : 'DELETE',
		           		data : info.event.id,
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
	          }
	        
        }); // end var calendar
	       calendar.render();
	})// end function
			.fail(function(xhr, status, err) {
				if(error) {
					error();
				}
			});
 }); // end ready
 </script>
</head>
<body>

<div id='calendar'></div>
<div id="admin_modal">
        <div class="modal-visual-close"></div>
        <div class="admin-area">
             <h1 class="admin-head">예약관리(Admin)</h1>
             <div class="form-group" style="border-bottom:1px solid #d9d9d9">
                <dl>
                    <dt>시술 가격을 입력하세요.</dt>
                    <dd>
                        <input type= "text" class="form-stye" id="price" name="price"/>
                    </dd>
                </dl>
             </div>
             <div class="admin-top">
                    <button id='modalSaveBtn' type="button" class="button btn-primary btn-submit">저장</button>
                    <button id='modalAdminDeleteBtn' type="button" class="button btn-default">삭제</button>
             <div class="admin-bottom"></div>
        	</div>
        </div>
</div>
</body>
</html>