import java.util.Arrays;

public class Ex12_ArrayCopy
{
	public static void main(String[] args)
	{
		/*
		 1차원, 2차원 배열은 크기가 지정된 경우에는 전체 원소가 0으로
		 초기화된다. double형 배열인 경우에는 0.0으로 초기화된다.
		 */
		int[] arr1 = new int[10];
//		for(int i=0; i<arr1.length; i++)
//			System.out.print(arr1[i] + " ");
//		System.out.println();
		int[] arr2 = new int[8];
		
		// 배열 ar1을 3으로 초기화
		Arrays.fill(arr1,  3);
		
		// 배열 arr1을 arr2로 부분 복사
		System.arraycopy(arr1,  0, arr2, 3, 4);  
		// arr1 0으로 바꾸기 arr1[3]번 부터 4번 째까지 3으로 
		
		// arr1 출력
		for(int i=0; i<arr1.length; i++)
			System.out.print(arr1[i] + " ");
		System.out.println();
		
		// arr2 출력
		for(int i=0; i<arr2.length; i++)
			System.out.print(arr2[i] + " ");
		System.out.println();
		
		// 배열 arr1을 arr3으로 부분 복사
		int[] arr3 = Arrays.copyOfRange(arr2, 2, 5);
		// arr2의 arr2[2] 시작 부터 arr2[5]번 째 가지 복사 출력
				
		// arr3 출력
		for(int i=0; i<arr3.length; i++)
			System.out.print(arr3[i] + " ");
		System.out.println();
	}
}
