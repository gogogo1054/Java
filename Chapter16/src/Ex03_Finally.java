import java.util.InputMismatchException;
import java.util.Scanner;

/*
finally절
: 예외발생과 상관없이 try문으로 진입했을때 반드시 실행해야 할 코드가
있는경우 기술하는 블럭이다. 즉 try문으로 진입되지 않는다면 finally절은
실행되지 않는다. 
1. try~catch : 예외를 직접 처리할때
2. try~catch~finally : 예외를 직접 처리후 실행할 문장이 있을때
3. try~finally : 예외는 외부로 던지고 예외발생과 상관없이 실행할 
	문장이 있을때
 */
public class Ex03_Finally
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			int num1 = sc.nextInt();
			int num2 = 10 / num1;
			System.out.println(num2);
		}
		catch(ArithmeticException e)
		{
			String str = e.getMessage();
			System.out.println(str);
			if (str.equals("/ by zero"))
				System.out.println("0으로 나눌 수 없습니다.");
		}
		catch(InputMismatchException e)  //
		{
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		finally   // 예외가 무조건 실행 함
		{
			/*
			try절에서 예외가 발생하더라도 혹은 return을 만나게되도
			finally절은 실행된다. 
			 */
			System.out.println("Good bye~~!");
		}
	}
}
