<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>All Contacts</title>
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript">
			$(document).ready( function () {
			    $('#contactsTable').DataTable(/*{
					"order":[[1,"asc"],[3,"desc"]]
				    }*/);
			} );
		
			function confirmDelete(){
				return confirm("are you sure, you want to delete?");
			}
		</script>
	</head>
<body>
	<h2>All Contacts</h2>
	<p><font color="green">${deletedMsg}</font></p>
	<p><font color="red">${deletedFailMsg}</font></p>
	<a href="contacts">Add Contact</a>
	<table border="1" id="contactsTable">
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
					<td>${contact.name}</td>
					<td>${contact.emailAddress}</td>
					<td>${contact.mobileNo}</td>
					<td>
						<a href="edit-contact?id=${contact.id}">Edit</a>
						<a href="delete-contact?cid=${contact.id}" onclick="confirmDelete()">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>