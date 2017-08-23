package ask.helloworld.basic;



// if class has one abs. method, abs class
public abstract class Printer 
{
	
	public Printer()
	{
		System.out.println("Constructor in Printer!!!!");
	}
		
	public Printer(String name)
	{
		System.out.println("Constructor in " + name +"'s MFP!!!!");
	}
	
	
	
	// not defined yet
	public abstract void print();
	
	
	// defined
	public void warmUp()
	{
		System.out.println("Warm Up in PRT");
	}
	
}
