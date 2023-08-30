import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex04_FileRead
{
	public static void main(String[] args)
	{ 
		try (InputStream in = new FileInputStream("data.txt"))   // 자식을 부모에게 대입
		{
			// 데이터를 1byte로 읽음.
			int dat = in.read();
			// 십진수로 출력
			System.out.println(dat);
			// 글자로 출력
			System.out.printf("%c \n", dat);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
