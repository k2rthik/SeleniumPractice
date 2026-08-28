package datadriven_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class UsingDbaseToVerify
{
	@Test
	public void testData() throws SQLException
	{
		String product = "Laptop";
		boolean flag = false;

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_db", "root", "root");
				Statement state = conn.createStatement();
				ResultSet res = state.executeQuery("select * from products")	)
		{
			while (res.next())
			{
				String check = res.getString(2);
				if (check.equals(product))
				{
					flag = true;
					System.out.println(product + " is available");
				}
			}
		}

		if (!flag)
		{
			System.out.println(product + " is not available");
			Assert.fail();
		}
	}
}
