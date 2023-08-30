import java.util.InputMismatchException;
import java.util.Scanner;

/*
 예외가 발생한 지점에서는 처리하지 않고 던진다. 대신 메서드를 호출한
지점에서 예외객체를 받은 후 처리한다. 
 */
public class Ex09_ThrowsInMethod
{
	public static void myMethod1()
	{
		myMethod2();  //예외 넘어옴
	}
	
	public static void myMethod2()
			throws ArithmeticException, InputMismatchException
	{
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();   // 에러 발생 지점
		int num2 = 10 / num1;      // 에러 발생 지점
		System.out.println(num2);
	}
	
	public static void main(String[] args)
	{
		try
		{
			myMethod1();  //예외 넘어옴
		}
		catch(ArithmeticException | InputMismatchException e)
		{
			e.printStackTrace();
		}
		/*
		앞에서 예외가 발생하더라도 예외처리를 했으므로 프로그램은 
		끝까지 실행된 후 정상적으로 종료된다. 실행의 흐름이 마지막까지
		이어지게 하는것이 예외처리의 목적이다. 
		 */
		System.out.println("----------이건 실행이 되지요^^");
	}
}
