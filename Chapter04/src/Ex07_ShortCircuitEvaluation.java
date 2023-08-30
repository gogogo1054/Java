public class Ex07_ShortCircuitEvaluation
{
	/*
	최단거리 평가(Short-Circuit Evaluation : SCE)
		: 논리곱에서는 둘 다 참이어야 참이 되므로 앞쪽이 거짓이면 뒤쪽 
		계산을 수행하지 않는다. 논리합에서는 둘 중 하나라도 참이면 참이 
		되므로 앞쪽이 참이면 역시 뒤쪽 계산을 수행하지 않게 된다.
		이처럼 연산의 효율 및 속도의 향상을 위해 불필요한 연산을 수행
		하지 않는 기능을 말한다.
	 */
	public static void main(String[] args)
	{
		int x = 0;
		int y = 0;
		boolean result;
		// 논리곱에서 앞이 false이므로 (y = y + 1) > 0 실행이 안됨
		result = ((x = x + 1) < 0) && ((y = y + 1) > 0);  // false
		
		System.out.println("result =" + result);
		System.out.println("x = " + x);
		// 여기서 y는 계산이 안됬기 때문에 초기값 0이다.
		System.out.println("y = " + y +'\n');
		
		// 논리합에서 앞이 true이므로 (y = y + 1) > 0 실행이 안됨
		result = ((x = x + 1) > 0) || ((y = y + 1) > 0);
		
		System.out.println("result =" + result);
		System.out.println("x = " + x);
		// 여기서도 y는 계산이 안됬기 때문에 초기값 0이다.
		System.out.println("y = " + y);
	}
}