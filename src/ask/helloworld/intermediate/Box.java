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

// Generic�� ��������ν� �����Ҷ��� ������ Ÿ������ �����ϰ�, 
// ���ÿ��� ��ü���� Ÿ���� ���������ν� �پ��� Ÿ���� Ŭ������ �̿�
// Generic�� ��� --> �÷��� �����ӿ�ũ

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