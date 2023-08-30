import java.io.*;
import java.net.*;

public class Receiver3 extends Thread
{
	Socket socket;
	BufferedReader in = null;
	
	public Receiver3(Socket socket)
	{
		this.socket = socket;
		
		try
		{
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		}
		catch (Exception e)
		{
			System.out.println("예외1 : " + e);
		}
	}
	
	// run()메소드 재정의
	public void run()
	{
		while(in != null)
		{
			try
			{
				System.out.println("Thread Receive : " + in.readLine());
			}
			catch (Exception e)
			{
				System.out.println("예외2 : " + e);
			}
		}
		
		try
		{
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("예외3 : " + e);
		}
	}
}
