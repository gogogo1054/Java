package step4;

public class BookInfo
{
	int bookNum = 0;
	String bookName = "";
	int bookCount = 0;
	
	public BookInfo() {}
	
	public BookInfo(int bookNum, String bookName, int bookCount)
	{
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookCount = bookCount;
	}

	public int getBookNum()
	{
		return bookNum;
	}

	public void setBookNum(int bookNum)
	{
		this.bookNum = bookNum;
	}

	public String getBookName()
	{
		return bookName;
	}

	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}

	public int getBookCount()
	{
		return bookCount;
	}

	public void setBookCount(int bookCount)
	{
		this.bookCount = bookCount;
	}
}
