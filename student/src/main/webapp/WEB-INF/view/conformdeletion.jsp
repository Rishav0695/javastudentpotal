<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
student to be deleted:<br><br>

${student}<br><br>

<form action="deleteconformation">

<input type="text"  name="ID" value="${ID}" readonly>
		<br>
		<input type="radio" id="yes" name="choice" value="yes">
		<label for="YES">YES</label><br>

		<input type="radio" id="no" name="choice" value="no">
		<label for="NO">NO</label><br>
<input type="submit">
</form>
</body>
</html>