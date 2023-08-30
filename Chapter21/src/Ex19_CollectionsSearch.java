import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex19_CollectionsSearch
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("전우치");
		list.add("손오공");
		list.add("멀린");
		
		// 정렬
		Collections.sort(list);
		
		// 탐색  <= 정렬후 해야 함
		// 검색되면 해당 인덱스가 반환 됨.
		int idx1 = Collections.binarySearch(list, "홍길동");
		System.out.println(idx1);
		
		int idx2 = Collections.binarySearch(list, "해리 포터");   
		// 없으면 마이너스 값 출력
		System.out.println(idx2);
	}

}
