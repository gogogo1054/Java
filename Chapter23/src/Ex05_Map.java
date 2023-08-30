import java.util.Arrays;
import java.util.List;

/*
 map :
 	요소들을 특정조건에 해당하는 값으로 변환해 줍니다.
	요소들을 대,소문자 변형 등 의 작업을 하고 싶을떄 사용 가능 합니다.
 */
public class Ex05_Map
{

	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("apple", "banana", "orange");
		
		list.stream()
		    .map(s -> s.toUpperCase())   // 대문자로 변환
		    //  map 은  data 원형을 변경하는데 사용
		    .forEach(n -> System.out.print(n + "\t"));
		
		System.out.println();
	}

}
