//해당 클래스는 toString()메서드를 오버라이딩하여 멤버변수를 
//반환하도록 재정의하였다.
class Book4
{
	String author;
	
	// 메서드 오버라이딩.
	public String toString()
	{
		return author;
	}
}

public class Ex04_toString3
{

	public static void main(String[] args)
	{
		Book4 myBook = new Book4();
		myBook.author = "홍길동";
		System.out.println(myBook.author);
		//toString()을 오버라이딩 하였으므로 이름이 출력된다. 
		System.out.println(myBook);
	}

}
