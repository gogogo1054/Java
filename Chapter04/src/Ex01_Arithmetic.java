public class Ex01_Arithmetic
{
	// 산술 연산자
	public static void main(String[] args)
	{
		int num1 = 7;
		int num2 = 3;
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		// 문자열로 합침 계산이 아님. 10이 문자로 인식, 나중에 배움.
//		System.out.println("num1 + num2 = " + 10); 
		System.out.println("num1 - num2 = " + (num1 - num2));
		System.out.println("num1 * num2 = " + (num1 * num2));
		/*
		 "/(나눗셈)" 연산자는 두개의 정수를 나눈 몫을 반환하므로
		 1 / 2의 결과는 0이 나오게 된다.
		 소수점의 결과가 나오지 않는 이유는 Java에서는 정수와 정수를 
		 연산하면 정수의 결과가 나오기 때문이다.
		 정수 계산기 이므로 값이 정수가 나옴. 나머지를 구하는 이유가 됨.
		 */
		System.out.println("num1 / num2 = " + (num1 / num2));
		System.out.println("num1 % num2 = " + (num1 % num2));
	}
}
