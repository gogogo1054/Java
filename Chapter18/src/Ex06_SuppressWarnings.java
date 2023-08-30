interface Unit6
{
	@Deprecated
	public void move(String str);   // 곧 없어질 내용이므로 반드시 수정할 것
	public void run(String str);    // 수정될 내용
}
/*
@SuppressWarnings
	- 선언한 곳의 컴파일 경고를 무시하도록 합니다.
 */
class Human6 implements Unit6
{
	@Override
	// @SuppressWarnings("deprecation")   // 수정할 내용 위에 다 사용해야함.
	public void move(String str) 
	{
		System.out.println(str);
	}  
	@Override   // 수정될 내용
	public void run(String str) 
	{
		System.out.println(str);
	}
}

public class Ex06_SuppressWarnings
{
	@SuppressWarnings("deprecation")   // deprecation 관련 워닝 메세지 생략
	public static void main(String[] args)
	{
		Unit6 unit = new Human6();
		unit.move("인간형 유닛이 이동합니다.");
		unit.run("인간형 유닛이 달립니다.");  // 수정될 내용
	}

}
