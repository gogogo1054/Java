class Npc3
{
	public String toString()
	{
		return "This is s Npc3.";
	}
}

class Tank3
{
	public String toString()
	{
		return "This is s Tank3.";
	}
}

class Camp3
{
	private Object unit;
	
	public void set(Object unit)
	{
		this.unit = unit;
	}
	
	public Object get()
	{
		return unit;
	}
}

public class Ex03_MyGame3
{
	public static void main(String[] args)
	{
		// 게임 종족 생성
		Camp3 human = new Camp3();
		Camp3 machine = new Camp3();
		
		// 게임 종족에 유닛을 생성해 담기
		// 우리가 만든 유닛을 넣어야 하는데... 잘못 입력하면 실행 하면 에러가 남
		human.set("난 공룡");    
		// <-- Human.set(new String("난 공룡");이렇게 형 변화를 하고 입력해야함
		machine.set("난 우주인");
		
		// 게임 종족에서 유닛을 가져오기
		// 꺼낼 때 당연히 게임 유닛을 기대하는데... 실행시 에러가 남
		Npc3 hUnit = (Npc3)human.get();
		Tank3 mUnit = (Tank3)machine.get();
		
		System.out.println(hUnit);
		System.out.println(mUnit);
	}
}
