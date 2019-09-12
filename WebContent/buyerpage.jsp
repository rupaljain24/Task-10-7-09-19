<%
String s=(String)session.getAttribute("uid");
if(s==null)
{
	response.sendRedirect("Home.jsp");
}

%>
<html>
<body>
	<h3>DashBoard-For-<%= s %></h3>
	<hr>
	<pre>
		<a href="SubjectPageCheck.jsp">Explore-Store</a>
		<a href="ShowBooks.jsp">Show all books</a>
		<a href="UpdateProfile.jsp">Update Profile</a>
		<a href="SearchBook.jsp">Search-Book</a>
		<a href="">View-Cart</a>
		<a href="">Trace-Order</a>
		<a href="">Logout</a>
	</pre>		
	<hr>
</body>
</html>