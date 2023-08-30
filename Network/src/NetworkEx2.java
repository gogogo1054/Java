import java.net.*;

public class NetworkEx2
{
	public static void main(String[] args)
	{
		URL url = null;
		String address = "http://www.enjoypuzzle.com:80/" + 
							"board/bbsview/nemonotice/260/1#1";
		
		try
		{
			url = new URL(address);
			URLConnection conn = url.openConnection();
			
			System.out.println("conn.toString() : " + conn);
			System.out.println("getAllowUserInteraction() : " + conn.getAllowUserInteraction());
			// UserInteraction ( 사용자 상호작용 ) 의 허용여부를 반환한다
			System.out.println("getConnectTimeout() : " + conn.getConnectTimeout());
			// 연결 종료시간을 천분의 일초로 반환한다.
			System.out.println("getContent() : " + conn.getContent());
			// Content 객체를 반환한다 - 주소
			System.out.println("getContentEncoding() : " + conn.getContentEncoding());
			// Content 객체의 인코딩을 반환한다. - null
			System.out.println("getContentLength() : " + conn.getContentLength());
			// content의 크기를 반환한다.
			System.out.println("getContentType() : " + conn.getContentType());
			// content의 type을 반환한다.
			System.out.println("getDate() : " + conn.getDate());
			// 헤더(header)의 date필드의 값을 반환한다. ms(밀리세컨드) 단위 - 뒤의 세자리가 ms
			System.out.println("getDefaultUseCaches() : " + conn.getDefaultUseCaches());
			// UseCache의 default값을 얻는다.
			System.out.println("getDoInput() : " + conn.getDoInput());
			// DoInput 필드값을 얻는다.
			System.out.println("getDoOutput() : " + conn.getDoOutput());
			// Dooutput 필드값을 얻는다.
			System.out.println("getExpiration() : " + conn.getExpiration());
			// 자원의 만료일자를 얻는다.
			System.out.println("getHeaderFields() : " + conn.getHeaderFields());
			// 헤더의 필드를 읽어온다.
			System.out.println("getIfModifiedSince() : " + conn.getIfModifiedSince());
			// IfModifiedSince ( 변경여부) 필드의 값을 반환한다.
			System.out.println("getLastModified() : " + conn.getLastModified());
			// 최종 변경일 필드의 값을 반환한다.
			System.out.println("getReadTimeout() : " + conn.getReadTimeout());
			// 읽기 제한시간의 값을 반환한다.
			System.out.println("getURL() : " + conn.getURL());
			// URLConnection의 URL을 반환한다.
			System.out.println("getUseCaches() : " + conn.getUseCaches());
			// 캐쉬의 사용여부를 반환한다.
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
