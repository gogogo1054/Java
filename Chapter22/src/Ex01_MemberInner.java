/*
내부클래스(Inner class)
: 클래스 안에 정의된 클래스로 static이 없는 클래스를 말한다. 
-외부 클래스의 모든 멤버(정적 혹은 인스턴스형)를 사용할 수 있다. 
-정적 멤버를 가질수 없다. 단 상수는 가질수있다. 
-컴파일시 외부클래스명$내부클래스명.class 파일이 생성된다. 
-이벤트 기반의 프로그래밍에서 많이 사용된다. 
 */
//외부클래스 정의
class Outer1
{
	//멤버변수
	private int speed = 10;
	
	// 맴버 내부 클래스
    // Outer1$MemberInner1.class 이렇게 파일이 생성됨 $로 디렉토리 구분. 
	// bin에서 확인
	class MemberInner1    
	{
		/*
		내부클래스에서는 외부클래스의 모든 멤버에 접근할 수 있다. 
		외부클래스가 더 넓은 지역이기 때문이다. 
		 */
		// 외부 클래스의 자원(speed) 사용 가능
		public void move()
		{
			System.out.printf("인간형 유닛이 %d 속도로 이동합니다.\n", speed);
		}
	}
	
	public void getMarine()
	{
		MemberInner1 inner = new MemberInner1();
		inner.move();
	}
}

public class Ex01_MemberInner
{
	public static void main(String[] args)
	{
		//외부클래스의 객체를 먼저 생성한다.
		Outer1 out = new Outer1();
		
		// out 기반으로 생성됨 객체의 메서드 호출
		out.getMarine();
		
		/* 추가
		외부클래스가 아닌 다른 클래스에서는 내부멤버클래스가 보이지
		않으므로 직접 인스턴스를 생성할 수 없다. 
		 */
//		MemberInner1 inner = new MemberInner1(); //에러발생
		
		/*
		외부클래스의 인스턴스를 먼저 생성한 후 내부클래스의 인스턴스를
		생성해야한다. MemberInner1은 Outer1클래스의 생성자에서 이미 객체가
		생성되었으므로 아래와같이 즉시 객체를 생성할 수 있다. 
		 */
		// out 기반으로 내부 클래스 객체 생성
		Outer1.MemberInner1 inner = out.new MemberInner1();   // 가능하나 잘 사용하지않음
		
		// inner 기반으로 생성된 객체의 메서드 호출
		inner.move();      // 가능하나 잘 사용하지않음
	}
}
