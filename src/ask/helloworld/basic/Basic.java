package ask.helloworld.basic;


import java.io.*;
import java.util.*;

import ask.helloworld.company.Company;
//���� import�� �ϱ� �ȴٸ�, Ȥ�� ���� �ٸ� ��Ű���� �����ϴ� ���� �̸��� Ŭ���� ������ ����ؾ� �Ѵٸ� 
//�Ʒ��� ���� �̿��Ѵ�. 
//com.eightcruz.javastudy.Hello hello = new com.eightcruz.javastudy.Hello(); �̷��� ����Ѵ�



public class Basic 
{
	
	// HelloWorld2�� ��ü �Ϻη� �ν��ߴ� +Cal method(class �ΰ�쵵 ����)�� 
	// static Ű���带 ��������μ�, ���������� ��ü ������ ����������.
//	1. ���ú���   --------------------------> Stack �޸� ����
//	2. �ν���Ʈ ���� ----------------------> Heap �޸� ����
//	3. static����(class ����) -------------->Method Area ����(in stack)
	
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
	//main�� static�� �޼ҵ��̴�. static�� �޼��忡���� static ���� ���� �ʵ带 ��� �� �� ����.
	// new(inst. ȭ) ���ص� ��, static �̿��߱� ����
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
		
		Employee emp1 = new Employee(); // new... ������ -> instance : �޸𸮿� ������� ��ü
		
		emp1.id = "admin";
		emp1.pwd = "admin1010";
		
		System.out.println(emp1.id);
		
		
		// �⺻�� vs. ������
		// �⺻�� : boolean, int, char, double...  // call by value
		// ������(class, array) : String   // call by reference
		
		String str = new String("hello");
		// str ------> Hello 
		// memory ��ġ���� ����(������) : �����Ѵ�!
		
		// String�� new ������ ���� inst. ���� ����
		
		System.out.println("--------- STRING ----------");
		String str1 = "without new inst."; //��� ������ ���� !!!!
		String str2 = "without new inst."; //���� instance ������
		
		String str3 = new String("hello"); // in heap
		String str4 = new String("hello"); // ���� �ٸ� �� ����Ŵ
		
		if(str1 == str2)
			System.out.println("str1 == str2"); // mem ����
		
		if(str3 != str4)
			System.out.println("str3 != str4");
		

//		str.subString(1,3) �� str�� �����ϴ� ���ڿ��� �ε��� 1������ 3������ �ڸ� ����̴�. 
//		str.subString(2) �� str�� �����ϴ� ���ڿ��� 2�� �ε������� ���������� �ڸ� ����� �ǹ��Ѵ�. 
//		���ڿ��� �ε����� 0�� ���� �����Ѵ�.

		//str1�� ���� �ȵ� : �Һ�, �ֳĸ� reference �̱� ������ �����Ǹ� �ȵ�(�ٸ��� �����Ҽ� ����)	// ���ǹ̾��� ���	
		String str5 = str1.substring(3);  // from 3 to end ���� ���
				
		System.out.println("org : " + str1);

		System.out.println("substring(3) : " + str5); 
		System.out.println("substring(0, 7) : " + str1.substring(0, 7)); // cut by range
		System.out.println("charAt(0) : " + str1.charAt(0));
		System.out.println("length() : " + str1.length());
		System.out.println(str1.concat(" by ASK"));
		
		
		
		
		// Class
		System.out.println("--------- CLASS ----------");		
		
		Company comB = new Company(); // error, param ������ �⺻ ������(�ڵ�)
		Company com = new Company("SEC"); // constructor, �ʱ�ȭ, 
		Company com2 = new Company("LG"); // method ������ ������ �̸� �־���� ����
		
		com.setName("Ahn");
		com.setName('9', "Ahn");
		
		System.out.println(com.getName());
		
		
//		static�� ������ �����ȴ�.(class var)
//		static�ϰ� ����� ������ ���� ������ �� �ִ� ������ �ϳ��� �����ȴ�.(only one) 
//		�׷��Ƿ�, �ν��Ͻ��� ������ �����ǵ� static�� ������ �ϳ���. 
//		Ŭ���� ������ ���۷���.������ �ϰ� ����ϱ� ���ٴ� Ŭ������.������ ���� ����ϴ°��� �� �ٶ���.
		//VariableScopeExam.staticVal		
				
		com.staticTest = 1;
		Company.staticTest = 3; // static�� class ������ ����
		com2.staticTest = 2;		
		
		System.out.println("staticTest : " + Company.staticTest); // only 1 and shared var!!!!
		
		//Company.MALE = "aaaa";  // final
		//????? : enum ���� �ҷ����� �����??
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


