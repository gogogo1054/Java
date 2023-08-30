import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04_CatchConcat
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		/*
		예외가 발생할 수 있는 지역을 try문으로 먼저 묶어준다. 
		예외가 발생되면 JVM(자바가상머신)은 해당 예외에 관련된 객체를 
		만들어 프로그램쪽으로 전달한다. 이때 catch절에서 예외객체를 잡아
		주는것을 "예외처리"라고 한다.
		만약 예외객체를 잡아주지 못하면 프로그램을 비정상적인 종료로 
		이어지게된다.  
		 */
		try
		{
			/*
			예외가 발생되는 지점
			해당 코드가 실행될때 예외가 발생하게되고 JVM이 예외객체를 
			생성해서 프로그램으로 던진다(throw)
			 */
			int num1 = sc.nextInt();
			int num2 = 10 / num1;
			System.out.println(num2);
		}
		catch(ArithmeticException  | InputMismatchException e) // 여러개 예외 실행 가능
		{
			/*
			JVM이 throw한 예외객체를 catch절에서 잡아 처리한다. 
			그러면 예외가 발생되어도 프로그램의 실행은 유지된다. 
			 */
			// 간략한 설명을 출력한다.
//			System.out.println(e.getMessage());
			// 예외에 대한 디테일한 설명을 출력한다.(가장 많이 사용됨)
//			e.printStackTrace();
			// 개발자가 임의로 메세지를 출력한다. 
			System.out.println("예외 발생");
		}
		// 예외처리를 통해 실행의 흐름이 중단되지 않으므로 아래 문장은
		// 정상적으로 출력된다.
		System.out.println("Good bye~~!");
	}
}
