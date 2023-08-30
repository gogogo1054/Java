import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex04_Convert
{
	public static void main(String[] args)
	{
		// 매게변수로 전달된 객체들을 저장한 컬렉션 객체의 생성 및 반환
		// 이렇게 생성된 리스트 인스턴스는 Immutable(불변) 객체임(생성 후 
		// 그 상태를 바꿀 수 없는 객체)
		List<String> list = Arrays.asList("홍길동", "전우치", "손오공", "전우치");
//		list.add("멀린");    // 실행 하면 에러남 배열에는 추가할수 없음
		list = new ArrayList<>(list);    // mutable 객체로 변환 ArrayList<> 로 변환
		list.add("해리 포터");   // 이젠 추가가 됨
				
		// ArrayList<E> 객체 순환
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');  
		System.out.println();
		
		// ArrayList<>를 LinkedList<E>로 변환  자식을 부모에게 대입할수 있음.
		list = new LinkedList<>(list);
		
		// LinkedList<E> 객체의 순환
		for(String s : list)
			System.out.print(s + '\t');
		System.out.println();
	}
}
