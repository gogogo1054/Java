/*
매개변수도 있고 반환값도 있음
 */
interface Unit9
{
	int calc(int a, int b);   // 매개변수 둘, 반환형 int
}

public class Ex09_LambdaRule2
{
	public static void main(String[] args)
	{
		//반환값이 있으므로 좌측항의 변수로 할당된다.
		Unit9 unit;
		unit = (a, b) -> { return a+b; };   // 기본 사용
		//unit = a, b -> { return a+b; };   // 앞쪽 소괄호 생략 안됨
		//unit = (a, b) -> return a+b;      // 뒤쪽 중괄호 생략 안됨
		
		// 람다식 호출시 두 정수를 인수로 전달한 후 반환값을 받는다. 
		int num = unit.calc(10, 20);
		System.out.println(num);
		
		// 매개변수 두개이고 반환문이 하나일때 뒤쪽 중괄호와 return 생략 가능
		unit = (a, b) -> a * b;  
		System.out.println(unit.calc(10, 20));	// 변수로 안받고 바로 사용가능
	}
}

// 메서드 몸체에 해당하는 내용이 return 문이면
// 그 문장이 하나이더라도 중괄호 생략이 불가능하다.
