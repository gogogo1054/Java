import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 Callable :
	Runnable과 유사하지만 return을 통해 작업의 결과를 받아볼 수 있다.
 Future :
	비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있다. get()
 */
public class Ex10_CallableFuture
{
	public static void main(String[] args)
			throws InterruptedException, ExecutionException
	{
		Callable<Integer> task1 = () -> {   // return 이 있음
			Thread.sleep(500);  
			return 2 + 3;	// 제네릭에서 지정한 형태로 값을 반환
		};
		
		Callable<Integer> task2 = () -> {
			Thread.sleep(1000);  
			return 2 * 3;	// 제네릭에서 지정한 형태로 값을 반환
		};
		
		// 스레트 플 2개 생성
		ExecutorService pool = Executors.newFixedThreadPool(2);
		// Future형 변수에 반환
		Future<Integer> future1 = pool.submit(task1);  // Callable에서 답이 와야 실행
		Future<Integer> future2 = pool.submit(task2);
		
		System.out.println("이 내용이 먼저 출력됩니다.");
		
		// get()을 통해서 반환값을 구해옴
		Integer r1 = future1.get();  // future1이 와야 실행
		System.out.println("result: " + r1);
		
		Integer r2 = future2.get();
		System.out.println("result: " + r2);
		
		pool.shutdown();	// 종료
	}
}
