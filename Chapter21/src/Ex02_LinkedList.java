import java.util.LinkedList;
import java.util.List;

/*
 LinkedList<E> : List계열의 컬렉션
-데이터의 중복 저장이 허용된다. 
-데이터의 저장 순서를 보장한다. 
-데이터 접근시 get() 혹은 iterator()를 이용한다. 
-linked라는 연결기반 자료구조.앞의 자료구조에서 본 리스트를 구성하여 객체를 저장한다.
 ArrayList보다 데이터를 추가 삭제가 용이하다. 데이터의 추가/삭제가 많은 경우 사용.
 */
public class Ex02_LinkedList
{
	public static void main(String[] args)
	{
		List<String> list = new LinkedList<>();
		
		// 객체 저장 : 순서 있음. 중복 허용
		list.add("orange");   
		list.add("apple");
		list.add("apple");
		list.add("banana");
		
		// 객체 참조
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');  
		System.out.println();
		
		// 첫 번째 객체 삭제
		list.remove(2);     // 세 번째 데이타 삭제 되면 나머지 순서가 앞으로 당겨짐
		
		// 삭제 후 객체 참조
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
	}
}
