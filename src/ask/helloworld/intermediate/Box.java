package ask.helloworld.intermediate;


// Need to cast as object type

//public class Box 
//{
//	private Object obj;
//	
//	public void setObj(Object obj)
//	{
//		this.obj = obj;
//	}
//	
//	public Object getObj()
//	{
//		return obj;
//	}
//	
//}

// Generic

// Generic을 사용함으로써 선언할때는 가상의 타입으로 선언하고, 
// 사용시에는 구체적인 타입을 설정함으로써 다양한 타입의 클래스를 이용
// Generic을 사용 --> 컬렉션 프레임워크

public class Box<E> 
{
	private E obj;
	
	public void setObj(E obj)
	{
		this.obj = obj;
	}
	
	public E getObj()
	{
		return obj;
	}
	
}