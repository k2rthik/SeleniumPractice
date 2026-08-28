package datadriven_testing;

import org.testng.annotations.Test;

public class RuntimeMavenPara
{
	@Test
	public void runtimeParameterTest()
	{
		System.out.println("testng test : "+System.getProperty("url"));
		System.out.println(System.getProperty("user"));
		System.out.println(System.getProperty("pw"));
		System.out.println(System.currentTimeMillis());
		//mvn -Dtest=RuntimeMavenPara test -Durl= -Duser= -Dpw=
	}
}
