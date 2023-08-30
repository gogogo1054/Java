public class Ex06_ProblemOfThread  // 스레드의 문제점
{
	public static int money = 0;
	
	public static void main(String[] args) throws InterruptedException
	// 원래는  try.. catch 를 사용해야함
	{
		Runnable task1 = () -> {    
			for (int i=0; i<10000; i++) 
				money++;
		};
		
		Runnable task2 = () -> {    
			for (int i=0; i<10000; i++) 
				money--;
		};
		// 스레드 객체 생성
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		// 실행
		t1.start();
		t2.start();
		
		/*
		생성된 쓰레드가 하나의 작업을 완료하기를 기다리는 기능을
		수행한다. 즉 해당 쓰레드가 하나의 작업이 종료되기를 기다렸다가
		다음 쓰레드를 실행한다. 쓰레드의 동시접근을 제한하는 기능을
		가지고있다.
		 */
		t1.join();    // t1 이 참조하는 스레드의 종료를 기다림. t1 쓰레드 멈춤
		t2.join();    // t2 이 참조하는 스레드의 종료를 기다림  t2 쓰레드 멈춤
		
		// 스레드가 종료되면 출력을 진행함. 위 join 의 영향
		System.out.println(money);  // 0이 나오지는 않음
	}
}
