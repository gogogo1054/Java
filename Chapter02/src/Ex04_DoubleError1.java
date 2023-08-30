public class Ex04_DoubleError1
{
	public static void main(String[] args)
	{
		/*
		 - 실수형에서 기본은 double형이다
		 - 소수점이 있는 데이터를 컴파일러는 무조건 double로 인식한다.
		 - 단, 소수점이 있는 데이터를 float에 대입하려면 접미사 F 혹은 
		 f를 붙여야 한다.
		 - 형변환도 가능하지만 Java에서는 권장하지 않는다.		
		 */
		
		// 정확한 값을 못찾으면 근사값을 찾음.
		double num1 = 1.0000001;
		System.out.println(num1);
		double num2 = 2.0000001;
		System.out.println(num2);
		// 연산을 하게되면 정확한 값이 안나옴. 실수는 계산을 하면 안됨.
		// 크다 작다만 비교해야함.
		double result = num1 + num2;
		System.out.println(result);
		
		float f3 = 100;
		// 에러발생. 3.14자체를 double형으로 인식하기 때문.
		//float f4 = 3.14;	// 여기서 f4 float이므로 에러
		
		// 형변환후 대입할 수 있으나 권장하지 않는다.
		float f4 = (float)3.14;
		System.out.println("f4="+ f4);
		
		// 접미사를 통해 float형 임의로 명시한다.(소문자 f도 가능함)
		float f5 = 3.14F;	// 권장사항
		System.out.println("f5="+ f5);
	}
}