package ask.helloworld.basic;


// No Abs class !!!! 
public class MFP extends Printer
{
	public MFP()
	{
		//super(); // parent's constructor(added auto. by sys.)
		super("ASK");
		System.out.println("Constructor in MFP!!!!");
	}
		
		
	//Overriding : redefine
	@Override
	public void print()
	{
		System.out.println("PRINT in MFP");
	}

	
	public void warmUp()
	{
		super.warmUp();
		System.out.println("Warm Up in MFP");
	}	
	
	
}
