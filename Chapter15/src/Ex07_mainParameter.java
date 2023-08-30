// 교제 순서대로 하면 됨.
public class Ex07_mainParameter
{
	public static void main(String[] args)
	{
		System.out.println(args.length);  // 입력한 배열의 갯수 확인.
		// main 메서드의 매개변수 확인
		for(int i = 0; i < args.length; i++)
			System.out.println(args[i]);
	}
}
