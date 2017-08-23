package ask.helloworld.high;



// Runnable�� �����ϴ� DaemonThreadŬ������ �ۼ�
public class DaemonThread implements Runnable 
{

	// ���ѷ����ȿ��� 0.5�ʾ� ���鼭 ���󾲷��尡 �������Դϴٸ� ����ϵ��� run()�޼ҵ带 �ۼ�
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
                break; //Exception�߻��� while �� ������  
            }
        }
    }
}
