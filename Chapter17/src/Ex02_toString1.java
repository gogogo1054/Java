/*
toString()메서드
-Object클래스에 정의된 메서드로 println()이 문자열을 출력하기전에
자동으로 호출하는 메서드이다. 
-인스턴스 변수를 문자열 형태로 변환하여 반환해준다. 
-필요한 경우 클래스 정의시 적절히 오버라이딩하여 재정의하는것이 좋다.
단, 필수사항은 아니다. - Ex03
 */
public class Ex02_toString1
{
	public static void main(String[] args)
	{
		String name = "홍길동";
		System.out.println(name);
		System.out.println(name.toString());
	}
}
