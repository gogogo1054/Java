public class Ex06_ForExtension
{
	// for문 요소의 생략 • 응용
	public static void main(String[] args)
	{
		// 2의 배수 출력
		/*
		 for문의 초깃값을 외부(넓은지역, 여기서는 main지역)에서 
		 선언하면 해당변수는 for문의 안쪽(좁은지역)에서 사용할 
		 수 있다. 즉 아래에 선언한 변수 i는 main메서드의 지역변수로 
		 선언된다.
		 */
		int i = 0;
		for( ; i<10; i++)   // 초기식 생략 
		{
			if (i % 2 == 0)  // 2의 배수이면서 짝수
				System.out.print(i + " ");
		}
		System.out.println();
		
		i = 0;   // 초기화
		for ( ; i<10; )	// 초기식, 증감식 생략
		{
			if (i % 2 == 0)
				System.out.print(i + " ");
			i++;	// 증감식
		}
		System.out.println();
		// 상황에 맞는 식을 구성할 수 있습니다.
		for (int j=0; j<10; j=j+2)	// 증감식 대신 연산 수식
		{
			System.out.print(j + " ");
		}
		System.out.println();
	}
}
