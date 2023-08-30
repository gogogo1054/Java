class 인간
{
	int kind;	// 1:황인종 2:백인종 3:흑인종
	String name;
	int age;
	void 인사()
	{
		System.out.println("안녕하세요.");
	}
}
public class 마이월드2
{
	public static void Hi()
	{
		System.out.println("Hi~");
	}
	public static void main(String[] args)
	{
		인간 사람1 = new 인간();
		사람1.kind =1;
		사람1.name = "홍길동";
		사람1.age = 20;
		
		인간 saram2 = new 인간();
		saram2.kind = 2;
		saram2.name = "멀린";
		saram2.age = 21;
		
		인간 saram3 = new 인간();
		saram3.kind = 3;
		saram3.name = "블랙펜서";
		saram3.age = 22;
		
		System.out.println(사람1.age + 1);
		Hi();
		사람1.인사();
		
		saram3.인사();
		
	}

}
