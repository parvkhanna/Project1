package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_nonSelectQuery {

	public static void main(String[] args) throws Throwable{
		
		Connection con = null;
		try
		{ 
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			//step 2 connect to db 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db" , "root" , "root");
			
			//step3 create/issue sql statement
			Statement stat = con.createStatement();
			
			//step4 execute the query
			int result = stat.executeUpdate("insert into student values(2, 'raja' , 'Shekhar' , 'rajshekhar@aol.com')");
			if(result==1)
				
			{
				System.out.println("Student is created");
			}
		}
			catch(Exception e)
			{
				System.err.println("Student not created----!!!");
			}
			
			finally
			{
				con.close();
				System.out.println("======= close connection =============");
			}
			
		}
	

}
