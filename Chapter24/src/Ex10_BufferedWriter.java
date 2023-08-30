import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ex10_BufferedWriter
{
	public static void main(String[] args)
	{
		String str1 = "동해물과 백두산이 마르고 닳도록";
		String str2 = "하느님이 보우하사 우리나라 만세.";
		
		/*
		BufferedWriter
			: System.out.println();과 유사
			  속도는 훨씬 빠르기 때문에(입력된 데이터가 바로 전달되지 않고 
			  버퍼를 거쳐 전달되므로 데이터 처리 효율성을 높임) 많은 양의 
			  데이터를 처리할 때 유리하다.  
		 */
		/*
		문자열을 저장하기 위한 출력스트림을 생성한다.
		문자열의 입력은 버퍼에 따라 성능의 차이가 크기때문에 버퍼 
		필터 스트림을 추가적으로 연결해서 사용한다. 
		 */
		try (BufferedWriter bw 
				= new BufferedWriter(new FileWriter("text2.txt")))
		{
			/*
			write()를 통해 문자열을 저장하고, 줄바꿈은 newLine()을 통해
			처리한다. 각 OS별로 개행문자가 다르기 때문에 해당 메서드를
			통해 줄바꿈 해야한다. 
			 */
			bw.write(str1, 0, str1.length());
			bw.newLine();    // OS 에 맞는 라인을 넣어줌. 줄바꿈 문자를 스트림으로 저장
			bw.write(str2, 0, str2.length());
		}
		catch(IOException e)  // IOException 반드시 해야 함.
		{
			e.printStackTrace();
		}
	}
}
