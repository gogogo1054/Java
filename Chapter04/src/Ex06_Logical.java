
public class Ex06_Logical
{
	/*
	논리연산자 
		&& : 논리And. 양쪽 모두가 true일때만 true를 반환하고
		 	나머지는 false를 반환하는 연산자
		|| : 논리Or. 한쪽만 true이면 true를 반환하고, 양쪽
			모두 false일때만 false를 반환하는 연산자
		! : 논리Not. 반대의 논리를 반환하는 연산자
	 */
	public static void main(String[] args)
	{
		int num1 = 11;  // 4바이트
		int num2 = 22;  // 4바이트
		boolean result; // 1바이트. 총 9바이트 메모리에 생성
		
		result = (num1 > 1) && (num1 < 10);
		System.out.println("1 초과 10 미만인가? " + result); // false
		
		result = ((num2 % 2) ==0) || ((num2 % 3) == 0);
		System.out.println("2 또는 3의 배수인가? " + result);  // true
	}
}
