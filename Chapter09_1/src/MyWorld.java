/*
Human클래스가 동일한 패키지에 정의되었다면 컴파일러는 해당 클래스를 찾아 즉시
객체(인스턴스)화 할 수 있다.
만약 다른 패키지에 선언된 클래스라면 반드시 import선언을 해야한다.
*/
class Human
{
	int kind;
	String name;
	int age;
	void sayHello() 
	{
		System.out.println("Hello~");
	}
	
	void sayGoodmorning() 
	{
		sayHello();
	}
}
public class MyWorld
{
	public static void hi()
	{
		System.out.println("Hi~");
	}
	
	public static void main(String[] args)
	{
		// 1. 객체생성 및 참조변수 선언(힙 영역에 인스턴스가 생성됨)
		Human saram1 = new Human();
		// 2. 객체초기화 : 참조변수를 통해 닷(.)으로 접근한다.
		// 여기서 멤버변수에 초기값을 할당한다.
		saram1.kind = 1;
		saram1.name = "홍길동";
		saram1.age = 20;
		
		// 3. 멤버메서드 호출을 통해 걷다, 먹다 등의 행위를 구현한다
		saram1.sayHello();
		saram1.sayGoodmorning();
		
		hi();
	}

}
