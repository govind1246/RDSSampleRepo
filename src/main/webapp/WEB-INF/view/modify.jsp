<%@page import="com.codetutr.bo.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Modify</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="pageJS.jsp" />
<jsp:include page="loadJS.jsp" />
</head>
<body class="blurBg-false" style="background-color: #EBEBEB">
	<%Customer customer = (Customer) request.getAttribute("modifyCustomer");%>

	<link rel="stylesheet" href="/css/formoid-solid-blue.css" type="text/css" />
	<script type="text/javascript" src="/js/jquery.min.js"></script>
	<form action="modifyCustomer" class="formoid-solid-blue"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px" method="post">
		<div class="title"> <h2>Modify</h2> </div>
		<div class="element-input">
			<label class="title"></label>
			<div class="item-cont">
				<input class="large" type="text" id="id" name="id" placeholder="Id"
					value="<%=customer.getId()%>" readonly /><span class="icon-place"></span>
			</div>
		</div>
		<jsp:include page="formElement.jsp" />
	</form>
	<script type="text/javascript" src="/js/formoid-solid-blue.js"></script>

	<script>
        P.when('jQuery').execute(function() {
	        $("#name").val('<%=customer.getName()%>')
	        $("#address").val('<%=customer.getAddress()%>')
	        $("#mobile").val(<%=customer.getMobile()%>)
	        $("#emailId").val('<%=customer.getEmailid()%>')
		});
	</script>
</body>
</html>


