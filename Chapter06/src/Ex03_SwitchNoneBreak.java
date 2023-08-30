
public class Ex03_SwitchNoneBreak
{
	public static void main(String[] args)
	{
		int n= 6;
		
		switch(n % 7)  // 산술식 5이하로 나누면 주중 
		{
		/*
		 여러 case를 동시에 처리할때는 break문 없이 case를 나열한다.
		 if문에서 || (논리 OR)를 사용하는 것과 비슷하다.
		 */
		case 1:case 2:  // if((n%3=1) || n%3=2)|| ....)
		case 3:
		case 4:
		case 5:
			System.out.println("주중");
			break;  // 여기서 멈춤.
		case 6:
		default:
			System.out.println("주말");
		}
	}
}
