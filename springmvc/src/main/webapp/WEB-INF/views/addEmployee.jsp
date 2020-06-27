<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg=(String) request.getAttribute("msg");
    String errMsg=(String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./addEmp" method="post">
   Employee Id:<input type="number" name="empId">
	Employee Name:<input type="text" name="empName">
	Employee Age:<input type="text" name="age">
	Employee Salary:<input type="number" name="salary">
	Employee Designation:<input type="text" name="designation">
	Employee Password:<input type="text" name="password">
	<input type="submit" name="Submit">
</form>
<%if(msg !=null ){ %>
<h3 style="color: green;">Employee added for<%=msg%></h3>

<% }%>
<%if(errMsg!=null && !errMsg.isEmpty()){ %>
<h2 style="color: red;"><%=errMsg %></h2>
<%} %>
</body>
</html>