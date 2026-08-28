package basics;

import java.util.Date;
import java.util.UUID;

public class DateTime
{
	public static void main(String[] args)
	{
		String time = new Date().toString().replace(" ", "_").replace(":","-").substring(4, 19);
		System.out.println(time);
		System.out.println(new Date().toString());
		System.out.println(UUID.randomUUID().toString().substring(24));
		System.out.println(System.currentTimeMillis());
	}
}
