package step3;
// jdbc 연결

import java.sql.*;
import java.util.*;


public class MyBook
{
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch ( ClassNotFoundException cnfe) 
		{
//			cnfe.printStackTrace();
		}
	}
	
	Scanner scanner = new Scanner(System.in);
	Map<String, BookInfo> bMap = new HashMap<>();
	Statement stmt = null;
	Connection con = null;
	
	public static void main(String[] args)
	{	
		MyBook mb = new MyBook();
		mb.BookRun();
	}
	
	public void BookRun()
	{
		connectDB();
		
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
					readBook();
					break;
				}
				case 4:	// 삭제
				{
					deleteBook();
					break;
				}
				case 5:	// 종료
				{
					disconnectDB();
					System.out.println("종료");
					return;
				}
				default:
				{
					System.out.println("잘 못 입력하셨습니다.");
					break;
				}
			}
		}
	}
	
	
	public void connectDB()
	{
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"TIGER");
			
			con.setAutoCommit(false);
		}
		catch (SQLException sqle)
		{
//			sqle.printStackTrace();
		}
	}
	
	public void disconnectDB()
	{
		try
		{
			if(pstmt != null) stmt.close();
			
			if(con != null) con.close();
		}
		catch (Exception e) {}
	}

	public void showMenu()
	{
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 책 등록 : ");
		System.out.println("2. 책 조회");
		System.out.println("3. 전체 리스트 조회");
		System.out.println("4. 책 제거");
		System.out.println("5. 종료");
		System.out.println("================");
		System.out.print("> ");
	}

	public void deleteBook()
	{
		System.out.println("삭제할 책 이름을 입력하세요.");
		System.out.print("> ");
		String bName = scanner.next();
		
		if(bMap.remove(bName) == null)
		{
			System.out.println(bName + "책이 없습니다.");
		}
		else
		{
			System.out.println(bName + "책이 제거되었습니다.");
		}
	}

	public void readBook()
	{
		Set<String> keySet = bMap.keySet();
		
		if(keySet.size() == 0)
		{
			System.out.println("책이 없습니다.");
		}
		else
		{
			Iterator<String> it = keySet.iterator();
			
			while(it.hasNext())
			{
				String bookName = it.next();
				BookInfo BI = bMap.get(bookName);
				System.out.println(
						BI.bookCount + ". " +
						BI.bookName + " " +
						BI.bookCount + "권");
			}
			
		}
	}

	public void findBook()	// 조회
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
					System.out.println("책 이름을 입력하세요");
					System.out.print("> ");
					String bName = scanner.next();
					
					BookInfo BI = bMap.get(bName);
					
					if(bName == null)
					{
						System.out.println("제대로 된 책이름을 입력해주세요.");
						break;
					}
					else
					{
						System.out.println(
								BI.getBookCount() + "." +
								BI.getBookName() + " " +
								BI.getBookCount() + "권");
						break;
					}
				}
				case 2:
				{
					break;
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

	PreparedStatement pstmt = null;
	public void saveBook()
	{
		System.out.println("책 번호 입력 : ");
		int bNum = scanner.nextInt();
		System.out.println("책 이름 입력 : ");
		String bName = scanner.next();
		System.out.println("책 권수 입력 : ");
		int bCount = scanner.nextInt();
		
		try
		{
			String query ="INSERT INTO JAVABOOK " +
							"VALUES(?, ?, ?)";
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bNum);
			pstmt.setString(2, bName);
			pstmt.setInt(3, bCount);
			int updateCount = pstmt.executeUpdate();
			
			if(updateCount == 1)
			{
				con.commit();
				System.out.println("데이터가 정상적으로 저장되었습니다.");
			}
			else
			{
				con.rollback();
				System.out.println("데이터 입력에 실패했습니다.");
			}
		}
		catch (SQLException sqle) 
		{
			sqle.printStackTrace();
			System.out.println("데이터 입력에 실패했습니다.");
		}
		BookInfo BI = new BookInfo(bNum, bName, bCount);
		bMap.put(bName, BI);
	}
}





