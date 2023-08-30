/*
 가변 인자는 타입... 변수명과 같은 형식으로 선언하며, 
 PrintStream클래스의 printf()가 대표적인 예이다.
 ex) public PrintStream printf(String format, Object... args) { ... }
 */
public class Ex03_Vararg
{
	public static void helloEverybody(String... vargs) // 가변 인수 표시
	// ... 는 가변인자 vargs를 배욜의 참조변수로 간주
	{
		for (String s : vargs)	// 가변 인수 사용
			System.out.print(s + '\t');
		System.out.println();
		
	}
	public static void main(String[] args)
	{
		helloEverybody("홍길동");
		helloEverybody("홍길동", "전우치");
		helloEverybody("홍길동", "전우치", "손오공");
	}
}
