package com.comcast.crm.generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection conn; //declaring globally as it needs to be used in all methods
	
	
	public void getDbConnection(String url,String username,String password) throws SQLException
	{	
		try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection(url,username,password);
		} 
		catch(Exception e)
		{
			System.out.println("Handle the exception while getting connection");
		}
	}
	
	//**************************************************************
	public void getDbConnectionWithDefaultparameters() throws SQLException
	{	
		try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3309/test", "root", "root");
		} 
		catch(Exception e)
		{
			System.out.println("Handle the exception while getting connection");
		}
	}
	//***************************************************************
	
	public void closeDBConnection() throws SQLException
	{
		try {
		conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Handle exception while closing connection");
		}
	}
	
	//************************************************************
	public ResultSet executeSelectQuery(String query) throws Throwable
	{
		ResultSet resultSet = null;
		try {
		Statement stat = conn.createStatement();
		resultSet = stat.executeQuery(query);
		}
		catch(Exception e)
		{
			System.out.println("Handle the exception in select query method");
		}
		return resultSet;
	}
	
	//******************************************************************
	
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try
		{
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
		}
		catch(Exception e)
		{
			System.out.println("Handle exception in NonSelectQuery method");
		}
		return result;
	}
	
	//***********************************************************************
}
