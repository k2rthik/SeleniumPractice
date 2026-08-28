package datadriven_testing;

import java.util.Random;

public class RandomAlphaNumeric
{

	public static void main(String[] args)
	{
		String ans = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		int n = 20;
		Random random = new Random();
		
		StringBuilder sb = new StringBuilder(n);
		
		for(int i = 0;i<n;i++)
		{
			//int index = (int)(ans.length() * Math.random());
			int index = random.nextInt(ans.length());
			sb.append(ans.charAt(index));
		}
		System.out.println(sb);
		

	}

}
