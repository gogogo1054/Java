import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class NetworkEx4
{
	public static void main(String[] args)
	{
		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;
		String address = 
"https://www.google.co.kr/logos/doodles/2018/world-cup-2018-day-23-6245640538423296.3-law.gif";
		
		int ch = 0;
		
		try
		{
			url = new URL(address);
			in = url.openStream();
			out = new FileOutputStream("google_today.gif");
			
			while((ch = in.read()) != -1)
			{
				out.write(ch);
			}
			in.close();
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
