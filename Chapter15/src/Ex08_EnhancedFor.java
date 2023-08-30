/*
foreach문(개선된 for문)
	 배열의 일부가 아니라 전체를 참조해야할때 주로 사용하는 개선된 
	 for문을 말한다. 배열의 원소를 참조의 형태로 가져와서 사용한다.
	 따라서 참조의 목적으로만 사용해야하고, 값의 변경은 허용하지 
	 않는다.
	 형식]
	 	for(자료형 참조변수 : 배열명){
	 		실행문장;
	 		참조변수를 통해 배열의 원소 출력가능함;
		}
*/
public class Ex08_EnhancedFor
{
	public static void main(String[] args)
	{
		// 1차원배열을 선언 및 초기화한다.
		int[] arr = {1, 2, 3, 4, 5};
		
		/*
		 배열 arr의 원소를 순서대로 하나씩 참조하여 출력하고, 더이상 
		 참조할 원소가 없을때 for문이 자동으로 종료된다.
		 */
		// 배열 요소 전체 출력
		for(int e: arr)
		{
			System.out.print(e + " ");
		}
		System.out.println();    // 즐 바꿈울 목적으로
		
		int sum = 0;
		
		// 배열 요소의 전체 합 출력
		for(int e: arr)
		{
			sum = sum +e;
		}
		System.out.println("sum: "+ sum);
		
		/* 추가
		 참조형태로 각 원소를 읽어와서 변수 b에 할당하는 형식이므로
		 아래 증가연산자를 통해 증가시킨 값은 실제 배열에 적용되지 
		 않는다. 해당 for문 내에서만 증가된다.
		 */
		System.out.println("배열arr의 요소값 1 증가시키기");
		for(int b : arr) {
			b++;
			// 변수 b에 저장된 값이 1증가하여 출력된다.
			System.out.print(b +" "); 
		}
		System.out.println();
		System.out.println("배열arr의 요소 재출력하기");
		for(int c : arr) {
			// 1증가되는 부분이 기존 배열에 적용되지 않으므로 기존값이 
			// 출력된다.
			System.out.print(c +" ");  
		}
	}
}
