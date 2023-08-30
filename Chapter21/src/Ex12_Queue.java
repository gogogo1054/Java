import java.util.LinkedList;
import java.util.Queue;

/*
 Queue :
 	줄을 서서 기다린다는 것처럼 먼저 들어오면 데이터가 먼저 나가는 형식입니다
	일명 FIFO(FirstInFirstOut) 방식입니다.
	큐의 앞 부분은 삭제 연산만 수행 큐의 뒷 부분은 삽입 연산만 수행합니다
 */
public class Ex12_Queue
{
	public static void main(String[] args)
	{
		Queue<String> que = new LinkedList<>(); // LinkedList<>로 구현 됨
		
		// 데이터 저장
		que.offer("A");
		que.offer("B");
		que.offer("C");
		
		// 리스트 확인
//		for(String s : que)
//			System.out.print(s.toString() + '\t');
//		System.out.println();
		
		// 무엇이 다음에 나올지 확인
		System.out.println("next; " + que.peek());
		// 첫 번째 객체 꺼내기
		System.out.println(que.poll());    // 꺼내면 다시 사용 못함 없어짐
		System.out.println(que.size());    // 남은 데이터 확인 하기
		
		// 무엇이 다음에 나올지 확인
		System.out.println("next; " + que.peek());
		// 두 번째 객체 꺼내기
		System.out.println(que.poll());    // 꺼내면 다시 사용 못함 없어짐
		System.out.println(que.size());    // 남은 데이터 확인 하기
		
		// 무엇이 다음에 나올지 확인
		System.out.println("next; " + que.peek());
		// 마지막 객체 꺼내기
		System.out.println(que.poll());    // 꺼내면 다시 사용 못함 없어짐
		System.out.println(que.size());    // 남은 데이터 확인 하기
	}
}
