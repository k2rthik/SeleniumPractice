package basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics
{
	public static void main(String[] args)
	{
		Date date = new Date();
		
		SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-dd");
		String startDate = sd.format(date);
		System.out.println(startDate);
		
		Calendar cal = sd.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String endDate = sd.format(cal.getTime());
		System.out.println(endDate);
		
		String s = "Karthihghghk";
		
		String p = s.substring((s.length()/2)-1,(s.length()/2)+1);
		
		System.out.println(p);
		
	}
}
