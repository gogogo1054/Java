class Book5
{
	String author;
}

/*
equals()메서드
-자바에서 인스턴스의 내용 비교를 위해 비교연산자(==)를 사용하는것은
단순히 참조값에 대한 비교이므로, 실제 내용에 대한 비교가 이뤄지지 
않는다. 
-인스턴스간의 내용비교를 위해 equals()메서드를 각 클래스에 맞게
오버라이딩하여 사용해야 한다. 
-String과 같은 기본클래스는 별도의 오버라이딩 없이도 내용비교가 
가능하다. 
 */
public class Ex05_equals1
{

	public static void main(String[] args)
	{
		Book5 myBook1 = new Book5();
		myBook1.author = "홍길동";
		
		Book5 myBook2 = new Book5();
		myBook2.author = "홍길동";
		
		if ( myBook1.equals(myBook2) )
			System.out.println("두 객체의 참조 id는 같습니다.");
		else
			System.out.println("두 객체의 참조 id는 다릅니다.");
	}
}
