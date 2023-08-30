public class Ex03_TypeChange2
{
	// 에러가 나는 것을 보는 예제
	public static void main(String[] args)
	{
		int num1 = 2147483647;   // 2^16 => 0~2147483647 디폴트가 int
//		int num2 = 2147483648; // 범위를 초과해서 에러남
		// 2147483648 PC는 이 값자체가 int로 인식함.
//		long num3 = 2147483648; 
		long num4 = 2147483648L;  // 뒤에 L을 붙여야 long으로 인식
		
//		float num5 = 1.0;  // 디폴트가 double 그래서 에러남
		float num6 = 1.0F;  // f로 float이라고 표시해줘야함.
		
		double num7 = 30;     // int -> double 자동 형변환
		
		/*
		아래와 같은 오류가 나올수 있으므로 값이 너무 클때 만 사용함. 게임등
		 */
		// 앞에 1바이트에 아무런 값이 없을때에만 형변환 할 것.
		// 0000 0000 (이럴때에만 형변환 함) 0000 0001
		long num8 = 3000000007L;
		int num9 = (int)num8;  // 큰수의 형변화은 조심해야 함.
		System.out.println(num9);  // -1294967289이 값이 나옴 에러임.
		
		/*
		문자는 메모리에 저장시 아스키코드로 저정되므로 int형과의 연산을
		진행한 후 문자로 표현하고 싶다면 char형으로 강제형변환 후 출력
		하면 된다.
		 */
		char ch3 = 'A', ch4;
		int num10 = 2; 
//		ch4 = ch3 + num4;  // 에러
		ch4 = (char)(ch3 + num10);
		System.out.println("ch4="+ ch4);
	}
}