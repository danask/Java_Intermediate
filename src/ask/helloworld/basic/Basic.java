package ask.helloworld.basic;


import java.io.*;
import java.util.*;

import ask.helloworld.company.Company;
//만약 import를 하기 싫다면, 혹은 각기 다른 패키지에 존재하는 같은 이름의 클래스 파일을 사용해야 한다면 
//아래와 같이 이용한다. 
//com.eightcruz.javastudy.Hello hello = new com.eightcruz.javastudy.Hello(); 이렇게 사용한다



public class Basic 
{
	
	// HelloWorld2의 객체 일부로 인식했던 +Cal method(class 인경우도 동일)가 
	// static 키워드를 사용함으로서, 독립적으로 객체 생성이 가능해진다.
//	1. 로컬변수   --------------------------> Stack 메모리 저장
//	2. 인스턴트 변수 ----------------------> Heap 메모리 저장
//	3. static변수(class 변수) -------------->Method Area 저장(in stack)
	
	//http://blog.naver.com/naaam828/220485132422
	
	
	
	// struct-like
	// 1) inner class
	class Number 
	{
		// field
		int a;
		int b;
				
		public void plus(int i, int j)
		{
			i++; j++;
		}
	}	

	// 2) inner static class
	public static class Employee 
	{
		// field
		String id;
		String pwd;
	}	
	
	
	
	// method
	
	// 3) local class
	public void localClass()
	{
		class Test
		{
			int i;
			int j;
		}
		
		Test t = new Test();
		
		t.i = 1;
		
		System.out.println("Local class executes : " + t.i );
		
	}
	
	
	public static double plusCalculate(int numA, double numB)
	{
		return numA+numB;
	}
	
	//throws
	public static int divide(int i, int j) throws Exception
	{
	        if(j == 0)
	        {
	        	// 1) ERROR HERE!!
	            throw new IllegalArgumentException("It can't be divided by Zero");
	        }
					
		return i/j;
	}
	
	
	public static void swap(int a, int b)
	{
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void classSwap(Number x)
	{
		int temp = x.a;
		x.a = x.b;
		x.b = temp;
	}	
		
	
	static int array[] = new int[10];  // static should be declared outside of main 
	
	
	//Starting point of program
	//main은 static한 메소드이다. static한 메서드에서는 static 하지 않은 필드를 사용 할 수 없다.
	// new(inst. 화) 안해도 됨, static 이용했기 때문
	public static void main(String[] args) 
	{
		char equal = '='; // 1byte = 2^8
		int i = 1; // 4byte = 2^(8*4) -> -() ~ +()
		int j = (5>4)? 50 : 40;
		
		long l = 987654321L; // 8byte = 2^(8*8)
		boolean isOkay = false;
		final double PI = 3.14; // const declaration as Capital letter
		final int OIL_PRICE = -1200; // #define PI 3.14
		
		//MATH : all methods are already declared as static. So, it doesn't need "new obj". 
		 int value1 = Math.max(5, 20);
		 int value2 = Math.min(5, -5);
		 int value3 = Math.abs(-10);
		 double value4 = Math.random();
		 double value5 = Math.sqrt(25); 		
		
		
		String hello = "Hello World";		
		Basic obj = new Basic();
		char input[] = new char[]{'a', 'b', 'c'};

		//PI = 11.2; // not possible
		
		
		System.out.println("--------- basic ----------");
		
		System.out.println("Hello World = " + obj.plusCalculate(2, OIL_PRICE));
		
		System.out.println(hello +equal+" "+ plusCalculate(2, PI));
		
		System.out.println("long "+ l + " "+ j);
		
		   
		// at least once
		System.out.println("--------- do ~ while ----------");		
		do{
			System.out.println("do~while");
			
		}while(i < 1);

		
		// scanf
		System.out.println("--------- Scanner ----------");		
		int value = 0;
				
//		Scanner scanf = new Scanner(System.in);
//				
//		do{
//			value = scanf.nextInt(); // ("%d", &N);
//			System.out.println("input : " + value);
//		}while(value !=10);
		
	 
		//continue
		System.out.println("--------- For, continue ----------");		
		for(int k = 1; k < 10; k++)
		{
			if(k % 2 != 0)
				continue;
		
			array[k] = k;            
			System.out.println(k);
		}

		// for each(1.5 up)
		for(char x : input)  // var : array
		{
			System.out.println("-" + x);		
		}
				
		System.out.println("all " + array.length);


//		for(char x : input)  // var <- array
//		for(int i = 0; i < input.length; i++)
//		{
//			char x = input[i];
		
//			System.out.println("-" + x);		
//		}		
				
		
		
		
		// 2D
		System.out.println("--------- 2D array ----------");		
		
		int array2[][] = new int[3][10];
		
		for(int x = 0; x < array2.length; x++)
		{
			for(int y = 0; y < array2[x].length; y++)
			{
				array2[x][y] = y+x;
				System.out.println(x + " : " +array2[x][y]);
			}
		}
		
		int array3[][] = new int[3][];
		
		array3[0] = new int[0];
		array3[1] = new int[1];
		
		int array4[][] = {{1}, {2,3}, {4,5,6}};
		
		for(int x[] : array4)
		{
			System.out.println("-");
			for(int y : x)
				System.out.println(" " + y);
		}
		
		
		
		
		
		
		// CLASS
		
		Employee emp1 = new Employee(); // new... 생성자 -> instance : 메모리에 만들어진 객체
		
		emp1.id = "admin";
		emp1.pwd = "admin1010";
		
		System.out.println(emp1.id);
		
		
		// 기본형 vs. 참조형
		// 기본형 : boolean, int, char, double...  // call by value
		// 참조형(class, array) : String   // call by reference
		
		String str = new String("hello");
		// str ------> Hello 
		// memory 위치값이 저장(포인터) : 참조한다!
		
		// String은 new 연산자 없이 inst. 생성 가능
		
		System.out.println("--------- STRING ----------");
		String str1 = "without new inst."; //상수 영역에 저장 !!!!
		String str2 = "without new inst."; //동일 instance 포인팅
		
		String str3 = new String("hello"); // in heap
		String str4 = new String("hello"); // 각각 다른 것 가리킴
		
		if(str1 == str2)
			System.out.println("str1 == str2"); // mem 절약
		
		if(str3 != str4)
			System.out.println("str3 != str4");
		

//		str.subString(1,3) 은 str이 참조하는 문자열을 인덱스 1번부터 3번까지 자른 결과이다. 
//		str.subString(2) 은 str이 참조하는 문자열을 2번 인덱스부터 마지막까지 자른 결과를 의미한다. 
//		문자열의 인덱스는 0번 부터 시작한다.

		//str1은 적용 안됨 : 불변, 왜냐면 reference 이기 때문에 수정되면 안됨(다른게 참조할수 있음)	// 별의미없는 얘기	
		String str5 = str1.substring(3);  // from 3 to end 까지 출력
				
		System.out.println("org : " + str1);

		System.out.println("substring(3) : " + str5); 
		System.out.println("substring(0, 7) : " + str1.substring(0, 7)); // cut by range
		System.out.println("charAt(0) : " + str1.charAt(0));
		System.out.println("length() : " + str1.length());
		System.out.println(str1.concat(" by ASK"));
		
		
		
		
		// Class
		System.out.println("--------- CLASS ----------");		
		
		Company comB = new Company(); // error, param 없으면 기본 생성자(자동)
		Company com = new Company("SEC"); // constructor, 초기화, 
		Company com2 = new Company("LG"); // method 있으면 생성시 이름 넣어줘야 동작
		
		com.setName("Ahn");
		com.setName('9', "Ahn");
		
		System.out.println(com.getName());
		
		
//		static한 변수는 공유된다.(class var)
//		static하게 선언된 변수는 값을 저장할 수 있는 공간이 하나만 생성된다.(only one) 
//		그러므로, 인스턴스가 여러개 생성되도 static한 변수는 하나다. 
//		클래스 변수는 레퍼런스.변수명 하고 사용하기 보다는 클래스명.변수명 으로 사용하는것이 더 바람직.
		//VariableScopeExam.staticVal		
				
		com.staticTest = 1;
		Company.staticTest = 3; // static은 class 명으로 접근
		com2.staticTest = 2;		
		
		System.out.println("staticTest : " + Company.staticTest); // only 1 and shared var!!!!
		
		//Company.MALE = "aaaa";  // final
		//????? : enum 직접 불러오는 방법은??
		System.out.println("ask.helloworld.company.Company.MALE : " 
										+ ask.helloworld.company.Company.MALE);  
		
		
		
		
		
		// Swap
		System.out.println("--------- SWAP ----------");		
		int swapA = 1, swapB = 2;
		
		// by Value
		swap(swapA, swapB);
		
		System.out.println(swapA + " " + swapB);
		
//		Number num = new Number();
		
		Basic.Number test = obj.new Number();
		
		test.a = 1; test.b = 2;
		
		// by Reference
		classSwap(test);
		
		System.out.println(test.a + " " + test.b);
		
		
		
		
		// Inherit
		System.out.println("--------- INHERIT ----------");				
		Samsung sec = new Samsung();
		
		sec.test();
		
		
		// Encapsulation
		// has related contents 
		// e.g., class : fields + methods
		System.out.println("protected : " + sec.p2);
		
		System.out.println("default : " + sec.k);
		
		// Basic class should extend Company
		//sec.protectedJ;
		
		

		// Abs : extends
		System.out.println("--------- Abs. class ----------");				
		MFP m = new MFP();
		

		// Overriding : redefined method from parents'
		System.out.println("--------- Overriding ----------");			
		m.print();
		m.warmUp();
		
		// Interface
		// 1) interface uses 'implements'
		// 2) interface can make instance  // cf. abs X
		// 3) use the same interface such as LED, LCD, UHD....
		
		System.out.println("--------- Interface ----------");		
					
		TV tv = new LEDTV();
		tv.turnOn();
		tv.changeVolume(50);
		tv.changeChannel(11);
		tv.turnOff();
				
		// from 1.8x, default, static as well as abs.
		System.out.println(tv.brightness(999));
				
		// interface name.method
		TV.contrast(888);
		
		//CLASS
		obj.localClass();
		
		
		
		// Exception
		try
		{
			//System.out.println(10/0);
			divide(1,0); 		// 2) an error occurs  in execute place, not in method
		}
  		catch(ArithmeticException e)
		{
			System.out.println("[ErrorLog] : ArithmeticException " + e.toString());
		}
		catch(Exception e)
		{
			System.out.println("[ErrorLog] : Exception " + e.toString());
		}
		finally
		{
			System.out.println("'finally' is always printed!!");  
		}
		
		

	}
}


