import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
IO관련 작업에서는 많은 부분에서 예외처리가 필요하다. 이때 예외를
throws하는것보다 try~catch로 예외처리를 해주는것을 권장한다. 예외를
무시하면 문제가 생겼을때 적절한 조치를 취하기 힘들기 때문이다.
 */
public class Ex02_FileWrite2  // 예외 try catch 직접 처리 할 때
{
	public static void main(String[] args)
	{
		OutputStream out = null;   
		
		try
		{
			// 출력스트림 생성
			out = new FileOutputStream("data.txt");
			out.write(66);      // ASCII 코드 66 = 'B'  LOCK 이	걸려있는 성황
			//out.close();       // finally 구문으로 옮김.		
		}
		catch (IOException e)
		{
			
		}
		finally
		{
			/*
			try문으로 진입하여 스트림을 생성했다면 finally구문에서는
			스트림을 닫아준다. try구문으로 진입했을때 무조건 실행되는
			구문이 finally절이다.
			 */
			if (out != null)
			{
				try
				{
					out.close();
				}
				catch (IOException e2)
				{
					
				}
			}
		}
	}
	// 너무 복잡함. 다음 예제에서...
}
