import java.util.Arrays;

class Person implements Comparable    
// Comparable있어야 comparaTo 를 사용할 수 있음
{
	private String name;
	private int age;
	
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Object o)  // comparaTo가 있어야 정렬을 할 수 있음
	{
		Person p = (Person)o;
		int nNum = this.name.compareTo(p.name);   // 이름을 사전순으로 정렬
		return nNum;
		
//		if(this.age > p.age)   // 나이를 작은수 부터 정렬
//			return 1;
//		else if(this.age < p.age)
//			return -1;
//		else
//			return 0;
	}
	
	public String toString()
	{
		return name + ": " + age;
	}
}

public class Ex17_ArrayObjSort
{
	public static void main(String[] args)
	{
		Person[] arr = new Person[3];
		
		arr[0] = new Person("홍길동", 29);
		arr[1] = new Person("전우치", 15);
		arr[2] = new Person("손오공", 37);
		
		Arrays.sort(arr);
		
		for(Person p : arr)
			System.out.println(p);
	}
}
