<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<form action="/submitPerson" method="post">
Person Name<input type="text" name="name">
Person DOB<input type="date" name="dob">
<input type="submit" name="submit">
</form>
</fieldset>
</body>
</html>