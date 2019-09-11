<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="VerifyUser.java" method="get">
<hr>
<table  cellspacing="15px" >
<tr>
<td>Enter user Id</td>
<td><input type="text" name="userid"></td>
</tr>

<tr>
<td>Enter user password </td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>RememberMe	<input type="checkbox" name="save" value="yes" checked="checked" /></td>
</tr>
<tr>
<td>User Type</td>
<td>owner<input type="radio" name="utype" value="owner" checked="checked"/>buyer <input type="radio" name="utype" value="buyer"/></td>

</tr>
<tr>
<td colspan="2"><input type="submit" value="Login" ></td>
</tr>
</table>
<hr>
</form>
</body>
</html>