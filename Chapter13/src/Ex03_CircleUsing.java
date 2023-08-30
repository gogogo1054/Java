/*
	하나의 클래스안에서 패키지는 다르나 같은 이름의 클래스를 
	사용해야한다면..
	방법1 : 클래스명 앞에 풀 패키지 경로를 기술한다. 
	방법2 : 하나의 클래스는 import하고, 다른 하나는 풀 패키지
		경로를 기술한다. 
*/
//import com.company.area.*;
public class Ex03_CircleUsing
{
    public static void main(String[] args)
    {
    	/*
		원의넓이계산 : 객체 생성을 위해 클래스의 풀
		패키지 경로를 명시하여 기술한다. 
		 */
        com.company.area.Circle c1 = new com.company.area.Circle(3.5);
//        Circle c1 = new com.company.area.Circle(3.5);
        System.out.println("반지름 3.5 원 넓이: " + c1.getArea());
        
        /*
		원의둘계산 : 객체 생성을 위해 클래스의 풀
		패키지 경로를 명시하여 기술한다. 
		 */
        com.company.circumference.Circle c2 = new com.company.circumference.Circle(3.5);
        System.out.println("반지름 3.5 원 둘레: " + c2.getCircumference());
    }
}
