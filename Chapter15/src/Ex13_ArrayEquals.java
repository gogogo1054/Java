import java.util.Arrays;

public class Ex13_ArrayEquals
{
	public static void main(String[] args)
	{
		int[] arr1 = {1, 2, 3, 4, 5};
		// arr1에 전달된 배열을 첫 번째 요소부터 arr1의 길이만큼 복사
		int[] arr2 = Arrays.copyOf(arr1,  arr1.length);  // arr1 관 같은 내용로 입력
				
		boolean bCheck = Arrays.equals(arr1,  arr2); // arr1, arr2 가 내용이 같을때 true
		System.out.println(bCheck);
	}
}
