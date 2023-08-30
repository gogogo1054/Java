import java.util.StringTokenizer;

public class Ex09_StringTokenizer
{
	public static void main(String[] args)
	{
		//StringTokenizer st1 = new StringTokenizer("a b c");  // 공백기준 분할 
		StringTokenizer st1 = new StringTokenizer("1,2,3", ",");	// ","(구분자)를 지정 분할 
		
		while (st1.hasMoreTokens())
		{
			System.out.println( st1.nextToken() );
		}
	}
}
