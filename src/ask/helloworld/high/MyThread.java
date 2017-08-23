package ask.helloworld.high;


// Inheritance
public class MyThread extends Thread
{
	String str;
	long millis = 1000;
	
	
	public MyThread(String str)
	{
		this.str = str;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
//		super.run();
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println(str);
			
			try
			{
				Thread.sleep((int)(Math.random()*millis));
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
