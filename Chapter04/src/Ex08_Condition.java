public class Ex08_Condition
{
	/*
	조건 연산자(삼항 연산자) 
		: 주어진 조건식이 참인 경우와 거짓인 경우에 다른 결과값을 
		나타내주는 연산자이다.
	 */
	public static void main(String[] args)
	{
		int num1 = 50;
		int num2 = 100;
		// false이므로 num2가 대입
		int big = (num1 > num2) ? num1 : num2;
		System.out.println("큰 수 : " + big);
		// false이므로 num2 - num1 값이 대입
		int diff = (num1 > num2) ? (num1 - num2) : (num2 - num1);
		System.out.println("두 수의 차 " + diff);
	}
}