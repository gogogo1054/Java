import java.util.InputMismatchException;
import java.util.Scanner;

/*
예외가 발생한 지점에서 예외를 직접 처리한다. 개발시 가장 많이
사용되는 방법으로 try~catch문을 통해 예외가 발생될수 있는 지점을
명시적으로 알수있다. 
 */
public class Ex02_TryCatch
{
	// Ex01문제를 try~catch문으로 예외 처리 하면 
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			int num1 = sc.nextInt();
			int num2 = 10 / num1;
			System.out.println(num2);
			System.out.println("Good bye~~!");
		}
		catch(ArithmeticException e)    // 0을 입력 했을 때 실행
		{
			String str = e.getMessage();
			System.out.println(str);
			if (str.equals("/ by zero"))
				System.out.println("0으로 나눌 수 없습니다.");
		}
		catch(InputMismatchException e)  // import 안하면 에러, 정수 값이 아니면 실행.
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
