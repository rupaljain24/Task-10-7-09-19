
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Download.java")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bookname = request.getParameter("choice");
		if(bookname.endsWith("pdf"))
			response.setContentType("application/pdf");
		else if(bookname.endsWith("doc"))
			response.setContentType("application/msword");	
		FileInputStream fis = new FileInputStream("E:/Books/"+bookname);
		byte b[] = new byte[fis.available()];
		fis.read(b);
		fis.close();
		ServletOutputStream out = response.getOutputStream();
		out.write(b);
		out.close();
		
		
		
		
		
	}


}
