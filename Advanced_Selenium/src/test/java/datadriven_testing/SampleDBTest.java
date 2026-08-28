package datadriven_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleDBTest
{
	public static void main(String[] args) throws Throwable
	{
		//Step 1 : Register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2 : Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_db","root","root");
		System.out.println("Done");
		
		//Step 3 : Create SQL statement
		Statement state = conn.createStatement();
		
		//Step 4 : Execute the query and get the result
		ResultSet res = state.executeQuery("select * from products;");
		//Statement object executeUpdate method to run insert or update queries
		
		while(res.next())
		{
			System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
		}
		
		//Step 6 : Close the connection
		conn.close();		
	}
}
