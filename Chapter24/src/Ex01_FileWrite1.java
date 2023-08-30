import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
스트림(Stream)
: IO모델의 핵심개념이라 할수있는 스트림은 '데이터의 흐름" 혹은
'데이터의 흐름을 생성해주는 통로' 정도로 정의할수있다. 
입력(input)스트림, 출력(output)스트림으로 나눌 수 있다.  
 */
public class Ex01_FileWrite1
{
	public static void main(String[] args) throws IOException  // <= 예외 처리해야 함
	{
		// 기본 스트림
		OutputStream out = new FileOutputStream("data.txt");  //OutputStream 이것만 사용  
		//스트림을 통해 데이터 보냄.
		out.write(65);      // ASCII 코드 65 = 'A'  LOCK 이	걸려있는 성황
		out.close();        // 문서 닫음 반드시 해야 함 그래야 lock이 풀림
	}
}
