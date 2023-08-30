/*
인터페이스(interface)
	- 클래스가 객체의 설계도라면 인터페이스는 클래스의 설계도라 할수 
		있다.
	- 자바는 단일 상속을 원칙으로 하지만 인터페이스를 통해 다중상속을
		구현할수 있다.
	- 추상클래스와 동일하게 상속을 목적으로 제작되므로 구현받은 하위
		클래스에서는 반드시 추상메서드를 오버라이딩 해야 한다.
	- 멤버로는 추상메서드와 상수로만 구성되다.
		메서드 : public abstract
		상수 : public static final
	- 인터페이스는 생성자를 사용할 수 없다.
 */
interface Greet
{
    void greet();
}

interface Talk
{
    void talk();
}

/*
인터페이스는 콤마를 이용해서 여러개를 동시에 "구현"할 수 있다.
 */
class Morning implements Greet, Talk
{
    public void greet()
    {
        System.out.println("안녕하세요!");
    }
    
    public void talk()
    {
        System.out.println("날씨 좋네요.");
    }
}

public class Ex01_Mee
{
    public static void main(String[] args)
    {
    	// Morning의 부모는 모두 2개이므로 아래는 모두 참조가 가능하다.
        Morning morning = new Morning();
        morning.greet();
        morning.talk();
    }
}
