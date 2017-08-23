package ask.helloworld.company;

import java.io.*;
import java.util.*;


public class Tutorial 
{
	
	// HelloWorld2?�� 객체 ?���?�? ?��?��?��?�� +Cal method(class ?��경우?�� ?��?��)�? 
	// static ?��?��?���? ?��?��?��?��로서, ?��립적?���? 객체 ?��?��?�� �??��?��진다.
//	1. 로컬�??��   --------------------------> Stack 메모�? ???��
//	2. ?��?��?��?�� �??�� ----------------------> Heap 메모�? ???��
//	3. static�??��(class �??��) -------------->Method Area ???��(in stack)
	
	//http://blog.naver.com/naaam828/220485132422
	
	
	
	// struct
	public static class Employee // inner class
	{
		// field
		String id;
		String pwd;
	}
	
	public static class Number // inner class
	{
		// field
		int a;
		int b;
	}	
	
	// method
	public static double plusCalculate(int numA, double numB)
	{
		return numA+numB;
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
	//main?? static?�� 메소?��?��?��. static?�� 메서?��?��?��?�� static ?���? ?��?? ?��?���? ?��?�� ?�� ?�� ?��?��.
	// new(inst. ?��) ?��?��?�� ?��, static ?��?��?���? ?���?
	public static void main(String[] args) 
	{
		char equal = '='; // 1byte = 2^8
		int i = 1; // 4byte = 2^(8*4) -> -() ~ +()
		int j = (5>4)? 50 : 40;
		
		long l = 987654321L; // 8byte = 2^(8*8)
		boolean isOkay = false;
		final double PI = 3.14; // const declaration as Capital letter
		final int OIL_PRICE = -1200; // #define PI 3.14
		
		String hello = "Hello World";		
		Tutorial obj = new Tutorial();
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
		
		Employee emp1 = new Employee(); // new... ?��?��?�� -> instance : 메모리에 만들?���? 객체
		
		emp1.id = "admin";
		emp1.pwd = "admin1010";
		
		System.out.println(emp1.id);
		
		
		// 기본?�� vs. 참조?��
		// 기본?�� : boolean, int, char, double...  // call by value
		// 참조?��(class, array) : String   // call by reference
		
		String str = new String("hello");
		// str ------> Hello 
		// memory ?��치값?�� ???��(?��?��?��) : 참조?��?��!
		
		// String?? new ?��?��?�� ?��?�� inst. ?��?�� �??��
		
		System.out.println("--------- STRING ----------");
		String str1 = "without new inst."; //?��?�� ?��?��?�� ???�� !!!!
		String str2 = "without new inst."; //?��?�� instance ?��?��?��
		
		String str3 = new String("hello"); // in heap
		String str4 = new String("hello"); // 각각 ?���? �? �?리킴
		
		if(str1 == str2)
			System.out.println("str1 == str2"); // mem ?��?��
		
		if(str3 != str4)
			System.out.println("str3 != str4");
		

//		str.subString(1,3) ?? str?�� 참조?��?�� 문자?��?�� ?��?��?�� 1번�??�� 3번까�? ?���? 결과?��?��. 
//		str.subString(2) ?? str?�� 참조?��?�� 문자?��?�� 2�? ?��?��?���??�� 마�?막까�? ?���? 결과�? ?��미한?��. 
//		문자?��?�� ?��?��?��?�� 0�? �??�� ?��?��?��?��.

		//str1?? ?��?�� ?��?�� : 불�?, ?��?���? reference ?���? ?��문에 ?��?��?���? ?��?��(?��른게 참조?��?�� ?��?��)		
		String str5 = str1.substring(3);  // from 3 to end 까�? 출력
				
		System.out.println("org : " + str1);

		System.out.println("substring(3) : " + str5); 
		System.out.println("substring(0, 7) : " + str1.substring(0, 7)); // cut by range
		System.out.println("charAt(0) : " + str1.charAt(0));
		System.out.println("length() : " + str1.length());
		System.out.println(str1.concat(" by ASK"));
		
		
		
		
		// Class
		System.out.println("--------- CLASS ----------");		
		
		Company comB = new Company(); // error, param ?��?���? 기본 ?��?��?��(?��?��)
		Company com = new Company("SEC"); // constructor, 초기?��, 
		Company com2 = new Company("LG"); // method ?��?���? ?��?��?�� ?���? ?��?��줘야 ?��?��
		
		com.setName("Ahn");
		com.setName('9', "Ahn");
		
		System.out.println(com.getName());
		
		
//		static?�� �??��?�� 공유?��?��.(class var)
//		static?���? ?��?��?�� �??��?�� 값을 ???��?�� ?�� ?��?�� 공간?�� ?��?���? ?��?��?��?��.(only one) 
//		그러�?�?, ?��?��?��?���? ?��?���? ?��?��?��?�� static?�� �??��?�� ?��?��?��. 
//		?��?��?�� �??��?�� ?��?��?��?��.�??���? ?���? ?��?��?���? 보다?�� ?��?��?���?.�??���? ?���? ?��?��?��?��것이 ?�� 바람�?.
		//VariableScopeExam.staticVal		
				
		com.staticTest = 1;
		Company.staticTest = 3; // static?? class 명으�? ?���?
		com2.staticTest = 2;		
		
		System.out.println("staticTest : " + Company.staticTest); // only 1 and shared var!!!!
		
		
		//Company.MALE = "aaaa";  // final
		System.out.println("Company.Gender.FEMALE : " + Company.Gender.FEMALE);
		
		
		
		
		
		// Swap
		System.out.println("--------- SWAP ----------");		
		int swapA = 1, swapB = 2;
		
		// by Value
		swap(swapA, swapB);
		
		System.out.println(swapA + " " + swapB);
		
		Number num = new Number();
		
		num.a = 1; num.b = 2;
		
		// by Reference
		classSwap(num);
		
		System.out.println(num.a + " " + num.b);
	}

}


       
