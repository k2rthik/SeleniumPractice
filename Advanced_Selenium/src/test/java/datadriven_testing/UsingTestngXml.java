package datadriven_testing;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class UsingTestngXml
{
	@Test
	public void testXml(XmlTest test)
	{
		System.out.println("Executed");
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("browser"));
	}
	
	@Test
	public void testXml2(ITestContext context)
	{
		System.out.println("Executed");
		System.out.println(context.getEndDate());
		System.out.println(context.getPassedConfigurations());
		System.out.println(context.getFailedConfigurations());
	}
}
