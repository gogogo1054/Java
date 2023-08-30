public class Ex05_Compare
{
	/*
	비교연산자 : 두개의 변수를 서로 비교하여 값이 크거나
		같은지를 판단하는 연산자이다. 
		! : 부정연산자로 다른지를 판단한다.(not) 
		== : 같은지를 판단한다. 
	 */
	public static void main(String[] args)
	{
		System.out.println("2 >= 1 : " +  (2 >= 1));
		System.out.println("2 <= 1 : " + (2 <= 1));
		
		/*
		실수형으로 자동 형변환이 이뤄진 다음 비교 연산을 수행했기 
		때문이다. 이처럼 비교 연산 시에도 형변환이 일어난다.
		 */
		System.out.println("1.0 == 1 : " + (1.0 == 1));
		System.out.println("1.0 != 1 : " + (1.0 != 1));
	}
}