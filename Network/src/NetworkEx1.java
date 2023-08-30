import java.net.InetAddress; // IP 주소를 표현
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkEx1
{
	public static void main(String[] args)
	{
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try
		{
			ip = InetAddress.getByName("www.naver.com");			
			System.out.println("getHostName() : " + ip.getHostName());
			// getHostName() - 호스트 이름을 문자열로 반환
			System.out.println("getHostAddress() : " + ip.getHostAddress());
			// getHostAddress() - IP 주소를 반환
			System.out.println("toString() : " + ip.toString());
			
			byte[] ipAddr = ip.getAddress();
			// getAddress() - InetAddress 객체의 IP주소를 반환
			System.out.println("getAddress() : " + Arrays.toString(ipAddr));
			
			String result = "";
			for(int i=0; i < ipAddr.length; i++)
			{
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			System.out.println("getAddress() + 256 : " + result);
			// InetAddress 값에 256을 더하면 실제 IP주소가 나옴 ( 보안 )
			System.out.println();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			ip = InetAddress.getLocalHost();
			// 실제 호스트 네임과 IP 주소 얻기
			System.out.println("getHostName() : " + ip.getHostName());
			System.out.println("getHostAddress() : " + ip.getHostAddress());
			System.out.println();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		try
		{
			// 모든 IP 주소 가져오기 - 네이버가 공개한 IP주소만 공개 ( 나머지는 보안상 숨김 )
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			for(int i=0; i < ipArr.length; i++)
			{
				System.out.println("ipArr[" + i + "] : " + ipArr[i]);
			}
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
	}
}
