<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="employeeCreate" method="get">
<fieldset>

<legend>CreateEmployeeForm</legend>
EmployeeFirstName: <input type="text" name=firstName /> 
EmployeeLastName: <input type="text" name=lastName /> <br />
EmployeeID: <input type="text" name=employeeID /> 
PassWord: <input type="text" name=passWord /> <br />

<button name=submit>button</button>

</fieldset>

</form>

</body>
</html>