package datadriven_testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator
{
	public static void main(String[] args)
	{
		Random random = new Random();
		int r = 0;
		List<Integer> check = new ArrayList<Integer>();

		for (int i = 0; i < 1000; i++)
		{
			r = random.nextInt(1000);
			if (check.contains(r))
			{
				System.out.println("Already exists : " + r);
				continue;
			}
			System.out.println(r);
			check.add(r);
		}
		System.out.println("Unique numbers generated : "+check.size());
	}
}
