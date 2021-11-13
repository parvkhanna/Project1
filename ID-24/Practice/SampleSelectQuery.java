package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleSelectQuery {
	
	//for select 

	public static void main(String[] args) throws SQLException {
		
		
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//Connect to DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		// Create/Issue SQL Statement
		
		Statement stat = con.createStatement();
		
		//Execute the query
		
		ResultSet set = stat.executeQuery("select * from project");
		while(set.next())
		{
			System.out.println(set.getInt(1) + "\t"  + set.getString(2) + "\t" + set.getString(3) + "\t" + set.getString(4));
			
		}
		
		//Verify
		
		//Close the connection 
		
		con.close();
		
		

	}

}
