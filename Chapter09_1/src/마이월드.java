// 샘플링 한글로 만들어서 안됨.
class 고양이
{
	String name;
	String color;
	void 울어봐()
	{
		System.out.println("야옹~내이름은 " +name);
	}
}

class 멍멍이
{
	String name;
	int age;
	String 가져와봐()
	{
		System.out.println("달려가서 가져옵니다.");
		return "원반";
	}
}
public class 마이월드
{
	public static void main(String[] args)
	{
		고양이 cat1 = new 고양이();
		cat1.name = "고양이1";
		cat1.color = "빨간색";
		cat1.울어봐();
		
		고양이 cat2 = new 고양이();
		cat2.name = "야옹이";
		cat2.color = "검은색";
		cat2.울어봐();
		
		System.out.println(cat1.color + ":" + cat2.color);
		
		멍멍이 dog1 = new 멍멍이();
		dog1.name = "해피";
		dog1.age = 12;
		String 결과 = dog1.가져와봐();
		System.out.println("멍멍이가 가져온 것 : " + 결과);
	}
}