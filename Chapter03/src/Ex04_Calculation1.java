public class Ex04_Calculation1
{
	// 에러를 보기위한 예제
	/*
	지금은 강제 형변화을 사용할 일이 없음. 옛날에는 메모리절약 때문에
	강제 형변환을 했음. 
	 */
	public static void main(String[] args)
	{
		byte num11 = 1;  // 1바이트
		byte num12 = 2;  // 1바이트
		// CPU 에서는 가장 작은게 int계산기 이므로 int 3 값이 나와서 에러남.
//		byte result1 = num11 + num12;   // num11 + num12 4바이트
		
		short num21 = 1;  // 2바이트
		short num22 = 2;  // 2바이트
		// CPU는 int계산만 할수 있음 그래서 결과가 int 3이나옴 그래서 에러남.
//		short result21 = num21 + num22;  //  num21 + num22 = int 3 ->4바이트
		// 강제적 형변환을 하면 에러 안남.
		short result22 = (short)(num21 + num22);  // 강제로 형변환
	}
}