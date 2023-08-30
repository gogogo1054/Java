import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex15_ConcurrentHashMap
{
	public static Map<String, Integer> syncMap = null; // 전체 락 전체 병목
	public static Map<String, Integer> concMap = null; // 부분 락 부분 병목
	
	public static void performanceTest(final Map<String, Integer> target)
			throws InterruptedException
	{
		System.out.println(("Start : " + Thread.currentThread().getName()));
		Instant start = Instant.now();
		
		Runnable task = () -> {  
			for (int i = 0; i<100000; i++)
				target.put(String.valueOf(i), i); //target 에 key 값 입력
		};
		
		// 5개의 스레트 풀 생성
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.submit(task);  
		pool.submit(task);
		pool.submit(task);
		pool.submit(task);
		pool.submit(task);
		
		pool.shutdown();	// 스레트 풀 종료
		// 안전하게 종료되기까지 기다림.
		pool.awaitTermination(100, TimeUnit.SECONDS);
		
		Instant end = Instant.now();
		// 실행 된 시간을 출력
		System.out.println("End : " + Duration.between(start, end).toMillis()); 
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		// synchronizedMap : Map을 동기화된 Map으로 반환
		syncMap = Collections.synchronizedMap(new HashMap<>());
		// 성능을 체크할 메서드 호출
		performanceTest(syncMap);
		
		/*
		 ConcurrentHashMap 클래스 :
			Hashtable 클래스의 단점을 보완하면서 Multi-Thread 환경에서 사용할 
			수 있도록 나온 클래스가 바로 ConcurrentHashMap 입니다.(JDK 1.5에
			검색과 업데이트시 동시성 성능을 높이기 위해서 나온 클래스 입니다.)
		 */
		concMap = new ConcurrentHashMap<>();  // 더 빠름
		// 성능을 체크할 메서드 호출
		performanceTest(concMap);
	}

}
