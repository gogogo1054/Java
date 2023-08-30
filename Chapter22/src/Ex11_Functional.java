/*
함수형 인터페이스
: 람다식을 사용하기 위해서는 먼저 인터페이스를 만들고 람다식으로 구현할
추상메서드를 선언한다. 이를 람다식을 만들기위한 함수형 인터페이스라고한다.
※ 함수형 인터페이스에는 오직 하나의 추상메소드만 선언할 수 있다.

@FunctionalInterface
	: 함수형 인터페이스의 조건을 갖추었는지에 대한 검사를 컴파일러에게 
	요청하는 역할을 한다. 	
 */
@FunctionalInterface     //<= 람다식
interface Unit11
{
	String move();   // 매개변수 없음, 반환형 String
	// 함수형 인터페이스에는 하나의 추상메서드만 생성할 수 있다. 추가로 
	// 선언시 에러가 발생한다.
//	void attack();   // @FunctionalInterface 에서 에러라고 알려줌
}

public class Ex11_Functional
{
	public static void main(String[] args)
	{
		/*
		Unit11 인터페이스를 구현하여 람다식을 생성한다. 
		추상메서드를 통해 매개변수의 타입을 유추할 수 있으므로 아래와
		같이 String을 생략할 수 있다. 
		 */
		Unit11 unit = () -> {  
		return "인간형 유닛 이동";
		};
		
		System.out.println(unit.move());
	}
}
