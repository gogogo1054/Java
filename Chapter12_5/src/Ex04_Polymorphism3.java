abstract class Animal
{
    abstract void doMove();
}

class Tiger extends Animal
{
    void doMove()
    {
        System.out.println("호랑이는 산을 달립니다.");
    }
}

class Lion extends Animal
{
    void doMove()
    {
        System.out.println("사자는 평원을 달립니다.");
    }
}

public class Ex04_Polymorphism3
{
    public static void animalChoose(Animal obj)
    {
    	/*
    	- 여기서 instanceof 연산자를 통해 형변환 가능여부를 판단하는 이유는
    	전달된 인수를 최상위 클래스인 Animal 타입으로 받고있기 때문이다.
    	- Animal 타입으로 인수를 받게되면 자동으로 형변환(업캐스팅)되므로
    	자식객체의 멤버메서드는 호출할 수 없게된다.
    	- 이때 자식의 멤버메서드를 호출하기 위해 강제형변환(다운캐스팅)이
    	필요하다.
    	- 따라서 전달된 인수의 각각의 타입으로 형변환이 가능한지 판단한 후
    	다운캐스팅을 진행하고 각 클래스의 멤버메서드를 호출할 수 있게된다.
    	 */
        if (obj instanceof Tiger)
        {
            Tiger tiger = (Tiger)obj;
            tiger.doMove();
        } else
        {
            Lion lion = (Lion)obj;
            lion.doMove();
        }
    }
    
    public static void main(String[] args)
    {
        Tiger tiger = new Tiger();
        animalChoose(tiger);
        
        Lion lion = new Lion();
        animalChoose(lion);
    }
}