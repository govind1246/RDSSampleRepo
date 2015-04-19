<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Details</title>
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="http://cdn.datatables.net/responsive/1.0.5/css/dataTables.responsive.css">
<script type="text/javascript" src="http://cdn.datatables.net/responsive/1.0.5/js/dataTables.responsive.js"></script>
</head>
<body>
	<form action="insertCustomer" method="post">
		    <table id="myTable" class="display nowrap" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>ENO</th>
						<th>EMPName</th>
						<th>Country</th>
						<th>Salary</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>001</td>
						<td>Anusha</td>
						<td>India</td>
						<td>10000</td>
					</tr>
					<tr>
						<td>002</td>
						<td>Charles</td>
						<td>United Kingdom</td>
						<td>28000</td>
					</tr>
					<tr>
						<td>003</td>
						<td>Sravani</td>
						<td>Australia</td>
						<td>7000</td>
					</tr>
					<tr>
						<td>004</td>
						<td>Amar</td>
						<td>India</td>
						<td>18000</td>
					</tr>
					<tr>
						<td>005</td>
						<td>Lakshmi</td>
						<td>India</td>
						<td>12000</td>
					</tr>
					<tr>
						<td>006</td>
						<td>James</td>
						<td>Canada</td>
						<td>50000</td>
					</tr>

					<tr>
						<td>007</td>
						<td>Ronald</td>
						<td>US</td>
						<td>75000</td>
					</tr>
					<tr>
						<td>008</td>
						<td>Mike</td>
						<td>Belgium</td>
						<td>100000</td>
					</tr>
					<tr>
						<td>009</td>
						<td>Andrew</td>
						<td>Argentina</td>
						<td>45000</td>
					</tr>

					<tr>
						<td>010</td>
						<td>Stephen</td>
						<td>Austria</td>
						<td>30000</td>
					</tr>
					<tr>
						<td>011</td>
						<td>Sara</td>
						<td>China</td>
						<td>750000</td>
					</tr>
					<tr>
						<td>012</td>
						<td>JonRoot</td>
						<td>Argentina</td>
						<td>65000</td>
					</tr>
				</tbody>
			</table>
	</form>
	<script>
        $(document).ready(function(){
        	$('#myTable').DataTable( {
                responsive: true
            } );
        });
    </script>
</body>
</html>