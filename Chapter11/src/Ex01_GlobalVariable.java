/*
 
static variable(정적변수)
- 맴버변수 앞에 static 키워드를 붙이면 정적변수가 된다.
- 정적변수는 JVM(자바가상머신)에 의해 프로그램이 시작되는 시점에 
 	초기화된다.
- main()메서드가 실행되기전에 이미 초기화되므로 main()메서드 실행시
	별도의 선언없이 변수를 사용할 수 있다.
	
접근방법
	- 클래스내부 : 변수명으로 접근가능(일반적인 멤버변수와 동일)
	- 글래스외부	
		1.객체의 참조변수를 통해 접근한다.(권장사항아님)
		2.객체생성없이 클래스명을 통해 접근한다.(권장사항)
- 메서드 앞에 static을 붙이면 정적메서드가 된다. 정적변수와 모든 
	특성이 동일하다.

전역 변수로 사용 :
	메서드 영역 내 스태틱 영역의 변수 및 메서드는 어떤 객체에서도 
	접근해서 사용할 수 있습니다. 그렇기에 스태틱 변수를 전역 
	변수라고 부르기도 합니다.
 */
class Cat
{
	/*
	정적멤버변수 : 객체를 생성할 필요없이 클래스명으로 바로 접근할 수 
		있다. JVM이 프로그램 시작할때 이미 메모리(Method영역)에	로딩
		된다.
	 */
	static int a = 5;	// static 변수. 자주 사용하지는 않는다. 남발하지 마라.
	/*
	멤버변수 : 인스턴스(객체)형 멤버변수는 반드시 클래스의 객체를 생성한 후
		참조변수를 통해 접근해야한다. 즉, 일반적인 멤버변수는 객체를 
		생성하는 시점에 메모리에 로드된다.(멤버변수는 Stack영역에,
		객체는 Heap영역에 생성된다.)
	 */
	int num = 3;
	
	/*
	인스턴스(객체)형 멤버메서드 : 인스턴스형 메서드에서는 모든 멤버를 사용할 
		수 있다. 인스턴스형 멤버, 정적 멤버 둘 다 접근이 가능하다.
	 */
	void printValue(int num)
	{
		this.num = num;
		System.out.println("num;"+this.num);
		System.out.println("a:"+a);
	}
}

public class Ex01_GlobalVariable
{
	
	public static void main(String[] args)	// 프로그램 시작 지점
	{
		int num1 = 5;	
		int num2 = 2;	
		System.out.println(num1 + ", " + num2);
		
		/*
		일반적인 멤버변수에 접근하는 방법 : MyStatic클래스의 객체를 
			생성한 후 참조변수를 통해 접근한다.
		 */
		Cat cat1 = new Cat();	// 스택 영역에 생성 
		cat1.num = 1;			
		
		cat1.a = 10;			// static 변수에 직접 
		cat1.printValue(20);	// 함수 호출
		System.out.println(cat1.num);	
		System.out.println(cat1.a);	
		
		Cat cat2 = new Cat();	// 스택 영역에 생성 
		cat2.num = 2;	
		
		cat2.a = 11;			// static 변수에 직접 접근
		cat2.printValue(10);	// 함수 호출
		
		/*
		인스턴스형 변수는 각각의 객체내에 존재하므로 아래 num의 값은
		서로 다르게 출력된다.
		 */
		System.out.println(cat2.num);	
		
		/*
		하지만 정적변수는 메서드 영역에 딱 하나만 생성되므로 어떤 
		객체로 접근하든 동일한 메모리가 된다. 따라서 값을 공유하게 
		되므로 출력결과는 동일하다. 마지막 값이 적용됨.
		 */
		System.out.println(cat2.a);		
		System.out.println(cat1.a);		
		
		/*
		결과를 보듯 입력시에는 각각의 참조변수를 사용했지만 결국
		하나의 정적변수에 값을 입력한 결과가 되므로, 정적변수에 접근
		시에는 참조변수를 사용하지 말고, 클래스명을 사용하는 것이
		좋다.
		*/
		System.out.println("직접호출: " + Cat.a);
		
		/*
		결론 :
		일반적인 인스턴스형 멤버는 객체의 참조변수를 통해 접근한다.
		정적(static) 멤버는 클래스명을 통해 객체생성없이 접근한다.
		 */
	}
}
