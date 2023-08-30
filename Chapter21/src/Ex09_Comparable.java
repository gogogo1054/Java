import java.util.Set;
import java.util.TreeSet;

/*
클래스 생성시 정렬의 기준을 만들어주기 위해서는 Comparable<T>
인터페이스를 구현해야 한다.
 */
// 정렬 순서 정하기
class Student2 implements Comparable<Student2>
{
	private String name;
	private int age;
	
	public Student2(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	//Object 클래스에서 제공하는 메서드를 오버라이딩
	public String toString()  
	{
		return name + ":" + age;
	}
	
	/*
	TreeSet<T>에 객체를 저장할때 정렬을 위해 compareTo()메소드를
	오버라이딩한다. 
	정렬의 기준은 단순하게 가나다와 같은 순서가 될수도 있고, 문자열의
	길이에 따른 정렬도 될수있다.  
	 */
//	@Override	// 생략
	public int compareTo(Student2 p)   
	// 정렬 순서를 정하지 않으면 TreeSet<> 에 입력이 안 됨
	{
//		return this.age - p.age;      // 나이 오른차순 정렬
//		return p.age - this.age;      // 나이 내림차순 정렬
//		return this.name.compareTo(p.name);  // 이름 가나다 순 정렬
		return p.name.compareTo(this.name);  // 이름 역순으로 정렬
	}
	
}
public class Ex09_Comparable
{
	public static void main(String[] args)
	{
		Set<Student2> tree = new TreeSet<>(); //compareTo 하지 않으면 입력이 안 됨
		tree.add(new Student2("홍길동", 30));
		tree.add(new Student2("전우치", 40));
		tree.add(new Student2("손오공", 20));
		
		//Set 컬렉션이므로 중복저장은 허용되지 않는다. 
//		tree.add(new Student2("손오공", 20));
		
		for(Student2 s : tree)
			System.out.println(s);
	}
}
