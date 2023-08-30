/*
매개변수는 없으나 반환값은 있음
 */
interface Unit10
{
	String move();   // 매개변수 없음, 반환형 String
}

public class Ex10_LambdaRule3
{
	public static void main(String[] args)
	{
		/*
		매개변수가 없는 람다식을 정의해야 하므로 비어있는 소괄호를
		사용한다.
		 */
		//단순히 문자열만 출력하는 람다식을 정의한다.
		Unit10 unit = () -> {          // 매게변수 없으면 '( )' 생략 불가능
			return "인간형 유닛 이동";
		};
		
		System.out.println(unit.move());
	}
}
