public class Ex05_DoubleError2
{
	public static void main(String[] args)
	{
		double dnum = 0.0;
		
		for (int i=0; i<1000; i=i+1)
		{
			/*
			 CPU는 실수 계산에 기본적인 오차를 가지고 있다.
			 이는 JAVA의 문제가 아니라 컴퓨터 자체의 문제이므로
			 정확한 계산을 위해서 약간의 보장을 필요로 한다.
			 */
			
			// 결과가 100이 나와야 함. 하지만 다른값이 나옴. 
			// 그래서 실수는 계산에 사용하지 않음.
			dnum = dnum + 0.1;		// 근사값만 나옴.
		}
		System.out.println(dnum);
	}
}