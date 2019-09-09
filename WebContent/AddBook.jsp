<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<form action="AddBooks.java" method="post">
<h1><b>Add New Books</b></h1>
<hr>
<table  cellspacing="15px" >
<tr>
<td>Enter Book Code</td>
<td><input type="text" name="bookId"></td>
</tr>

<tr>
<td>Enter book name </td>
<td><input type="text" name="bookName"></td>
</tr>
<tr>
<td>Enter book Author name</td>
<td><input type="text"  name="bookAuthor"></td>
</tr>
<tr>
<td>Enter book Genre</td>
<td><input type="text" name="bookgenre"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Insert" ></td>
</tr>
</table>

</form>
</body>
</html>