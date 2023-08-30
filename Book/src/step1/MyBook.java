package step1;
// 메뉴 출력과 책 정보 저장 확인
// 저장된 책 조회

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyBook
{
	static Scanner scanner = new Scanner(System.in);
	static Map<String, BookInfo> bMap = new HashMap<>();

	public static void showMenu()
	{
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 책 등록 : ");
		System.out.println("2. 책 조회");
		System.out.println("3. 전체 리스트 조회");
		System.out.println("4. 책 제거");
		System.out.println("5. 종료");
		System.out.println("================");
		System.out.print("선택 : ");
	}
	
	public static void main(String[] args)
	{
		while(true)
		{
			showMenu();	// 메뉴
			
			int menuSelect = scanner.nextInt();	// 메뉴선택
			
			switch (menuSelect)
			{
				case 1:	// 등록
				{
					saveBook();
					break;
				}
				case 2:	// 조회
				{
					findBook();
					break;
				}
				case 3:	// 전체 리스트 조회
				{
					break;
				}
				case 4:	// 삭제
				{
					break;
				}
				case 5:	// 종료
				{
					System.out.println("종료");
					return;
				}
				default:
					System.out.println("잘 못 입력하셨습니다.");
					break;
			}
		}
	}

	public static void findBook()	// 조회
	{
		while(true)
		{
			System.out.println("1. 책 이름으로 조회");
			System.out.println("2. 책 번호로 조회");
			System.out.println("3. 돌아가기");
			int readSelect = scanner.nextInt();
		
			switch (readSelect)
			{
				case 1:
				{
					System.out.print("책 이름을 입력하세요 : ");
					String bName = scanner.next();
					
					BookInfo BI = bMap.get(bName);
					
					if(bName == null)
					{
						System.out.println("제대로 된 책이름을 입력해주세요.");
						break;
					}
					else
					{
						System.out.println(BI.getBookName() + " " +
								BI.getBookCount() + "권");
						break;
					}
				}
				case 2:
				{
					System.out.print("책 번호를 입력하세요 : ");
					int bNum = scanner.nextInt();
					
					BookInfo BI = bMap.get(bNum);
					
					if(bNum == 0)
					{
						System.out.println("해당 번호의 책이 없습니다.");
						break;
					}
					else
					{
						System.out.println(BI.getBookName() + " " +
								BI.getBookCount() + "권");
						break;
					}
				}
				case 3:
				{
					return;
				}
				default:
					System.out.println("잘 못 입력하셨습니다.");
					break;
			}
		}
	}

	public static void saveBook()
	{
		System.out.println("책 이름 입력 : ");
		String bn = scanner.next();
		System.out.println("책 권수 입력 : ");
		int bc = scanner.nextInt();

			BookInfo SBI = new BookInfo(bn, bc);
			bMap.put(bn, SBI);
	}
}





