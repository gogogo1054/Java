import java.util.Scanner;
import java.io.*;
import java.lang.*;


public class ThreadMain
{
	{
		System.out.println("숫자를 입력해 주세요.");
		Scanner s = new Scanner(System.in);
		String s_num = s.nextLine();
		int n_num = Integer.parseInt(s_num);
		
		try
		{
			Thread tsub = new ThreadSub(n_num);
			tsub.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("이름을 입력해 주세요.");
		String s_name = s.nextLine();
		System.out.println(s_name);
	}
}
