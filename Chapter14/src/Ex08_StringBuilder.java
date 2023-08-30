public class Ex08_StringBuilder
{
	public static void main(String[] args)
	{
		/*
		StringBuilder 클래스
		: String클래스는 기존 문자열에 새로운 문자열을 추가하면 새롭게 
		생성된 메모리에 문자열을 저장한다. 기존 메모리가 소멸되고 새로운 
		메모리가 생성되는 낭비를 막기위해, 문자열의 변경이 많은 경우에는
		StringBuilder 클래스를 사용하는것이 좋다. 해당 클래스는 기존 메모리의
		문자열을 변경하는 방식으로 추가하게된다. 
		 */
		StringBuilder buf = new StringBuilder("동해물과");
		
		/*
		append() : 문자열의 끝에 새로운 문자열을 연결한다. 
		 */
		buf.append("백두산이");   // append를 주로 사용. 추가 
		System.out.println(buf.toString());
		
		buf.append("12345");	// 추가 
		System.out.println(buf.toString());
		
		buf.delete(0 , 4);  // 0~4번재 자리까지. 삭제 
		System.out.println(buf.toString());
		
		/*
		replace : 특정 문자열을 찾아서 지정된 문자열로 변경한다. 
		만약 찾는 문자열이 없다면 변경만 되지 않을뿐 에러가 발생하진
		않는다. 
		 */
		buf.replace(4 , 8, "ABC");   // 4~8번째 자리까지
		System.out.println(buf.toString());
		
		buf.reverse();               // 순서 반전.
		System.out.println(buf.toString());
	}
}
