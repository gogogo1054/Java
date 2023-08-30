/*
다형성(Polymorphism)
	: 하나의 객체를 여러 타입의 참조변수를 통해 참조할 때 참조변수의
	타입에 따라 다양한 객체를 이용할 수 있는 특성을	말한다. 
	단 객체간에는 상속관계가 있어야 한다.
	
- 부모타입의 참조변수로 자식객체를 참조
	1. 이경우 부모타입의 참조변수는 부모로부터 상속받은 멤버까지만 접근할
	수 있다.
	2. 자식에서 오버라이딩한 메서드가 우선적으로 호출된다.
	3. 자식에서 새롭게 정의한 멤버는 접근할 수 없다.
	4. 이런 형태를 이질화(Heterogeneous : 헤태로지니어스)라고 한다.
	
- 같은 타입의 참조변수로 객체를 참조
	1. 객체 전체를 접근할 수 있다. 즉 클래스의 일반적인 규칙을 따른다.
	2. 이런 형태를 동질화(Homogeneous : 호모지니어스)라고 한다.
 */
abstract class Calc
{
    int a = 5;
    int b = 6;
    
    abstract void Plus();
}

class MyCalc extends Calc
{
	// 부모에서 정의한 메서드를 오버라이딩해서 재정의한 멤버메서드
    void Plus()  {System.out.println(a + b);}
    
    void Minus() {System.out.println(a - b);}
}

public class Ex01_Polymorphism1
{
    public static void main(String[] args)
    {
    	// 동질화 : 자신의 참조변수로 자신의 객체를 참조한다.
        MyCalc myCalc1 = new MyCalc();
        
        // 동질화의 경우 객체 전체를 접근할 수 있다.
        myCalc1.Plus();
        myCalc1.Minus();
        
        /*
		이질화 : 부모타입의 변수로 자식객체를 참조하는 것을 말한다.
			이경우 자식에서 새롭게 정의한 멤버에는 접근할 수 없다.
			만약 접근해야 한다면 자식타입으로 강제형변환(다운캐스팅)
			해야한다.
		 */
        // 하위클래스 객체를 상위 클래스 객체에 대입
        Calc myCalc2 = new MyCalc();
        myCalc2.Plus();
        
        // 부모타입의 참조변수로 자식객체에 접근할 수 없으므로 에러발생.
        // 다음 메서드는 설계도에 없다. 사용할 수 없다.
        //myCalc2.Minus();
        
        /*
		부모로 자식에 접근하려면 강제형변환 해야한다.
		소괄호를 하나 더 추가해서 myCalc2를 자식타입으로 형변환 후
		멤버변수에 접근해야 한다.
		 */
        ((MyCalc)myCalc2).Minus();
    }
}