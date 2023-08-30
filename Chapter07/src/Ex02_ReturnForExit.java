
/*
Method(메서드, 함수)
	: 객체지향 프로그램에서 행동 또는 동작을 의미한다.
	즉 어떤 하나의 업무를 처리하기 위한 모듈(부석품)이라 
	정의 할 수 있다.
규칙
	- 메서드는 반드시 class 내부에 정의해야 한다
	- 메서드 안에 또 다른 메서드를 정의할 수 없다.이런 경우 에러가 
		발생한다.
	- 반환값이 없다면 void를 반드시 명시해야 한다
	- 함수명은 변수명과 동일한 규칙으로 작성한다.
Java에서의 NamingRule(이름을 지을때의 규칙)
	- 클래스명 : SimpleFunc => 대문자로 시작하는 Camel case로 작성한다.
	- 메서드 혹은 변수명 : simpleFunc() 혹은 simpleFunc
		=> 소문자로 시작하는 변형된 Camel case
	- 상수명: SIMPLE_FUNC => 전체를 대문자로 기술한다. 단 연결단어는 
		가독성을 위해 _(언더바)로 구분한다.
	- 패키지명 : simple.func => 전체를 소문자로 기술하고, 연갈단어는
		.(닷)으로 구분한다.
*/
public class Ex02_ReturnForExit
{
	public static void main(String[] args)
	{
		devide(4, 2);
		devide(6, 2);
		devide(8, 0);
	}
	
	public static void devide(int num1, int num2)
	{
		if (num2 == 0)
		{
			/*
			 이와 같이 메서드 중간에 return을 기술하면 즉시 종료되므로
			 그 아래에 있는 코드는 실행되지 않는 쓰레기코드가 된다.
			 따라서 return을 사용할때에는 반드시 조건문과 같이 기술되어야
			 한다. 단, 메서드의 마지막 라인에 기술한다면 조건문이 없어도 
			 된다.
			 */
//			return;
			System.out.println("0으로 나눌 수 없습니다."); 
			return;  // 메서드 종료
		}
		
		System.out.println("나눗샘 결과: " + (num1 / num2));
	}
}