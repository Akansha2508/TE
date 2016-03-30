import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Search extends HttpServlet
{
Connection con=null;
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
String articlename="";
String article="";
PrintWriter pw=res.getWriter();
String s=req.getParameter("searcharticle");
pw.println("<html>");
pw.println("<body bgcolor=cyan>");
pw.println("<body background=\"../(28).jpg\">");
pw.println("<div align=\"center\"><font color=\"red\" size=\"+2\" face=\"Arial, Helvetica, sans-serif\"><strong>");
pw.println("<h1><marquee>NETZINE..The Online Magazine</marquee></h2>");
pw.println("</strong>");
pw.println("</font></div>");
System.out.println(s+"---");


 
 Connection con=DBInfo.getConnection();

String query="select * from article where articlename like ?";
try
{
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1,s);
ResultSet rs=ps.executeQuery();

			System.out.println("after resultset");
			while(rs.next())
			{
			System.out.println("in while block");
			articlename=(rs.getString(1));
			article=(rs.getString(2));
	         pw.println("<form>");
pw.println("<fieldset>");
	        pw.println("<legend>"+(rs.getString(1))+"</legend>");
			pw.println("<p>");
pw.println((rs.getString(2)));
pw.println("</p>");	
			}
			}
catch (Exception e)
{
e.printStackTrace();
}		
 


pw.println("<hr>");
pw.println("<a href=Student>BACK</a>");
pw.println("</p>");
pw.println("</fieldset>");
pw.println("</form>");

pw.println("<section id='copyright' class='dark_section' style='margin-top:200px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. Road Ahead Technologies(India) Pvt. Ltd.</p></div></div></div></section>");
pw.println("</body>");
pw.println("</html>");
}
}