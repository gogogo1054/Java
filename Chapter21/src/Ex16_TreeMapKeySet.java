import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/*
 TreeMap은 이진트리를 기반으로 한 Map 컬렉션입니다. 
	: TreeMap은 키와 값이 저장된 Map, Etnry를 저장한다는 점입니다. 
	TreeMap에 객체를 저장하면 자동으로 정렬되는데, 키는 저장과 동시에 자동 
	오름차순으로 정렬되고 숫자 타입일 경우에는 값으로, 문자열 타입일 경우에는 
	유니코드로 정렬합니다. 
	정렬 순서는 기본적으로 부모 키값과 비교해서 키 값이 낮은 것은 왼쪽 
	자식 노드에 키값이 높은 것은 오른쪽 자식 노드에 Map.Etnry 객체를 저장합니다. 
	TreeMap은 일반적으로 Map으로써의 성능이 HashMap보다 떨어집니다. 
	TreeMap은 데이터를 저장할 때 즉시 정렬하기에 추가나 삭제가 HashMap보다 
	오래 걸립니다. 
 */
public class Ex16_TreeMapKeySet
{
	public static void main(String[] args)
	{
		// 객체 생성
		TreeMap<String, Integer> map = new TreeMap<>();
		
		// Key-Value 기반 데이타 저장 <= 키값에 벨류값을 저장
		map.put("홍길동", 20);
		map.put("전우치", 25);
		map.put("손오공", 27);
		
		// key만 담고 있는 컬렉션 인스턴스 생성. 정렬된 값을 가져옴.
		Set<String> ks = map.keySet();
		
		// 전체 Key 출력 (향상된 for문 기반)
		for(String s : ks)
			System.out.print(s + '\t');
		System.out.println();
		
		// 전체 Value 출력 (향상된 for문 기반)
		for(String s : ks)
			System.out.print(map.get(s).toString() + '\t');
		System.out.println();
		
		// 전체 Value 출력 (반복자 기반)  <= 수정 할 수 있음
		for(Iterator<String> itr = ks.iterator(); itr.hasNext();)
			System.out.print(map.get(itr.next()).toString() + '\t');
		System.out.println();
	}
}
