import java.util.Arrays;

public class Ex02_Pipeline   // Ex01을 줄여 놓은 것
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5};   
		
		// Pipeline 구성    <= 원래 하나로 사용 함.
		int sum = Arrays.stream(arr)
				.filter(n -> n%2 ==1)   // 중간 연산
				.sum();                 // 최종 연산 끝

		System.out.println(sum);
	}
}
