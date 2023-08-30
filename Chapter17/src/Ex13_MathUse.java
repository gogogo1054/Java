/*
Math클래스
-java.lang 패키지에 정의된 클래스
-수학과 관련된 일련의 작업들을 처리하는 메서드가 정의됨
-메서드는 static으로 선언되어있어 객체생성없이 클래스명으로 즉시 
사용가능함
 */
public class Ex13_MathUse
{
	public static void main(String[] args)
	{
		System.out.println("4의 제곱근: " + Math.sqrt(4));
		System.out.println("log2(8): " + baseLog(8, 2));  // 2의 몇승이 8이되나 답 3
		System.out.println("2의 3승: " + Math.pow(2, 3));	// 거듭 제곱.
		System.out.println();
		
		System.out.println("원주율: " + Math.PI);
		System.out.println("파이에 대한 Degree: " + Math.toDegrees(Math.PI));
		System.out.println("2 파이에 대한 Degree: " + Math.toDegrees(2.0 * Math.PI));
		System.out.println();
		
		double radian45 = Math.toRadians(45);
		
		System.out.println("싸인 45: " + Math.sin(radian45));
		System.out.println("코싸인 45 " + Math.cos(radian45));
		System.out.println("탄젠트 45: " + Math.tan(radian45));
	}
	
	public static double baseLog(double x, double base)
	{
		return Math.log(x) / Math.log(base);
	}
}
