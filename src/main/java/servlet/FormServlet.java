package servlet;

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

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String n = request.getParameter("user_name");
		String p = request.getParameter("user_password");
		String e = request.getParameter("user_mail");
		String c = request.getParameter("user_country");
		try {
			Class.forName("com.mssql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jbdc:mysql://localhost:3306/javadb","root","root");
			
		   PreparedStatement ps = conn.prepareStatement("insert into register values(?,?,?,?)"); 
		   
		   ps.setString(1, n);
		   ps.setString(2, p);
		   ps.setString(3, e);
		   ps.setString(4, c);
    
		   int i = ps.executeUpdate();
		   if(i > 0) {
			   out.print("<h2>You are registered Successfully</h2>");
		   }
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		out.close();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

}
