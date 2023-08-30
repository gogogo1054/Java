import java.util.Scanner;

public class MyCalculatur
{
	// 메뉴를 출력한다.
	public static void showMenu() 
	{
		System.out.println("===========================");
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1.더하기");
		System.out.println("2.빼기");
		System.out.println("3.곱하기");
		System.out.println("4.나누기");
		System.out.println("5.거듭제곱");
		System.out.println("0.끝내기");
		System.out.println("===========================");
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			/*
			while안에 너무 많은 것이 들어오면 안되어서 메뉴를 외부에
			메서드로 만들어서 호출함.
			 */
			showMenu();	
			
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
				
                // 계산진행
				if(num == 1)
    				add();
				else if(num == 2)
    				substract();
				else if(num == 3)
    				multiplay();
				else if(num == 4)
    				divide();
				else if(num == 5)
    				power();
			}
		}
		System.out.println("===========================");
	}
	
	// 계산 메소드
	public static void add()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자:");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자:");
        int num2 = sc.nextInt();
         
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}

	public static void substract()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자:");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자:");
        int num2 = sc.nextInt();
		
		int result = num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + result);
	}

	public static void multiplay()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자:");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자:");
        int num2 = sc.nextInt();
		
		int result = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + result);
	}

	public static void divide()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자:");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자:");
        int num2 = sc.nextInt();
		
		if (num2 == 0)
		{
			System.out.println("0으로 나눌수 없읍니다.");
			return;  // if 문인 경우 continue 대신 사용
		}
		
		int result1 = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + result1 + "몫");
		int result2 = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " 
							+ result2 + "나머지");
	}

	public static void power()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자:");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자:");
        int num2 = sc.nextInt();
		
		int result = 1;
		for(int i=0; i<num2; i=i+1)
		{
			result = result * num1;
		}
		System.out.println("거듭 제곱 결과: " + result);
	}	
}

