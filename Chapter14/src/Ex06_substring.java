public class Ex06_substring
{
	public static void main(String[] args)
	{
		String str1 = "AppleBananaOrange";
		int num1 = str1.indexOf("Banana");	// Banana 시작 위치 반환 
		int num2 = str1.indexOf("Orange");	// Orange 시작 위치 반환 
		
		/*
		substring() : 시작인덱스와 마지막인덱스 사이의 문자열을 
		잘라서 반환한다. 
		방법1 : 인덱스를 하나만 사용 => 이경우 인덱스부터 문자열의 
			끝까지를 잘라낸다. 
		방법2 : 시작인덱스, 종료인덱스를 사용 => 인덱스에 해당하는 
			부분만 잘라서 반환한다. 
		 */
		String str2 = str1.substring(num1, num2);	// 5~10까지 반환 
		System.out.println(str2);	
		
		String str3 = str1.substring(num2);	// 11부터 끝 까지 
		System.out.println(str3);
	}
}
