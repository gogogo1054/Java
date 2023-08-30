import java.util.HashMap;
import java.util.Set;

/*
HashMap<K, V>
: Map<T> 인터페이스를 구현한 컬레션
-Key, Value 의 쌍으로 객체를 저장한다. 
-Key값은 중복될 수 없다. 만약 중복되면 기존의 데이터를 덮어쓰기한다. 
-Key값으로 검색하므로 다른 컬렉션에 비해 속도가 빠르다. 
-저장 순서는 유지되지 않는다. 
 */
public class Ex14_HashMap  // 일반 자료형으로 사용 못함.
{
	public static void main(String[] args)
	{
		//Map컬렉션 생성. Key와 Value를 모두 String객체로 선언한다. 
		HashMap<String, String> map = new HashMap<>();
		
		/*
		객체저장
			: 객체저장시 기존에 저장된 동일한 Key값이 존재하면 이전에 
			저장된 객체가 반환된다. 만약 처음 입력이라면 null값을 반환한다.
		 */
		// Key-Value 기반 데이타 저장 <= 키값에 벨류값을 저장
		map.put("홍길동", "010-1234-1443");   // put 으로 입력
		map.put("전우치", "010-4321-1443");
		map.put("손오공", "010-9876-1443");
		
		String str1 = map.get("홍길동");   // 특정 위치에 값을 가져올 수 있음
		
		/*
		출력하기
		 	키값을 알고있을때 : get(Key값) 으로 출력한다. 
		 */
		// 데이터 탐색
		System.out.println("홍길동 : " + map.get("홍길동"));
		System.out.println("전우치 : " + map.get("전우치"));
		System.out.println("손오공 : " + map.get("손오공"));
		
		//현재까지 3개의 데이터가 저장됨. 
//		System.out.println("저장된 객체수:"+ map.size());
		System.out.println();
		
		// 데이터 삭제
		map.remove("손오공");
		
		Set<String> ks = map.keySet();  // key 값을 가지고 오려 할 때
		for (String s : ks)
		{
			String str2 = map.get(s);
			System.out.println(str2);
		}	
		
		System.out.println();
	
		// 데이터 삭제 확인
		System.out.println("손오공; " + map.get("손오공"));
		
		map.put("손오공", "010-9876-1443");
		System.out.println("손오공; " + map.get("손오공"));
	}
}
