package ask.helloworld.high;



// Runnable을 구현하는 DaemonThread클래스를 작성
public class DaemonThread implements Runnable 
{

	// 무한루프안에서 0.5초씩 쉬면서 데몬쓰레드가 실행중입니다를 출력하도록 run()메소드를 작성
    @Override
    public void run() 
    {
        while (true) 
        {
            System.out.println("Background thread in progress");

            try 
            {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
                break; //Exception발생시 while 문 나가기  
            }
        }
    }
}
