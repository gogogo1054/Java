import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// 응용
public class Ex11_ConvertExt
{
	public static void main(String[] args)
	{
		// 크기의 변경이 안됨.
		List<String> immutableList = 
				Arrays.asList("홍길동", "전우치", "전우치", "손오공");
		// 변경 가능하게 다시 ArrayList로 객체생성
		ArrayList<String> mutableList = new ArrayList<>(immutableList);
		
		for(String s : mutableList)
			System.out.print(s.toString() + '\t');
		System.out.println();
		
		// Set특성을 이용해서 중복 제고
		HashSet<String> set = new HashSet<>(mutableList);
		
		// 다시 Set을 list로 변환
		mutableList = new ArrayList<>(set);
		
		// 향상된 for문으로 중복 제거 확인
		for(String s : mutableList)
			System.out.print(s.toString() + '\t');
		System.out.println();
	}
}
