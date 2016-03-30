import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ContactUs extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter pw=res.getWriter();
ServletContext sc=req.getServletContext();
	 res.setContentType("text/html");
	 

 pw.println("<!DOCTYPE html>");
	 pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
	 pw.println("<head>");
	 pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"iso-8859-1\" />");
	 pw.println("<title></title>");
   

//use single quotes instead of double quotes for simplicity

	 pw.println("<link rel='stylesheet' href='../css/bootstrap.css'><link rel='stylesheet' href='../css/animations.css'><link rel='stylesheet' href='../css/main.css'>");
	
     pw.println("<script src='../js/vendor/modernizr-2.6.2.min.js'></script>");

     pw.println("</head>");

	 
	 
	 
pw.println("<body bgcolor=cyan>");
pw.println("<body background=\"../(28).jpg\">");

pw.println("<div align=\"center\"><font color=\"red\" size=\"+2\" face=\"Arial, Helvetica, sans-serif\"><strong>");
pw.println("<h1><marquee>TALENT EXPRESS..The Online Magazine</marquee></h2>");
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

pw.println("<section id='copyright' class='dark_section' style='margin-top:200px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. Road Ahead Technologies(India) Pvt. Ltd.</p></div></div></div></section>");
pw.println("</body>");
pw.println("</html>");
}
}