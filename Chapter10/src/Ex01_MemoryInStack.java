/*
디버깅하며 배우는 스택 영역 원리
	-매개변수와 지역 변수가 스택 영역에서 어떻게 처리되는지를 
	예제로 알아보겠습니다.
 */
public class Ex01_MemoryInStack
{
	public static void main(String[] args)  // [Toggle Breakpoint]를 선택
	{
		/*
		프로그램 실행중 여기서 멈춘다는 것. Step Into 안으로 들어가는 것
		Step Over 다음줄로 넘어가는 것
		 */
		int num1 = 10; // Step Over.
		int num2 = 20;	
		int num3 = adder(num1, num2);	// step into
		System.out.println("------------------");
	}  // 여기에서 스텍에있는 메인까지 사람짐.
	
	public static int adder(int n1, int n2)
	{
		// n1=10, n2=20입력됨.
		int result = n1 + n2;
		return result;
	} 	 // 끝나면 스텍에서 사라짐. 이래서 딴 곳에 있는 변수를 사용 못함. 지역 변수 다음장에 배움.
}
