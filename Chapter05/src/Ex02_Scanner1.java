// Scanner 클래스 임포트. Ctrl+Shift+o => 자동입력 됨.
import java.util.Scanner;

public class Ex02_Scanner1
{
	public static void main(String[] args)
	{
		/*
		 Scanner클래스	
		 	: 사용자로부터 입력값을 받기위해 클래스로, 해당 클래스의
		 	메서드가 실행되면 잠깐 실행이 중지되고 입력을 기다린다.
		 	nextLine() : 문자열을 입력받는 메서드
		 	nextInt() : 정수를 입력받는 메서드
		 */
		Scanner sc = new Scanner(System.in);  // Scanner 객체 생성. 입력
		
		System.out.println("숫자를 1 2 3 이렇게 입력하고 엔터를 입력하세요.");
		// 입력대기
		// 공백(스페이스)이나 탭으로도 구분된다.
		int num1 = sc.nextInt();  
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		System.out.println("숫자를 1 입력하고 엔터를 입력하세요.");
		int num4 = sc.nextInt();
		System.out.println("숫자를 2 입력하고 엔터를 입력하세요.");
		int num5 = sc.nextInt();
		System.out.println("숫자를 3 입력하고 엔터를 입력하세요.");
		int num6 = sc.nextInt();
		
		System.out.printf("%d %d %d %d %d %d", num1, num2, num3, num4, num5, num6);
	}
}
