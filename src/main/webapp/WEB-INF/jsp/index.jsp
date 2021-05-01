<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Save Contacts</title>
	</head>
<body>
	<h2>Save Contacts</h2>
	<p><font color="green">${succMsg}</font></p>
	<p><font color="red">${errMsg}</font></p>
	<form:form action="save-contact" modelAttribute="contact" method="POST">
		<table>
			<tr>
				<td>Contact Name: </td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>Contact Email: </td>
				<td><form:input path="emailAddress"/></td>
			</tr>
			<tr>
				<td>Mobile No: </td>
				<td><form:input path="mobileNo"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"/></td>
				<td><input type="submit" value="Save"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>