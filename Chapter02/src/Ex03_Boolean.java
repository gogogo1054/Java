public class Ex03_Boolean
{
	public static void main(String[] args)
	{
		/*
		boolean타입 : true 혹은 false 두가지의 값만 가질수 있는 자료형
			으로 산술연산(+,-)이나 비교연산(<, <=)에서는 사용할 수 없고
			논리연산에서만 사용할 수 있다. 
		 */
		
		// 직접 값 대입. 글자가 아님 대표하는 값. 1바이트
		boolean check1 = true;      
		boolean check2 = false;
		 // 연산의 결과를 값으로 대입.
		boolean check3 = (1 < 2);  
		
		System.out.println(check1);  // boolean으로 대입한 값을 출력
		System.out.println(check2);
		System.out.println(check3);
		System.out.println(1 > 2);  // 연산의 결과를 출력
	}
}