/*
 열거형 : - 클래스처럼 보이게 하는 상수
	- 서로 관련있는 상수들끼리 모아 상수들을 정의하는것
	- enum 클래스 형을 기반으로 한 클래스형 선언
기본형
	enum 열거형이름 {상수명1, 상수명2, ...}
열거형에 정의된 상수를 사용하는 방법은 열거형이름.상수명이다.
클래스의 static 변수를 참조하는 것과 동일하다.
 */
enum Human2 { MAN, WOMAN }

enum Machine2 { TANK, AIRPLANE }

public class Ex02_Enum
{

	public static void main(String[] args)
	{
		createUnit(Machine2.AIRPLANE);
		
//		createUnit(Human1.MAN);    // 잘못된 상수 사용 : 에러
		
		// 참고 : C처럼 숫자로 비교하면 에러가 난다.
//		if (Human2.MAN == 0)  // -> 객체이므로 맞지않음.
//		{
//			
//		}
	}
	
	public static void createUnit(Machine2 kind) 
	{
		switch(kind) 
		{
		//case Machine1.TANK:  
		//enum을 사용해 열거형을 만들때 switch 에서 achine2 생략 가능
		case TANK:
			System.out.println("탱크를 만듭니다.");
			break;
		case AIRPLANE:
			System.out.println("비행기를 만듭니다.");
			break;
		}
	}
}
