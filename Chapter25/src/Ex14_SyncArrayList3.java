import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Ex14_SyncArrayList3  // synchronizedList
{
	//public static List<Integer> list =  new ArrayList<Integer>();
	// 컬렉션의 동기화 - Collections.synchronizedXXX()
	// synchronizedList : list를 동기화된 list로 반환
	public static List<Integer> list = 
			Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) throws InterruptedException
	{
		for (int i = 0; i < 10; i++)
			list.add(i);
		System.out.println(list);
		
		Runnable task = () -> {  
			// list 객체를 사용할 때 객체에 동기화 Lock을 설정 그러면 제대로 나옴
			synchronized(list)   // 반드시 사용해야 똑 같이 나옴 동기화 문제가 안 생김
			{
				ListIterator<Integer> itr = list.listIterator();
				
				while (itr.hasNext())
					itr.set(itr.next() +1);  
			}
			
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.submit(task);  
		pool.submit(task);
		pool.submit(task);
		pool.submit(task);
		pool.submit(task);
		
		pool.shutdown();	// 스레트 풀 종료
		// 안전하게 종료되기까지 기다림.
		pool.awaitTermination(100, TimeUnit.SECONDS);
		
		// 값 출력
		System.out.println(list);  // 똑 같이 나옴
	}
}
