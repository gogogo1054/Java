public class Ex01_VariableType
{
	public static void main(String[] args)
	{
		/*
		 정수자료형
		 - byte, short, int, long타입(형)이 있다.
		 - 각 자료형의 표현범위는 교안을 참조한다.(단, 외울필요없음)
		 - 일반적으로 CPU(중앙처리장치)는 정수형 연산을 할때 int형을
		 가장 빠르게 처리한다.
		 - 즉, 정수형 변수를 쓸때에는 거의 대부분 int 형을 사용하면 된다.
		 */
		byte num1 =1;   // 0000 0001 1바이트 메모리 1칸씀
//		byte num1;   // 선언만 한것
//		num1 = 1;    // 값을 넣어줌
		short num2 = 1;  // 0000 0000 0000 0001 2바이트  2칸씀
		int num3 = 1;   // 4바이트  4칸씀
		long num4 = 1;  // 8바이트  8칸씀
		
		System.out.println(num1);
		System.out.println(num2);	
		System.out.println(num3);	  
		System.out.println(num4);
	}
}