public class Ex08_parseXXX
{
	public static void main(String[] args)
	{
		String str = "100";
		/*
		parseInt() : 숫자형식의 문자열을 정수(숫자)로 변경한다. 
		parseDouble() : 실수로 변경한다. 
		 */
		int a = Integer.parseInt(str);          // 문자열에서 숫자로 변환
		double b = Double.parseDouble("3.14");  // 문자열에서 실수로 변환
		
		System.out.println(a + " : " + b);
		
		/* 추
		문자열을 숫자로 변경할때는 반드시 숫자형식만 기술해야한다. 
		"원"은 숫자가 아니므로 예외가 발생한다.
		 */
		String money = "120원";
//		System.out.println("120원:"+ Integer.parseInt(money)); //예외발생 
	}
}
