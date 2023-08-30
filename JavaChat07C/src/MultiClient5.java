import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultiClient5
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		System.out.println("이름을 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		try
		{
			String ServerIP = "localhost";
			if(args.length > 0)
			{
				ServerIP = args[0];
			}
			Socket socket = new Socket(ServerIP, 9999); // 소켓 객체 생성
			System.out.println("서버와 연결 되었습니다.");
			
			Thread receiver = new Receiver5(socket);
			receiver.start();
			
			Thread sender = new Sender5(socket, name);
			sender.start();
		}
		catch (Exception e)
		{
			System.out.println("예외[MultiClient class]" + e);
		}
	}
}
