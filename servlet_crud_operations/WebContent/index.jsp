


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet curd operations</title>
</head>
<body>
<h1>Add New Employee</h1>
<form action="saveServlet" method="post">
<table>
<tr>
<td><td>Name:<td/><input type="text" name="name"></td>
</tr>
<tr>
<td><td>Password<td/><input type="password" name="password"></td>
</tr>
<tr>
<td><td>Email<td/><input type="email" name="email"/></td>
</tr>
<tr>
<td><td>Country<td/><select name="country">
<option>India</option>
<option>USA</option>
<option>China</option>
</select> </td>
</tr>
<tr>
<td colspan="3">
<input type="submit" value="Save Employee"/><td/>
</tr>

</table>
</form><br/>
<a hreh="/ViewServlet">view employees</a>
</body>
</html>