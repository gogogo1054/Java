public class Ex04_PrefixOistfix
{
	/*
	증감연산자
		: 변수를 +1 혹은 -1 한것과 같은 결과를 반환한다. 
		주로 반복문에서 사용된다.
	Prefix(전위 증가 혹은 감소)
	: 연산자가 변수 앞에 있는 경우
	1.변수의 값이 먼저 변경된다.
	2.변경된 값이 좌측항으로 혹은 다른 코드에 반영된다. 
	Postfix(후위 증가 혹은 감소)
	: 연산자가 변수 뒤에 있는 경우
	1.변수의 값이 먼저 다른 코드에 반영된다. 
	2.반영된 이후 변수의 값이 변경된다. 
	 */
	public static void main(String[] args)
	{
		int num = 10;
		System.out.println(++num);   // num의 값 하나 증가 후 출력
		System.out.println(num);     // num의 값이 증가되어 있음
		
		System.out.println(num++);   // 출력 후에 값이 증가
		System.out.println(num);     // 값이 증가 된 것을 확인
		
//		int result = num++;	// 이렇게 사용하지 말것.
		
		// 다음처럼 반복문에서 단독으로 사용하는 것이 좋습니다.
//		int num = 0;
//		while (num > 10) {
//			...
//			++num;
//		}
		
//		int i=0;
//		for (int i=0; i<10, i++)
//		{
//			...
//		}
		
		// 디버깅
		int num1 = 7;
		int num2, num3; //현재상태 : 7, X, X
		num2 = ++num1; /*
					1.num1의 값이 먼저 1 증가한다. 
					2.증가된 num1이 num2에 대입된다. 
					현재상태 : 8, 8, X
		*/
		num3 = --num1;/*
					1.num1의 값이 먼저 1 감소한다.
					2.감소된 값이 num3에 대입된다. 
					현재상태 : 7, 8, 7
		*/
		System.out.println("전위증가/감소시");
		System.out.printf("num1=%d, num2=%d, num3=%d %n%n",
				num1, num2, num3);//최종결과 : 7, 8, 7

		///////////////////////////////////////////////////////////////////

		num1 = 7; //  	현재상태 : 7, 8, 7
		num2 = num1++; /*
					1.num1의 값이 먼저 num2에 대입된다. 
					2.num1의 값이 나중에 증가한다. 
					현재상태 : 8, 7, 7
		*/
		num3 = num1--; /*
					1.num1의 값이 먼저 num3에 대입된다. 
					2.num1의 값이 감소한다. 
					현재상태 : 7, 7, 8
		*/

		System.out.println("후위증가/감소시");
		System.out.printf("num1=%d, num2=%d, num3=%d",
				num1, num2, num3);//최종결과 : 7, 7, 8
	}
}