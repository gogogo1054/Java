import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;

public class Ex05_FileCopy1   // 원초적인 파일 복사 프로그램
{

	public static void main(String[] args)
	{
		String src = "./src/Ex04_FileRead.java";
		String dst = "FileRead1.txt";
		
		//원본파일과 복사본파일에 각각 입출력 스트림을 생성한다. 여러개를 지정할 수 있다.
		try (InputStream in = new FileInputStream(src); // 문자을 구분하는데 ; 사
			OutputStream out = new FileOutputStream(dst))   
		{
			// 시작한 현재 시간을 구함.
			Instant start = Instant.now();  // Instant 시간 관련 함수
			int data;      // 1byte 씩 읽음 비용이 많이 듬
			while (true)   // data 를 읽음
			{
				data = in.read(); 
				if(data == -1)    // 마지막 data 확인 하기. 더이상 못 읽으면 -1 반환.
					break;  // 중단
				out.write(data);  // 파일에 저장
			}
			
			// 총 복사한 시간 체크 . 끝나는 현재 시간을 구함.
			Instant end = Instant.now();
			
			// 1/1000초 단위로 보여주기
			System.out.println("복사에 걸린 시간: " +
					Duration.between(start,  end).toMillis());
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
