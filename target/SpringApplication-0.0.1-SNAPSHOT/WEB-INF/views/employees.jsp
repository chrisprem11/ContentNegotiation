<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Emp ID</td>
			<td>Employee Name</td>
			<td>Employee Department</td>
			<td>Employee Designation</td>
		</tr>
		<tr>
			<td>${emp.employeeId}</td>
			<td>${emp.employeeName}</td>
			<td>${emp.employeeDept}</td>
			<td>${emp.employeeDesignation}</td>
		</tr>
	</table>
</body>
</html>