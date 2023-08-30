public class Ex02_PackageUse
{
    public static void main(String[] args)
    {
        Apple apple = new Apple();
        apple.showName();
        
        /*
		default 하위에 com.study 패키지가 생성되지만
		이 둘은 서로 다른 패키지로 인식한다. 
		따라서 Banana() 메서드를 호출하기 위해서는 반드시
		패키지의 풀경로를 이용해서 객체를 생성한다.
		 */
        //Banana banana = new Banana();   <= 실행 안됨
        com.study.Banana banana = new com.study.Banana();  
        //반드시 경로도 같이 입력 해야함.
        banana.showName();
    }
}
