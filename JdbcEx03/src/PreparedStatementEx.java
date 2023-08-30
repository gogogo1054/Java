import java.sql.*;


public class PreparedStatementEx
{
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
	
	
	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"TIGER");
			String sql = "create table test2(id varchar2(10)," +
						 " password varchar2(10)) ";
			
			pstmt1 = con.prepareStatement(sql);
			int updateCount = pstmt1.executeUpdate();
			System.out.println("createCount : " + updateCount);
			
//----------------------------------------------------------------------------
			sql = "insert into test2 values(?, ?)";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, "홍길동");
			pstmt2.setString(2, "1111");
			updateCount = pstmt2.executeUpdate();
			System.out.println("insertCount : " + updateCount);
			
//----------------------------------------------------------------------------
			sql = "select * from test2";
			pstmt3 = con.prepareStatement(sql);
			rs = pstmt3.executeQuery();
			while(rs.next())
			{
				System.out.print("id : " + rs.getString(1));
				System.out.println(", password : " + rs.getString(2));
			}
			
//----------------------------------------------------------------------------
			sql = "drop table test2";
			pstmt4 = con.prepareStatement(sql);
			updateCount = pstmt4.executeUpdate();
			System.out.println("dropCount : " + updateCount);
		}
		catch ( SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			try 
			{
			if (rs != null) rs.close();
			if (pstmt1 != null) pstmt1.close();
			if (pstmt2 != null) pstmt2.close();
			if (pstmt3 != null) pstmt3.close();
			if (pstmt4 != null) pstmt4.close();
			if (con != null) con.close();
			}
			catch (SQLException sqle)
			{
			}
		}
	}
}
