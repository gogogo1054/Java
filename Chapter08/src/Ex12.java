import java.util.Scanner;

public class Ex12   // 여기서 수정해가면서 할것.
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===========================");
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1.더하기");
		System.out.println("2.빼기");
		System.out.println("3.곱하기");
		System.out.println("4.나누기");
		System.out.println("5.거듭제곱");
		System.out.println("0.끝내기");
		System.out.println("===========================");
		
		while(true)
		{
			int num = sc.nextInt();
			if(num == 0)
			{
				System.out.println("계산기를 종료합니다.");
				break;
			}
			else 
			{
				if(num > 5)
				{
					System.out.println("없는 메뉴입니다.");
					System.out.println("메뉴를 다시 선택하세요.");
					continue;
				}
				
				System.out.print("첫 번째 숫자:");
				int num1 = sc.nextInt();
				System.out.print("두 번째 숫자:");
				int num2 = sc.nextInt();
				
                // 계산진행
				if(num == 1)
				{
					int result = num1 + num2;
					System.out.println(num1 + " + " + num2 + " = " + result);
				}else if(num == 2)
				{
					int result = num1 - num2;
					System.out.println(num1 + " - " + num2 + " = " + result);
				}else if(num == 3)
				{
					int result = num1 * num2;
					System.out.println(num1 + " * " + num2 + " = " + result);
				}
				else if(num == 4)
				{
					int result1 = num1 / num2;
					System.out.println(num1 + " / " + num2 + " = " + result1 + "몫");
					int result2 = num1 % num2;
					System.out.println(num1 + " % " + num2 + " = " 
							+ result2 + "나머지");
				}
				else if(num == 5)
				{
					int result = 1;
					for(int i=0; i<num2; i=i+1)
					{
						result = result * num1;
					}
					System.out.println("거듭 제곱 결과: " + result);
				}
			}
		}
	}
}