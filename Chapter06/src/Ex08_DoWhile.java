/*
do~while문
	: 반드시 한번은 실행해야 할 경우 사용하는 반복문으로 조건검사없이
	무조건 한번은 실행된다.
	형식]
		반복을 위한 변수;
		do {
			실행문장;
			반복문 탈출을 위한 증감식
		}while (조건문); <- 문장의 끝에 세미콜론(;)이 들어간다.
*/
public class Ex08_DoWhile
{
	//  do~while문을 이용한 반복
	public static void main(String[] args)
	{
		int num = 0;
		int count = 0;
		
		do
		{
			num++;
			
			if( (num % 5) != 0 )
				continue;
			if( (num % 7) != 0 )
				continue;
			
			count++;                   // 5와 7의 배수인 경우에만 실행
			System.out.println(num);   // 5와 7의 배수인 경우에만 실행
		} while(num < 100);	// 반복을 위한 조건 체크
		// 세미콜론(；)을 잊어서 에러를 내는 경우가 많은데 주의해야 함..
		System.out.println("count : " + count);
	}
}