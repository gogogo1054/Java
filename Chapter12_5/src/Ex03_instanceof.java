/*
instanceof 연산자
	: 인스턴스 연산자가 어떤 타입의 변수인지를 판단하는 연산자로 형변환
	(즉 상속관계가 있으면)이 가능하면 true를 아니면 false를 반환한다.
	- 객체간에 형변환이 되려면 반드시 구 클래스간에 상속관계가 있어야
	한다.
	- 부모타입의 참조변수로 자식 객채를 참조할 수 있으므로 매개변수를
	부모타입으로 만들면 하위의 자식 객체를 인수로 받을 수 있다.
	- 매개변수로 전달되는 인수는 부모타입으로 자동형변환 되므로
	사용을 위해 기존에 어떤 타입이었는지 확인할때 사용한다.
 */

interface Cry
{
    void cry();
}

class Cat implements Cry
{
    public void cry()
    {
        System.out.println("야옹~");
    }
}

class Dog implements Cry
{
    public void cry()
    {
        System.out.println("멍멍!");
    }
}

public class Ex03_instanceof
{
    public static void main(String[] args)
    {
    	// 부모 참조변수로 자식객체를 참조한 변수 생성. 다형성을 이용한 코드 작성.
        Cry test1 = new Cat();
//        Cry test1 = new Dog();
        
        // 참조값이 어떤 객체를 가리키는지 조사하여 그에 따른 코드를 진행한다.
        // instanceof 는 결국 다형성을 잘 사용하려고 사용하는 연산자이다.
        if (test1 instanceof Cat)
        {
            test1.cry();
        }
        else if (test1 instanceof Dog)
        {
            System.out.println("고양이가 아닙니다.");
        }
    }
}