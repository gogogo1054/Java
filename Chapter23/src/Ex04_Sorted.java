import java.util.Arrays;
import java.util.List;

/*
 sorted :
 	스트림내 요소들에 대해서 정렬하는 작업
 */
public class Ex04_Sorted
{

	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("홍길동", "멀린", "해리포터");
		
		
		// 사전순 정렬
		list.stream()
			.sorted()    // 중간 연산은 여러개 사용 가능
			.forEach(n -> System.out.print(n + "\t"));   // 최종 연산 하나만 가능

		System.out.println();
		
		// 역순 정렬. 추가
		list.stream()
		    .sorted((s1, s2) -> s2.compareTo(s1))    
		    .forEach(n -> System.out.print(n + "\t"));
		
		System.out.println();
		
		// 람다식을 이용하여 글자 길이순 정렬
		list.stream()
		    .sorted((s1, s2) -> s1.length() - s2.length())    
		    // 길이순서로 data 바꾸어서 정렬
		    .forEach(n -> System.out.print(n + "\t"));
		
		System.out.println();
	}

}
