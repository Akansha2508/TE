import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DisplayRecords extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{

PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body bgcolor=cyan>");
pw.println("<body background=\"../(3).jpg\">");
pw.println("<center>");
pw.println("<h1><u><b>List Of all profiles</b></u></h1>");
pw.println("<table border=0>");
pw.println("<tr>");
pw.println("<th>ID</th>");
pw.println("<th>Username</th>");
pw.println("<th>Password</th>");
pw.println("<th>Usertype</th>");
pw.println("<th>Update</th>");
pw.println("<th>Delete</th>");
pw.println("</tr");

Connection con = DBInfo.getConnection();
String query="select *from login";

try
{
PreparedStatement ps = con.prepareStatement(query);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
int id=rs.getInt(1);
String uname=rs.getString(2);
String pass=rs.getString(3);
String utype=rs.getString(4);

pw.println("<tr>");
pw.println("<td>"+id+"</td>");
pw.println("<td>"+uname+"</td>");
pw.println("<td>"+pass+"</td>");
pw.println("<td>"+utype+"</td>");
pw.println("<td><a href=UpdateValues?str="+id+">Update</a></td>");
pw.println("<td><a href=DeleteValues?str"+id+">Delete</a></td>");
pw.println("</tr>");
HttpSession session=req.getSession();
session.setAttribute("id1",id);
}
}
catch(Exception e)
{
e.printStackTrace();
}

pw.println("</table>");
pw.println("<BR><a href=Admin>BACK</a>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");
DBInfo.close();
}
}