package step07;

public class PhoneInfo implements java.io.Serializable 
// implements java.io.Serializable 저장을 위해 입력 해야함 없으면 save 안됨 
{
	String name;
	String phoneNumber;
	String email;
	
	public PhoneInfo(String name, String phoneNumber)
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
