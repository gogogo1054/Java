import java.sql.*;

public class TransactionEx
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
		Statement stmt = null;
		boolean success = false;
		
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"TIGER");
			stmt = con.createStatement();
			
			con.setAutoCommit(false);
			
//----------------------------------------------------------------------------
			String sql = "insert into test3 values('홍길동2', '1111')";
			stmt.executeUpdate(sql);
			System.out.println("11111");
			
			sql = "insert into test3 values('전우치2', '2222')";
			stmt.executeUpdate(sql);
			System.out.println("22222");
			
			sql = "insert into test3 values('손오공2', '3333')";
			stmt.executeUpdate(sql);
			System.out.println("33333");
			
			success = true;
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			try
			{
				if(success)
				{
					System.out.println("44444");
					con.commit();
				}
				else
				{
					System.out.println("55555");
					con.rollback();
				}
				
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			}
			catch (SQLException sqle) {}
		}
	}
}
