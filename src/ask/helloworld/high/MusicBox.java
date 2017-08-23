package ask.helloworld.high;



// shared object

// synch to prevent method conflict // to avoid deadlock


//synchronized�� ������ ���� �޼ҵ�� �ٸ� ��������� synchronized�޼ҵ带 �����ϸ鼭 
//����͸� ���� ȹ���ߴ� �ϴ���, �װͰ� ������� ����ȴ�.
//synchronized�� �޼ҵ忡 ������ ��� �� ���, �޼ҵ��� �ڵ尡 �������, 
//�������� ����ϴ� �����尡 �ʹ� ���� ��ٸ��°��� �������ؼ� �޼ҵ忡 synchronized�� ������ �ʰ�, 
//������ ������ ���� �κи� synchronized����� ����Ѵ�.



// Thread -(start())- Runnable - Running - (sleep(), wait()) - Blocked - Dead
// blocked(wait) - notify -> runnable/running 

public class MusicBox
{
	public synchronized void playTayo()
	{
	            for(int i = 0; i < 10; i ++)
	            {
	          	  synchronized(this)
	          	  {
	          		  System.out.println("TAYO!!!");
	          	  }
	          		  
	                      try 
	                      {
	                          Thread.sleep((int)(Math.random() * 1000));
	                      } 
	                      catch (InterruptedException e) 
	                      {
	                          e.printStackTrace();
	                      }
	            }		
	}
	
	public synchronized void playPororo()
	{
	            for(int i = 0; i < 10; i ++)
	            {
	          	  synchronized(this)
	          	  {
	          	        	  System.out.println("Pororo!!!");
	          	  }
	                      
	                      try 
	                      {
	                          Thread.sleep((int)(Math.random() * 1000));
	                      } 
	                      catch (InterruptedException e) 
	                      {
	                          e.printStackTrace();
	                      }
	            }		
	}

	public void playCocomong()
	{
	            for(int i = 0; i < 10; i ++)
	            {
	          	  synchronized(this)
	          	  {
	          		  System.out.println("Cocomong!!!");
	          	  }
	                      
	                      try 
	                      {
	                          Thread.sleep((int)(Math.random() * 1000));
	                      } 
	                      catch (InterruptedException e) 
	                      {
	                          e.printStackTrace();
	                      }
	            }		
	}
	
}
