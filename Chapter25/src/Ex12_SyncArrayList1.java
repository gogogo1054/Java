import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex12_SyncArrayList1
{
	// 스태틱 영역에 리스트 객체 생성
	public static List<Integer> list =  new ArrayList<Integer>();
	
	public static void main(String[] args) throws InterruptedException
	{
		// 정수 10개를 추가
		for (int i = 0; i < 10; i++)
			list.add(i);
		System.out.println(list);	// 리스트 출력
		
		// 스레드 생성
		Runnable task = () -> {   
			// 리스트 반복자
			ListIterator<Integer> itr = list.listIterator();
			
			while (itr.hasNext())
				// 리스트 값에 1씩 더하기
				itr.set(itr.next() +1);
		};
		
		// 5개 처리 할 수 있는 스레드 풀 생성
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
		System.out.println(list); // 똑 같이 나오지는 않음
	}
}
