public class Ex03_ContentsCompare
{

	public static void main(String[] args)
	{
		String str1 = new String("Apple");
		String str2 = new String("apple");
		String str3 = new String("Banana");
		int cmp;
		
		/*
		equals()메서드
		: Object클래스로부터 상속받은 메서드로 실제 저장된 문자열을
		비교하도록 만들어진 메서드이다. 즉 아래는 객체에 저장된 실제
		문자열에 대한 비교가 이루어진다. 
		 */
		if (str1.equals(str3))
			System.out.println("두 문자열은 같습니다");
		else
			System.out.println("두 문자열은 다릅니다");
		
		/*
		compareTo() : 2개의 문자열의 첫번째 문자부터 순차적으로
		비교하면서 앞문자의 아스키코드가 크면 양수를 반환하고
		뒷 문자의 아스키코드가 크면 음수를 반환한다. 
		두 문자열이 같을때 0을 반환한다 
		 */
		cmp = str1.compareTo(str2);
		
		if (cmp == 0)
			System.out.println("두 문자열은 일치합니다.");
		else if (cmp < 0)
			System.out.println("사전의 앞에 위치하는 문자: " + str1);
		else
			System.out.println("사전의 앞에 위치하는 문자: " + str2);
		
		// 대소문자 구분없이 비교.
		if(str1.compareToIgnoreCase(str2) == 0)
			System.out.println("두 문자열은 같습니다");
		else
			System.out.println("두 문자열은 다릅니다");
	}
}
