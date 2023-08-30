import java.util.Scanner;

public class Ex08_WhyThrow
{
	public static void myMethod1()
	{
		try
		{
			myMethodA();   // 여기로 myMethod1으로부터 첫번째 예외가 넘어옴
		}
		catch(Throwable e)
		{
			System.out.println("에러 !!!");
		}
	}
	
	public static void myMethod2()
	{
		try
		{
			myMethodA();    // 여기로 myMethod1으로부터 두번째 예외가 넘어옴
		}
		catch(Throwable e)
		{
			System.out.println("Error !!!");
		}
	}
	
	public static void myMethodA()
	{
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();   // 에러 발생 지점
		int num2 = 10 / num1;      // 에러 발생 지점
		System.out.println(num2);
	}
	
	public static void main(String[] args)
	{
		myMethod1();
		myMethod2();
	}
}
