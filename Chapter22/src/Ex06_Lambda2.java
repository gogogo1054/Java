/*
익명클래스 정의를 통한 오버라이딩
 */

//인터페이스 정의(부모객체로 사용)
interface Unit6
{
	void move(String s);
}

//익명클래스를 통해 구현하므로 implements는 필요하지 않다. 
//즉, 상속을 위한 클래스를 생성할 필요가 없다.
public class Ex06_Lambda2
{
	public static void main(String[] args)
	{
		/*
		Unit6 인터페이스를 구현한 익명클래스를 정의한다. 
		extends 혹은 implements 키워드는 없지만 중괄호 부분은 자식의 
		영역이 된다. 즉, 익명클래스는 눈에 보이지 않는 상속(혹은 구현)이
		되어있어 오버라이딩이 가능하다.
		 */
		Unit6 unit = new Unit6() {    // 익명 클래스. 부모 이름으로 new 하면됨
			/*
			상속의 절차를 익명클래스로 대체하므로 코드가 좀 더 간결해진다.
			 */
			public void move(String s)	// 오버라이딩
			{
				System.out.println(s);
			}
		};
		unit.move("Lambda : unit 6");
	}
}
