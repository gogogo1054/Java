class Camp8<T extends Number>    
// 특정 타입의 인자를 입력 할때 extends Number <= 숫자 타입을 입력할때
{
	private T ob;
	
	public void set(T o)
	{
		ob = o;
	}
	
	public T get()
	{
		return ob;  // extends Number 안 사용하면 여기서 에러가 남
	}
}

public class Ex08_BoundedCamp
{
	public static void main(String[] args)
	{
		Camp8<Integer> iBox = new Camp8<>();
		iBox.set(24);;
		
		Camp8<Double> dBox = new Camp8<>();
		dBox.set(5.97);;
		
		System.out.println(iBox.get());
		System.out.println(dBox.get());
	}
}
