import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class LikeMusic extends HttpServlet
{
Connection con=null;
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
int count=0;
PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body>");
String like=req.getParameter("like");
if ( req.getParameter("like")!= null)
{

	    RequestDispatcher rd=req.getRequestDispatcher("Music");
			rd.include(req,res);
			
			Connection con=DBInfo.getConnection();

String query="select * from countermusic ";
try
{
PreparedStatement ps = con.prepareStatement(query);
ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			count=(rs.getInt(1));
	        pw.println("<h3 align=\"bottom\"><font color=red>"+(rs.getInt(1))+"Likes</font></h3>");
              
			  }
			  }
			  catch (Exception e)
{
e.printStackTrace();
}
			    count++;  
			   con=DBInfo.getConnection();
              String query1="update countermusic set countermusic=?";
			  try
              {
             PreparedStatement ps = con.prepareStatement(query1);
             ps.setInt(1,count);
            ps.executeUpdate();
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