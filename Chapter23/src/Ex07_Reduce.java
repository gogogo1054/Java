import java.util.Arrays;
import java.util.List;

/*
 reduce() :
 	정의된 연산이 아닌 프로그래머가 직접 구현한 연산을 적용한다.
 	최종 연산으로 스트림의 요소를 소모하여 연산을 수행한다.
 */
public class Ex07_Reduce   // 정의 되지 않는 연산
{
	public static void main(String[] args)
	{
		List<String> list1 = Arrays.asList("홍길동", "전우치", "손오공");
				
		String name1 = list1.stream()   // Arrays 는 list로 stream 할 수 있음
				.reduce("이순신", (s1, s2) ->     // 이순신 <= 초기값
						s1.length() >= s2.length() ? s1 : s2);
		System.out.println(name1);
				
		List<String> list2 = Arrays.asList("홍길동", "멀린", "해리포터");
		
		String name2 = list2.stream()
				.reduce("이순신", (s1, s2) ->     // 이순신 <= 초기값
						s1.length() >= s2.length() ? s1 : s2);
		System.out.println(name2);
	}
}
