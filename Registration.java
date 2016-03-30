import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Registration extends HttpServlet
{
Connection con;
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{

PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body bgcolor=cyan>");
pw.println("<center>");
pw.println("<div>");
pw.println("<h1><u><b>Enter The Information</b></u></h1>");
pw.println("</div>");
pw.println("<form method=post>");
pw.println("<pre>");
pw.println("<font color=blue size=+2>");
pw.println("Enter Name <input type=text size=15 name= name><BR>");
pw.println("Enter Father's name <input type=text size=15 name= fname><BR>");
pw.println("Enter Mobile no. <input type=text size=15 name= mobile><BR>");
pw.println("Enter Email <input type=text size=15 name= email><BR>");
pw.println("Choose Username <input type=text size=15 name= uname><BR>");
pw.println(" Enter Password <input type=password size=15 name= pass><BR>");
pw.println("Renter Password <input type=password size=15 name=repass><BR>");
pw.println("usertype is<input type=text size=15 readonly=true name=usertype value=STUDENT> ");
pw.println("</pre>");


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
 pw.println("<h3><font color=red>Registration successfully done!</font></h3>");
 }
 else
 {
 pw.println("<h3><font color=red>Registration failed!</font></h3>");
 }
 
 pw.println("<body bgcolor = yellow>");
 pw.println("<form method =\"get\">");
 pw.println("<BR><input type=submit value=BACK>");
 pw.println("</form>");
 pw.println("</body>");
 pw.println("</html>");
 }
 }
 