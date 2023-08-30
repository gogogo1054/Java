public class Ex04_conca
{
	public static void main(String[] args)
	{
		String str1 = "기초";
		String str2 = "프로그래밍";
		
		/*
		concat() : 두개의 문자열을 연결할때 사용한다. print()문에서
		+와 동일한 역할을 한다. 
		 */
		String str3 = str1.concat(str2);
		System.out.println(str3);
		
		String str4 = "자바".concat(str3);
		System.out.println(str4);
	}
}
