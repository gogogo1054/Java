public class Ex03_UtilMethod
{
	public static void main(String[] args)
	{
		MyCalculator calc1 = new MyCalculator();   // 의미없음
		/*
		정적변수도 일반적인 멤버변수처럼 참조변수를 통해 접근할 수 
		있지만, Java에서는 권장하지 않는 방법이다.
		(※ 참조변수를 통해 접근할거면, 굳이 정적변수를 사용할 이유가 
		없다.)
		 */
		int num1 = calc1.adder(1, 2);
		System.out.println(num1);
		
		/*
		정적변수도 일반적인 멤버변수처럼 참조변수를 통해 접근할 수 
		있지만, Java에서는 권장하지 않는 방법이다.
		(※ 참조변수를 통해 접근할거면, 굳이 정적변수를 사용할 이유가 
		없다.)
		 */
		int num2 = MyCalculator.adder(2, 3);  // new 가 없음.
		System.out.println(num2);
	}
}
