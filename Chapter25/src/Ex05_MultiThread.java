public class Ex05_MultiThread
{
	public static void main(String[] args)
	{
		Runnable task1 = () -> {    
			try
			{
				for (int i=0; i<20; i=i+2)   // 20 미만 짝수 출력
				{
					System.out.print(i + " ");
					/*
					기본적으로 우선순위가 높은 쓰레드가 먼저 실행되지만 sleep()
					메서드를 사용하면 실행중 잠깐씩 블럭상태로 전환되어 우선순위가
					낮은 쓰레드도 실행될 수 있는 기회가 생기게된다. 
					 */
					Thread.sleep(1000);   // 1초(1000밀리세컨드) 쉼
				}
			}
			catch (InterruptedException e) {}
		};
		
		Runnable task2 = () -> {   
			try
			{
				for (int i=9; i>0; i--)   // 10 미만 홀수 출력
				{
					System.out.print("(" + i + ") ");
					Thread.sleep(500);  // 0.5초(500밀리세컨드) 쉼
				}
			}
			catch (InterruptedException e) {}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);  
		
		t1.start();
		t2.start();   // 각각 실행이라 출력순서가 컴환경에 따라 똑같지는 않음. 
	}
}
