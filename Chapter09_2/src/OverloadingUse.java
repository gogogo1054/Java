/*
메서드 오버로딩(Method Overloading)	: 동일한 이름의 메서드를 2개이상 
	정의하는 것을 말한다.
	- 매개변수의 개수가 다르거나 자료형이 다를 때 성립한다.
	- 변환타입만 다른것은 허용하지 않는다.
	- 컴파일러는 메서드 호출시 전달되는 인수(파라미터)를 통해 호출할 메서
		드를 구분한다.
	- 자바에서는 메서드명과 매개변수를 합해서 하나의 메서드명으로 본다.
*/
class Calc
{
	int add(int a, int b)
	{
		return a + b;
	}
	
	int add(int a)
	{
		return a + 1;
	}
	
	double add(double a, double b)
	{
		return a + b;
	}
}

public class OverloadingUse
{
	public static void main(String[] args)
	{
		Calc calc = new Calc();  // 객체 생성
		int nRtn1 = calc.add( 3, 9 );
		int nRtn2 = calc.add( 3 );
		double nRtn3 = calc.add( 3.0,  9.0);
		
		/*
		 출력을 위해 사용하는 print()문이 대표적인 오버로딩으로 정의된 
		 메서드이다. 정수, 실수, 문자 등 모든 타입에 대해 오버로딩으로 
		 정의되어 있다.
		 */
		System.out.println("Rtn1 = "+ nRtn1);
		System.out.println("Rtn2 = "+ nRtn2);	
		System.out.println("Rtn3 = "+ nRtn3);
	}
}
