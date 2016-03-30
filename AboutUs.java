import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AboutUs extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter pw=res.getWriter();

pw.println("<html>");
pw.println("<body bgcolor=cyan>");
pw.println("<body background=\"../(28).jpg\">");

pw.println("<div align=\"center\"><font color=\"red\" size=\"+2\" face=\"Arial, Helvetica, sans-serif\"><strong>");
pw.println("<h1><marquee>Talent Express..The Online Magazine</marquee></h2>");
pw.println("</strong>");
pw.println("</font></div>");

pw.println("<form>");
pw.println("<fieldset>");
pw.println("<legend><b>Contact Us<b></legend>");
pw.println("<p>");
pw.println("<i>Contact here<i><br>");
pw.println("<address>SKIT,Jaipur</address>");
pw.println("<address>email-skit@gmail.com</address><br>");
pw.println("<i>Thanks for visiting<i><br>");
pw.println("<a href=../Login.html>BACK</a>");
pw.println("</p>");
pw.println("</fieldset>");
pw.println("</form>");


pw.println("</body>");
pw.println("</html>");
}
}