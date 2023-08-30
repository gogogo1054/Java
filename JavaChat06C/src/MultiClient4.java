import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultiClient4
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		System.out.println("이름을 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		PrintWriter out = null;
		
		try
		{
			String ServerIP = "localhost";
			if(args.length > 0)
			{
				ServerIP = args[0];
			}
			Socket socket = new Socket(ServerIP, 9999); // 소켓 객체 생성
			System.out.println("서버와 연결 되었습니다.");
			
			Thread receiver = new Receiver4(socket);
			receiver.start();
			
			out = new PrintWriter(socket.getOutputStream(), true);
			
			out.println(name);
			
			while ( out != null)
			{
				try
				{
				//출력
					String s = sc.nextLine();
					out.println(s);
					
					if(s.equals("q") || s.equals("Q"))
					{
						break;
					}
				}
				catch(Exception e)
				{
					System.out.println("예외 : " + e);
				}
			}

			out.close();
			
			socket.close();
		}
		catch (Exception e)
		{
			System.out.println("예외[MultiClient class]" + e);
		}
	}
}
