import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 Set계열의 컬렉션 :
 	- 객체가 순서없이 저장된다. 
  	- 객체의 중복저장을 허용하지 않는다. 
 */
public class Ex06_Set
{
	public static void main(String[] args)
	{
		Set<String> set = new HashSet<>();  //String 은 내용값을 비교
		set.add("orange");
		set.add("apple");
		set.add("banana");
		set.add("apple");   // 중복 안됨
		
		System.out.println("객체 수: " + set.size());
		
		// 반복자를 이용한 전체 출력
		for(Iterator<String> itr = set.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();
		
		// 향상된 for 문을 이용한 전체 출력
		for(String s : set)
			System.out.print(s + '\t');
		System.out.println();
	}
}
