import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest
{
	public static void main(String[] args)
	{
		// Map<키, 밸류> -> 키는 중복을 허용하지 않음
		// 키가 중복인 경우 값을 변경
		Map<String, String> map = new HashMap<>();
		map.put("만화", "마녀배달부 키키");
		map.put("호러", "스크림");
		map.put("영화", "황혼에서 새벽까지");
		
		System.out.println(map);
		System.out.println();
		
		String key;
		Set<String> set = map.keySet();
		
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			key = (String)it.next();
			System.out.println(map.get(key));
		}
		System.out.println();
		
		map.put("영화", "놀자..."); // 동일한 키는 값을 변경
		System.out.println(map);
		System.out.println();
		
	}
}
