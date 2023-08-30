import java.util.ArrayList;
import java.util.List;

/*
ArrayList<E> : List계열의 컬렉션
-데이터의 중복 저장이 허용된다. 
-데이터의 저장 순서를 보장한다. 
-데이터 접근시 get() 혹은 iterator()를 이용한다. 
-Array라는 이름처럼 '배열'의 특성을 가지고 있어 index를 통한
저장 및 접근이 가능하다. 탐색 또는 정렬을 자주사용하는 경우에 많이 사용.
 */
public class Ex01_ArrayList
{
	public static void main(String[] args)
	{
		/*
		String 객체를 저장할 수 있는 List컬렉션 생성
		ArrayList와 나머지 컬렉션들은 데이터를 저장하는 내부적인 자료구조만
		다를뿐 사용법은 100% 동일하다. 
		 */
		List<String> list = new ArrayList<>();	// 자식을 부모에 대입
		
		/*
		객체저장 : add() 
			add(객체) : 순차적으로 저장하면서 인덱스는 0부터 자동으로 
				부여한다.
			add(인덱스, 객체) : 데이터 저장시 인덱스를 직접 부여한다. 단, 
				인덱스를 건너뛰면 에러가 발생하므로 주의해야 한다. 
				해당 인덱스에 이미 객체가 저장되어 있다면 삽입(끼워넣기)이 
				된다.
		 */
		// 객체 저장 : 순서 있음. 중복 허용
		list.add("orange");    // 추가할때 add() 사용
		list.add("apple");
		list.add("apple");
		list.add("banana");
		
//		// 추가
//		list.add(4,"banana1");
//		// 에러발생. 인덱스를 건너뛸 수 없다.
//		list.add(6,"banana2");
//		list.add(list.size(),"mango"); 
//		System.out.println("중복 저장전 객체수:"+ list.size()); 
//		/*
//		중복저장 
//			: List는 배열의 특성을 가지므로 데이터의 중복저장이 허용된다. 
//			동일한 데이터라 할지라도 index로 구분할 수 있기때문이다. 
//			add() 메서드는 추가에 성공한 경우 true를 반환한다. 
//		 */
//		System.out.println(list.add("mango") ? "중복저장됨":"중복저장안됨");
//		System.out.println("중복 저장후 객체수:"+ list.size());
		
		/*
		 컬렉션 출력시 일반for문 사용. 이때는 인덱스를 통해 접근해야 하므로
		 get()메서드를 사용한다.
		 */
		// 객체 참조. 일반 for문 사용
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');   // data 부를 때는 get() 사용
		System.out.println();
		
		// 첫 번째 객체 삭제
		list.remove(0);     // 첫 번째 데이타 삭제 되면 나머지 순서가 앞으로 당겨짐
		
		// 삭제 후 객체 참조
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
	}
}
