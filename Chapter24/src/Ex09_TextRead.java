import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex09_TextRead   // 문자 읽기
{
	public static void main(String[] args)
	{
		
		try (Reader in = new FileReader("text.txt"))//문자열을 읽기 위한 입력스트림 생성
		{
			int ch;
			
			while(true)
			{
				// FileReader 객체를 통해 파일을 한글자씩 읽어 ch변수에 할당한다.
		        // .read() 메소드의 리턴이 int형이기 때문에 ch를 int로 선언해주어야 한다.
				ch = in.read();  //  다음 글자를 읽는다.
				
				//더이상 읽은 내용이 없다면 while루프를 탈출한다. 
				if (ch == -1)	//-1을 EOP 라고 부르며 파일의 끝을 나타낸다. (End Of File)
					break;
				//한글자씩 출력
				System.out.print((char)ch);  // ch  케릭터로 바꿔줄것.
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
