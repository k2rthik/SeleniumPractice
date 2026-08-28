package com.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandom()
	{
		Random ran = new Random();
		int num = ran.nextInt(1000);
		return num;
	}
	
	public String getDateYYYYMMDD()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String date = sdf.format(d);
		return date;
	}
	
	public String requiredDate(int days)
	{
		Date d = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-dd");
		sd.format(d);
		
		Calendar cal = sd.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String date = sd.format(cal.getTime());
		return date;
	}
	
	public static void main(String[] args)
	{
		JavaUtility ju = new JavaUtility();
		System.out.println(ju.getDateYYYYMMDD()+" = "+ju.getRandom()+" = "+ju.requiredDate(30));
	}
}
