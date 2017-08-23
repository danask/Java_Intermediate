package ask.helloworld.high;

public class MusicBoxPlayer extends Thread
{
	int type;
	
	MusicBox mb;
	
	public MusicBoxPlayer(int type, MusicBox mb)
	{
		this.type = type;
		this.mb = mb;
	}
	
	public void run()
	{
		switch(type)
		{
			case 1:
				mb.playTayo();
				break;
			case 2:
				mb.playPororo();
				break;		
			case 3:
				mb.playCocomong();
				break;		
			default:
				break;
		
		}
	}
	
}
