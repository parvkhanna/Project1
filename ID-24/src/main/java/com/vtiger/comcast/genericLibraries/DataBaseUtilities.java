package com.vtiger.comcast.genericLibraries;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtilities {
	static Driver driver;
	static Connection connection;
	static ResultSet result;
	
	/**
	 * This method will perform the mysql database connection
	 */
	public void connectDB()
	{
		try
		{
			driver = new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * this method will close the mysqlDatabase
	 * throws SQLException
	 */
	
	public void closeDB() throws SQLException
	{
		connection.close();
	}

}
