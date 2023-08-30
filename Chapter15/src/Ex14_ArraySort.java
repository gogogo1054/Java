import java.util.Arrays;

public class Ex14_ArraySort
{
	public static void main(String[] args)
	{
		/*
		배열을 선언과 동시에 초기화한다. 원소의 개수를 통해 크기가 
		결정된다. 생성된 배열 객체의 주소값을 할당하게 된다.
		 */
		int[] arr1 = {1, 2, 3, 4};
		double[] arr2 = {4.4, 3.3, 2.2, 1.1};
		String[] arr3 = {"홍길동", "전우치", "손오공", "멀린"};
		
		Arrays.sort(arr1);   // 작은정수 부터 정렬
		Arrays.sort(arr2);   // 작은실수 부터 정렬
		Arrays.sort(arr3);   // 가나다 순서로 정렬
		
		for (int n : arr1)
			System.out.print(n + "\t");
		System.out.println();
		
		for (double d : arr2)
			System.out.print(d + "\t");
		System.out.println();
		
		for (String s : arr3)
			System.out.print(s + "\t");
		System.out.println();
	}
}
