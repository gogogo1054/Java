import java.util.Arrays;
import java.util.stream.IntStream;

/*
 스트림(Stream) 이란?
	: 다양한 데이터 소스(컬렉션, 배열 등)를 표준화된 방법으로 다루기 위한 것
	  그 전까지는 List, Set, Map 등의 사용 방법들이 서로 달랐다.
	  데이터 소스를 스트림으로 변환 후 여러 번의 중간연산과 마지막의 최종 
	  연산을 통해 다를 수 있다.
 */
public class Ex01_Stream1
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5};   // 배열 잘 사용 안함
		
		// 스트림 생성
		IntStream stm1 = Arrays.stream(arr);  //IntStream <= 정수 stream  기존에 있음
		
		// 중간연산
		IntStream stm2 = stm1.filter(n -> n%2 ==1);   // 람다식이 여기에서 필요함.
		// true 만 받겠다, 즉 홀수만 받겠다.
		
		// 최종연산
		int sum = stm2.sum();   // 홀수의 합
		
		System.out.println(sum);
	}
}
/*
 데이터를 언제 계산하느냐가 컬렉션과 스트림의 가장 큰 차이이다.
컬렉션은 우리가 아는 DVD와 비슷하다. 영상 전체 데이터를 CD에 모두 담고 있다. 
컬렉션은 현재 자료구조가 포함하는 모든 값을 메모리에 저장하는 자료 구조다. 
즉, 컬렉션의 모든 요소는 컬렉션에 추가하기 전에 계산되어야 한다.
반면, 스트림은 스트리밍 서비스와 비슷하다. 사용자가 필요로 하는 몇 부분만 
미리 내려받는다. 스트림은 이론적으로 요청할 때만 요소를 계산하는 고정된 
자료구조이다. 사용자가 요청하는 값만 추출하는 것이 스트림의 핵심이다.
*/