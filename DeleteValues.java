import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DeleteValues extends HttpServlet
{
  
   public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException
   {
    int flag=0,flag1=0;
     PrintWriter pw=res.getWriter();
	 String s1=req.getParameter("str");
	
	 pw.println("<html>");
	 pw.println("<body bgcolor=yellow>");
	 pw.println("<center>");
	
	 
	 
	
	 Connection con=DBInfo.getConnection();
	 String query="delete from login where id=?";
	 String query1="delete from registration where id=?";
	 try
		 {
		 PreparedStatement ps=con.prepareStatement(query);
		 
		 ps.setString(1,s1);
		 flag= ps.executeUpdate();
		
		 }
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 }
	 try
		 {
		 PreparedStatement ps=con.prepareStatement(query1);
		 ps.setString(1,s1);
		flag1= ps.executeUpdate();
		
		 }
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 }
	 if(flag==1 && flag1==1)
	 {
	 pw.println("<h3>Record deleted!</h3>");
	 }
	 else
	 {
	 pw.println("<h3>Record Not deleted!</h3>");
	 }
	 
	 pw.println("<BR><a href=DisplayRecords>BACK</a>");
	
	 pw.println("</center>");
	 pw.println("</body>");
	 pw.println("</html>");
	 DBInfo.close();
	 
   }
    
}