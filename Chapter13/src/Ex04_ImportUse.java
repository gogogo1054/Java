/*
임포트 선언부 : 현재 작성중인 클래스에서 다른 패키지에 있는 클래스를
	가져다 쓰기위한 선언으로, 사용할 클래스의 위치를 지정하는것으로
	생각하면 된다. 
	패키지명과 클래스명을 함께 기술한다. 
	만약 해당 패키지 하위에 선언된 모든 클래스를 한꺼번에 임포트하고
	싶다면
	import java.util.*; 와 같이 선언하면 된다. 
 */
import com.study.Banana;

public class Ex04_ImportUse
{
    public static void main(String[] args)
    {
        Banana banana = new Banana();
        banana.showName();
    }
}