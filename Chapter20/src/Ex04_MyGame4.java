class Npc4
{
	public String toString()
	{
		return "This is s Npc4.";
	}
}

class Tank4
{
	public String toString()
	{
		return "This is s Tank4.";
	}
}

class Camp4
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

public class Ex04_MyGame4
{
	public static void main(String[] args)
	{
		// 게임 종족 생성
		Camp4 human = new Camp4();
		Camp4 machine = new Camp4();
		
		// 게임 종족에 유닛을 생성해 담기
		// 우리가 만든 유닛을 넣어야 하는데... 잘못 입력하면 실행 하면 에러가 남
		human.set("난 공룡");    
		machine.set("난 우주인");
		
//		Npc3 hUnit = (Npc3)human.get();      
//		Tank3 mUnit = (Tank3)machine.get();
		// 이 둘을 입력하지 않으면 결과가 제대로 나오고 오류도 나오지 않음 위험함.
		
		System.out.println(human.get());     
		System.out.println(machine.get());
	}
}
