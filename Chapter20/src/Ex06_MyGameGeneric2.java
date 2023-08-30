class Npc6
{
	public String toString()
	{
		return "This is s Npc6.";
	}
}

class Tank6
{
	public String toString()
	{
		return "This is s Tank6.";
	}
}

class Camp6<T>   // 이렇게 사용하는 것을 제네릭 이라함.
{
	private T unit;
	
	public void set(T unit)
	{
		this.unit = unit;
	}
	
	public T get()
	{
		return unit;
	}
}

public class Ex06_MyGameGeneric2
{
	public static void main(String[] args)
	{
		// 게임 종족 생성
		Camp6<Npc6> human = new Camp6<>();     // T 가 Npc로 
		Camp6<Tank6> machine = new Camp6<>();
		
		// 게임 종족에 유닛을 생성해 담기
		human.set(new Npc6());
//		Machine.set("난 공룡")     // 제네릭 사용후 이렇게 입력하면 곧바로 에러가남
		
		// 게임 종족에서 유닛을 가져오기
		Npc6 hUnit = human.get();
		Tank6 mUnit = machine.get();

		System.out.println(hUnit);     
		System.out.println(mUnit);
	}
}
