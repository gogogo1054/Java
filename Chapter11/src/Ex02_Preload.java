/*
mainO보다 먼저 실행
 */
// 인스턴스 생성과 관계 없이 static 변수가 메모리 공간에 할당될 때 실행이 된다.
import java.util.Random;	// 임포트

public class Ex02_Preload
{
	static int num;		// 스태틱 멤버 변수
	
	/*
	static 블럭
		: 동일 클래스내 main() 메서드보다 먼저 실행되는 블럭으로 
		main메서드의 실행코드가 없어도 먼저 실행된다.
		또한 생성자보다 먼저 static블럭이 실행된다.
		static블럭내에서 선언된 변수는 지역변수이므로 main메서드에서는
		사용할 수 없다. 해당 지역에서만 사용할 수 있다.
	 */
	static
	{
		Random rand = new Random();		
		// main 실핼 전에 이미 난수값이 대입이 된다.
		// 블럭내에서 정적멤버변수에 접근할 수 있다.
		num = rand.nextInt(100);		
	}	
	
	public static void main(String[] args)		
	{
		System.out.println(num);		
	}
}
