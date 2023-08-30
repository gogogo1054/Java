/*
생성자(Constructor) : 객체 생성을 할 때만 호출하는 특수한 메서드입니다.
	- 클래스를 객체화(인스턴스화)할때 자동으로 호출되는 메서드
	- 자동으로 호출되며, 개발자가 임의로 호출할 수 없다.
	- 반환값이 없다. 즉 동작을 마친후 값을 반환할 수 없다.
		따라서 선언시 void를 사용하면 에러가 발생하거나 제대로 만들어지지
		않는다.
	- 그 외에는 메서드가 가진 모든 특성을 가지고 있다.(인수전달, 오버로딩 등)
*/
class Book
{
	// 멤버변수
	String title;
	int price;
	int num = 0;
	
	/*
	 디폴트 생성자 : 해당 클래스에 생성자를 정의하지 않으면 아래와 같이
	 	매개변수, 실행부가 없는 생성자가 컴파일러에 의해 자동으로 삽입
	 	된다. 지금까지 우리가 new 클래스명()과 같이 사용했던 문장이 바로
	 	디폴트 생성자를 호출하여 객체를 생성하는 것이었다.
	 */
	// 디폴트 생성자는 보통 생략
//	Book(){}
	Book()   // 디폴트 생성자에 기능 부여, 
	{
		title = "자바 프로그램밍";
		price = 30000;
	}
	
	// 생성자를 오버로딩해서 매개변수가 있는 생성자를 만듭니다.
	Book(String t, int p)   	// 다른 책들을 추가하고 싶을 때
	{
		title = t;	//-3
		price = p;
	}
	
	void print()	//-4
	{
		System.out.println("제    목 :" + title);
		System.out.println("가    격 :" + price);
		System.out.println("주문수량 :" + num);
		System.out.println("합계수량 :" + price * num);
		System.out.println("===============================");
		
	}
}

public class ConstructorUse
{
	public static void main(String[] args)
	{
		/*
		new 연산자가 객체의 생성자를 이용하여 객체를 생성해줍니다.
		바로 밑에 Book()은 디폴트 생성자
		 */
		Book book1 = new Book(); 	// 디폴트 생성자 사용
		book1.print();
		
		// 오버로딩된 생성자사용
		Book book2 = new Book("자바 디자인패턴", 35000); 
		book2.num = 10;	
		book2.print();
	}
}
