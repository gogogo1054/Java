import java.util.Iterator;
import java.util.LinkedList;

public class Ex05_PrimitiveData
{
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();  // 객체만 입력해야 함
		
		// 저장과정에서 오토 박싱으로 저장 가능
		list.add(10);
		list.add(20);
		list.add(30);
		
		// for 문 
		for(Iterator<Integer> itr = list.iterator(); itr.hasNext();)
		{
			int n = itr.next();    // 오토 언박싱 정수로 변환 저장
			System.out.println(n);
		}
		
		// while 문
//		Iterator<Integer> itr = list.iterator();
//		while(itr.hasNext())
//		{
//			int n = itr.next();
//		    System.out.println(n);
//		}
	}
}
