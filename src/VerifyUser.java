import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VerifyUser.java")
public class VerifyUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		String uname = config.getInitParameter("username");
		String upass = config.getInitParameter("password");

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String utype = request.getParameter("utype");
		try {
			if (utype.equals("owner")) {
				if (userid.equals(uname) && password.equals(upass)) {
					response.sendRedirect("adminpage.jsp");
				} else {
					out.println("INVALID CREDENTIALS FOR ADMIN");
				}
			} else {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
				String sql = "SELECT name FROM USER where id=? AND password=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userid);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {

					HttpSession session = request.getSession();
					session.setAttribute("uid", userid);

					// whether user want to save the password
					String choice = request.getParameter("save");
					if (choice != null) {

						Cookie c1 = new Cookie("id", userid);
						Cookie c2 = new Cookie("pw", password);

						c1.setMaxAge(60 * 60 * 24 * 7);
						c2.setMaxAge(60 * 60 * 24 * 7);

						response.addCookie(c1);
						response.addCookie(c2);

					}

					// response.sendRedirect("buyerpage.jsp");
					RequestDispatcher rd = request.getRequestDispatcher("buyerpage.jsp");
					rd.forward(request, response);

				} else {
					out.println("INVALID BUYER CREDENTIALS");
				}
				con.close();
			}
		} catch (Exception e) {
			out.println(e);
		}
	}

}