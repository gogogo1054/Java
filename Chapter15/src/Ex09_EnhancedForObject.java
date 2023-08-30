class House
{
	private int houseNum;
	private String name;
	
	House(int houseNum, String name)
	{
		this.houseNum = houseNum;
		this.name = name;
	}
	
	public int getHouseNum()
	{
		return houseNum;
	}
	
	public String getName()
	{
		return name;
	}
}

// 객페 자료형을 가진 배열도 사용 할수 있음.
public class Ex09_EnhancedForObject
{
	public static void main(String[] args)
	{
		House[] arr = new House[5];
		
		arr[0] = new House(101, "홍길동");
		arr[1] = new House(102, "전우치");
		arr[2] = new House(103, "손오공");
		arr[3] = new House(104, "해리포터");
		arr[4] = new House(105, "멀린");
		
		for(House e: arr)
		{
			// getter 메소드로 객체의 멤버변수의 값을 비교
			if(e.getHouseNum() == 102)
				System.out.println(e.getName());
		}
	}
}