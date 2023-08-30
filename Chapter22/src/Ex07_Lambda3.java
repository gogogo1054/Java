/*
람다식으로 구현하기
	: 객체지향 프로그래밍에서는 메서드를 선언하기 위해 반드시 클래스를
	정의해야한다. 이러한 불편함 때문에 함수형 프로그래밍(Functional
	Programming)의 장점이 대두되었고, 이런 Java문법의 단점을 보완하기
	위해 JDK1.8부터 람다식을 지원하게되었다. 
 */

//람다식 정의를 위한 인터페이스 정의
interface Unit7
{
	void move(String s);
}

public class Ex07_Lambda3
{
	public static void main(String[] args)
	{
		/*
	 	앞의 예제의 익명클래스를 다음과 같은 람다식으로 표현할 수 있다. 
		1.함수명을 제거한다. 어차피 부모 인터페이스로부터 오버라이딩 
		했으므로 동일한 이름인것을 우리는 알고있다. 
		2.람다식 임을 표현하기 위해 소괄호와 중괄호 사이에 화살표를 삽입
		한다. 좌측의 부모참조변수가 우측의 자식영역을 참조한다는 개념으로
		이해하면 된다. 
		 */
//		Unit6 unit = new Unit6() {    // 앞의 예제
//			public void move(String s)
//			{
//				System.out.println(s);
//			}
//		};
		
		Unit6 unit = (String s) ->     // (String s) 값을 함수('{ }')를 이용하여 unit에 넣어라
					// 	(String s) 에서부터 '};' 여기까지를 람다식이라 함
			{                              //여기서 부터 함수
				System.out.println(s);
			};                             // 함수 끝
		
		//추상메서드의 이름을 통해 람다식을 호출한다. 
		unit.move("Lambda : unit 7");
	}
}
