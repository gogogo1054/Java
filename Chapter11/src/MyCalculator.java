public class MyCalculator
{
	/*
	정적멤버메서드 : 정적메서드 내부에서는 인스턴스형 멤버에 접근할 수
	 	없다. 정적 멤버만 접근할 수 있다.
	  	(* main 메서드에서는 static으로 선언된 메서드만 호출할 수 있었
	  	음을 기억하자.)
	 */
	public static int adder(int n1, int n2)
	{
		return n1 + n2;
	}
}
