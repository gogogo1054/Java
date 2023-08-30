/*
Wrapper클래스
: 기본자료형의 데이터를 인스턴스화(객체화)할때 사용하는 클래스로
Boxing 혹은 Unboxing을 통해 기본자료형의 데이터를 객체화한다. 
뒤에서 학습할 제네릭 클래스에서 필수적으로 사용된다.
 */
public class Ex10_BoxingUnboxing
{
	public static void main(String[] args)
	{
		// 박싱
		Integer iObj = Integer.valueOf(10);  // Integer.valueOf(10); 이게 박싱
		Double dObj = Double.valueOf(3.14);
		
		//메소드 호출을 통한 언박싱
		int num1 = iObj.intValue();          // iObj.intValue(); 이게 언박싱
		double num2 = dObj.doubleValue();
		
		System.out.println(num1 + " : " + iObj);
		System.out.println(num2 + " : " + iObj);
		System.out.println();
		
		// 래퍼 인스턴스 값의 증가 방법
		iObj = Integer.valueOf(iObj.intValue() + 10);   
		// 언박싱 먼저 한후에 계산후에 박싱 전환
		dObj = Double.valueOf(dObj.doubleValue() + 1.2);
		
		System.out.println(iObj);
		System.out.println(dObj);
	}
}
