import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex11_BufferedReader
{
	public static void main(String[] args)
	{
		/*
		 BufferedReader
			: Scanner와 유사.
			  속도는 훨씬 빠르기 때문에(입력된 데이터가 바로 전달되지 않고 
			  버퍼를 거쳐 전달되므로 데이터 처리 효율성을 높임) 많은 양의 
			  데이터를 처리할 때 유리하다.  
			  Enter만 경계로 인식하고 받은 데이터가 String으로 고정되기 
			  때문에 입력받은 데이터를 가공(형변환)하는 작업이 필요한 경우가 
			  많다. 
		 */
		try (BufferedReader br 
				= new BufferedReader(new FileReader("text2.txt")))
		{
			String str;
			
			while(true)
			{
				/*
				개행(줄바꿈)이 등장하기 전까지의 데이터를 한번에 읽어온다. 
				즉 한줄씩 읽는다.
				 */
				str = br.readLine();   // 한 줄씩 읽음. 라인 단위로 읽음
				
				//더이상 읽은 내용이 없다면 while루프를 탈출한다. 
				if (str == null)
					break;
				/*
				입력시 newLine()을 통해 개행정보가 입력되지만, 읽어들인
				문자열에는 개행정보가 포함되지 않는다. 따라서 개행을 하려면
				println()을 사용해야한다. 즉, 입력시의 개행정보는 문자열을
				라인별로 구분하는 용도로만 사용된다.
				 */
				System.out.println(str);  // 출력
			}
		}
		catch(IOException e)	// IOException 반드시 해야 함.
		{
			e.printStackTrace();
		}
	}
}
