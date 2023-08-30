/*
직렬화
: Ex12_Unit클래스를 입출력의 대상으로 파일로 저장하기 위해 Serializable
인터페이스를 구현하여 정의한다. 인스턴스가 파일의 형태로 저장되는것을
"직렬화"라고 한다. 만약 상속이 되는 경우라면 부모쪽만 implements 하면된다.
 */
// 객체를 저장하는 클래스
public class Ex12_Unit implements java.io.Serializable // 직렬화 할 수 있다는 표시
{
	// 안 넣어도 되지만 되도록이면 넣을 것
	private static final long serialVersionUID = 1L;  
	private String name;
	// 생성자 
	public Ex12_Unit(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
