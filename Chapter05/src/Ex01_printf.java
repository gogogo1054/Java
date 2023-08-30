public class Ex01_printf
{
	public static void main(String[] args)
	{
		//글자들을 저장할 때 사용하는 자료형
		String name = "Hong Gil Dong";    
		int age = 20;
		double height = 175.5;
		
		/*
		printf(); : 출력내용을 서식에 맞춰서 출력한다. 또한 자체적인 줄바꿈 
		기능이	없으므로 \n 혹은 %n 을 이용해서 줄바꿈한다. 변수를 출력
		하는 서식문자에는 %d, %f등이 있다.
		단, 줄바꿈을 위한 %n은 printf()에서만 사용할 수 있다.
		*/
		System.out.printf("%s의 나이는 %d이고, 티는 %f입니다.\n", 
				name, age, height);
		// 실수를 출력하면 너무 길게 출력되므로, 소수점 아래 두 
		// 자리까지만 출력합니다
		System.out.printf("%s의 나이는 %d이고, 티는 %.2f입니다.%n", 
				name, age, height);
	}
}