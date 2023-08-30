/*
if문(조건문) 형식1
	if(조건문){
		실행문장;
	}
-if문의 조건문은 반드시 비교식 혹은 논리식이어야 한다 .
-즉 결과값이 boolean형으로 true 혹은 false를 반환해야한다. 
-실행할 문장이 하나라면 중괄호 생략이 가능하다.
 */
public class Ex01_if
{
	public static void main(String[] args)
	{
		int num = 100;
		
		if (num > 50)   // 처음 배운 방식
		{
			System.out.println("num 변수의 값이 50보다 큽니다.");
		}
		
		// 한 줄만 실행하면 중괄호를 생략 가능
		// if 문의 끝은 ';'이다.
		if (num > 50)
			System.out.println("num 변수의 값이 50보다 큽니다.");
		
		// 같은 줄에 작성 가능. 실행 문장의 끝은 세미콜론(;)으로 구분.
		if (num > 50) System.out.println("num 변수의 값이 50보다 큽니다.");
		
		// 의도치 않은 결과
		if (num < 50)
			System.out.println(num);  //num 변수의 값이 궁금해 출력.안 나옴
		
			// if문이랑 상관없음. 다른 내용이 출력됨.
			System.out.println("num 변수의 값이 50보다 작습니다.");
	}
}
