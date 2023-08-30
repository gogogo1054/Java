package step4;
// 책 제거
// 책 조회
// 전체리스트 조회

import java.sql.*;
import java.util.*;


public class MyBook
{
	Scanner scanner = new Scanner(System.in);
	Map<String, BookInfo> bMap = new HashMap<>();
	Connection con = null;
	ResultSet rs = null;
	
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch ( ClassNotFoundException cnfe) 
		{
			cnfe.printStackTrace();
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
			sqle.printStackTrace();
		}
	}
	
	public void disconnectDB()
	{
		try
		{
			if(pstmts != null) pstmts.close();
			if(pstmtd != null) pstmtd.close();
			
			if(con != null) con.close();
			if(rs != null) rs.close();
		}
		catch (Exception e) {}
	}

	public static void main(String[] args)
	{	
		MyBook mb = new MyBook();
		mb.BookRun();
	}
//////////////////////////////////////////////////////////////////////////////
// 연결 및 메인
	
	public void BookRun() // 책 선택
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
	
	public void showMenu() // 책 메뉴
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

	PreparedStatement pstmts = null;
	public void saveBook() // 책 등록
	{
			System.out.println("책 번호 입력 : ");
			String bNum = scanner.next();
			System.out.println("책 이름 입력 : ");
			String bName = scanner.next();
			System.out.println("책 권수 입력 : ");
			int bCount = scanner.nextInt();
		
		try
		{
			String query ="INSERT INTO JAVABOOK " +
							"VALUES(?, ?, ?)";
			
			pstmts = con.prepareStatement(query);
			pstmts.setString(1, bNum);
			pstmts.setString(2, bName);
			pstmts.setInt(3, bCount);
			int updateCount = pstmts.executeUpdate();
			
			if(updateCount > 0)
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
	}
	
	
	

	PreparedStatement pstmtr = null;
	public void readBook() // 전체 조회
	{
		try
		{
			String query = "SELECT * FROM JAVABOOK ORDER BY BNUM";
			pstmtr = con.prepareStatement(query);
			rs = pstmtr.executeQuery();
			
			while(rs.next())
			{
				System.out.println("----------------------------------------");
				System.out.println("책 번호 : " + rs.getString("BNUM") +"번");
				System.out.println("책 제목 : " + rs.getString("BNAME"));
				System.out.println("책 수량 : " + rs.getInt("BCOUNT") +"권");
			}
			System.out.println("----------------------------------------");
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			try
			{
			rs.close();
			}
			catch (SQLException sqle) {}
		}
		
	}
	PreparedStatement pstmtfnum = null;
	public void findBookNum() // 조회 - 책 번호
	{
		try
		{
			System.out.println("책 번호를 입력하세요");
			System.out.print("> ");
			String bNum = scanner.next();
			
			String query = "SELECT * FROM JAVABOOK " +
							"WHERE BNUM = ?";
			pstmtfnum = con.prepareStatement(query);
			pstmtfnum.setString(1, bNum);
			rs = pstmtfnum.executeQuery();
			
			while(rs.next())
			{
				System.out.println("----------------------------------------");
				System.out.println("책 번호 : " + rs.getString("BNUM") +"번");
				System.out.println("책 제목 : " + rs.getString("BNAME"));
				System.out.println("책 수량 : " + rs.getInt("BCOUNT") +"권");
			}
			System.out.println("----------------------------------------");
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
			}
			catch (SQLException sqle) {}
		}
	}
	
	public void findBook()	// 조회
	{
		while(true)
		{
			System.out.println("1. 책 번호로 조회");
			System.out.println("2. 책 제목으로 조회");
			System.out.println("3. 돌아가기");
			int readSelect = scanner.nextInt();
			
			switch (readSelect)
			{
				case 1:
				{
					findBookNum();
				}
				case 2:
				{	
					findBookName();
				}
				case 3:
				{
					System.out.println("전 메뉴창으로 돌아갑니다.");
					return;
				}
				default:
					System.out.println("잘 못 입력하셨습니다.");
					break;
			}
		}
	}

	PreparedStatement pstmtfname = null;
	public void findBookName() // 조회 - 책 제목
	{
		try
		{
			System.out.println("책 제목을 입력하세요");
			System.out.print("> ");
			String bName = scanner.next();
			
			String query = "SELECT * FROM JAVABOOK " +
							"WHERE BNAME = ?";
			pstmtfname = con.prepareStatement(query);
			pstmtfname.setString(1, bName);
			rs = pstmtfname.executeQuery();
			
			while(rs.next())
			{
				System.out.println("----------------------------------------");
				System.out.println("책 번호 : " + rs.getString("BNUM") +"번");
				System.out.println("책 제목 : " + rs.getString("BNAME"));
				System.out.println("책 수량 : " + rs.getInt("BCOUNT") +"권");
			}
			System.out.println("----------------------------------------");
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
			}
			catch (SQLException sqle) {}
		}
	}
	
	PreparedStatement pstmtd = null;
	public void deleteBook() // 책 제거
	{
		
		System.out.println("삭제할 책 번호를 입력하세요.");
		System.out.print("> ");
		String bNum = scanner.next();

		try
		{
			String query = "DELETE FROM JAVABOOK " +
							"WHERE BNUM = ?";
			
			pstmtd = con.prepareStatement(query);
			pstmtd.setString(1, bNum);
			int updateCount = pstmtd.executeUpdate();
			
			if(updateCount > 0)
			{
				con.commit();
				System.out.println("데이터가 정상적으로 삭제되었습니다.");
			}
			else
			{
				con.rollback();
				System.out.println("데이터 삭제에 실패했습니다.");
			}
		}
		catch (SQLException sqle) 
		{
			sqle.printStackTrace();
			System.out.println("데이터 입력에 실패했습니다.");
		}
	}

	
}





