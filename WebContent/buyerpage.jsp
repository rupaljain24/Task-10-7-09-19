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
		<a href="SubjectPageServlet">Explore-Store</a>
		<a href="">Search-Book</a>
		<a href="">View-Cart</a>
		<a href="">Trace-Order</a>
		<a href="">Logout</a>
	</pre>		
	<hr>
</body>
</html>