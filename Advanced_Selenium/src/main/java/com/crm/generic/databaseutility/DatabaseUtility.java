package com.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility
{
	Connection conn;
	//public void getConnection(String url, String username, String password)
	public void getConnection()
	{
		
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_db", "root", "root");
		} catch (Exception e)
		{
				System.err.println("Unable to connect to DB");
		}
	}
	
	public void closeConnection()
	{
		try
		{
			conn.close();
		} catch (Exception e)
		{}
	}
	
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet result = null;
		try
		{
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query)
	{
		int result = 0;
		try
		{
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e)
		{		}
		return result;
	}
	
	public static void main(String[] args) throws SQLException
	{
		DatabaseUtility du = new DatabaseUtility();
		du.getConnection();
		du.executeNonSelectQuery("insert into products values (6,'Bleh',120312);");
		ResultSet result = du.executeSelectQuery("select * from products");
		
		while(result.next())
		{
			System.out.println(result.getString(2));
		}
		du.closeConnection();
	}
}
