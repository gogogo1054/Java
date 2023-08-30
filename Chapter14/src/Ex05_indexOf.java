
public class Ex05_indexOf
{
	public static void main(String[] args)
	{
		String str = "AppleBananaOrange";
		/*
		indexOf() : 문자열에서 특정 문자열의 시작인덱스를 반환한다.
		만약 존재하지 않으면 -1을 반환한다. 인덱스는 항상 0부터 시작
		이므로 -1은 해당 문자열이 없다는 의미가 된다. 
		 */
		int num1 = str.indexOf("n"); 	// "a" 위치 반환 
		int num2 = str.indexOf("n", num1 + 1);	// 첫 "a" 그다음 "a"위치 반환 
		
		System.out.println(num1);
		System.out.println(num2);
	}
}
