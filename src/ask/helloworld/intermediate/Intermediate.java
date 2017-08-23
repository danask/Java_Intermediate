package ask.helloworld.intermediate;



import java.lang.reflect.Method;

//java.lang패키지의 클래스는 import를 하지 않고도 사용할 수 있다.
//java.lang패키지에는 기본형타입을 객체로 변환시킬때 사용하는 Wrapper클래스가 있다.
//Boolean, Byte, Short, Integer, Long, Float, Double 클래스
//모든 클래스의 최상위 클래스인 Object도 java.lang패키지
//문자열과 관련된 String, StringBuffer, StringBuilder도 모두 java.lang패키지
//화면에 값을 출력할때 사용했던 System클래스도 java.lang패키지
//수학과 관련된 Math클래스도 java.lang패키지
//Thread와 관련된 중요 클래스들이 java.lang패키지

//오토박싱(Auto Boxing)
//Integer i3 = 5; 
//숫자 5는 원래 기본형이지만 자동으로 Integer형태로 변환된다.
//오토 언박싱(Auto unboxing)
//int i5 = i2; 
//Integer객체타입의 값을 기본형 int로 자동으로 변환되어 값을 할당한다.




import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Date클래스는 지역화를 지원하지 않는다.(deprecated) 
//지역화란 국가별로 현재 날짜와 시간은 다를 수 있는데, 그 부분을 지원하지 못한다.
//이런 문제를 해결하기 위하여 나온 클래스가 Calendar클래스. Calendar클래스는 자바 1.1에 등장하였다.

//지역화와 관련된 클래스들은 Locale로 시작되는 이름을 가진 클래스들입니다. 역시 1.1 이후에 등장한다.


/**
 * 
 * 
 * List, Set, Collection, Map은 DS == Collection Framework와 관련된 인터페이스
 * 
 * <interface> Collection
 * 중복도 허용하고, 자료가 저장된 순서도 기억하지 못하는 것이 Collection인터페이스
 * add(Object) : boolean
 * iterator() : interator  // 단순 get
 *             --> hasNext() : boolean, next(): object
 * size() : int
 * 
 * <interface> List 
 * // 순서있고, 중복 허용
 * get(int) : Object
 * 
 * <interface> Set  <----------------------  <interface> Map  // 순서 없고, 중복 비허용
 * add(Object) : boolean <----------------  get(Obejct), keySet(), put(Obj, Obj)
 *
 *
 */



public class Intermediate 
{
	public static void main(String[] args)
	{
		// StringBuffer vs. String : changeable(delete 제공) vs. non-editable(substring-> copy해야)  

		System.out.println("=======StringBuffer========");		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("sb_test1").append(" sb_test2"); // method chaining(메소드 체이닝) // sb가 변경됨
		
		String strn = sb.toString();
		//strn = strn.substring(3, 5); // strn 이 변경 안됨
		
		System.out.println(strn);
		
		
		// flexible memory use -> if needed, copy vs. O(xn^2) 
		
		// (1) String의 +연산을 이용해서 10,000개의 *를 이어붙입니다.
		//시작시간을 기록합니다.(millisecond단위)
		long startTime1 = System.currentTimeMillis();
		String str1="";
		for(int i=0;i<10000;i++){
		        str1=str1+"*";
		}
		//종료시간을 기록합니다.(millisecond단위)
		long endTime1 = System.currentTimeMillis();
		
		// (2) StringBuffer를 이용해서 10,000개의 *를 이어붙입니다.
		//시작시간을 기록합니다.(millisecond단위)                
		long startTime2 = System.currentTimeMillis();
		StringBuffer sb1 = new StringBuffer();
		for(int i=0;i<10000;i++){
		        sb1.append("*");
		}
		//종료시간을 기록합니다.(millisecond단위)
		long endTime2 = System.currentTimeMillis();
		
		// 방법(1)과 방법(2)가 걸린 시간을 비교합니다.
		long duration1 = endTime1-startTime1;
		long duration2 = endTime2-startTime2;
		
		System.out.println("String의 +연산을 이용한 경우 : "+ duration1);
		System.out.println("StringBuffer의 append()을 이용한 경우 : "+ duration2);		
		
		
		
		
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
	          
	          // map에 저장된 모든 key들을 Set자료구조로 꺼냅니다.
	          Set<Integer> keys = map.keySet();
	            
	          // Set자료구조에 있는 모든 key를 꺼내기 위하여 Iterator를 구합니다.
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
		
		String searchTarget = "Luke Skywarker 02-123-4567 luke@daum.net\n다스베이더 070-9999-9999 darth_vader@gmail.com\nprincess leia 010 2454 3457 leia@gmail.com";

		Pattern pattern = Pattern.compile("\\d{2,3}[- ]?\\d{3,4}[- ]?\\d*");//여기에 정규표현식을 적습니다.
		Matcher matcher = pattern.matcher(searchTarget);
		
		while(matcher.find())
		{
			System.out.println(matcher.group(0));
		}
		
		
	}
	
}
