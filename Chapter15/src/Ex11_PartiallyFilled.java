public class Ex11_PartiallyFilled
{
	public static void main(String[] args)
	{
		/*
		 1차원 배열의 경우 원소의 갯수에 의해 전체 크기가 결정된다.
		 2차원 배열도 마찬가지이나 다른점이라면 가장 큰 원소에 의해 
		 크기가 결정되므로 빈공간이 발생할 수 있다. 이때 빈 공간은 
		 0으로 채울수 없으므로 null로 채워지게 된다. 즉 배열의 크기
		 에서 제외되는 부분이 발생한다.
		 */
		int[][] arr = {
				{11},
				{22, 33},
				{44, 55, 66}
		};
		
		// 배열의 구조대로 내용 출력
		for(int i=0; i<arr.length; i++) 
		{
			/*
			 2차원배열에서 행의 크기를 알고 싶을때는 배열명[인덱스]를
			 사용한다.
			 */
			for(int j=0; j<arr[i].length; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		/* 추가
		2차원 배열에서 특정 원소에 접근하기 위해서는 2개의 배열기호가
		필요하다. 또한 값이 없는 원소, 즉 null로 채워져 있는 원소를
		출력하면 예외가 발생한다. (배열의 인덱스를 초과했다는 예외가
		발생하게 된다.) 
		 */
		System.out.println("배열 출력하기");
		System.out.println("arr[0][0]="+arr[0][0]);
		//예외 발생(null이므로 출력할 수 없다.)
		System.out.println("arr[0][1]="+arr[0][1]); 
		/*
		 ArrayIndexOutOfBoundsException 예외가 발생한다.
		 즉, 배열의 index를 초과했다는 의미이다.
		 */
	}
}
