<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="blurBg-false" style="background-color: #EBEBEB">

	<link rel="stylesheet" href="/css/formoid-solid-blue.css"
		type="text/css" />
	<script type="text/javascript" src="/js/jquery.min.js"></script>
	<form action="insertCustomer" class="formoid-solid-blue"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post">
		<div class="title">
			<h2>Registration</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span></label>
			<div class="item-cont">
				<input class="large" type="text" name="name" required="required"
					placeholder="Name" /><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span></label>
			<div class="item-cont">
				<input class="large" type="text" name="address" required="required"
					placeholder="Address" /><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span></label>
			<div class="item-cont">
				<input class="large" type="text" name="mobile" required="required"
					placeholder="Mobile" /><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span></label>
			<div class="item-cont">
				<input class="large" type="text" name="emailid" required="required"
					placeholder="Email" /><span class="icon-place"></span>
			</div>
		</div>
		<div class="submit">
			<input type="submit" value="Submit" />
		</div>
	</form>
	<script type="text/javascript" src="/js/formoid-solid-blue.js"></script>



</body>
</html>
