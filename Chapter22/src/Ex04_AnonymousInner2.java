/*
인터페이스 정의
: 기능이 없는 추상메서드만 멤버메서드로 정의할 수 있다. 
또한 메서드 앞에는 public abstract가 생략되어 있다. 
 */
interface Unit4
{
	void move();
}

/*
익명클래스(Anonymous class)
-이름이 없는 클래스를 말한다. 
-내부클래스처럼 이벤트 기반의 프로그래밍에서 많이 사용된다.(안드로이드)
-부모클래스의 메서드를 오버라이딩 하는것이 목적이다. 
-클래스를 정의하는 것이 마치 메서드를 정의하는것과 비슷하다. 
-마지막에 세미콜론을 반드시 기술해야 한다. 
형식]
	부모클래스명 참조변수 = new 부모클래스명(){
		익명클래스의 실행부;
		부모클래스의 메서드 오버라이딩();
	};
	※부모클래스를 상속받아 이름없는 자식클래스를 생성하는
	개념으로 이해하면된다. 상속되기 때문에 오버라이딩이 가능하다. 
	즉, {} 안쪽은 "자식"의 영역이다.
 */
class HumanCamp4
{
	private int speed = 10;
	
	public Unit4 getMarine()
	{
//		class Marine3 implements Unit3	// 앞의 예제
//		{
//			public void move()
//			{
//				System.out.printf("인간형 유닛이 %d 속도로 이동합니다.\n", speed);
//			}
//		}
//		
//		return new Marine3();
		
		// 이름이 없으므로 부모 클래스나 인터페이스의 이름을 사용
		return new Unit4()   //<== 익명 클래스 위에 클래스가 생략됨, 부모 이름으로 new
		{
			public void move()	// 오버라이딩
			{
				System.out.printf("인간형 유닛이 %d 속도로 이동합니다.\n", speed);
			}
		};    // 하나의 실행문이므로 세미콜론으로 끝납니다.
	}
}

public class Ex04_AnonymousInner2
{

	public static void main(String[] args)
	{
		// 객체 생성
		HumanCamp4 hc = new HumanCamp4();
		
		/*
		인터페이스를 구현(상속)하여 생성한 익명클래스
		추상메서드는 기능이 없지만 오버라이딩의 목적으로 생성하므로 
		아래처럼 구현하는게 일반적이다. 
		 */
		Unit4 unit = hc.getMarine();
		unit.move();
	}
	/*
	결론]
		상속의 목적은 "확장"
		익명클래스의 목적은 "오버라이딩"이다. 
		따라서 익명클래스는 주로 interface를 통해 구현한다. 
	 */
}
