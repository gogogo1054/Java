public class Ex05_Calculation2
{
	public static void main(String[] args)
	{
		/*
		CPU에서 기본 자료형 수를 계산하는 연산 장치가 있고, 이 장치가 
		다음과 같이 계산. 디폴트는 int.
		 */
		int num31 = 1;    //  메모리에 저장
		int num32 = 2;	  // 메모리에 저장
		int result3 = num31 + num32;  // int 계산기, CPU에서 계산

		long num41 = 1;   
		long num42 = 2;
		long result4 = num41 + num42;  // long 계산기
		
		// num31 long으로 자동형 변환 후 계산
		long result5 = num31 + num41; 
		
		/*
		 - 실수형에서 기본은 double형이다
		 - 소수점이 있는 데이터를 컴파일러는 무조건 double로 인식한다.
		 - 단, 소수점이 있는 데이터를 float에 대입하려면 접미사 F 혹은 
		 f를 붙여야 한다.
		 - 형변환도 가능하지만 Java에서는 권장하지 않는다.		
		 */
		float num61 = 1.0f;   
		float num62 = 2.0f;
		float result6 = num61 + num62; // float 계산기
		
		double num71 = 1.0;  
		double num72 = 2.0;
		double result7 = num71 + num72; // double 계산기
		
		/*
		 - 동일자료형 끼리의 연산은 동일자료형이 되는것이 기본원칙이다.
		 - 하지만 큰 자료형과 작은 자료형을 연산하면 큰 자료형으로 자동
		 형변환된다. 이유는 데이터의 손실(오차)이 있을 수 있기 때문이다.
		 - 단, byte형과 short형은 예외적인 상황으로 생각하면된다. int형에
		 최적화된 CPU의 특성때문이다. 
		 */
		// num61 float로 자동형 변환 후 계산
		double result8 = num61 + num71;  
		
		// 원하는 값이 출력되었는가?
		int num91 = 2147483647; // 큰값이 들어갈때는 조심해야함. 
		int num92 = 2;
		// long으로 변환해야 정확한 값이 나옴. 은행이면 큰일남.
		int result9 = num91 + num92;  
		// PC는 가장 앞의 비트를 부호비트로 사용 양수, 음수를 구분
		System.out.println(result9);  // -2147483647 이값이 나옴, 에러임.
	}
}