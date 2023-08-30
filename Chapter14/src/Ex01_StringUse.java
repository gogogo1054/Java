public class Ex01_StringUse
{
	public static void main(String[] args)
	{
		/*
		String클래스의 객체생성방법
		: new를 이용한다. new를 통해 문자열 객체(인스턴스)를 생성하면
		동일한 문자열이라도 항상 새로운 메모리를 할당하게된다. 
		 */
		String str1 = new String("자바프로그래밍");
		String str2 = new String("자바프로그래밍");
		/*
		String클래스의 객체 생성방법2
		: "(더블쿼테이션)을 사용한다. 이 경우 내용이 동일하다면 같은
		주소를 사용한다. 즉 새로운 메모리를 할당하지 않는다. 
		따라서 String객체는 주로 방법2를 사용하는것이 좋다.
		 */
		String str3 = "자바프로그래밍";
		String str4 = "자바프로그래밍";
		
		System.out.println((str1));
		System.out.println((str2));
		System.out.println((str3));
		System.out.println((str4));
		
		// 문자열은 문자와 달리 내용 없이 다음과 같이 사용할 수 있습니다.
		String str5 = "";
	}
}
