public class Ex04_RunnableInterface2
{
	public static void main(String[] args)
	{
		Runnable task = () -> {    // 람다식으로 내부에 만드는 것을 많이 씀
			try
			{
				Thread.sleep(3000);    // 3초 동안 멈춰라
			}
			catch (Exception e) {}
			
			int sum = 0;
			for (int i=0; i<10; i++)
				sum = sum +i;
			// 현 재 스레드명
			String name = Thread.currentThread().getName(); 
			// 연산 결과 출력. 3초 뒤에 출력
			System.out.println(name + ": " + sum);  // 여기가 실행되야 멈춤
		};
		
		// 스레드 객체 생성
		Thread t = new Thread(task);  // 람다식을 일반식에 넣음
		// start()메서드를 호출 하면 run()메서드가 실행됨.
		t.start();   
		// 실행과 동시에 출력
		System.out.println("main: " + Thread.currentThread().getName()); 
	}
}
