import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Admin extends HttpServlet
{
Connection con=null;
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
String articlename="";
String article="";
PrintWriter pw=res.getWriter();
HttpSession session=req.getSession();
String str=(String)(session.getAttribute("id"));
pw.println("<html>");
pw.println("<body bgcolor=cyan>");
pw.println("<body background=\"../(7).jpg\">");
pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
pw.println("<div align=\"center\"><font color=\"red\" size=\"+2\" face=\"Arial, Helvetica, sans-serif\"><strong>");
pw.println("<h1><marquee>NETZINE..The Online Magazine</marquee></h2>");
pw.println("</strong>");
pw.println("</font></div>");
pw.println("<h1><u><b>ADMIN SECTION</b></u></h1>");
pw.println("<h1>Hello "+str+" </h1>");

pw.println("<font color=\"#F0F0F0\" size=\"+7\" face=\"Arial, Helvetica, sans-serif\"></font>");
pw.println("<font color=\"#FFFFFF\" face=\"Times New Roman, Times, serif\"></div>");
pw.println("<table width=\"963\" align=\"center\" cellspacing=\"10\" bgcolor=\"#000000\">");

  pw.println("<tr>");
 
pw.println("<td width=\"104\"><a style=\"text-decoration:none\" href=DisplayRecords><div align=\"center\"><font color=\"#FFFFFF\">DISPLAY PROFILES</font></div>  </a></td>");
pw.println("<td width=\"141\"><a style=\"text-decoration:none\" href=AddRecordsAdmin><div align=\"center\"><font color=\"#FFFFFF\">ADD PROFILES</font></div>  </a></td>");
pw.println("<td width=\"111\"><a style=\"text-decoration:none\" href=../Login.html><div align=\"center\"><font color=\"#FFFFFF\">HOME</font></div>  </a></td>");
pw.println("<td width=\"141\"><a style=\"text-decoration:none\" href=../Login.html><div align=\"center\"><font color=\"#FFFFFF\">SIGN OUT</font></div>  </a></td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</font>");

Connection con=DBInfo.getConnection();

String query="select * from article ";
try
{
PreparedStatement ps = con.prepareStatement(query);
ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			articlename=(rs.getString(1));
			article=(rs.getString(2));
			pw.println("<form>");
pw.println("<fieldset>");
	        pw.println("<legend>"+(rs.getString(1))+"</legend>");
			pw.println("<p>");
pw.println((rs.getString(2)));
pw.println("</p>");
pw.println("</fieldset>");
pw.println("</form>");
              
			  }
			  }
			  catch (Exception e)
{
e.printStackTrace();
} 



pw.println("<form method=post>");
pw.println("<fieldset>");
pw.println("Enter Article Name <input type=text  name= aname><BR>");
pw.println("Enter your article <input type=text  name= article><BR>");
pw.println("<BR> <input type=submit>");
pw.println("</fieldset>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
}
             
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
int flag=0;
String articlename="";
String article="";
String an=req.getParameter("aname");
String a=req.getParameter("article");
PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body bgcolor=yellow>");
pw.println("<body background=\"../(31).jpg\">");
con=DBInfo.getConnection();
String query="insert into article values(?,?)";

try
{
PreparedStatement ps = con.prepareStatement(query);

ps.setString(1,an);
ps.setString(2,a);
flag=ps.executeUpdate();
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 if(flag!=0 && flag!=0)
 {
 pw.println("<h3><font color=red>article loaded successfully!</font></h3>");
 }
 else
 {
 pw.println("<h3><font color=red>Article loading  failed!</font></h3>");
 }
 pw.println("<form method =\"get\">");
 pw.println("<BR><input type=submit value=BACK>");
 pw.println("</form>");
DBInfo.close();				 
pw.println("</body>");
pw.println("</html>");
}
}


