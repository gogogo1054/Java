/*
Thread(쓰레드)
- 쓰레드의 생성은 Thread클래스를 상속하는것부터 시작한다. 
- 해당 방법은 쓰레드로 생성할 클래스가 다른 클래스를 상속할 필요가 없을때
사용한다. 
- 만약 해당 클래스가 다른 클래스를 상속해야 한다면 Runnable 인터페이스를
구현하여 사용한다. 
- java.lang패키지에 있어서 따로 import 할 필요가 없다.
 */
class MyThread2 extends Thread   // 스레드로 상속 받아서 실행
{
	/*
	run() 메서드는 쓰레드의 main() 메서드에 해당한다. 
	Thread 클래스의 run() 메서드는 오버라이딩 한것으로 해당 메서드는 
	직접 호출하면 안되고, start() 메서드를 통해 간접적으로 호출해야한다. 
	만약 직접 호출하면 단순한 실행만 될뿐 쓰레드가 생성되지 않는다. 
	 */
//	@Override	// 생략
	public void run()  // 스레드 상속시 반드시 run() 을 사용 할 것. 이것이 스레드
	{
		int sum = 0;
		for (int i=0; i<10; i++)
			sum = sum +i;
		// 스레드 이름이 없으면 숫자로 줌
		String name = Thread.currentThread().getName(); 
		// 나중에 출력. 연산 결과 출력
		System.out.println(name + ": " + sum); 
	}
}

public class Ex02_ThreadClass
{
	public static void main(String[] args)
	{
		//쓰레드 객체 생성
		MyThread2 t = new MyThread2();
		//쓰레드 객체를 통한 쓰레드 생성 및 실행
		t.start();    // run() 을 불러 옴.
		
		// 현재 스래드명
		System.out.println("main: " + Thread.currentThread().getName());   // 먼저 실행
	}
}
