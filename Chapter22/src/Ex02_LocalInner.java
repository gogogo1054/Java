class HumanCamp2
{
	private int speed = 10;
	
	public void getMarine()
	{
		// 지역 내부 클래스
		class Marine2   // HumanCamp2$1Marine2.class  이렇게 파일이 생성됨  $1 으로 구분
		// 이 안에서만 사용 가능 다른데서 사용하지 못함
		{
			// 외부 클래스의 자원(speed) 사용 가능
			public void move()
			{
				System.out.printf("인간형 유닛이 %d 속도로 이동합니다.\n", speed);
			}
		}
		
		// 여기서만 생성 가능. 객체의 생성을 제한
		Marine2 inner = new Marine2();	
		inner.move();
	}
}

public class Ex02_LocalInner   
{
	public static void main(String[] args)
	{
		HumanCamp2 hc = new HumanCamp2();
		hc.getMarine();
	}
}
