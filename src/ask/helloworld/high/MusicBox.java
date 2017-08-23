package ask.helloworld.high;



// shared object

// synch to prevent method conflict // to avoid deadlock


//synchronized를 붙히지 않은 메소드는 다른 쓰레드들이 synchronized메소드를 실행하면서 
//모니터링 락을 획득했다 하더라도, 그것과 상관없이 실행된다.
//synchronized를 메소드에 붙혀서 사용 할 경우, 메소드의 코드가 길어지면, 
//마지막에 대기하는 쓰레드가 너무 오래 기다리는것을 막기위해서 메소드에 synchronized를 붙이지 않고, 
//문제가 있을것 같은 부분만 synchronized블록을 사용한다.



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
