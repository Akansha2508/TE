import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UpdateValues extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body bgcolor=cyan>");
pw.println("<center>");
pw.println("<form method=post>");
String s1=req.getParameter("str");

Connection con=DBInfo.getConnection();
String query="select * from login where id=?";
try
{
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1,s1);
ResultSet rs=ps.executeQuery();
while(rs.next()) 
{
String userid=rs.getString(1);
String u=rs.getString(2);
String p=rs.getString(3);
String t=rs.getString(4);

pw.println("<BR>your id is:<input type=text readonly=true name=id value="+userid+">");
pw.println("<BR>your username is:<input type=text name=username value="+u+">");
pw.println("<BR>your new password is:<input type=text name=password value="+p+">");
pw.println("<BR>your new usertype is:<input type=text name=usertype value="+t+">");
}
}
catch(Exception e)
{
e.printStackTrace();
}
pw.println("<input type=submit>");
pw.println("</form>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");
DBInfo.close();
}

public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
int flag=0;
PrintWriter pw=res.getWriter();
String s1=req.getParameter("id");
String s2=req.getParameter("username");
String s3=req.getParameter("password");
String s4=req.getParameter("usertype");
pw.println("<html>");
pw.println("<body bgcolor=yellow>");
pw.println("<center>");

Connection con=DBInfo.getConnection();
String query="update login set password=?,usertype=? where id=?";
try
{
PreparedStatement ps=con.prepareStatement(query);
ps.setString(1,s3);
ps.setString(2,s4);
ps.setString(3,s1);
flag=ps.executeUpdate();
}
catch(Exception e)
{
e.printStackTrace();
}
if(flag==1)
{
pw.println("<h2>Record updated succesfully</h2>");
}
else
{
pw.println("<h2>Record updation failed<h2>");
}
pw.println("<BR><a href=DisplayRecords>BACK</a>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");
DBInfo.close();
}
}








