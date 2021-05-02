<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<style>
			div{
				border-radius: 5px;
				background-color: #f2f2f2;
				padding: 20px;
				width: 40%;
			}
			input[type=text]{
				border-radius: 5px;
				width: 100%;
				border: 1px solid #ccc;
				padding: 16px 20px;
				margin: 10px;
				
			}
			input[type=submit]{
				border-radius: 5px;
				width: 100%;
				border: 1px solid #ccc;
				padding: 16px 20px;
				margin: 10px 30px;
				background-color: #96fb96;
			}
			input[type=reset]{
				border-radius: 5px;
				width: 100%;
				border: 1px solid #ccc;
				padding: 16px 20px;
				margin: 10px;
				background-color: #96eafb;
			}
		</style>
		
		<script>
			//$('form').validate();
		</script>
		<meta charset="ISO-8859-1">
		<title>Save Contacts</title>
	</head>
<body>
	<h2>Save Contacts</h2>
	<p><font color="green">${succMsg}</font></p>
	<p><font color="red">${errMsg}</font></p>
	<p><font color="green">${savedMsg}</font></p>
	<div>
		<form:form id="contactForm" action="save-contact" modelAttribute="contact" method="POST">
			<table>
				<tr>
					<form:hidden path="id"/>
					<td>Contact Name: </td>
					<td><form:input  path="name"/></td>
				</tr>
				<tr>
					<td>Contact Email: </td>
					<td><form:input  path="emailAddress"/></td>
				</tr>
				<tr>
					<td>Mobile No: </td>
					<td><form:input  path="mobileNo"/></td>
				</tr>
				<tr>
					<td><input type="reset" value="Reset"/></td>
					<td><input type="submit" value="Save"/></td>
				</tr>
			</table>
			<a href="all-contacts">View All Contacts</a>
		</form:form>
	</div>
	<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>
    <script type="text/javascript">
    $(function() {
          $("#contactForm").validate({
          rules: {
            name: {
              required: true
            },
            emailAddress: {
              required: true,
              email: true
            },
            mobileNo: {
              required: true
            }
          },
          messages: {
            name: {
              required: "Name is a required field!"
            },
            emailAddress: {
              required: "Email is a required field!",
              email: "A valid email address is required"
            },
            MobileNo: {
              required: "MobileNo is a required field!"
            }
              }
          });
    });
    </script>
</body>
</html>