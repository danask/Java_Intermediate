package ask.helloworld.high;

public class ThreadMain
{
	public static void main(String[] args)
	{
		
/*		
		// 1st : Inherit(extend) Thread 
				
		MyThread t1 = new MyThread("ASK");
		MyThread t2 = new MyThread("AYE");
				
		// ready
		t1.start(); // 2nd
		t2.start(); // 3rd
		
		System.out.println("Main Thread!!!!!");
		
		
		// 2nd : Interface Runnable <-- not thread
		// public class Bus extends Car implements Runnable{
		// �̹� Car�� ��ӹ��� �����̱� ������ Thread�� ��ӹ��� ���� �����ϴ�.		
		
		
		MyThread2 tt1 = new MyThread2("----ASK2");
		MyThread2 tt2 = new MyThread2("----AYE2");
				
		Thread thread1 = new Thread(tt1);
		Thread thread2 = new Thread(tt2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("Main Thread2!!!!!");		
		
		
*/		
		
		
/*		
		MusicBox box = new MusicBox();
		
		MusicBoxPlayer a = new MusicBoxPlayer(1, box);
		MusicBoxPlayer b = new MusicBoxPlayer(2, box);
		MusicBoxPlayer c = new MusicBoxPlayer(3, box);
		
		
		a.start();
		b.start();
		c.start();
*/
		
		

		
		
/*
                     //  JOIN for sequential step		

	            MyThread5 thread = new MyThread5();
	            	             
	            thread.start(); 
	            
	            System.out.println("Thread�� ����ɶ����� ��ٸ��ϴ�.");
	            
	            try 
	            {
	                // when thread is done, then go to the next step 
	                thread.join();
	            } 
	            catch (InterruptedException e) 
	            {
	                e.printStackTrace();
	            }
	            	            
	            System.out.println("Thread�� ����Ǿ����ϴ�."); 		
		
*/

	
/*			
		// 1st wait for Thread B by using join
		
		
		ThreadB b = new ThreadB();
	            b.start();

	            System.out.println("WAIT!!");
	            
	            try
	            {
	          	  b.join();
	            }
	            catch(Exception e)
	            {
	          	  e.printStackTrace();
	            }
	            System.out.println("Total is: " + b.total);
*/		            
		
/*		
		
		// 2nd wait for Thread B : b notify its end, then wait is finished
		
	            // �տ��� ���� ������ B�� ���� �� start 
	            // �ش� �����尡 ����Ǹ�, �ش� ������� run�޼ҵ� �ȿ��� �ڽ��� ����͸� ���� ȹ��
	            ThreadB b = new ThreadB();
	            b.start();

	            // b�� ���Ͽ� ����ȭ ���� ����
	            // ���� main�����尡 �Ʒ��� ����� ���� Thread���� ���� ����Ǿ��ٸ� 
	            // wait�� �ϰ� �Ǹ鼭 ����͸� ���� ���� ���       
	            synchronized(b)
	            {
	                try
	                {
	                    // b.wait()�޼ҵ带 ȣ��.
	                    // ���ξ������ ����
	                    // ThreadB�� 5�� ���� ���� �� notify�� ȣ���ϰ� �Ǹ� wait���� ���
	                    System.out.println("b�� �Ϸ�ɶ����� ��ٸ��ϴ�.");
	                    b.wait();
	                }
	                catch(InterruptedException e)
	                {
	                    e.printStackTrace();
	                }

	                //��� �� ����� ���
	                System.out.println("Total is: " + b.total);
	            }		
*/		
		
		
		// Daemon Thread
		
	           // Runnable�� �����ϴ� DaemonThread�� �����ϱ� ���Ͽ� Thread ����
	            Thread th = new Thread(new DaemonThread());
	            
	            // ���󾲷���� ����
	            th.setDaemon(true);
	            
	            // �����带 ����
	            th.start();
		
	            
	            // ���� �����尡 1�ʵڿ� ����ǵ��� ����. 
	            // ���󾲷���� �ٸ� �����尡 ��� ����Ǹ� �ڵ�����.
	            try
	            {
	                Thread.sleep(5000);
	            } 
	            catch (InterruptedException e) 
	            {
	                e.printStackTrace();
	            }   
	            System.out.println("Main Thread was finished");  	            
	            
	            
	}
}

