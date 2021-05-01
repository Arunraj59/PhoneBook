<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>All Contacts</title>
	</head>
<body>
	<h2>All Contacts</h2>
	<a href="contacts">Add Contact</a>
	<table>
		<thead>
			<tr>
				<th>SNo</th>
				<th>Name</th>
				<th>Email</th>
				<th>MobileNo</th>
				<th>Operation</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="contact" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<%-- <td>${contact.name}</td> --%>
					<td>${contact.emailAddress}</td>
					<td>${contact.mobileNo}</td>
					<td>
						<a href="">Edit</a>
						<a href="">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>