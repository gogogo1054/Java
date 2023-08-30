package step5;
// 회원 가입

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


//연결 및 메인

public class MyBook
{
	Scanner scanner = new Scanner(System.in);
	Connection con = null; // 연결
	ResultSet rs = null; // 쿼리문 저장
	int adminCheck = 0; // 관리자 확인 번호
	int wdOut = 0; // 회원탈퇴
	String UID = ""; // 유저아이디
	String UPW ="";	// 유저비밀번호
	String UNAME =""; // 유저이름
	int BC = 0; // 빌린 권수
	long blackDay = 0; // 체납일
	
	static // DB 연결
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
	
	public void connectDB() // scott계정 로그인
	{
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",	
					// 학원에서는 hostname을 localhost로 변경 (집 : hostname )
					"scott",
					"TIGER");
			
			con.setAutoCommit(false);
		}
		catch (SQLException sqle)
		{
//			sqle.printStackTrace();
		}
	}
	
	public void disconnectDB() // DB연결 해제
	{
		try
		{
			if(pstmtBN != null) pstmtBN.close();
			if(pstmtCNB != null) pstmtCNB.close();
			if(pstmtCNC != null) pstmtCNC.close();
			if(pstmtCNR != null) pstmtCNR.close();
			if(pstmtDNAME != null) pstmtDNAME.close();
			if(pstmtDNUM != null) pstmtDNUM.close();
			if(pstmtFID != null) pstmtFID.close();
			if(pstmtFNAME!= null) pstmtFNAME.close();
			if(pstmtFNUM != null) pstmtFNUM.close();
			if(pstmtFPW != null) pstmtFPW.close();
			if(pstmtIDC != null) pstmtIDC.close();
			if(pstmtLOGIN != null) pstmtLOGIN.close();
			if(pstmtR != null) pstmtR.close();
			if(pstmtBR != null) pstmtBR.close();
			if(pstmtRI != null) pstmtRI.close();
			if(pstmtRL != null) pstmtRL.close();
			if(pstmtSB != null) pstmtSB.close();
			if(pstmtSIGN != null) pstmtSIGN.close();
			if(pstmtUI != null) pstmtUI.close();
			
			if(con != null) con.close();
			if(rs != null) rs.close();
		}
		catch (Exception e) {}
	}

	public static void main(String[] args)
	{	
		MyBook mb = new MyBook();
		mb.FirstRun();
	}
	
	PreparedStatement pstmtCNB = null;
	public int countNumBook() // 책 고유번호
	{
		int cnb = 0;
		
		try
		{
			String query = "select CNB.nextval from dual";
			pstmtCNB = con.prepareStatement(query);
			rs = pstmtCNB.executeQuery();
			
			while(rs.next())
			{
				cnb = rs.getInt("nextval");
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return cnb;
	}
	
	PreparedStatement pstmtCNC = null;
	public int countNumClient() // 유저 고유번호
	{
		int cnc = 0;
		
		try
		{
			String query = "select CNC.nextval from dual";
			pstmtCNC = con.prepareStatement(query);
			rs = pstmtCNC.executeQuery();
			
			while(rs.next())
			{
				cnc = rs.getInt("nextval");
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return cnc;
	}
	
	PreparedStatement pstmtCNR = null;
	public int countNumRental() // 대여 고유번호
	{
		int cnl = 0;
		
		try
		{
			String query = "select CNR.nextval from dual";
			pstmtCNR = con.prepareStatement(query);
			rs = pstmtCNR.executeQuery();
			
			while(rs.next())
			{
				cnl = rs.getInt("nextval");
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return cnl;
	}
	
	PreparedStatement pstmtCNT = null;
	public int countNumTurn() // 반납 고유번호
	{
		int cnl = 0;
		
		try
		{
			String query = "select CNT.nextval from dual";
			pstmtCNR = con.prepareStatement(query);
			rs = pstmtCNR.executeQuery();
			
			while(rs.next())
			{
				cnl = rs.getInt("nextval");
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return cnl;
	}
	

	public long diffOfDate(String begin, String end) throws Exception 
	// 날짜계산식
	{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    
    Date nowD = sdf.parse(begin);
    Date turnD = sdf.parse(end);
    
    long diff = turnD.getTime() - nowD.getTime();

    long diffDays = diff / (24 * 60 * 60 * 1000);
    // 날짜값을 시*분*초*밀리초로 나눠줘야 값이나옴
    
    return diffDays;
	}
	
///////////////////////////////////////////////////////////////////////////////
// 처음 - 로그인창

	public void FirstRun() // 첫 메뉴 - 로그인창
	{
		connectDB();
		
		while(true)
		{
			try
			{
				showLoginMenu();	// 메뉴
				
				int menuSelect = scanner.nextInt();	// 메뉴선택
				
				switch (menuSelect)
				{
					case 1:	// 회원가입
					{
						memberShip();
						break;
					}
					case 2:	// 로그인
					{
						login();
						break;
					}
					case 3:	// 아이디 찾기
					{
						findId();
						break;
					}
					case 4:	// 비밀번호 찾기
					{
						findPw();
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
						System.out.println("올바르지 않은 메뉴선택입니다.");
						break;
					}
				}
			}
			catch (InputMismatchException ime)
			{
				scanner = new Scanner(System.in); // 스캐너 버그 해결
//				ime.printStackTrace();
				System.out.println("올바르지 않은 메뉴선택입니다.");
			}
		}
	}
	
	public void showLoginMenu()
	{
		wdOut = 0;
		
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 회원가입 ");
		System.out.println("2. 로그인 ");
		System.out.println("3. 아이디 찾기 ");
		System.out.println("4. 비밀번호 찾기");
		System.out.println("5. 종료 ");
		System.out.println("================");
		System.out.print("> ");
	}
	
	PreparedStatement pstmtFPW = null;
	public void findPw() // 비밀번호 찾기
	{
		System.out.print("아이디를 입력해주세요 : ");
		String id = scanner.next();
		
		if(id.equals("admin"))
		{
			System.out.println("관리자 계정은 조회할 수 없습니다.");
			return;
		}
		
		System.out.print("이름을 입력해주세요 : ");
		String name = scanner.next();
		
		try
		{
			String query = "select * from CLIENTDB where CID = ? and CNAME = ?";
			pstmtFPW = con.prepareStatement(query);
			pstmtFPW.setString(1, id);
			pstmtFPW.setString(2, name);
			rs = pstmtFPW.executeQuery();
			int fcnt = 0;
			
			while(rs.next())
			{
				fcnt++;
				rs.getString("CPW");
				System.out.println("당신의 비밀번호는");
				System.out.println(rs.getString("CPW") + " 입니다.");
			}
			
			if(fcnt == 0)
			{
				System.out.println("등록되어 있지 않은 계정입니다.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	PreparedStatement pstmtFID = null;
	public void findId() // 아이디 찾기
	{
		System.out.print("이름을 입력해주세요 : ");
		String name = scanner.next();
		
		try
		{
			String query = "select * from CLIENTDB where CNAME = ? "
								+ "order by CNUM";
			pstmtFID = con.prepareStatement(query);
			pstmtFID.setString(1, name);
			rs = pstmtFID.executeQuery();
			int fcnt = 0;
			
			while(rs.next())
			{
				fcnt++;
				rs.getString("CID");
				System.out.println("ID : " + rs.getString("CID") 
				+ "	//	" + fcnt);
			}
			
			if(fcnt == 0)
			{
				System.out.println("등록되어 있지 않은 이름입니다.");
			}
			else if(fcnt != 0)
			{
				System.out.println("ID가	" + fcnt + "개 조회되었습니다.");
				System.out.println("-----------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	PreparedStatement pstmtLOGIN = null;
	public void login() // 로그인
	{
		System.out.print("ID : ");
		String id = scanner.next();
		System.out.print("PW : ");
		String pw = scanner.next();
		
		try
		{
			String query = "select * from CLIENTDB where CID = ? and CPW = ?";
			pstmtLOGIN = con.prepareStatement(query);
			pstmtLOGIN.setString(1, id);
			pstmtLOGIN.setString(2, pw);
			rs = pstmtLOGIN.executeQuery();
			int fcnt = 0;
			
			while(rs.next())
			{
				fcnt++;
				rs.getString("CID");
				rs.getString("CPW");
				
				if(id.equals("admin") && pw.equals("1234"))
				{
					System.out.println("------------------");
					System.out.println("관리자 화면입니다.");
					System.out.println("------------------");
					adminCheck++;
					adminMenu();
				}
				else
				{
					UID = rs.getString("CID");
					UPW = rs.getString("CPW");
					UNAME = rs.getString("CNAME");
					blackDay = rs.getLong("CBLACK");
					BC = rs.getInt("BC");
					System.out.println("안녕하세요! " + rs.getString("CNAME") +"님");
					userMenu();
				}
			}
			
			if(fcnt == 0)
			{
				System.out.println("아이디 또는 패스워드가 다르거나");
				System.out.println("등록되어 있지 않은 계정입니다.");
			}
		}
		catch (Exception e)
		{
//			e.printStackTrace();
		}
	}
	
	public void memberShip() // 회원가입
	{
		scanner = new Scanner(System.in); // 스캐너 버그 해결
		String id = mbIdCheck();
		String pw = mbPwCheck();
		String name = mbNameCheck();
		signUp(id, pw, name);
	}
	
	PreparedStatement pstmtSIGN = null;
	public void signUp( String id, String pw, String name) 
	// 회원가입 정보 DB 입력
	{
		try
		{
			int cnum = countNumClient();
			
			String query = "insert into CLIENTDB values(?, ?, ?, ?, ?, ?)";
			pstmtSIGN = con.prepareStatement(query);
			pstmtSIGN.setInt(1, cnum);
			pstmtSIGN.setString(2, id);
			pstmtSIGN.setString(3, pw);
			pstmtSIGN.setString(4, name);
			pstmtSIGN.setString(5, "0");
			pstmtSIGN.setInt(6, 0);
			
			
			int updateCount = pstmtSIGN.executeUpdate();
			if(updateCount ==1)
			{
				con.commit();
				System.out.println("회원가입이 정상적으로 처리되었습니다.");
			}
			else
			{
				con.rollback();
				System.out.println("회원가입에 실패했습니다.");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("회원가입 과정에 오류가 발생하였습니다. ");
//			e.printStackTrace();
		}
	}
	
	
	
	public String checkEnNum(String check) // 숫자, 영문 확인
	{
		int checkCnt = 0;
		int checkEn = 0;
		String result = check;
		
		for(int i=0; i<check.length(); i++)
		{
			char ch = check.charAt(i);
			
			if(('a'<=ch && ch<='z') || ('A'<=ch && ch<='Z'))
			{
				checkCnt++;
				checkEn++;
			}
			else if('0'<=ch && ch<='9')
			{
				checkCnt++;
			}
			else
			{
				System.out.println("영어와 숫자만 사용가능합니다.");
				return result ="";
			}
		}
		
		if(checkCnt == 0)
		{
			System.out.println("영문자와 숫자만 입력하세요.");
			return result = "";
		}
		
		if(checkEn == 0)
		{
			System.out.println("영문자는 한글자 이상 입력해야합니다.");
			return result = "";
		}
		
		return result;
	}
	
	PreparedStatement pstmtIDC = null;
	public String mbIdCheck() // 아이디체크
	{
		String fID = "";
		
		while(true)
		{
			System.out.print("ID : ");
			String id = scanner.nextLine();
			
			if(id.length() <5 || id.length() >15)
			{
				scanner = new Scanner(System.in);
				System.out.println("5~15자 이내의 아이디만 가능합니다.");
				continue;
			}
			else
			{
				if(checkEnNum(id).equals(""))
				{
					scanner = new Scanner(System.in);
					continue;
				}
				else
				{
					fID = checkEnNum(id);
					
					try
					{
						String query = "select * from CLIENTDB where CID = ?";
						pstmtIDC = con.prepareStatement(query);
						pstmtIDC.setString(1, fID);
						rs = pstmtIDC.executeQuery();
						int fcnt = 0;
						
						while(rs.next())
						{
							fcnt++;
							rs.getString("CID");
							System.out.println(fID + "는 이미 사용중입니다.");
						}
						if(fcnt == 0)
						{
							System.out.println(fID + "는 사용 가능합니다.");
							System.out.println("사용 하시겠습니까? y/n");
							String useQ = scanner.next();
							
							if(useQ.equals("y") || useQ.equals("Y"))
							{
								scanner = new Scanner(System.in);
								return fID;
							}
							else if(useQ.equals("n") || useQ.equals("N"))
							{
								System.out.println("다시 입력해주세요.");
								scanner = new Scanner(System.in);
								continue;
							}
							else
							{
								System.out.println("y 또는 n 으로만 답해주세요.");
								scanner = new Scanner(System.in);
								continue;
							}
						}
					}
					catch(Exception e)
					{
//						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	
	public String mbNameCheck() // 이름 체크
	{
		String fNAME = "";
		
		while(true)
		{
			System.out.print("이름을 입력해주세요 : ");
			String name = scanner.next();
			
			if(name.length() <1)
			{
				System.out.println("이름은 1글자 이상으로 입력해주세요.");
				scanner = new Scanner(System.in);
				continue;
			}
			else
			{
				fNAME = name;
				return fNAME;
			}
		}
	}
	
	public String mbPwCheck() // 비밀번호 체크
	{
		String fPW = "";
		
		while(true)
		{
			System.out.print("PW : ");
			String pw = scanner.nextLine();
			
			if(pw.length() <4 || pw.length() >15)
			{
				System.out.println("4~15자 이내의 비밀번호만 가능합니다.");
				scanner = new Scanner(System.in);
				continue;
			}
			else
			{
				fPW = pw;
				return fPW;
			}
		}
	}
	
///////////////////////////////////////////////////////////////////////////////
// 관리자 화면
	
public void adminMenu() // 관리자 메뉴
{
	while(true)
	{
		try
		{
			adminShow();	// 메뉴
			
			int menuSelect = scanner.nextInt();	// 메뉴선택
			
			switch (menuSelect)
			{
				case 1:	// 책 정보
				{
					bookSelect();
					break;
				}
				case 2:	// 전체 유저 정보
				{
					userInfo();
					break;
				}
				case 3:	// 전체 대여 정보
				{
					rentalInfo();
					break;
				}
				case 4:	// 로그아웃
				{
					System.out.println("로그아웃 되었습니다.");
					adminCheck = 0;
					return;
				}
				case 5:	// 종료
				{
					disconnectDB();
					System.out.println("종료");
					System.exit(0);
				}
				default:
				{
					System.out.println("올바르지 않은 메뉴선택입니다.");
					break;
				}
			}
		}
		catch (InputMismatchException ime)
		{
			scanner = new Scanner(System.in); // 스캐너 버그 해결
//			ime.printStackTrace();
			System.out.println("올바르지 않은 메뉴선택입니다.");
		}
	}
}

public void adminShow() // 관리자 메뉴창
{
	System.out.println("===== 메뉴 =====");
	System.out.println("1. 보유중인 책 목록 ");
	System.out.println("2. 전체 유저 정보");
	System.out.println("3. 대여 정보 ");
	System.out.println("4. 로그아웃");
	System.out.println("5. 종료 ");
	System.out.println("================");
	System.out.print("> ");
}

PreparedStatement pstmtRI = null;
public void rentalInfo()
{
	try
	{
		String query = "select * from RENTDB order by RNUM";
		pstmtRI = con.prepareStatement(query);
		rs = pstmtRI.executeQuery();
		
		while(rs.next())
		{
			System.out.println("----------------------------------------");
			System.out.println("대여번호 : " + rs.getInt("RNUM") +"번");
			System.out.println("책번호 : " + rs.getInt("R_BNUM") + "번");
			System.out.println("유저ID : " + rs.getString("R_CID"));
			System.out.println("성함 : " + rs.getString("R_CNAME"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd");
			String rentD = sdf.format(rs.getDate("RENTD"));
			String turnD = sdf.format(rs.getDate("TURND"));


			System.out.println("대여일 : " + rentD);
			System.out.println("반납일 : " + turnD);
		}
		System.out.println("----------------------------------------");
	}
	catch (SQLException sqle)
	{
		sqle.printStackTrace();
	}
}

PreparedStatement pstmtUI = null;
public void userInfo()
{
	try
	{
		String query = "select * from CLIENTDB where CNUM>=1 order by CNUM";
		pstmtUI = con.prepareStatement(query);
		rs = pstmtUI.executeQuery();
		
		while(rs.next())
		{
			System.out.println("----------------------------------------");
			System.out.println("유저번호 : " + rs.getString("CNUM") +"번");
			System.out.println("유저ID : " + rs.getString("CID"));
			System.out.println("유저PW : " + rs.getInt("CPW"));
			System.out.println("성함 : " + rs.getString("CNAME"));
			if(rs.getInt("CBLACK") > 0 )
			{
				System.out.println("블랙리스트입니다. " + rs.getInt("CBLACK") + "일 동안 대여 불가능");
			}
		}
		System.out.println("----------------------------------------");
	}
	catch (SQLException sqle)
	{
//		sqle.printStackTrace();
	}
}
	
///////////////////////////////////////////////////////////////////////////////
// 유저 화면	
	
public void userMenu() // 유저 메뉴 
{
	blackDay();
	
	while(true)
	{
		try
		{
			userShow();	// 메뉴
			
			int menuSelect = scanner.nextInt();	// 메뉴선택
			
			switch (menuSelect)
			{
				case 1:	// 책 정보
				{
					bookSelect();
					break;
				}
				case 2:	// 대여
				{
					rentalMenu();
					break;
				}
				case 3:	// 반납
				{
					returnBook();
					break;
				}
				case 4:	// 연장
				{
					extensionDay();
					break;
				}
				case 5:	// 로그아웃
				{
					UID = "";
					UNAME ="";
					UPW ="";
					blackDay = 0;
					System.out.println("로그아웃 되었습니다.");
					return;
				}
				case 6:	// 회원탈퇴
				{
					withdrawal();
					break;
				}
				case 7:	// 종료
				{
					disconnectDB();
					System.out.println("종료");
					System.exit(0);
				}
				default:
				{
					System.out.println("올바르지 않은 메뉴선택입니다.");
					break;
				}
			}
			if(wdOut > 0)
			{
				return;
			}
			
		}
		catch (InputMismatchException ime)
		{
			scanner = new Scanner(System.in); // 스캐너 버그 해결
//			ime.printStackTrace();
			System.out.println("올바르지 않은 메뉴선택입니다.");
		}
	}
}	
	
public void userShow()// 유저 메뉴창
{
	System.out.println("===== 메뉴 =====");
	System.out.println("1. 책 정보 ");
	System.out.println("2. 대여 ");
	System.out.println("3. 반납 ");
	System.out.println("4. 연장 ");
	System.out.println("5. 로그아웃");
	System.out.println("6. 회원탈퇴 ");
	System.out.println("7. 종료 ");
	System.out.println("================");
	System.out.print("> ");
}

PreparedStatement pstmtUBU = null;
public void updateBC()
{
	try
	{
		String query = "update CLIENTDB set BC = ? "
				+ "where CID = ?";
		
		pstmtUBU = con.prepareStatement(query);
		pstmtUBU.setInt(1, BC);
		pstmtUBU.setString(2, UID);
		pstmtUBU.executeUpdate();	
		con.commit();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
}


PreparedStatement pstmtBDC = null;
PreparedStatement pstmtBDCU = null;
PreparedStatement pstmtBDCT = null;
PreparedStatement pstmtBDCTU = null;
public void blackDay() 
{
	try
	{
		String query = 
				"select * from RENTDB where R_CID = ?";
		pstmtBDC = con.prepareStatement(query);
		pstmtBDC.setString(1, UID);
		rs = pstmtBDC.executeQuery();
		int fcnt = 0;
	
		while(rs.next())
		{
			fcnt++;
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
			Date today = new Date();
			
			String turnD = sdf.format(rs.getDate("TURND"));
//			String nowD = sdf.format(today);
			String nowD = "230706"; // 연체일 출력 확인
			
			long dayDiff = diffOfDate(nowD, turnD);

			if(dayDiff < 0)
			{
				try
				{
					blackDay = dayDiff * (-2);
					
					String query2 = "update CLIENTDB set CBLACK = ? "
							+ "where CID = ?";
					pstmtBDCU = con.prepareStatement(query2);
					pstmtBDCU.setLong(1, blackDay);
					pstmtBDCU.setString(2, UID);
					pstmtBDCU.executeUpdate();

					con.commit();
					System.out.println( "연체된 책이 있습니다.");
					break;
				}
				catch (Exception e)
				{
					e.printStackTrace();
					System.out.println("오류");
				}
			}
			else
			{
				break;
			}
		}
		if(fcnt == 0)
		{
			try
			{
				String query3 = "select * from TURNDB where T_CID = ?";
	
				pstmtBDCT = con.prepareStatement(query3);
				pstmtBDCT.setString(1, UID);
				rs = pstmtBDCT.executeQuery();
				int fcnt2 = 0;
			
				while(rs.next())
				{
					fcnt2++;
					SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
					Date today = new Date();
					
					String backD = sdf.format(rs.getDate("BACKD"));
//					String nowD = sdf.format(today);
					String nowD = "230706"; // 연체일 차감 확인 - 반납일
					
					long dayDiff = diffOfDate(nowD, backD);
					
					if(dayDiff < 0)
					{
						blackDay -= (dayDiff*(-1));
						
						if(blackDay < 0) // 음수값이 들어가면 안되므로
						{
							blackDay = 0;
						}
						else
						{
							try
							{
								String query4 = "update CLIENTDB set CBLACK = ? "
										+ "where CID = ?";
								
								pstmtBDCTU = con.prepareStatement(query4);
								pstmtBDCTU.setLong(1, blackDay);
								pstmtBDCTU.setString(2, UID);
								pstmtBDCTU.executeUpdate();	
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
						}
						con.commit();
					}
				}
				if(fcnt2 == 0)
				{
					return;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
			
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

PreparedStatement pstmtED = null;
PreparedStatement pstmtEDC = null;
public void extensionDay()
{
	System.out.println("대여기간을 연장할 책 제목을 입력하세요.");
	System.out.print("> ");
	String bName = scanner.next();
	
	try
	{
		String query = "select * from RENTDB where R_BNAME = ? and R_CNAME = ?";
		pstmtEDC = con.prepareStatement(query);
		pstmtEDC.setString(1, bName);
		pstmtEDC.setString(2, UNAME);
		rs = pstmtEDC.executeQuery();
		int fcnt = 0;
		
		while(rs.next())
		{
			fcnt++;
			
			int exCheck = rs.getInt("EXCOUNT");
			
			if(exCheck == 0)
			{
				try
				{
					String query2 = "update RENTDB set TURND = TURND + 7, EXCOUNT = EXCOUNT + 1" +
									"where R_BNAME = ? and R_CNAME = ?";
					
					pstmtED = con.prepareStatement(query2);
					pstmtED.setString(1, bName);
					pstmtED.setString(2, UNAME);
					int updateCount = pstmtED.executeUpdate();
			
					if(updateCount > 0)
					{
						con.commit();
						System.out.println("[" + bName + "] 책의 반납일이 1주일 연장되었습니다.");
					}
					else
					{
						System.out.println("오류발생");
					}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
					System.out.println("오류");
				}
			}
			else
			{
				System.out.println("반납일 연장은 최대 한 번 가능합니다.");
				break;
			}
		}
		if(fcnt == 0)
		{
			System.out.println("[" + bName + "] 책이 없습니다.");
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
}

PreparedStatement pstmtTB = null;
PreparedStatement pstmtTBM = null;
PreparedStatement pstmtTBDATE = null;
PreparedStatement pstmtBD = null;
public void returnBook()
{

	System.out.println("책은 한 번에 다 반납하셔야 합니다.");
	System.out.println("반납하시겠습니까? y/n");
	String useQ = scanner.next();
	
	if(useQ.equals("y") || useQ.equals("Y"))
	{
		while(true)
		{
			System.out.println("반납하실 책 제목을 입력하세요.");
			System.out.print("> ");
			String bName = scanner.next();
		
			try
			{
				int fcnt = 0;
				String query = "select * from RENTDB where R_CID = ?";
				pstmtTBDATE = con.prepareStatement(query);
						pstmtTBDATE.setString(1, UID);
				rs = pstmtTBDATE.executeQuery();
				
				while(rs.next())
				{
					fcnt++;
					BC--; // 반납 권수 차감
					updateBC();
					String query2 = "delete from RENTDB " +
									"where R_BNAME = ? and R_CNAME = ?";
					
					pstmtTB = con.prepareStatement(query2);
					pstmtTB.setString(1, bName);
					pstmtTB.setString(2, UNAME);
					int updateCount = pstmtTB.executeUpdate();
					
					if(updateCount > 0)
					{
						try
						{
							System.out.println("[" + bName + "]책을 반납했습니다.");
							
							String query3 = "update JAVABOOK set BCOUNT = BCOUNT + 1 "
									+ "where BNAME = ?";
							
							pstmtTBM = con.prepareStatement(query3);
							pstmtTBM.setString(1, bName);
							pstmtTBM.executeUpdate();
							
							String query4 = "insert into TURNDB values"
									+ "(?,?,?,"
									+ "to_date(?,'yyyy/mm/dd'))";
							
							int tNum = countNumTurn();
							LocalDate sysdate = LocalDate.now();
							LocalDate today = sysdate;
							
							pstmtBD = con.prepareStatement(query4);
							pstmtBD.setInt(1, tNum);
							pstmtBD.setString(2, UID);
							pstmtBD.setString(3, bName);
							pstmtBD.setDate(4, java.sql.Date.valueOf(today));
							pstmtBD.executeUpdate();
						}
						catch(Exception e)
						{
							scanner = new Scanner(System.in);
							e.printStackTrace();
						}
					}
					else
					{
						scanner = new Scanner(System.in);
						con.rollback();
						System.out.println("[" + bName + "]책이 없습니다.");
						break;
					}
				}
				if(fcnt == 0)
				{
					scanner = new Scanner(System.in);
					System.out.println("대여 정보가 없습니다.");
				}
				con.commit();
			}
			catch (Exception sqle) 
			{
				sqle.printStackTrace();
				System.out.println("입력 오류.");
			}
			
			if(BC == 0)
			{
				scanner = new Scanner(System.in);
				System.out.println("책을 모두 반납했습니다.");
				return;
			}
		}
	}
	else if(useQ.equals("n") || useQ.equals("N"))
	{
		System.out.println("반납을 취소합니다.");
		return;
	}
	else
	{
		scanner = new Scanner(System.in);
	}
}

public void rentalMenu()
{
	while(true)
	{
		try
		{
			rentalShow();	// 메뉴
			
			int menuSelect = scanner.nextInt();	// 메뉴선택
			
			switch (menuSelect)
			{
				case 1:	// 대여 가능한 책 목록
				{
					rentalList();
					break;
				}
				case 2:	// 대여
				{
					bookRental();
					break;
				}
				case 3:	// 돌아가기
				{
					return;
				}
				default:
				{
					System.out.println("올바르지 않은 메뉴선택입니다.");
					break;
				}
			}
		}
		catch (InputMismatchException ime)
		{
			scanner = new Scanner(System.in); // 스캐너 버그 해결
//			ime.printStackTrace();
			System.out.println("올바르지 않은 메뉴선택입니다.");
		}
	}
}

public void rentalShow()
{
	System.out.println("===== 메뉴 =====");
	System.out.println("1. 대여 가능한 책 목록 ");
	System.out.println("2. 대여 ");
	System.out.println("3. 돌아가기 ");
	System.out.println("================");
	System.out.print("> ");
}

PreparedStatement pstmtBN = null;
PreparedStatement pstmtBR = null;
PreparedStatement pstmtBRC = null;
PreparedStatement pstmtUPDATE = null;
public void bookRental()
{
	if(blackDay > 0)
	{
		System.out.println(blackDay + "일 동안 대여가 불가능합니다.");
		return;
	}
	if(BC >= 3)
	{
		System.out.println("책은 3권까지만 빌리실 수 있습니다.");
		return;
	}
	
	System.out.println("대여하실 책 제목을 입력해주세요.");
	String bName = scanner.next();
	
	try
	{
		String query = "select * from RENTDB where R_CID = ? "
				+ "and R_BNAME = ?";
		pstmtBRC = con.prepareStatement(query);
		pstmtBRC.setString(1, UID);
		pstmtBRC.setString(2, bName);
		rs = pstmtBRC.executeQuery();
		while(rs.next())
		{
			System.out.println("이미 대여한 책입니다.");
			return;
		}
		int fcnt = 0;
		String query2 = "select * from JAVABOOK where BNAME = ?";
		pstmtBN = con.prepareStatement(query2);
		pstmtBN.setString(1, bName);
		rs = pstmtBN.executeQuery();
		
		while(rs.next())
		{
			fcnt++;
			int bNum = rs.getInt("BNUM");
			int bCount = rs.getInt("BCOUNT");
			
			LocalDate sysdate = LocalDate.now();
			LocalDate rentdate = sysdate;
			LocalDate turndate = sysdate.plusWeeks(1);
			
			try
			{
				bCount--;
				
				if(bCount < 0)
				{
					System.out.println("[" + bName + 
							"] 책이 현재 없습니다.");
					break;
				}
				
				
				int cnl = countNumRental();
				
				String query3 = "insert into RENTDB values"
						+ "(?,?,?,?,?,"
						+ "to_date(?,'yyyy/mm/dd'),to_date(?,'yyyy/mm/dd'), ?)";
				// to_date로 변환해주지 않으면 대입이 안됨 이유는 모름
				pstmtBR = con.prepareStatement(query3);

				pstmtBR.setInt(1,cnl);
				pstmtBR.setString(2,UID);
				pstmtBR.setString(3,UNAME);
				pstmtBR.setInt(4,bNum);
				pstmtBR.setString(5,bName);
				pstmtBR.setDate(6,java.sql.Date.valueOf(rentdate));
				pstmtBR.setDate(7,java.sql.Date.valueOf(turndate));
				pstmtBR.setInt(8,0);
				
				System.out.println("[" + bName + "] 책을 대여하셨습니다.");
				System.out.println("반납기한은 " + turndate +"까지이며");
				System.out.println("1주일 연장가능합니다.");
				
				String query4 = "update JAVABOOK set BCOUNT = ? "
						+ "where BNAME = ?";
				
				pstmtUPDATE = con.prepareStatement(query4);
				pstmtUPDATE.setInt(1, bCount);
				pstmtUPDATE.setString(2, bName);
				pstmtUPDATE.executeUpdate();
				
				pstmtBR.executeUpdate();
				con.commit();

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		if(fcnt == 0)
		{
			System.out.println("해당 책을 보유하고 있지 않습니다.");
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	BC++;
	updateBC();
}

PreparedStatement pstmtRL = null;
public void rentalList()
{
	try
	{
		String query = "select * from JAVABOOK where BCOUNT != 0 "
						+ "order by BNUM";
		pstmtRL = con.prepareStatement(query);
		rs = pstmtRL.executeQuery();
		
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
}

PreparedStatement pstmtWD = null;
PreparedStatement pstmtWDC = null;
public void withdrawal()
{
	System.out.println("정말로 탈퇴하시겠습니까? y/n");
	String useQ = scanner.next();
	
	if(useQ.equals("y") || useQ.equals("Y"))
	{
		scanner = new Scanner(System.in);
		
		try
		{
			String query = "select * from RENTDB where R_CID = ?";
			pstmtWDC = con.prepareStatement(query);
			pstmtWDC.setString(1, UID);
			rs = pstmtWDC.executeQuery();
			int fcnt = 0;
			
			while(rs.next())
			{
				fcnt++;
			}
			if(fcnt == 0)
			{
				System.out.println("비밀번호를 입력해주세요.");
				System.out.print("PW : ");
				String pw = scanner.next();
				
				if(pw.equals(UPW))
				{
					try
					{
						String query2 = "delete from CLIENTDB " +
										"where CID = ?";
						
						pstmtWD = con.prepareStatement(query2);
						pstmtWD.setString(1, UID);
						
						int updateCount = pstmtWD.executeUpdate();
						
						if(updateCount > 0)
						{
							wdOut++;
							con.commit();
							System.out.println("회원 탈퇴되었습니다.");
						}
						else
						{
							con.rollback();
							System.out.println("비밀번호를 제대로 입력해주세요.");
						}
					}
					catch (SQLException sqle) 
					{
	//					sqle.printStackTrace();
						System.out.println("데이터 입력에 실패했습니다.");
					}
				}
				else
				{
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}
			else
			{
				System.out.println("책 반납 후 탈퇴 가능합니다.");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("오류");
		}
			
	}
	else if(useQ.equals("n") || useQ.equals("N"))
	{
		System.out.println("전 메뉴창으로 돌아갑니다.");
		return;	
	}
	else
	{
		System.out.println("y 또는 n 으로만 답해주세요.");
		scanner = new Scanner(System.in);
	}
}

//////////////////////////////////////////////////////////////////////////////
//책

	public void bookSelect() // 책 선택
	{
		
		while(true)
		{
			try
			{
				showBookMenu();	// 메뉴
				
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
					case 5:	// 돌아가기
					{
						return;
					}
					case 6:	// 종료
					{
						disconnectDB();
						System.out.println("종료");
						System.exit(0);
					}
					default:
					{
						System.out.println("올바르지 않은 메뉴선택입니다.");
						break;
					}
				}
			}
			catch (InputMismatchException ime)
			{
				scanner = new Scanner(System.in); // 스캐너 버그 해결
//				ime.printStackTrace();
				System.out.println("올바르지 않은 메뉴선택입니다.");
			}
		}
	}
	
	public void showBookMenu() // 책 메뉴
	{
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 책 등록");
		System.out.println("2. 책 조회");
		System.out.println("3. 전체 리스트 조회");
		System.out.println("4. 책 제거");
		System.out.println("5. 돌아가기");
		System.out.println("6. 종료");
		System.out.println("================");
		System.out.print("> ");
	}

	PreparedStatement pstmtSB = null;
	PreparedStatement pstmtUB = null;
	public void saveBook() // 책 등록
	{
		if(adminCheck == 0)
		{
			System.out.println("관리자만 가능합니다.");
			return;
		}
		
			
			System.out.println("책 이름 입력 : ");
			String bName = scanner.next();
		
		while(true)
		{
			try
			{
					System.out.println("책 권수 입력 : ");
					int bCount = scanner.nextInt();
					
				try
				{
					int bNum = countNumBook();
					
					String query ="insert into JAVABOOK " +
									"values(?, ?, ?)";
				
					pstmtSB = con.prepareStatement(query);
					pstmtSB.setInt(1, bNum);
					pstmtSB.setString(2, bName);
					pstmtSB.setInt(3, bCount);
					int updateCount = pstmtSB.executeUpdate();
					
					if(updateCount > 0)
					{
						con.commit();
						System.out.println("데이터가 정상적으로 저장되었습니다.");
						break;
					}
					else
					{
						con.rollback();
						System.out.println("데이터 입력에 실패했습니다.");
					}

				}
				
				catch(SQLIntegrityConstraintViolationException sqlce) // 책 제목이 같아 무결성 오류가 발생하면 실행
				{
					try
					{
						String query2 = "update JAVABOOK set BCOUNT = BCOUNT + ? "
								+ "where BNAME = ?";
						
						pstmtUB = con.prepareStatement(query2);
						pstmtUB.setInt(1, bCount);
						pstmtUB.setString(2, bName);
						
						pstmtUB.executeUpdate();
						con.commit();
						
						System.out.println("[" + bName + "] 책을 " + bCount +
								"권 추가했습니다.");
						break;
					}
					catch (SQLException sqle)
					{
						sqle.printStackTrace();
					}
				}
				catch (SQLException sqle) 
				{
					sqle.printStackTrace();
					System.out.println("데이터 입력에 실패했습니다.");
				}
			}
			catch (InputMismatchException ime)
			{
				scanner = new Scanner(System.in); // 스캐너 버그 해결
				System.out.println("숫자를 입력해주세요.");
//				ime.printStackTrace();
			}
		}
	}
	
	
	

	PreparedStatement pstmtR = null;
	public void readBook() // 전체 조회
	{
		try
		{
			String query = "select * from JAVABOOK order by BNUM";
			pstmtR = con.prepareStatement(query);
			rs = pstmtR.executeQuery();
			
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
//			sqle.printStackTrace();
		}
	}
	
	public void findBook()	// 조회
	{
		try
		{
			while(true)
			{
				System.out.println("====== 메뉴 ======");
				System.out.println("1. 책 번호로 조회");
				System.out.println("2. 책 제목으로 조회");
				System.out.println("3. 돌아가기");
				System.out.println("==================");
				System.out.print("> ");
				int readSelect = scanner.nextInt();
				
				switch (readSelect)
				{
					case 1:
					{
						findBookNum();
						break;
					}
					case 2:
					{	
						findBookName();
						break;
					}
					case 3:
					{
						return;
					}
					default:
						System.out.println("올바르지 않은 메뉴선택입니다.");
						break;
				}
			}
		}
		catch (InputMismatchException ime)
		{
			scanner = new Scanner(System.in);
			System.out.println("올바르지 않은 메뉴선택입니다.");
//			ime.printStackTrace();
		}
	}
	
	PreparedStatement pstmtFNUM = null;
	public void findBookNum() // 조회 - 책 번호
	{
		try
		{
			System.out.println("책 번호를 입력하세요");
			System.out.print("> ");
			int bNum = scanner.nextInt();
			
			try
			{
				String query = "select * from JAVABOOK " +
								"where BNUM = ?";
				pstmtFNUM = con.prepareStatement(query);
				pstmtFNUM.setInt(1, bNum);
				rs = pstmtFNUM.executeQuery();
				int fcnt = 0;
				while(rs.next())
				{
					fcnt++;
					System.out.println("----------------------------------------");
					System.out.println("책 번호 : " + rs.getString("BNUM") +"번");
					System.out.println("책 제목 : " + rs.getString("BNAME"));
					System.out.println("책 수량 : " + rs.getInt("BCOUNT") +"권");
					System.out.println("----------------------------------------");
				}
				
				if(fcnt == 0)
				{
					System.out.println("조회 결과가 없습니다.");
				}
			}
			catch (SQLException sqle)
			{
//			sqle.printStackTrace();
			}
		}
		catch(InputMismatchException ime)
		{
			scanner = new Scanner(System.in);
			System.out.println("숫자를 입력해주세요.");
//			ime.printStackTrace();
		}
	}
	
	PreparedStatement pstmtFNAME = null;
	public void findBookName() // 조회 - 책 제목
	{
		try
		{
			System.out.println("책 제목을 입력하세요");
			System.out.print("> ");
			String bName = scanner.next();
			
			String query = "select * from JAVABOOK " +
							"where BNAME = ?";
			pstmtFNAME = con.prepareStatement(query);
			pstmtFNAME.setString(1, bName);
			rs = pstmtFNAME.executeQuery();
			int fcnt = 0;
			
			while(rs.next())
			{
				fcnt++;
				System.out.println("----------------------------------------");
				System.out.println("책 번호 : " + rs.getString("BNUM") +"번");
				System.out.println("책 제목 : " + rs.getString("BNAME"));
				System.out.println("책 수량 : " + rs.getInt("BCOUNT") +"권");
				System.out.println("----------------------------------------");
			}
			
			if(fcnt == 0)
			{
				System.out.println("----------------------------------------");
				System.out.println("조회 결과가 없습니다.");
				System.out.println("----------------------------------------");
			}
			
		}
		catch (SQLException sqle)
		{
//			sqle.printStackTrace();
		}
	}
	
	public void deleteBook()
	{
		if(adminCheck == 0)
		{
			System.out.println("관리자만 가능합니다.");
			return;
		}
		
		while(true)
		{
			try
			{
				System.out.println("====== 메뉴 ======");
				System.out.println("1. 책 번호로 제거");
				System.out.println("2. 책 제목으로 제거");
				System.out.println("3. 돌아가기");
				System.out.println("4. 종료");
				System.out.println("==================");
				System.out.print("> ");
				int readSelect = scanner.nextInt();
				
				switch (readSelect)
				{
					case 1:
					{
						deleteBookNum();
						break;
					}
					case 2:
					{	
						deleteBookName();
						break;
					}
					case 3:
					{
						System.out.println("전 메뉴창으로 돌아갑니다.");
						return;
					}
					case 4:
					{
						disconnectDB();
						System.out.println("종료합니다.");
						System.exit(0);
					}
					default:
					{
						System.out.println("올바르지 않은 메뉴선택입니다.");
					}
				}
			}
			catch (InputMismatchException ime)
			{
				scanner = new Scanner(System.in);
				System.out.println("올바르지 않은 메뉴선택입니다.");
//				ime.printStackTrace();
			}
		}
	}
	
	PreparedStatement pstmtDNUM = null;
	public void deleteBookNum() // 책 번호로 제거
	{
		try
		{
			System.out.println("버릴 책 번호를 입력하세요.");
			System.out.print("> ");
			int bNum = scanner.nextInt();
	
			try
			{
				String query = "delete from JAVABOOK " +
								"where BNUM = ?";
				
				pstmtDNUM = con.prepareStatement(query);
				pstmtDNUM.setInt(1, bNum);
				int updateCount = pstmtDNUM.executeUpdate();
				
				if(updateCount > 0)
				{
					con.commit();
					System.out.println("[" + bNum + "]번 책을 성공적으로 제거했습니다.");
				}
				else
				{
					con.rollback();
					System.out.println("[" + bNum + "]번 책이 없습니다.");
				}
			}
			catch (SQLException sqle) 
			{
//				sqle.printStackTrace();
				System.out.println("입력오류");
			}
		}
		catch (InputMismatchException ime)
		{
			scanner = new Scanner(System.in);
			System.out.println("숫자를 입력해주세요.");
//			ime.printStackTrace();
		}
	}
	
	PreparedStatement pstmtDNAME = null;
	public void deleteBookName() // 책 이름으로 제거
	{
		
		System.out.println("버리실 책 제목을 입력하세요.");
		System.out.print("> ");
		String bName = scanner.next();

		try
		{
			String query = "delete from JAVABOOK " +
							"where BNAME = ?";
			
			pstmtDNAME = con.prepareStatement(query);
			pstmtDNAME.setString(1, bName);
			int updateCount = pstmtDNAME.executeUpdate();
			
			if(updateCount > 0)
			{
				con.commit();
				System.out.println("[" + bName + "]을 성공적으로 제거했습니다.");
			}
			else
			{
				con.rollback();
				System.out.println("[" + bName + "] 책이 없습니다.");
			}
		}
		catch (SQLException sqle) 
		{
//			sqle.printStackTrace();
			System.out.println("입력오류");
		}
	}
}





