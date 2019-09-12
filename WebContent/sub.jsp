<%@page import="java.sql.*" %>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
String sql = "SELECT distinct genre from books";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
%>
<html>
<body>
<form action="SubjectpageServlet">
<% while(rs.next())
	{
	String s1=rs.getString(1);

%>
<%=s1 %><input type="checkbox" name="c">
<%} %>
</form>
</body>
</html>