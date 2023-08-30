public class Ex03_StringArray
{
	public static void main(String[] args)
	{
		/*
		객체 배열 : 기본자료형을 저장하는 배열이 아닌 객체의 참조값을
		저장할 목적으로 생성한 배열을 말한다. 사용법은 동일하다. 
		 */
		// 7개의 문자열을 담을 수 있는 배열을 생성 
		String[] name = new String[7];
		
		// new 연산자를 이용하여 새로운 문자열 객체를 만들어 객체의 주소를 저장 
		// 인덱스를 통해 접근 후 각 원소를 초기화
		name[0] = new String("홍길동");
		name[1] = new String("전우치");
		name[2] = new String("손오공");
		name[3] = new String("강감찬");
		name[4] = new String("이순신");
		name[5] = new String("을지문덕");
		name[6] = new String("양만춘");
		
		/*
		배열의 선언 및 초기화
			: 배열은 여러개의 변수를 사용하기 위해 선언하므로 접근을 
			위해 일반적으로 반복문(for)을 사용한다.
			
		배열명.length : 해당 배열의 크기를 반환한다. 배열의 크기가 
			변경되는 경우 유연하게 대처할 수 있다. 
		 */
		int cnum = 0;
		//배열의 각 원소를 출력한다.
		for(int i = 0; i < name.length; i++)
		{
			// 각 문자열 길이를 구해서 더해줌.
			System.out.println(name[i]);
			cnum += name[i].length();
		}
		
		System.out.println("총 문자의 수: " + cnum);
	}
}
