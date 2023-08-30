/*
상속(Inheritance)
	: 기존에 정의된 클래스에 메서드와 변수를 추가하여 새로운 클래스를
	정의하는것을 말한다. 부모클래스를 자식클래스가 상속할때는 extends
	키워드를 사용한다. 
 */
//부모(상위)클래스 : 캐릭터의 일반적인 형태를 추상화한다.
class Unit
{
	String name;
	int hp;
	
	void printUnit()
	{
		System.out.println("이름 : " + name);
		System.out.println("HP : " + hp);
	}
}

//자식(하위)클래스 : Unit클래스를 상속받아서 Marine을 추상화한다.
class Marine extends Unit
{
	int attack;
	
	void printMarine()
	{
		printUnit();
		System.out.println("공격력 : " + attack);
	}
}

//자식(하위)클래스 : Unit클래스를 상속받아서 Medic을 추상화한다.
class Medic extends Unit
{
	int heal;
	
	void printMedic()
	{
		printUnit();
		System.out.println("치유량 : " + heal);
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
		
		unit1.printMarine();
		System.out.println();
		unit2.printMedic();
	}
}
