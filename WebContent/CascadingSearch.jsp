<%@page import="java.sql.*" %>
<% 
String name=(String)session.getAttribute("uid");
%>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
String sql = "SELECT distinct genre from books";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
String choices[]=request.getParameterValues("c");




%>

<html>
<body>
<form action="SubjectPageCheck.jsp">
<h1>welcome <%=name %></h1>
<h3>Select the Desired Subject to view books</h3>
<hr>


<% while(rs.next())
	{
	String s1=rs.getString(1);

%>

<input type="checkbox" name="c" multiple="multiple" value=<%=s1 %>><%=s1 %>




<%
    }
%>
<input type="submit" value="Search Books">
<hr>
</form>


<%
if(choices!=null)
{
	String sql2 = "select * from books where genre in (";
	for(int i=0;i<choices.length;i++)
	{
		sql2 = sql2 +"'"+ choices[i]+"'" ;
		if(i!=choices.length-1)
		{
			sql2 = sql2 + ",";
		}
		
	}
	sql2 = sql2 + ")"; 
	%>
	
	<%
	
	ps=con.prepareStatement(sql2);
	rs=ps.executeQuery();
	
		while (rs.next()) {
			String s1 = rs.getString(1);
			String s2 = rs.getString(2);
			String s3 = rs.getString(3);
			String s4 = rs.getString(4);
			int s5 = rs.getInt(5);
	
			
%>

	<%=s2 %>		
<%		
	}
}



%>
<a href=SubjectPageServlet>Subject-Page</a>
<a href=buyerpage.jsp>Buyer-Page</a>
<% 
     con.close();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
%>
		
		
</body>
</html>
		