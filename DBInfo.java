import java.sql.DriverManager;
import java.sql.*;

public class DBInfo
{
static Connection con;
static
{
	//driver installation
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(ClassNotFoundException e)
	{
	e.printStackTrace();
	}
}
public static Connection getConnection()
{
	//connection establishment
	String url="jdbc:mysql://localhost:3306/magazinedb";
	String uname="root";
	String pass="rat";
	try
	    {
		con=(Connection)DriverManager.getConnection(url,uname,pass);
		}
	catch(SQLException e)
	    {
		e.printStackTrace();
		}
	return con;
	}
public static void close()
{
	try
	     {
		con.close();
	     }
   catch(Exception e)
		    {
			e.printStackTrace();
			}
}

}
