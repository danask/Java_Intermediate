package ask.helloworld.basic;


// function definition only
public interface TV
{
	// change to static final in compile time
    public int MAX_VOLUME = 100;
    public int MIN_VOLUME = 0;

    // change to abstract in compile time
    public void turnOn();
    public void turnOff();
    public void changeVolume(int volume);
    public void changeChannel(int channel);
    
    
    // No abs.
//    public int contrast (int a)
//    {
//    	return a;
//    }    
    
    
    
    // since 1.8
    default int brightness(int a)
    {
    	return a;
    }
    
    public static int contrast(int b)
    {
    	return b;
    }
    
    
}
