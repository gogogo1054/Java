package step2;

public class BookInfo
{
	String bookName = "";
	int bookCount = 0;
	
	public BookInfo() {}
	
	public BookInfo(String bookName, int bookCount) // 여러권
	{
		this.bookName = bookName;
		this.bookCount = bookCount;
	}
	
	@Override
	public String toString()
	{
		return (bookName + " " + bookCount + "권");
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
