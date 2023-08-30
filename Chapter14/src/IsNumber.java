public class IsNumber
{
	public static void main(String[] args)
	{
		String value = "12o34";
		char ch = ' ';
		boolean isNumber = true;
		
		for (int i=0; i<value.length(); i++)
		{
			/*
			charAt(인덱스) : 문자열에서 특정 index에 해당하는 문자
			하나를 반환한다. index는 배열과 같이 0부터 시작한다.
			 */
			ch = value.charAt(i);  // 이진수로 받음
			
			if ((ch >= '0' && ch <= '9'))  // 아스키 코드(이진수)로 비교
			{}
			else 
			{
				isNumber = false;
				break;
			}
		}
		
		if (isNumber)
		{
			System.out.println(value + "는 숫자입니다.");
		}else
		{
			System.out.println(value + "는 숫자가 아닙니다.");
		}
	}
}
