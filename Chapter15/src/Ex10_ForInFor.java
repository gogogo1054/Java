public class Ex10_ForInFor
{
	public static void main(String[] args)
	{
		// 3행 4열 크기의 2차원 배열 생성
		int[][] arr = new int[3][3];
		
		int num = 1;
		
		// 각 행과 열의 크기만큼 반복하면서 배열 초기화한다.
		for(int i=0; i<3; i++)
		{
			// 먼저 i로 층을 정하고 여기서 j로 층의 방을 다 돕니다.
			for(int j=0; j<3; j++)
			{
				arr[i][j] = num;
				num++;
			}
		}
		
		//  초기화된 데이터를 출력한다.
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
