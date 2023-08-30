import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 Comparator<T>: 
 	기본 정렬 조건이 있다고 하도라도 새로운 정렬 조렬조건을 주고 싶을때 사용
 */
// 임의로 다른 조건을 제시하고 정렬 할때
class MyStringComparator implements Comparator<String>
{
	public int compare(String s1, String s2)  
	{
		// 길이가 동일한 데이터는 추가하지 않는다. <= 이조건을 적용할 것
		return s1.length() - s2.length();
	}
}

public class Ex10_Comparator
{
	public static void main(String[] args)
	{
//		Set<String> tree = new TreeSet<>();
		Set<String> tree = new TreeSet<>(new MyStringComparator());  
		// MyStringComparator() 이 조건을 수행 후 정렬 할 것
		tree.add("홍길동");
		tree.add("전우치");
		tree.add("멀린");
		tree.add("해리포터");
		tree.add("전우치");
		
		for(String s : tree)
			System.out.print(s.toString() + '\t');
		
		System.out.println();
	}
}
