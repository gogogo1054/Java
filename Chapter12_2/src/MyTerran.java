/*
오버라이딩(overriding)
	: 클래스가 상속관계에 있을때 하위클래스에서 상위클래스의 멤버메서드와
	완전히 동일한 모양으로 재정의하는 것을 말한다.
	오버로딩과 다른점은 매개변수의 갯수, 반환타입 등이 완전히 똑같은 
	형태로 재정의 하는 것이다.
	하위클래스에서 오버라이딩 한 메서드는 상위클래스의 메서드를 가리게
	되므로 항상 최하위 클래스에서 오버라이딩한 메서드가 호출된다. 
*/
class Unit
{
	String name;
	int hp;
	
	// 상속관계에서 오버라이딩을 목적으로 정의한 메서드
	void doMove()
	{
		System.out.println("이동속도 10으로 이동");
	}
}

class Marine extends Unit
{
	int attack;
	
	/*
	 @Override : 어노테이션이라 부르고, 오버라이딩된 메서드에 추가하여
	 	컴파일러에게 알려주는 역할을 한다. 필수사항은 아니므로 생략할 
	 	수 있다.
	 */
	void doMove()
	{
		/*
		 super를 통해 부모클래스에 정의된 멤버메서드를 호출한다.
		 특히, 오버라이딩 된 메서드를 호출할때에는 super가 없으면
		 재귀호출이 되므로 주의해야 한다.
		 */
		super.doMove();
		System.out.println(attack + " 공격");  // 기능 추
	}
}

class Medic extends Unit
{
	int heal;
	
	void doMove()
	{
		System.out.println("이동속도 8으로 이동");	// 재정의 
		System.out.println(heal + " 치유");		// 기능추가 
	}
}

public class MyTerran
{
	public static void main(String[] args)
	{
		Marine unit1 = new Marine();
		unit1.name = "마린";
		unit1.hp = 100;
		unit1.attack = 20;
		
		Medic unit2 = new Medic();
		unit2.name = "메딕";
		unit2.hp = 120;
		unit2.heal = 10;
		
		unit1.doMove();
		System.out.println();
		unit2.doMove();
	}
}
