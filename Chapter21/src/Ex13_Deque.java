import java.util.ArrayDeque;
import java.util.Deque;

/*
 Deque(Double-Ended Queue) :
 	덱(Deque)은 어떤 쪽으로 입력하고 어떤 쪽으로 출력하느냐에 따라서 
 	스택(Stack)으로 사용할 수도 있고, 큐(Queue)로도 사용할 수 있다. 
 	특히 한쪽으로만 입력 가능하도록 설정한 덱을 스크롤(scroll)이라고 
 	하며, 한쪽으로만 출력 가능하도록 설정한 덱을 셸프(shelf)라고 한다. 
 */
public class Ex13_Deque
{
	public static void main(String[] args)
	{
		// 둘 다 사용 가능
		Deque<String> deq = new ArrayDeque<>();
//		Deque<String> deq = new LimkedList<>();
		
		// 앞으로 넣고  이것이 stack
		deq.offerFirst("A");
		deq.offerFirst("B");
		deq.offerFirst("C");
		
		// 리스트 확인
//		for(String s : deq)
//			System.out.print(s.toString() + '\t');
//		System.out.println();
		
		// 앞에서 꺼내기
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		
		System.out.println("-----------------------------");
		
		// 뒤에서 넣고   이것이 stack
		deq.offerLast("A");
		deq.offerLast("B");
		deq.offerLast("C");
		
		// 리스트 확인
//		for(String s : deq)
//			System.out.print(s.toString() + '\t');
//		System.out.println();
		
		// 뒤에서 꺼내기
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		
		System.out.println("-----------------------------");
		
		// 뒤로 넣고  이것이 Queue
		deq.offerLast("A");
		deq.offerLast("B");
		deq.offerLast("C");
		
		// 앞에서 꺼내기
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		
		System.out.println("-----------------------------");
	}
}
