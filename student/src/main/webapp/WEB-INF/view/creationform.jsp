<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>student creation form</title>
</head>
<body>
enter student details:
<form action="createsubmission" method="GET">
	
		<input type="text" name="name" placeholder="name" />
		<br><br>
		<input type="text" name="phonenumber" placeholder="phone number" />
		<br><br>
		<input type="radio" id="male" name="gender" value="male">
		<label for="YES">male</label>
		&nbsp;
		<input type="radio" id="female" name="gender" value="male">
		<label for="NO">female</label><br>
		<br>
		<br><br>
		Do you want to enter address:
		<br><br>		
		<input type="radio" id="yes" name="choice" value="yes">
		<label for="YES">YES</label>
		&nbsp;
		<input type="radio" id="no" name="choice" value="no">
		<label for="NO">NO</label><br>
		<br>
		<input type="text" name="housenumber" placeholder="housenumber" />
		&nbsp;&nbsp;
		<input type="text" name="street" placeholder="street" />
		<br><br>
		<input type="text" name="city" placeholder="city" />
		&nbsp;&nbsp;
		<input type="text" name="country" placeholder="country" />
		<br><br>
		<input type="text" name="pincode" placeholder="pincode" />
		<br><br><br>
		
		
		<input type="submit" />
			
	</form>
</body>
</html>