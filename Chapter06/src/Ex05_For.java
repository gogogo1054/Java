/*
for : 반복문으로 초깃값, 조건식, 증감식이 한줄에
	있어 반복의 횟수를 명확히 알수 있는 반복문이다. 따라서 반복의 
	횟수가 정해져있을때 주로 사용한다.
	형식]
		for(초기값 ; 조건식 ; 증감식){
		   실행문;
	    }
*/ 
class Ex05_For
{
	public static void main(String[] args)
	{
		/*
		 for문의 실행순서
		 1. 반복을 위한 변수 i를 1로 초기화한다.
		 2. 조건식을 검사한다.
		 3. 조건이 true이면 실행문을 실행한다.
		 4. 증감식 실행
		 5. 조건을 검사(3,4,5 번을 횟수만큼 반복한다.)
		 6. 조건이 false일때 탈출한다,
		 */
		for (int i =2; i<10; i++)
		{
			System.out.print((2 * i) + " ");
		}
		System.out.println();
		
		// 한 줄만 실행하면 중괄호를 생략 가능
		for (int i =2; i<10; i++)	// 3단 출력	
			System.out.print((3 * i) + " ");
		System.out.println();
		
		// 같은 줄에 작성 가능. 실행 문장의 끝은 세미콜론(;)으로 구분
		// 보통 이렇게 만들지는 않습니다.
		for (int i =2; i<10; i++) System.out.print((4 * i) + " ");
		System.out.println();  // 4단 출력
		
		// 의도치 않은 결과
		/*
		 for문의 초기식에서 선언된 변수 i는 for문이 종료되는 순간
		 메모리에서 소멸된다. 여기서 사용된 변수 i는 지역변수
		 (Local Variable)라고 한다. 지역변수는 해당 지역을 벗어
		 나면 즉시 소멸되는 특징을 가지고 있다.
		 */
		for (int i =2; i<10; i++)
//		    System.out.print(i);  // i 변수의 값이 궁금해 출력
			// 위에문의 주석을 풀면 여기는 에러가남. for문이랑 상관 없어지므로 i는 for문안에서만 사용.
			System.out.print((5 * i) + " "); 
		System.out.println();
	}	
}
