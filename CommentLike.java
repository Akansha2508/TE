import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class CommentLike extends HttpServlet
{
Connection con=null;
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
String comment="";
int count=0;
PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body>");
String c=req.getParameter("comment");
String like=req.getParameter("like");
if ( req.getParameter("comment")!= null && req.getParameter("like")!= null)
{
pw.println("not print if");
}
        else if(c.equals("comment"))
		{
	    RequestDispatcher rd=req.getRequestDispatcher("Art");
			rd.include(req,res);
			Connection con=DBInfo.getConnection();
String query="insert into comment values(?)";

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


					
	

String query1="select * from comment ";
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
		 
		 
else if(like.equals("like"))
{


	    RequestDispatcher rd=req.getRequestDispatcher("Art");
			rd.include(req,res);
			
			Connection con=DBInfo.getConnection();

String query="select * from counter ";
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
              String query1="update counter set counter=?";
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
  pw.println("not print");
  }

pw.println("</body>");
pw.println("</html>");
}
}
