<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Details</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="/css/dataTables.responsive.css">
<jsp:include page="pageJS.jsp"/>
<jsp:include page="loadJS.jsp"/>
<script>
P.when('jQuery').execute(function($){
	loadJS('/js/jquery.dataTables.min.js', function() {
	    P.register('dataTables');
	});
	loadJS('/js/dataTables.responsive.js', function() {
	    P.register('dataTablesResponsive');
	});
});
</script>    
</head>
<body>
	<form action="insertCustomer" method="post">
	        <!--  https://datatables.net/extensions/responsive/examples/display-control/classes.html -->
		    <table id="myTable" class="display responsive" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th class="min-tablet">Id</th>
						<th class="all">Name</th>
						<th class="desktop" >Address</th>
						<th class="min-tablet">Mobile</th>
						<th class="min-phone-l">Emailid</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
	</form>
    	<script>
        P.when('jQuery','dataTables','dataTablesResponsive').execute(function(){
            $(document).ready(function(){
            	$.getJSON("/customer", {}, function(data) {
                    var waitListTable = $("#myTable").DataTable();
                    waitListTable.clear().draw();
                    for (var i = 0; i < data.length; i++) {
                  	  var item = [data[i]["id"],data[i]["name"],data[i]["address"],data[i]["mobile"],data[i]["emailid"]];
                      waitListTable.row.add(item).draw();
                    }
                  });
            });
        });
        P.when('jQuery').execute(function(){
           
        });
        </script>
</body>
</html>