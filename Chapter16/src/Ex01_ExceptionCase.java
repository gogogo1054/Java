import java.util.Scanner;

public class Ex01_ExceptionCase
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		/*
		숫자를 0으로 나누면 무한대가 되므로 연산이 불가능하다.
		이처럼 연산불능 상태가 되었을때 예외가 발생된다. -> ArithmeticException
		nextInt()는 정수를 입력받기 위한 메서드인데 문자를 입력하는 경우
		발생되는 예외->InputMismatchException
		 */
		int num1 = sc.nextInt();   // 0 이면 에러가 나옴
		int num2 = 10 / num1;
		System.out.println(num2);
		
//		Mybook book1 = new MyBook(); // 일빈예외 문법적 오류가 없음.
		
		/* 추가 
		Syntax에러(구문에러)
		: 실행자체가 되지않는 코드로 오류를 수정해야만 정상적으로 실행된다. 
		즉 코드에 문법적인 오류가 발생되었음을 의미한다.  
		 */
//		Int number = 10; // -> int를 Int로 표기했음
//		if(true);
//		{}
//		else  // -> if문이 세미콜론으로 종료되어 의미없는 else문이 됨
//		{}
			
		 
		//위 코드를 정상적으로 수정하면 아래와같다. 
		int number = 10;
		if(true) {
			System.out.println("참이다");
		}
		else {
			System.out.println("거짓이다");
		}
	}
}
