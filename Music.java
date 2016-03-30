import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Music extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body background=\"../(8).jpg\">");
pw.println("<div align=\"center\"><font color=\"brown\" size=\"+2\" face=\"Arial, Helvetica, sans-serif\"><strong>");
pw.println("<h1><marquee>NETZINE..The Online Magazine</marquee></h2>");
pw.println("</strong>");
pw.println("</font></div>");
pw.println("<font color=\"#F0F0F0\" size=\"+7\" face=\"Arial, Helvetica, sans-serif\"></font>");
pw.println("<font color=\"#FFFFFF\" face=\"Times New Roman, Times, serif\"></div>");
pw.println("<table width=\"963\" align=\"center\" cellspacing=\"10\" bgcolor=\"#000000\">");

  pw.println("<tr>");
 
pw.println("<td width=\"104\"><a style=\"text-decoration:none\" href=ArtImage><div align=\"center\"><font color=\"#FFFFFF\">Gallery</font></div>  </a></td>");
pw.println("<td width=\"111\"><a style=\"text-decoration:none\" href=Student><div align=\"center\"><font color=\"#FFFFFF\">Profile</font></div>  </a></td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</font>");
pw.println("<h2>Music..</h2>");
pw.println("<pre>");
pw.println("<blockquote>");
pw.println("<p>musick has a is a diverse range of human activities and the products of those activities,</p>");
pw.println("<p>usually involving imaginative or technical skill. In their most general form these activities</p>"); 
pw.println("<p>include the production of works of art, the criticism of art, the study of the history of art,</p>");
 pw.println("<p>and the aesthetic dissemination of art. This article focuses primarily on the visual arts,</p>"); 
 pw.println("<p>which includes the creation of images or objects in fields including painting, sculpture,</p>"); 
 pw.println("<p>printmaking, photography, and other visual media. Architecture is often included as one of the</p>");
 pw.println("<p>visual arts; however, like the decorative arts, it involves the creation of objects where</p>"); 
 pw.println("<p>the practical considerations of use are essential in a way that they usually are not in a</p>"); 
 pw.println("<p>painting<p>");
 pw.println("</blockquote>");
pw.println("</pre>");
pw.println("<form action=LikeMusic>");
pw.println("<input type=submit name=\"like\" value=\"like\">");
pw.println("</form>");
pw.println("<HR>");


pw.println("<form action=CommentMusic>");
pw.println("comment:<input type=text name=\"comment\" value=\"comment\">");
pw.println("<input type=submit>");
pw.println("</form>");



pw.println("</body>");
pw.println("</html>");

}

}

