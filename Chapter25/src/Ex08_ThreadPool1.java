import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 스레드 풀은 작업처리에 사용되는 스레드를 제한된 개수만큼 정해놓고 
 작업큐 (Queue)에 들어오는 작업들을 하나씩 스레드가 맡아 처리한다. 
 그렇게 하면 작업처리 요청이 폭증되어도 스레드의 전체개수가 늘어나지 
 않으므로(제한해서 하나씩 처리하기 때문)  시스템 성능이 급격히 저하
 되지 않는다.
 */
public class Ex08_ThreadPool1
{
	// 스태틱 영역에 변수 선언
	public static int money = 0;
	
	public static void main(String[] args)
	{
		Runnable task1 = () -> {    // 스레드에 시킬 작업
			for (int i=0; i<10000; i++) 
				money++;
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + money);
		};
		
		Runnable task2 = () -> {    // 스레드에 시킬 작업
			for (int i=0; i<10000; i++) 
				money--;
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + money);
		};
		
		// 스레드 풀을 만듬.
		// 하나만 실행. 그래서 스레드명이 하나임.
		ExecutorService pool = Executors.newSingleThreadExecutor(); 
		pool.submit(task1);  // 스레드 풀에 작업을 전달. 
		pool.submit(task2);  // 스레드 풀에 작업을 전달   task1 작업이 끝나야 실행
		
		// main()스레드명 출력
		System.out.println("End " + Thread.currentThread().getName());
	
		pool.shutdown();  // 스레드 풀과 그 안에 있는 스레드의 소멸
		// 작업이 다 끝나야 끝남.
	}
}
