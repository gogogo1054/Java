import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex09_ThreadPool2
{
	public static void main(String[] args)
	{
		Runnable task1 = () -> {    
			String name = Thread.currentThread().getName();
			try
			{
				Thread.sleep(5000);
			}
			catch (Exception e) {}
			System.out.println(name + ": 5초 후 실행");
		};
		
		Runnable task2 = () -> {  
			String name = Thread.currentThread().getName();
			System.out.println(name + ": 바로 실행");
		};
		
		Runnable task3 = () -> {    
			String name = Thread.currentThread().getName();
			try
			{
				Thread.sleep(2000);
			}
			catch (Exception e) {}
			System.out.println(name + ": 2초 후 실행");
		};
		
		// 스레드 폴에서 수행될 수 있는 스레드의 총량을 제한. 두개 처리가능.
		ExecutorService pool = Executors.newFixedThreadPool(2); 
		// 2개의 스레드 풀 사용 5개 까지 가능
		pool.submit(task1);	// 계속 사용중
		pool.submit(task2);	// 바로 사용하고 끝
		pool.submit(task3);  // task2 실행이 끝난 후 그 스레드 폴로 실행 스레드가 같음
		
		pool.shutdown();
	}
}
