package step01;

public class PhoneInfo   // 1.PhoneInfo 클래스 만들기
{
	String name;
	String phoneNumber;
	String email;
	
	public PhoneInfo(String name, String phoneNumber)  // 함수의 오버로딩
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneInfo(String name, String phoneNumber, String email)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void showPhoneInfo()
	{
		System.out.println("Namw : " + name);
		System.out.println("PhoneNumber : " + phoneNumber);
		if (email != null && !email.equals(""))
			System.out.println("Email : " + email);
		System.out.println("------------------------");
	}
}
