class BoxA6 {}

public class Ex06_ArrayInit
{
	public static void main(String[] args)
	{ 
		int[] arr1 = new int[3];          // 0으로 초기화
		/*
		배열을 선언과 동시에 초기화한다. 원소의 갯수를 통해 크기가
		결정된다. 생성된 배열 객체의 주소값을 할당하게 된다.  
		 */
		int[] arr2 = new int[] {1, 2, 3};
		/*
		배열 원소의 갯수를 통해 배열을 생성한 후 초기화까지 동시에
		진행한다. 이 경우 new를 생략할 수 있다.
		 */
		double[] arr3 = {1.0, 2.0, 3.0};
		double[] arr4 = new double[3];    // 0.0으로 초기화
		BoxA6[] arr5 = new BoxA6[3];
		
		for (int i=0; i<arr1.length; i++)
		{
			System.out.print(arr1[i] + " ");
			System.out.print(arr2[i] + " ");
			System.out.print(arr3[i] + " ");
			System.out.print(arr4[i] + " ");
			System.out.print(arr5[i] + " ");
			System.out.println();
		}
	}
}
