public class Ex02_Char
{
	public static void main(String[] args)
	{
		/*
		char형 : 하나의 문자를 저장할 수 있는 자료형으로 값을 저장할때
			'(Single quotation)으로 감싸서 표현한다. 
			만약 "(Double quotation)으로 감싸면 문자열로 인식하므로 
			이경우에는 String으로 선언해야한다.
		 */
		// 자바가 인코딩을 합니다.
		char ch1 ='A';     // 한글자만 가능             
		// 10진수로 직접 문자의 값을 넣어줍니다. 진법변환만
		char ch2 =65;                    
		// 16진수로 직접 문자의 값을 넣어줍니다. 진법변환만
		char ch3 =0x41;                 
		// 2진수로 직접 문자의 값을 넣어줍니다.
		char ch4 =0b0000000001000001;   
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		
		/*
		아스키코드 : 1byte로 표현할 수 있는 문자(영문, 숫자)를 십진수로
			정의한것을 말한다. 
			예) A => 65, a => 97로 표현된다. 
		유니코드 : 1byte로 표현할 수 없는 문자로 한글, 한자 등을 2byte로 
			표현한것을 말한다. 보통 큰 숫자이므로 16진수로 표현한다.
		 */
	}
}