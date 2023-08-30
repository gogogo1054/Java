
public class Ex02_switch
{
	/*
	switch문
		if문처럼 조건에 따라 분기하는(나누어서 갈라진) 제어문으로, 정수식의 
		값과 동일한 부분을 찾아 실행하는 형태를 가지고있다.
		형식]
			switch(산술식 혹은 정수식){
			case 값1:
				실행문; break;
			case 값2:
				실행문; break;
			default:
				위에서 값이 매칭되지 않을때, 실행되는 문장으로
				else와 같은 의미로 사용된다.
		※ switch문 내부에서 break문을 만나게되면 실행이 중지되고 밖으로
		탈출하게된다.
		※ 만약 break문이 없으면 그 아래의 모든 실행문이 실행되게 된다. 
	 */
	public static void main(String[] args)
	{
		int n = 4;
		
		/*
		조건식에는 이렇게 연산식을 넣어줄 수도 있고 그냥 변수만 
		넣어줄 수도 있습니다
		 */
		switch(n % 3)
		{
		case 1:
			System.out.println("나머지가 1");
			// break문을 만나면 switch문을 탈출한다.
			break;  // 없으면 다 실행 됨.
		case 2:
			System.out.println("나머지가 2");
			break;
		default:
			System.out.println("나머지가 0");
			/*
			switch문의 마지막에는 break문을 기술하지 않는다.
			더이상 실행할 문장이 없기 때문이다.
			 */
		}
	}
}
