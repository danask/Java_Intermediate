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
		// 이미 Car를 상속받은 상태이기 때문에 Thread를 상속받을 수는 없습니다.		
		
		
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
	            
	            System.out.println("Thread가 종료될때까지 기다립니다.");
	            
	            try 
	            {
	                // when thread is done, then go to the next step 
	                thread.join();
	            } 
	            catch (InterruptedException e) 
	            {
	                e.printStackTrace();
	            }
	            	            
	            System.out.println("Thread가 종료되었습니다."); 		
		
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
		
	            // 앞에서 만든 쓰레드 B를 만든 후 start 
	            // 해당 쓰레드가 실행되면, 해당 쓰레드는 run메소드 안에서 자신의 모니터링 락을 획득
	            ThreadB b = new ThreadB();
	            b.start();

	            // b에 대하여 동기화 블럭을 설정
	            // 만약 main쓰레드가 아래의 블록을 위의 Thread보다 먼저 실행되었다면 
	            // wait를 하게 되면서 모니터링 락을 놓고 대기       
	            synchronized(b)
	            {
	                try
	                {
	                    // b.wait()메소드를 호출.
	                    // 메인쓰레드는 정지
	                    // ThreadB가 5번 값을 더한 후 notify를 호출하게 되면 wait에서 깨어남
	                    System.out.println("b가 완료될때까지 기다립니다.");
	                    b.wait();
	                }
	                catch(InterruptedException e)
	                {
	                    e.printStackTrace();
	                }

	                //깨어난 후 결과를 출력
	                System.out.println("Total is: " + b.total);
	            }		
*/		
		
		
		// Daemon Thread
		
	           // Runnable을 구현하는 DaemonThread를 실행하기 위하여 Thread 생성
	            Thread th = new Thread(new DaemonThread());
	            
	            // 데몬쓰레드로 설정
	            th.setDaemon(true);
	            
	            // 쓰레드를 실행
	            th.start();
		
	            
	            // 메인 쓰레드가 1초뒤에 종료되도록 설정. 
	            // 데몬쓰레드는 다른 쓰레드가 모두 종료되면 자동종료.
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

