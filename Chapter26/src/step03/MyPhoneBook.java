package step03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyPhoneBook  // 3.연락처 입력 동작시키기 → 콜렉션 객체에 데이터 추가
{
	static Scanner sc = new Scanner(System.in);
	static Map<String, PhoneInfo> map = new HashMap<>();
	// <= 검색을 해야하므로 Map 을 사용해야 함.
	
	public static void showMenu() // 메뉴 구성
	{
		System.out.println("[메뉴 선택]");
		System.out.println("1.전화번호 입력");
		System.out.println("2.전화번호 조회");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.종료");
		System.out.print("선택 : ");
	}
	
	public static void addNumber()  // 콜렉션 객체에 데이터 추가
	{
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		PhoneInfo pInfo;
		if (email != null && !email.equals(""))
		{
			pInfo = new PhoneInfo(name, phoneNumber, email);  //3 개 다 입력 됬을 때
		} else 
		{
			pInfo = new PhoneInfo(name, phoneNumber);  // 2개만 입력 됬을 때 
		}
		pInfo.showPhoneInfo();
		map.put(name, pInfo);  // map 값을 입력
		System.out.println("맵의 크기 : " + map.size());
	}
	
	
	public static void selNumber()
	{
		
	}
	
	public static void delNumber()
	{
		
	}
	
	public static void main(String[] args)  // 번호 선택하기 예외 처리는 안했음
	{
		int choice;
		while(true)
		{
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
			case 1:
				addNumber();
				break;
			case 2:
				selNumber();
				break;
			case 3:
				delNumber();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}
}

