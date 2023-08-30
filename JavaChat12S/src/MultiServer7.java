import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer7
{

		ServerSocket serverSocket = null;
		Socket socket = null;
		Map<String, PrintWriter> clientMap;
		
		public MultiServer7() {
			
			clientMap = new HashMap<String, PrintWriter>();
			
			Collections.synchronizedMap(clientMap);
			
		}

		public void init()
		{
		
			try
			{
				serverSocket = new ServerSocket(9999);
				System.out.println("서버가 시작되었습니다.");
				
				while (true)
				{
					socket = serverSocket.accept();
					System.out.println(socket.getInetAddress() + ":" + socket.getPort());
					
					Thread msr = new MultiServerT(socket);
					msr.start();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}	
			finally
			{
				try
				{
					serverSocket.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		
		public void list(PrintWriter out)
		{
			Iterator<String> it = clientMap.keySet().iterator();
			String msg = "사용자 리스트{";
			
			while (it.hasNext())
			{
				msg += (String)it.next() + ",";
			}
			msg = msg.substring(0, msg.length()-1) + "]";
			
			try
			{
				out.println(msg);
			}
			catch (Exception e) {}
			
		}
		
		
		public void sendAllMsg(String msg, String name)
		{
			Iterator it = clientMap.keySet().iterator();
			
			while(it.hasNext())
			{
				try
				{
					PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
					if(name.equals(""))
					{
						it_out.println(msg);
					}
					else
					{
						it_out.println(name + " > " + msg);
					}
				}
				catch(Exception e)
				{
					System.out.println("예외 : " + e);
				}
			}
		}
				
		public static void main(String[] args)
		{
			MultiServer7 ms = new MultiServer7();
			ms.init();
		}
		
/////////////////////////////////////////////////////////////////////////////
// 내부 클래스
// 클라이언트로부터 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을
// 하는 메서드
		
	class MultiServerT extends Thread
	{
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;
		String name = "";
		
		public MultiServerT(Socket socket)
		{
			this.socket = socket;
			
			try
			{
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader
						(this.socket.getInputStream()));
			}
			catch (Exception e)
			{
				System.out.println("예외 : " + e);
			}
		}
	
		@Override
		public void run()
		{
			String s = "";
			
			try
			{
				name = in.readLine();
				System.out.println("[" + name + "]님이 대화방에 입장하셨습니다.");
				
				sendAllMsg(name + "님이 입장하셨습니다.", "");
				clientMap.put(name, out);
				
				System.out.println("현재 접속자 수는 " + clientMap.size() +"명 입니다.");
				
				while (in != null)
				{
					s = in.readLine();
					
					if(s.equals("q") || s.equals("Q"))
					{
						break;
					}
					
					System.out.println(name + " > " + s);
					
					if(s.equals("/list"))
					{
						list(out);
					}
					else
					{
						sendAllMsg(s, name);
					}
				}

				System.out.println("쓰레드 종료");
			}
			catch (Exception e)
			{
				System.out.println("예외 : " + e);
			}
			finally
			{
				clientMap.remove(name);
				sendAllMsg(name + "님이 퇴장하셨습니다.", "");
				System.out.println("현재 접속자 수는 " + clientMap.size() +"명 입니다.");
				
				try
				{
					in.close();
					out.close();
					
					socket.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
/////////////////////////////////////////////////////////////////////////////		
}
