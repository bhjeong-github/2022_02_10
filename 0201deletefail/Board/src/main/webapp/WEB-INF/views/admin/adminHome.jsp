<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<style>
table {
  border-collapse: collapse;
}
th, td {
  border: 1px solid black;
}
</style>
<%@include file="includes/header.jsp" %>
<div class="admin-content">
<div id="table-container">
<table>
  <thead>
    <tr>
      <th>Sell No</th>
      <th>Res No</th>
      <th>Date</th>
      <th>Title</th>
      <th>Style</th>
      <th>Price</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${salesData}" var="sale">
      <tr>
        <td>${sale.sellno}</td>
        <td>${sale.resno}</td>
        <td>${sale.date}</td>
        <td>${sale.title}</td>
        <td>${sale.style}</td>
        <td>${sale.price}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</div>
<div id="input-container">
    <label for="start">Start Date:</label>
	<input type="text" id="start">
	<label for="end">End Date:</label>
	<input type="text" id="end">
    <button id="update-button">Update</button>
</div>

</div>
<html>	
<head>
	<title>Admin Home</title>
</head>
<script>
	$(document).ready(function(){
		$.datepicker.setDefaults({
		    dateFormat: 'yy-mm-dd'
		});
		  $("#start").datepicker();
		  $("#end").datepicker();
	}); 
	$(function() {
		var csrfHeaderName ="${_csrf.headerName}"; 
      	var csrfTokenValue="${_csrf.token}";
        $(document).ajaxSend(function(e, xhr, options) {
//	           console.log("requestHeader...csrf");
        xhr.setRequestHeader(csrfHeaderName, csrfTokenValue); 
    	});
        var start = null;
        var end = null;	
        var updateButton = document.getElementById("update-button");
//    	$.getJSON("/admin/sellList/"+ start +"/"+ end ,
//    			function(data) {
// 		   		console.log(data);
		   		
//    	});
		$(updateButton).on("click", function() {
 		 	start = $("#start").val();
  			end = $("#end").val();
        $.getJSON("/admin/sellList/" + start + "/" + end, 
        		function(data) {
            $("#table-container").empty();
            var table = $("<table>");
            var thead = $("<thead>").appendTo(table);
            var tbody = $("<tbody>").appendTo(table);
            var tr = $("<tr>").appendTo(thead);
            tr.append("<th>SellNo</th>");
            tr.append("<th>ResNo</th>");
            tr.append("<th>Date</th>");
            tr.append("<th>Title</th>");
            tr.append("<th>Style</th>");
            tr.append("<th>Price</th>");
            $.each(data, function(i, sale) {
                var tr = $("<tr>").appendTo(tbody);
                tr.append("<td>" + sale.sellno + "</td>");
                tr.append("<td>" + sale.resno + "</td>");
                tr.append("<td>" + sale.date + "</td>");
                tr.append("<td>" + sale.title + "</td>");
                tr.append("<td>" + sale.style + "</td>");
                tr.append("<td>" + sale.price + "</td>");
            });
            $("#table-container").append(table);
        });
	});
});
</script>
<body>

</body>
</html>
