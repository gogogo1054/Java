import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex13_ObjectOutputStream
{

	public static void main(String[] args)
	{
		// 앞에서 만든 클래스로 객체 생성
		Ex12_Unit unit1 = new Ex12_Unit("Marine");
		Ex12_Unit unit2 = new Ex12_Unit("Medic");
		
		// 인스턴스를 파일에 저장하기 위해 출력스트림을 생성한다.
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream("Object.bin")))
		{
			// 파일에 저장
			oos.writeObject(unit1);
			oos.writeObject(unit2);
			
		}    // 자동으로 파일이 닫힘. close; 가 됨
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
