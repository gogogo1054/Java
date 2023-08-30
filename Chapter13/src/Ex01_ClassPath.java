public class Ex01_ClassPath
{
    public static void main(String[] args)
    {
    	/*
		Apple 클래스를 통해 객체(인스턴스)를 생성한다. 생성시 할당된
		주소값을 반환하고, 좌측항의 참조변수가 그 값을 할당받게된다.
		 */
        Apple apple = new Apple();
        //객체의 참조변수를 통해 멤버메서드를 호출할 수 있다.
        apple.showName();
    }
}
