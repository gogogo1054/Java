/*
지역변수(Local variable)
- 변수는 사용범위(Scope)를 가지고 있고, 해당 지역내에서만 사용할 수 
	있다.
- 해당 지역을 벗어나면 즉시 메모리에서 소멸된다.
- 기본자료형은 스택(Stack)이라는 메모리 공간을 사용한다.
- 스택은 입구가 하나만 있는 컵과 같은 형태이며, '선입후출'의 특성을
	가진다. 또한 스텍은 CPU가 메모리의 생성 및 소멸을 주관한다.
*/
public class Ex03_VariableScope
{
	/*
	 Java에서 main()은 항상 public static void로 선언해야 한다.
	 또한 static으로 선언된 메서드에서 호출되는 메서드는 항상 static으로
	 선언해야 한다. 단 public의 경우 현 상태에서는 있어도 없어도 별다른
	 차이가 없다. 
	 */
	public static void main(String[] args)
	{
		// 변수의 사용 가능 범위
		boolean myState = true;
		/*
		 main지역에서 num을 선언하면 그보다 좁은 지역인 if문에서는 같은
		 이름의 변수를 선언할 수 없다. 큰 지역에서 이미 선언되어 메모리
		 에 상주하고 있기 때문이다.
		 */
//		int num = 11;   // 에러가 발생하므로 주석으로 처리한다.
		
		/*
		main보다 좁은 지역인 if문의 블럭을 생성한 후 변수 num을 선언
		한다. 단, if문의 블럭과 else문의 블럭은 서로 다른 지역이므로 
		동일한 이름의 변수를 선언할 수 있다. 		
		 */
		if (myState)
		{
			 int num = 22;  
			num++;
			System.out.println("첫번째 if문 지역:"+ num);
		}
		else
		{
			int num = 33;
			num++;
			System.out.println("첫번째 if문의 else지역:"+ num);
		}
		
		/*
		 if문의 블럭에서 선언된 변수 num은 해당 블럭을 벗어나는 순간 
		 메모리에서 소멸되므로 아래에서 num을 선언할 수 있다.
		 */
		int num = 20;
		System.out.println(num); 
		
		// for문 영
		for (int i=0; i<3; i++)
		{
			System.out.println(i);
		}
//		 System.out.println(i);   // 의미없는 선언 실행 안됨
	}
	
	/*
	main문에서 선언한 변수 num은 메모리에 아직 상주하고 있지만, 해당 
	메서드는 크기가 동일한 서로 다른 지역에 정의되었으므로 같은 이름의 
	변수를 선언할 수 있다.
	앞의 main메서드의 if~else문의 블럭도 같은 개념으로 변수를 선언한 
	것이다.
	 */
	static void simpleFunc()
	{
		int num = 1000;
		System.out.println("simple메소드지역:"+ num);
	}
}
