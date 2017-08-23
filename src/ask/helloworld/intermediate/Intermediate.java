package ask.helloworld.intermediate;



import java.lang.reflect.Method;

//java.lang��Ű���� Ŭ������ import�� ���� �ʰ� ����� �� �ִ�.
//java.lang��Ű������ �⺻��Ÿ���� ��ü�� ��ȯ��ų�� ����ϴ� WrapperŬ������ �ִ�.
//Boolean, Byte, Short, Integer, Long, Float, Double Ŭ����
//��� Ŭ������ �ֻ��� Ŭ������ Object�� java.lang��Ű��
//���ڿ��� ���õ� String, StringBuffer, StringBuilder�� ��� java.lang��Ű��
//ȭ�鿡 ���� ����Ҷ� ����ߴ� SystemŬ������ java.lang��Ű��
//���а� ���õ� MathŬ������ java.lang��Ű��
//Thread�� ���õ� �߿� Ŭ�������� java.lang��Ű��

//����ڽ�(Auto Boxing)
//Integer i3 = 5; 
//���� 5�� ���� �⺻�������� �ڵ����� Integer���·� ��ȯ�ȴ�.
//���� ��ڽ�(Auto unboxing)
//int i5 = i2; 
//Integer��üŸ���� ���� �⺻�� int�� �ڵ����� ��ȯ�Ǿ� ���� �Ҵ��Ѵ�.




import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//DateŬ������ ����ȭ�� �������� �ʴ´�.(deprecated) 
//����ȭ�� �������� ���� ��¥�� �ð��� �ٸ� �� �ִµ�, �� �κ��� �������� ���Ѵ�.
//�̷� ������ �ذ��ϱ� ���Ͽ� ���� Ŭ������ CalendarŬ����. CalendarŬ������ �ڹ� 1.1�� �����Ͽ���.

//����ȭ�� ���õ� Ŭ�������� Locale�� ���۵Ǵ� �̸��� ���� Ŭ�������Դϴ�. ���� 1.1 ���Ŀ� �����Ѵ�.


/**
 * 
 * 
 * List, Set, Collection, Map�� DS == Collection Framework�� ���õ� �������̽�
 * 
 * <interface> Collection
 * �ߺ��� ����ϰ�, �ڷᰡ ����� ������ ������� ���ϴ� ���� Collection�������̽�
 * add(Object) : boolean
 * iterator() : interator  // �ܼ� get
 *             --> hasNext() : boolean, next(): object
 * size() : int
 * 
 * <interface> List 
 * // �����ְ�, �ߺ� ���
 * get(int) : Object
 * 
 * <interface> Set  <----------------------  <interface> Map  // ���� ����, �ߺ� �����
 * add(Object) : boolean <----------------  get(Obejct), keySet(), put(Obj, Obj)
 *
 *
 */



public class Intermediate 
{
	public static void main(String[] args)
	{
		// StringBuffer vs. String : changeable(delete ����) vs. non-editable(substring-> copy�ؾ�)  

		System.out.println("=======StringBuffer========");		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("sb_test1").append(" sb_test2"); // method chaining(�޼ҵ� ü�̴�) // sb�� �����
		
		String strn = sb.toString();
		//strn = strn.substring(3, 5); // strn �� ���� �ȵ�
		
		System.out.println(strn);
		
		
		// flexible memory use -> if needed, copy vs. O(xn^2) 
		
		// (1) String�� +������ �̿��ؼ� 10,000���� *�� �̾���Դϴ�.
		//���۽ð��� ����մϴ�.(millisecond����)
		long startTime1 = System.currentTimeMillis();
		String str1="";
		for(int i=0;i<10000;i++){
		        str1=str1+"*";
		}
		//����ð��� ����մϴ�.(millisecond����)
		long endTime1 = System.currentTimeMillis();
		
		// (2) StringBuffer�� �̿��ؼ� 10,000���� *�� �̾���Դϴ�.
		//���۽ð��� ����մϴ�.(millisecond����)                
		long startTime2 = System.currentTimeMillis();
		StringBuffer sb1 = new StringBuffer();
		for(int i=0;i<10000;i++){
		        sb1.append("*");
		}
		//����ð��� ����մϴ�.(millisecond����)
		long endTime2 = System.currentTimeMillis();
		
		// ���(1)�� ���(2)�� �ɸ� �ð��� ���մϴ�.
		long duration1 = endTime1-startTime1;
		long duration2 = endTime2-startTime2;
		
		System.out.println("String�� +������ �̿��� ��� : "+ duration1);
		System.out.println("StringBuffer�� append()�� �̿��� ��� : "+ duration2);		
		
		
		
		
		// Object
		
//		Box box = new Box();
//		box.setObj(new Object());
//		
//		Object obj = box.getObj();
//		
//		box.setObj("hello");
//		String str = (String)box.getObj();
//		System.out.println(str);
	
		// Generic : all types
		Box<Object> box = new Box<>();
		box.setObj(new Object());
		Object obj = box.getObj();
		
		
		// Generic : string
		System.out.println("=======Generic========");
		Box<String> boxString = new Box<>();  // no casting 
		boxString.setObj("hello");
		String str = boxString.getObj();
		System.out.println(str);
		
		Box<Integer> boxInt = new Box<>();  // no casting 
		boxInt.setObj(123);
		System.out.println(boxInt.getObj());

		
		
		// HashSet : value
		System.out.println("=======HashSet========");
		// hashset of set
		Set<String> set1 = new HashSet<>();
		
		System.out.println(set1.add("ASK"));
		System.out.println(set1.add("KIM"));
		System.out.println(set1.add("ASK"));
		System.out.println(set1.size());
		
		
		Iterator<String> iter = set1.iterator();
		
		
		while(iter.hasNext()) // boolean(idx X)
		{
			System.out.println(iter.next());  // string value
		}
		
		
		// List(dynamic size, dup & order) vs. Array(fixed size)
		System.out.println("=======ArrayList========");
		// arraylist of list 
		List<String> list = new ArrayList<>(); 
		
	          list.add("kim");
	          list.add("lee");
	          list.add("kim");
	           
	          for(int i = 0; i < list.size(); i++)
	          {
	               System.out.println(list.get(i));
	          }		
		
	
		// HashMap : key, value
		System.out.println("=======HashMap========");
		// hashmap of map	          
	          
		Map<Integer, String> map = new HashMap<>();  
		// int vs. Integer : primitive type vs wrapper class(use addr pntr) ->  equals() or casting
		//http://marobiana.tistory.com/130
		
	          map.put(001, "AYE");
	          map.put(002, "ASK");
	          map.put(003, "LSH");
	          map.put(002, "AAA");  // overwrite
	          
	          // map�� ����� ��� key���� Set�ڷᱸ���� �����ϴ�.
	          Set<Integer> keys = map.keySet();
	            
	          // Set�ڷᱸ���� �ִ� ��� key�� ������ ���Ͽ� Iterator�� ���մϴ�.
	          Iterator<Integer> iterMap = keys.iterator();
	            
	          while (iterMap.hasNext()) 
	          {
	          	Integer key = iterMap.next();
	          	String value = map.get(key);

	          	System.out.println(key + " : " + value);
	           }          
	          
	          
		System.out.println("=======Annotation========");
	          
		MyHello hello = new MyHello();
		
		try
		{
			Method method = hello.getClass().getDeclaredMethod("hello");
			
			// verify a certain method
			if(method.isAnnotationPresent(Count100.class))
			{
				for(int i = 0; i< 3; i++)
				{
					hello.hello();
				}
			}
			else
			{
				hello.hello();
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		
		
		System.out.println("=======Regular Expression========");
		
		String searchTarget = "Luke Skywarker 02-123-4567 luke@daum.net\n�ٽ����̴� 070-9999-9999 darth_vader@gmail.com\nprincess leia 010 2454 3457 leia@gmail.com";

		Pattern pattern = Pattern.compile("\\d{2,3}[- ]?\\d{3,4}[- ]?\\d*");//���⿡ ����ǥ������ �����ϴ�.
		Matcher matcher = pattern.matcher(searchTarget);
		
		while(matcher.find())
		{
			System.out.println(matcher.group(0));
		}
		
		
	}
	
}
