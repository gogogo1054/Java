/*
디버깅하며 배우는 힙 영역 원리
	: 객체 변수가 스택 영역과 힙 영역에서 어떻게 처리되는지를 
	알아보겠습니다.
 */
public class Ex02_MemoryInHeap1
{
	public static void main(String[] args)
	{
		Book book1 = new Book();	
		Book book2 = new Book();	
		
		book1.num = 10;	
		book2.num = 20;	
		System.out.println(book1.num);
		System.out.println(book2.num);
		
		book1 = null;	// heap 영역 메모리 null 만들기
		book2 = null;	// heap 영역 메모리 null 만들기
	}	// 여기서 block상태가 됨.
}
