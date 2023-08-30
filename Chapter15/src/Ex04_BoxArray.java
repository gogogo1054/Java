/*
클래스형 : 클래스를 배열로 선언하는 방식. 사용법은 동일하다. 
 */
class BoxA4
{
	public String name;
	
	BoxA4(String name)
	{
		this.name = name;
	}
}
public class Ex04_BoxArray
{
	public static void main(String[] args)
	{
		// 객체를 저정할 배열을 선언 
		BoxA4[] ar = new BoxA4[3];
		
		// 배열에 객체 저장 (초기화). 인덱스를 통해 접근 후 각 원소를 초기화
		ar[0] = new BoxA4("홍길동");
		ar[1] = new BoxA4("전우치");
		ar[2] = new BoxA4("손오공");
		
		// 저장된 객체의 참조
		System.out.println(ar[0].name);
		System.out.println(ar[1].name);
		System.out.println(ar[2].name);
	}
}
