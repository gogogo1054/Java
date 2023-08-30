import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex03_CollectionVsStream
{
	public static void main(String[] args)
	{
		int[] arr = {1, 5, 3, 2, 4};   
		List<Integer> list = new ArrayList<>();
		
		// 컬렉션 프레임워크를 이용한 방식
		for (int i : arr)   // 중간 연산
		{
			if (i%2 == 1)
			{
				list.add(i);
			}
		}
		
		Collections.sort(list);   // 순서 정렬
		
		for (int i : list)  // 최종 연산 => 결과 출력  
		{
			System.out.print(i + "\t");
		}
		
		System.out.println();
		
		// Stream 을 이용한 방식. 간결하게 사용 가능.
		Arrays.stream(arr)
				.filter(n -> n%2 ==1)    // 중간 연산
				.sorted()                // 순서 정렬
				.forEach(n -> System.out.print(n + "\t")); // 최종 연산 => 결과 출력 끝

		System.out.println();
	}
}
