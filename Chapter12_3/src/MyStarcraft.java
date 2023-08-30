/*
추상클래스
	- 상속을 목적으로 제작되므로 객체생성을 허용하지 않는다.
	- 추상클래스는 대부분 추상메서드를 포함하고 있으므로, 이를 상속받는
	클래스는 반드시 추상메서드를 오버라이딩 해야한다.
	- 클래스의 상속관계에서 설계도와 같은 역활을 한다.
	- 객체생성은 할수없으나 그외 참조변수, 상속 등의 모든 기능을 사용할
	수 있다.
	
추상메서드
	- 오버라이딩의 목적으로 제작된다.
	- 메서드의 실행부가 없으므로 중괄호{} 대신 ;을 붙여 마무리한다.
 */

/*
추상메서드를 맴버로 포함한 클래스는 반드시 abstract로 선언해야한다.
그렇지 않으면 에러가 발생한다.
 */
abstract class Unit
{
	/*
	추상메서드는 실행부가 없으므로 {}를 기술하지 않는다. ;으로 끝남.
	오버라이딩을 목적으로 생성한다.
	 */
    abstract void doMove();
}

class Marine extends Unit
{
	/*
	위 클래스를 상속하면 부모가 가진 추상메서드를 그대로 상속받게 되므로
	해당 클래스도 abstract로 선언해야 한다. 단, 이경우 해당 클래스로도
	객체를 생성할 수 없게된다. 만약 객체를 생성해야 한다면 추상메서드를 
	자식쪽에서 오버라이딩 하면된다.
	 */
//	@Override
    void doMove()
    {
        System.out.println("마린은 두 발로 이동합니다.");
    }
}

class Zergling extends Unit
{
    void doMove()
    {
        System.out.println("질럿은 네 발로 이동합니다.");
    }
}

public class MyStarcraft
{
    public static void main(String[] args)
    {
    	// 추상클래스는 객체를 생성할 수 없다.
//		Unit unit = new Unit();
		
    	// 추상클래스를 상속한 하위클래스는 객체생성을 할수 있다.
        Marine unit1 = new Marine();
        unit1.doMove();
        
        Zergling unit2 = new Zergling();
        unit2.doMove();
    }
}