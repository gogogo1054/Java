public class Ex07_Number
{
	public static void main(String[] args)
	{
		/*
		JDK1.4 이전의 코딩형태
		기본자료형을 박싱 처리한 객체에 대해서 산술연산을 진행할때
		다시 언박싱을 위해 intValue()와 같은 메서드를 호출해야한다. 
		 */
		//현재는 이와같은 생성자는 deprecated(디플리케이트)되었다.
		//구 버전과의 호환성을 위해 아직 남겨져있는 상태이다.
//		Integer num1 = new Integer(20);   // <= 과거에 사용 하였음
		Integer num1 = Integer.valueOf(20);   
		// 현재에는 이 표현으로만 사용함, 숫자만 사용  " 숫자 "도 숫자로 사용가능
		System.out.println(num1.intValue());
		System.out.println(num1.doubleValue());
		
		Double num2 = Double.valueOf(3.14);   
		System.out.println(num2.intValue());
		System.out.println(num2.doubleValue());
	}
}
