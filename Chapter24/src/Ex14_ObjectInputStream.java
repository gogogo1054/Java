import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex14_ObjectInputStream
{
	public static void main(String[] args)
	{
		/*
		인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고 readObject()를
		통해 복원한다. 
		 */
		try (ObjectInputStream ois =
				new ObjectInputStream(new FileInputStream("Object.bin")))
		{
			/*
			저장시 Object기반으로 저장되므로 복원할때는 원래의 자료형으로
			형변환(다운캐스팅) 해야 한다. 
			 */
			Ex12_Unit unit1 = (Ex12_Unit) ois.readObject();
			// 객체의 메서드 호출
			System.out.println(unit1.getName());
			
			Ex12_Unit unit2 = (Ex12_Unit) ois.readObject();
			System.out.println(unit2.getName());
		}
		catch(ClassNotFoundException e)  // input 일때 에러가 나지 않게 하기위해 넣어줌
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
