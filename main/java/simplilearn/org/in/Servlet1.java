package simplilearn.org.in;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		out.print("<h1>Display the record</h1>");
		out.print("<table border='1'><tr><th> Id</th><th>Name</th><th> Price</th></tr></table>");
	    String url="jdbc:mysql://localhost:3306?user=root&password=Anusha@123";
		try {
		Class.forName("com.msql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select *from t12 where id="+id+"");
		while(rs.next())
		{
		out.print("<tr><td>");
		out.println(rs.getInt(1));
		out.print("</td>");
		out.print("<td>");
		out.println(rs.getString(2));
		out.print("</td>");
		out.print("<td>");
		out.println(rs.getInt(3));
		out.print("</td>");
		out.print("</tr>");		
			}}
		catch(Exception e) {
			
			System.out.println(e);
			
		}
		
	out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
