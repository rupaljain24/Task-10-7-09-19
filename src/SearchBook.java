

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

@WebServlet("/SearchBook.java")
public class SearchBook extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String s1= request.getParameter("searchBook");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/java";
			String db_uname = "root";
			String db_upass = "root";
			Connection con = DriverManager.getConnection(db_url, db_uname, db_upass);
			String q = "Select * from books where genre="+"'"+s1+"'";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery(q);
			PrintWriter out = response.getWriter();
			while (rs.next()) {
				out.println("<html>");
				out.println("<body>");
				out.println("<pre>");
				out.println("Book Id:"); 		out.println(rs.getInt(1));  out.println("<br>");
				out.println("Book Name:");		out.println(rs.getString(2));	out.println("<br>");
				out.println("Book Author:"); 	out.println(rs.getString(3));  out.println("<br>");
				out.println("Book Genre:");		out.println(rs.getString(4)); out.println("<br>");
				out.println("</pre>");
				out.println("</body>");
			out.println("</html>");
			
			
			}
	
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		
		
		}

}
