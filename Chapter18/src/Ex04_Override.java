interface Unit4
{
	public void move(String str);
}

/*
 자바의 어노테이션은 소스코드에 추가해서 사용할 수 있는 메타 데이터의 일종이다. 
 메타 데이터란 애플리케이션이 처리해야할 데이터가 아니라 컴파일 과정과 실행 
 과정에서 코드를 어떻게 처리해야하는지를 알려주기 위한 추가 정보다.
 에노테이션은 주석이라는 의미를 가진다.
 자바 소스 코드에 사이에 @ 기호를 앞에 붙여서 사용하는데,  
 JDK 1.5 버전 이상에서 사용 가능하다.
 어노테이션의 용도
	- 컴파일러에게 코드 작성 문법 에러를 체크하도록 정보를 제공
	- 소프트웨어 개발툴이 빌드나 배치시 코드를 자동으로 생성할 수 있도록 정보 제공
	- 실행시(런타임시)특정 기능을 실행하도록 정보를 제공
 */
class Human4 implements Unit4
{
	/*
	 @Override
		- 선언한 메서드가 오버라이드 되었다는 것을 나타냅니다.
		- 만약 상위(부모) 클래스(또는 인터페이스)에서 해당 메서드를 
		찾을 수 없다면 컴파일 에러를 발생 시킵니다
	 */
	@Override    // 오타방지를 위해서 사용
	//public void move(Sting str) <- Sting 오타찾음
	public void move(String str) 
	{
		System.out.println(str);
	}
}

public class Ex04_Override
{
	public static void main(String[] args)
	{
		Unit4 unit = new Human4();
		unit.move("인간형 유닛이 이동합니다.");
	}
}
