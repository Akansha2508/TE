import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddRecordsAdmin extends HttpServlet
{
Connection con;
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{

PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body bgcolor=cyan>");
pw.println("<body background=\"../(3).jpg\">");
pw.println("<center>");
pw.println("<h2><b>Adding Profiles<b></h2>");
pw.println("<form method=post>");
pw.println("<pre>");
pw.println("<font color=blue size=+2>");
pw.println("Enter Name <input type=text name= name>");
pw.println("<BR>Enter Father's name <input type=text name= fname>");
pw.println("<BR>Enter Mobile no. <input type=text name= mobile>");
pw.println("<BR>Enter Email <input type=text name= email>");
pw.println("<BR>Choose Username <input type=text name= uname>");
pw.println("<BR> Enter Password <input type=password name= pass>");
pw.println("<BR>REenter Password <input type=password name=repass>");
pw.println("<BR>Select usertype<select name=usertype> ");
pw.println("</pre>");

con=DBInfo.getConnection();
String query="select * from usertype";
try
{
PreparedStatement ps = con.prepareStatement(query);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
String s1=rs.getString(2);
pw.println("<option value="+s1+">"+s1+"</option>");
}
}
catch (Exception e)
{
e.printStackTrace();
}
pw.println("</select>");
pw.println("<BR> <input type=submit>");
pw.println("</form>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");
}

public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter pw=res.getWriter();
pw.println("<html>");
String s1=req.getParameter("name");
String s2=req.getParameter("fname");
String s3=req.getParameter("mobile");
String s4=req.getParameter("email");
String s5=req.getParameter("uname");
String s6=req.getParameter("pass");
String s7=req.getParameter("repass");
String s8=req.getParameter("usertype");

String id="";
for(int i=0;i<5;i++)
{
id+=(int)(Math.random()*9)+1;
}

int flag=0,flag1=0;

con=DBInfo.getConnection();
String query="insert into registration values(?,?,?,?,?)";
String query1="insert into login values(?,?,?,?)";
try
{
PreparedStatement ps = con.prepareStatement(query);

ps.setString(1,id);
ps.setString(2,s1);
ps.setString(3,s2);
ps.setString(4,s3);
ps.setString(5,s4);
 flag=ps.executeUpdate();
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }

try
{
PreparedStatement ps = con.prepareStatement(query1);

ps.setString(1,id);
ps.setString(2,s5);
ps.setString(3,s6);
ps.setString(4,s8);

 flag1=ps.executeUpdate();
 }
 catch(Exception e)
 {
 e.printStackTrace();
 } 
 
 if(flag!=0 && flag!=0)
 {
 pw.println("<h3>Registration successfully done!</h3>");
 }
 else
 {
 pw.println("<h3>Registration failed!</h3>");
 }
 
 pw.println("<body bgcolor = red>");
 pw.println("<form method =\"get\">");
 pw.println("<BR><input type=submit value=BACK>");
 pw.println("</form>");
 pw.println("</body>");
 pw.println("</html>");
 }
 }
 