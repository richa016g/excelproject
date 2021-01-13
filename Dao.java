import java.sql.*;

class Dao
{
	public static Connection makeConnection()
	{
		Connection con = null;

		try
		{
			//step 1
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			//Class.forName("com.mysql.jdbc.Driver");
			
			//step 2
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","career"); 
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return con; 		
	}
}