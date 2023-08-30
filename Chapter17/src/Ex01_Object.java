/*
Object클래스
-자바에서의 최상위 클래스이다. 
-별도의 선언없이 Object클래스에 정의된 모든 메서드를 사용할 수 있다. 
-개발자가 정의한 모든 클래스는 Object의 참조변수로 참조할수 있다. 
ex) Object obj = new Person()
	또는
	void simpleFunc(Object obj){}
 */
public class Ex01_Object extends Object  // extends Object가 생략된 것 임.
{
	String name;
	String getName()
	{
		return name;
		
	}
}
