/*
while문
	: 반복의 횟수가 명확하게 정해져있지 않았을때 주로 사용하는 
	반복문으로 반복을 위한 초기값, 조건, 증감식을 따로 작성하는 
	형식을 가지고 있다. 
 	형식]
 		반복을 위한 변수의 초기값;
 		while(반복의조건){
 			실행문장;
			증감식; <= 반복문 탈출을 위한 문장
		}
	조건이 true일때 반복하게되고, 반복문의 처음으로 돌아가면 조건을 
	확인한다.
	반복의 조건이 false일때 while문을 탈출하게 된다.
*/
public class Ex07_while
{
	// while문을 이용한 반복
	public static void main(String[] args)
	{
		int num = 0;
		int count = 0;
		// 반복을 위한 조건식을 작성
		while((num++) < 100)
		{
			/*
			아래의 조건이 어려우면 밑에 if문처럼 
			이해하기 쉽게 나눠서 비교할수 있습니다
			 */
//			if (((num % 5) != 0) || ((num % 7) != o)))
//				continue;   // 5와 7의 배수 아니라면 나머지 건너띄고 위로 이동
			if( (num % 5) != 0 )
				continue;
			if( (num % 7) != 0 )
				continue;
			// 5와 7의 공배수
			count++;                   // 5와 7의 배수인 경우에만 실행
			System.out.println(num);   // 5와 7의 배수인 경우에만 실행
		}
		
		System.out.println("count: " + count);
	}
}
