import java.util.Iterator;
import java.util.TreeSet;

/*
TreeSet<T> 컬렉션
: 트리라는 자료구조를 기반으로 한 Set계열의 컬렉션
-Set의 기본적인 특성은 동일하다. 
-중복은 허용되지 않는다. 
-단 객체가 정렬되어 저장된다. 정렬의 기준은 개발자가 직접 정의
할 수 있다. 
 */

public class Ex08_TreeSet
{
	public static void main(String[] args)
	{
		TreeSet<String> tree = new TreeSet<>();
		tree.add("홍길동");
		tree.add("전우치");
		tree.add("손오공");
		tree.add("멀린");
		tree.add("손오공");
		
		System.out.println("객체 수: " + tree.size());
		
		// Iterator 반복자에 의한 반복
		// 이름 가나다순으로 정력해줌
		for(Iterator<String> itr = tree.iterator(); itr.hasNext(); )
			System.out.print(itr.next().toString() + '\t');
		System.out.println();
	}
}
