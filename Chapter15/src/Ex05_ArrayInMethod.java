public class Ex05_ArrayInMethod
{
	public static void main(String[] args)
	{
		int[] arr = makeIntArray(5);
		
		/*
		 배열명을 인수로 전달하는 것은 배열의 참조값(주소값)을 전달하는 
		 것이다. 즉, 배열 자체가 전달되지 않는다.
		 아래 출력문에는 배열객체의 참조값이 출력된다.
		 */
		int sum = sumOfArray(arr);
		
		System.out.println(sum);
	}
	
	// 메서드의 반환형이 int형 배열. .
	public static int[] makeIntArray(int len)
	{
		// 매개변수가 받은 인자값이 배열 개수를 정함
		int[] arr = new int[len];
		// 배열의 초기화 
		for(int i=0; i< len; i++)
		{
			arr[i] = i;
		}
		// 배열의 주소 값을 반환 
		return arr;
	}
	
	// 매개변수가 인자값으로 배열의 주소값을 받음.
	public static int sumOfArray(int[] arr)
	{
		int sum = 0;
		for(int i=0; i< arr.length; i++)
		{
			sum = sum + arr[i];
		}
		return sum;
	}
}
