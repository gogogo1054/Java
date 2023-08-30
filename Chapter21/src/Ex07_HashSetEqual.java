import java.util.HashSet;

/*
HashSet<E> : Set계열의 컬렉션
-Set계열의 인터페이스를 구현한 컬렉션
-객체가 순서없이 저장된다. 
-객체의 중복저장을 허용하지 않는다. 
-단 기본클래스(String, Integer등)가 아닌 개발자가 새롭게 정의한 클래스라면
	hashCode(), equals() 메서드를 적절히 오버라이딩하여 중복에 대한 기준을 
	설정해야한다. 
-List가 배열의 특성을 가진다면, Set은 집합의 특성을 가진다. 
 */
class Student
{
	private String name;
	private int age;
	
	public Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String toString()  // 오버라이징딩 하지 않으면 hachcode 값이 나옴
	{
		return name + ":" + age;
	}
	
	/*
	 Hash Code란, 객체를 식별할 수 있는 유니크한 값을 말한다. 메모리에 생성된 
	 객체의 주소를 정수로 변환한 형태를 얘기하는데, 이 정수는 중복되지 않는 
	 고유의 값입니다.
	 */
//	public int hashCode()    // 나이비교
//	{
//		int num = age % 3;
//		System.out.println(num);
//		return num;
//	}
	
	public int hashCode()  // 이때는 equals() 호출 되지 않음.
	{
		int num = java.util.Objects.hash(name, age);  // <== 비교대상 .가변인자
		System.out.println(num);
		return num;
	}
	
	public boolean equals(Object obj)	
	{
		System.out.println("비교를 합니다.");  
		// name, age 둘다 비교 후 먼저 입력한 값이 나옴 하나라도 다르면 비교 안 함
		if(age == ((Student)obj).age)
			return true;
		else
			return false;
	}
}

public class Ex07_HashSetEqual
{
	public static void main(String[] args)
	{
		//Object를 기반으로 Set컬렉션을 생성하면 모든 객체를 저장할수 있다.
		HashSet<Student> set = new HashSet<>();
		
		/*
		객체저장  
			: add()메서드를 통해 저장되고, 성공하면 true를 반환한다.
		 */
		set.add(new Student("홍길동", 20));  // 특정 위치에 입력이 안됨 set.add(0."홍길동")이 안됨
		set.add(new Student("전우치", 20));
		set.add(new Student("홍길동", 25));
		
		System.out.println("객체 수: " + set.size());
		
		for(Student s : set)
			System.out.print(s.toString() + '\t');
		
		System.out.println();
		
		// 추가
		/*
		기본클래스의 객체 중복저장
			: 기본 클래스인 경우 별도의 오버라이딩 없이도 중복이 제거된다.
			따라서 아래의 add()메서드는 false를 반환한다. 
		 */
		System.out.println(set.add(new Student("홍길동", 25)) ? "저장성공":"저장실패");
		//저장에 실패이므로 5개 출력
		System.out.println("[중복 저장후 객체수]:"+ set.size());
		System.out.println();
		
		/*
		포함여부 확인
			: set 컬렉션 내에 해당 객체가 있는지만 확인한다. 
		 */
		System.out.println(set.contains(new Student("홍길동", 25)) ? 
				"\"홍길동\", 25 있음" : "\"홍길동\", 25 없음");
		
		/*
		객체삭제
			: set컬렉션은 인덱스가 없으므로 객체의 참조값을 통해서만
			삭제할 수 있다. 
		 */
		System.out.println(set.remove(new Student("홍길동", 25)) ?
				"\"홍길동\", 25 삭제 성공" : "\"홍길동\", 25 삭제 실패");
		System.out.println("[중복 삭후 객체수]:"+ set.size());
		System.out.println();
		
		/*
		전체삭제
			: List컬렉션과 동일하다. 
		 */
		set.clear();
		System.out.println("전체삭제:"+ set.removeAll(set));
		System.out.println("[전체 삭제후 객체 수]:"+ set.size());
	}
}
