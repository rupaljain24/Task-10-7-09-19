

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

@WebServlet("/AddBooks.java")
public class AddBooks extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s1= request.getParameter("bookId");
		String s2= request.getParameter("bookName");
		String s3= request.getParameter("bookAuthor");
		String s4= request.getParameter("bookgenre");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/java";
			String db_uname = "root";
			String db_upass = "root";
			Connection con = DriverManager.getConnection(db_url, db_uname, db_upass);
			PreparedStatement st = con
					.prepareStatement("insert into books(id,name,author,genre)values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
			// Statement st=con.createStatement();
			st.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println("Data Added into Table");
			
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		
		
		
		}

}
