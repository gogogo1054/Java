public class Ex07_SyncMethod  
{
	public static int money = 0;
	
	/*
	쓰레드의 동기화
	: synchronized 선언으로 인해 정확한 결과가 나오긴 하지만 코드 실행
	시간이 기존에 비해 길어지게 되는 단점이있다. 즉 동기화 작업은 성능의
	감소를 초래하므로 필요한 부분에 대해서만 동기화 처리를 해주는것이
	좋다. 
	 */
	// 스레드의 문제점을 해결하기 위해 메소드로 호출. 메서드 전체를 동기화
	public synchronized static void deposit()
	{
		money++;
	}
	
	// 스레드의 문제점을 해결하기 위해 메소드로 호출
	public synchronized static void withdraw()
	{
		money--;
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Runnable task1 = () -> {    
			for (int i=0; i<10000; i++) 
				deposit();
		};
		
		Runnable task2 = () -> {    
			for (int i=0; i<10000; i++) 
				withdraw();
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();
		
		t1.join();    // t1 이 참조하는 스레드의 종료를 기다림. t1 쓰레드 멈춤
		t2.join();    // t2 이 참조하는 스레드의 종료를 기다림  t2 쓰레드 멈춤
		
		// 스레드가 종료되면 출력을 진행함. 위 join 의 영향
		System.out.println(money);  // 0이 나옴.
	}
}
