import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;

/*
1byte씩 읽어서 복사하는 것보다 1kb(1024byte)씩 읽어 저장할 수 있는 
버퍼(buffer)를 이용하기 때문에 복사 속도가 훨씬 빨라진다. 
스트림 혹은 네트워크를 통해 파일을 전송할때도 버퍼를 사용하는 이유는
바로 이런 속도차 때문이다. 
 */
public class Ex06_FileCopy2
{

	public static void main(String[] args)  
	// 원초적인 buffer를 이용한 파일 복사 프로그램 앞에거 보다 빠름
	{
		String src = "./src/Ex04_FileRead.java";
		String dst = "FileRead2.txt";
		
		try (InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst))   
		{
			//1kbyte씩 파일의 내용을 읽어 저장하기 위한 버퍼생성(byte형배열)
			byte[] buf = new byte[1024];    // 1024 byte 를 사용하여 data 읽기
			int len;
			
			Instant start = Instant.now(); 
			
			//파일의 내용 전체를 읽기위해 무한루프 구성
			while (true)   // data 를 읽음
			{
				//배열의 크기 즉 1kbyte씩 파일을 읽어온다. 
				len = in.read(buf);   
				// buf 를 활용하여 data 읽기 1024 byte 를 채울때 까지 읽음
 				if(len == -1)    // 마지막 data 확인 하기
 					//더이상 읽을 내용이 없다면 즉시 루프를 탈출한다.
					break;
 				/*
				읽어온 내용을 파일에 입력한다. 버퍼에 저장된 데이터를
				인덱스 0의 위치에서 len의 크기만큼 전송한다. 
				 */
				out.write(buf, 0 ,len);  
			}
			
			Instant end = Instant.now();
			System.out.println("복사에 걸린 시간: " +
					Duration.between(start,  end).toMillis());
			// 속도가 줄어든 것을 확인 할 수 있다.	
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
