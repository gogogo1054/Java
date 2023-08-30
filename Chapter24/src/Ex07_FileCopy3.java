import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Ex07_FileCopy3
{
	public static void main(String[] args)  
	{
		//원본파일과 복사본파일에 각각 입출력 스트림을 생성한다.
		String src = "./src/Ex04_FileRead.java";
		String dst = "FileRead3.txt";
		
		// 보조 스트림에 버퍼를 이용한 파일 복사 프로그램 제일 빠름
		try (BufferedInputStream in = 
				new BufferedInputStream(new FileInputStream(src));
			BufferedOutputStream out = 
					new BufferedOutputStream(new FileOutputStream(dst)))  
		// 보조스트림을 이용하여 속도 개선 
		// byte[] buf = new byte[1024]; 이런 역활을 알아서 함
		{
			Instant start = Instant.now();
			
			int data;
			while (true)   
			{
				// 1바이트씩 읽지만 내부적으로 버퍼링이 되게 된다.
				data = in.read();   
				if(data == -1)  
					break;
				out.write(data);  
			}
			
			Instant end = Instant.now();
			System.out.println("복사에 걸린 시간: " +
					Duration.between(start,  end).toMillis());
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
