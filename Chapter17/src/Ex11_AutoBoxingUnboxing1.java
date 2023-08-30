public class Ex11_AutoBoxingUnboxing1
{
	public static void main(String[] args)
	{
		/*
		JDK1.5이후 버전에서의 코딩형태
		오토박싱 혹은 오토언박싱이 지원되므로 기본자료형 변수를
		선언하는것과 동일하게 코딩할 수 있다. 
		 */
		//별도의 형변환이나 처리없이 사용할 수 있다.
		// 오토 박싱
		Integer iObj = 10;
		Double dObj = 3.14;
		
		// 오토 언박싱
		int num1 = iObj;
		double num2 =  dObj;
		
		System.out.println(num1 + " : " + iObj);
		System.out.println(num2 + " : " + dObj);
	}
}
