package ask.helloworld.basic;

public class LEDTV implements TV
{

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
        System.out.println("�Ѵ�");
	}
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
        System.out.println("����");   
	}
	@Override
	public void changeVolume(int volume) {
		// TODO Auto-generated method stub
        System.out.println(volume + "�� ���������ϴ�.");  
	}
	@Override
	public void changeChannel(int channel) {
		// TODO Auto-generated method stub
        System.out.println(channel + "�� ä�������ϴ�."); 
	}
	
//	public int brightness(int a)
//    {
//    	return a;
//    }

	
}
