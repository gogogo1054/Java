class Camp7<T1, T2>   // 이렇게 여러가지로 사용가능 대부분 한글자를 많이 사용
{
	private T1 param1;
	private T2 param2;
	
	public void set(T1 o1, T2 o2)
	{
		param1 = o1;
		param2 = o2;
	}
	
	public String toString()
	{
		return param1 + " & " + param2;
	}
}

public class Ex07_MultiParameter
{
	public static void main(String[] args)
	{
		Camp7<String, Integer> camp = new Camp7<>();
		camp.set("Apple", 25);   // param1 은 String, param2 는 Integer 로 입력
		System.out.println(camp);
	}
}
