public class Ex02_intArray
{
	public static void main(String[] args)
	{
		// 길이가 3인 int형 1차원 배열의 생성
		int[] ar = new int[3];
		//가장 기본적인 초기화 방식
		//인덱스로 접근해서 원소를 초기화한다. 
		ar[0] = 100;     // 값의 저장 : 첫번째 요소
		ar[1] = 90;      // 값의 저장 : 두번째 요소
		ar[2] = 80;      // 값의 저장 : 세번째 요소
		
		int sum = ar[0] + ar[1] + ar[2];   // 값의 참조
		System.out.println("총점 : " + sum);
	}
}
