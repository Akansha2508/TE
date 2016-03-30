
import javax.servlet.http.*;
import java.io.*;
 import java.sql.*;
public class Login1 extends HttpServlet
{
Connection con=null;
String usertype="";
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
{
PrintWriter pw=res.getWriter();
String s1=req.getParameter("fname2");
String s2=req.getParameter("pass2");
HttpSession session=req.getSession();
session.setAttribute("id",s1);
pw.println("<html>");
pw.println("<body bgcolor=yellow>");
int flag=0;
Connection con=DBInfo.getConnection();
String query="Select *from login where username=? and password=?";
try
{
 
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1,s1);
ps.setString(2,s2);
ResultSet rs=ps.executeQuery();

while(rs.next())
{
flag=1;
usertype=rs.getString(4);
break;
}
}
catch (Exception e)
{
e.printStackTrace();
}
if(flag==1 && usertype.equalsIgnoreCase("admin"))
{

res.sendRedirect("Admin");
}

if(flag==1 && usertype.equalsIgnoreCase("student"))
{

res.sendRedirect("Student");
}

if(flag==1 && usertype.equalsIgnoreCase("moderator"))
{
res.sendRedirect("Moderator");
}

else 
{
pw.println("<center><h3><font color=red> Wrong username or password!</font></h3>");
pw.println("<a href=../Login.html>BACK</a>");
pw.println("</center>");
}
pw.println("</body>");
pw.println("</html>");
DBInfo.close();


}
}


