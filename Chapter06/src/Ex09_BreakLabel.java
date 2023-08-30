public class Ex09_BreakLabel
{
	// 레이블을 이용한 중첩된 반복문의 일괄 중지
	public static void main(String[] args)
	{
		int sum = 0;
		
myExit: while (true)	// 무한 반복. 레이블(라벨)로 myExit 지정
		{
			for (int i=0; i<100; i++)	// 중첩된 반복문
			{
				sum = sum + i;
				if (sum >2000)
				{
					/*
					 반복문 내에서 break, continue문을 사용할때는 반드시 
					 조건문과 같이 사용해야 한다. 그렇지 않으면 해당코드 
					 하위는 실행되지 않는 쓰레기코드가 되기때문이다.
					 */
//				    break;  // 아래가 다 쓰레기 코드가 됨.
					System.out.printf("%d : %d\n", i, sum);
					/*
					바깥쪽의 반복문까지 한꺼번에 멈추고 싶다면 바깥 
					반복문에 지정한 레이블을 break에 붙여줍니다. 
					 */
					break myExit;
					/*
					 중첩된 반복문 안에서 break문을 만나면 "가장 가까운 반복문 
					 하나"만 탈출한다.
					 */
				}
			}
		}
	}
}