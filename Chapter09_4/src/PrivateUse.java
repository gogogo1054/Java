/*
접근 제한자 : 변수나 메서드에 접근 제한자를 지정하면 접근을 
	제한할 수 있습니다. private을 적용하면 클래스 외부에서 
	클래스 내부로의 변수와 메서드에 대한 접근을 제한할 수 
	있습니다. 이러한 것을 객체지향 프로그래밍에서 정보 
	은닉화(formation hiding)라고 부릅니다. - 데이터의 안정을 위해
 */
class Student1  // 부적절한 class 
{
	String name;
	int age;
}

class Student2	
{
	public String name;
	// private으로 접근 제한자를 지정. 같은 클래스에서만 접근 가능
	private int age; 	// private 멤버 변수
	
	public Student2(String name, int age)
	{
		/*
		 동일 클래스 내에서는 private 멤버라 할지라도 접근을 허용
		 한다. 즉 동일 클래스내에서는 접근지정자의 영향을 받지 
		 않는다.
		 */
		/*
		this.name은 같은 클래스의 맴버변수, 뒤에 name은 매개변수 
		색깔이 다름. 매게변수를 같은 이름으로 사용할 때 구별
		 */
		this.name = name;   // class 내 같은색 변수. 
		this.age = age;		
	}
	
	/*
	age 변수는 다른 클래스에서 접근할 수 없기 때문에 변수의 
	값을 다른 클래스에서 가져갈 수 있게 게터로 getAgeO 메서드를 
	제공, 값을 대입하는 setAge() 메서드를 제공.
	게터. 세터를 지정하여 변수에 접근하는 이유는 값대입 시 
	부적절한 값의 대입을 막기 위함
	 */
	public int getAge()	// 게터 :  get대문자시작
	{
		return age;
	}
	
	public void setAge(int age)	// 세터 : set대문자시작
	{
		if (age < 0 || age > 150)	// 유효성 검사
		{
			System.out.println("나이가 부적절합니다.");
			this.age = 0;
			return;
		}
		this.age = age;
	}
}

public class PrivateUse
{
	public static void main(String[] args)
	{
		Student1 student1 = new Student1();
		student1.name = "홍길동";	// 멤버 변수에 직접 접근
		student1.age = -20;			// 멤버 변수에 직접 접근
		System.out.printf("%s의 나이는 %d살입니다.\n", 
				student1.name, student1.age);
		
		Student2 student2 = new Student2("전우치", 20);
		student2.name = "손오공";	// 멤버 변수에 직접 접근
		// private이므로 접근 불가능
		// student2.age = -10  <-- 오류남	// 에러 발생 
		/*
		 private으로 선언된 멤버의 외부클래스에서 접근하려면 public으로
		 선언된 멤버메서드를 통해 간접적으로 접근해야 한다. 클래스 내부
		 에서는 접근지정자의 영향을 받지 않으므로 해당메서드를 통해 접
		 근하는 것은 가능해지게 된다.
		 */
		student2.setAge(-10);		// 세터를 사용한 접근
		int age = student2.getAge();
		System.out.printf("%s의 나이는 %d살입니다.\n", 
				student2.name, age);	// 출력
	}
}
