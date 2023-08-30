import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex08_TextWrite   // 문자 쓰기
{
	public static void main(String[] args)
	{
		/*
		text.txt 파일을 대상으로 문자 출력 스트림을 생성한다. 
		만약 파일이 존재하지 않으면 새롭게 생성한다. 
		 */
		try (Writer out = new FileWriter("text.txt"))
		{
			/*
			Java는 유니코드를 기반으로 문자를 저장한다. 아래는 문자스트림을
			기반으로 해당 OS의 인코딩방식에 맞춰 문자를 텍스트파일에 저장한다. 
			 */
			for (int ch = (int)'A'; ch < (int)('Z'+1); ch++)
				//문자를 텍스트 파일에 입력한다.
				out.write(ch);
			
			out.write(13);  // 1byte 로 읽음. CR -> \r(커서를 맨 으로)
			out.write(10);	// LF -> \n
			
			for(int ch = (int)'A'+32; ch < (int)('Z'+1+32); ch++) 
				out.write(ch);
			
			out.write(13);
			out.write(10);
			
			out.write("동해물과 백두산이 마르고 닳도록");  // 2byte 로 읽음
			out.write("\r\n");
			out.write("하느님이 보우하사 우리나라 만세");
			out.write("\r\n");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
