import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class CommentMusic extends HttpServlet
{
Connection con=null;
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
String comment="";

PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body>");
String c=req.getParameter("comment");

if ( req.getParameter("comment")!= null)
{

	    RequestDispatcher rd=req.getRequestDispatcher("Music");
			rd.include(req,res);
			Connection con=DBInfo.getConnection();
String query="insert into commentmusic values(?)";

try
{
PreparedStatement ps = con.prepareStatement(query);

ps.setString(1,c);
ps.executeUpdate();
}
catch (Exception e)
{
e.printStackTrace();
}


					
	

String query1="select * from commentmusic ";
try
{
PreparedStatement ps = con.prepareStatement(query1);
ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			comment=(rs.getString(1));
	        pw.println("<h3 align=\"bottom\"><font color=red>"+(rs.getString(1))+"<br></font></h3>");
              
			  }
			  }
			  catch (Exception e)
{
e.printStackTrace();
}              
                  DBInfo.close();				 
		 }
else
{
pw.println("not Liked");
}
pw.println("</body>");
pw.println("</html>");
}
}
