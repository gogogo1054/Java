
public class Ex03_PlusMinusSign
{
	public static void main(String[] args)
	{
		
		short num1 = 5;
		// +, - 만 붙어도 연산이 이루어지는 것.
		System.out.println(+num1);    // 결과적으로 불필요한 +연산
		System.out.println(-num1);    // 부호를 바꿔서 얻은 결과를 출력
		System.out.println(num1);     // num1 의 값은 변하지 않음
		
		short num2 = 7;
		/*
		이렇게 + 연산자에 의해 연산이 이루어지고 int로 형변환이 되었기 
		때문에 다시 short로 강제 형변환을 해주어야 변수에 값을 대입할 
		수 있게 된다
		 */
		short num3 = (short)(+num2);  // 형 변환 하지 않으면 오류 발생
		short num4 = (short)(-num2);  // 형 변환 하지 않으면 오류 발생
		System.out.println(num3);
		System.out.println(num4);
	}
}
