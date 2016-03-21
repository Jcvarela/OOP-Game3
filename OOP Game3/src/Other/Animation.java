package Other;

import java.awt.image.BufferedImage;

public class Animation {
	private BufferedImage[] frames;
	private int currentFrame;
	private int numFrames;
	
	private int count;
	private int delay = 2;//TODO: 
	
	private int timesPlayed;
	
	public Animation(BufferedImage image){
		//TODO: this constructor needs to be change
		frames = new BufferedImage[1];
		frames[0] = image;
	}
	public Animation(BufferedImage[] frames){
		this(frames, 2);
	}
	public Animation(BufferedImage[] frames, int delay){
		timesPlayed = 0;
		setFrames(frames,delay);
	}
	
	public void setFrames(BufferedImage[] frames){
		this.setFrames(frames,delay);
	}
	public void setFrames(BufferedImage[] frames, int delay){
		this.frames = frames;
		currentFrame = 0;
		count = 0;
		timesPlayed = 0;
		this.delay = delay;
		numFrames = frames.length;
	}
	
	public void setDelay(int i) { 
		//TODO: test negative numbers
		delay = i; 
	}
	public void setFrame(int i) { 
		
		if(currentFrame < 0 || currentFrame >= numFrames){
			System.err.println("Animation class error: setFrame(i) i is out of bound");
			currentFrame = 0;
		}
		else {
			currentFrame = i;
		}
		
	}
	
	public void update() {
		
		if(delay == -1) return;
		
		count++;
		
		if(count >= delay) {
			currentFrame++;
			count = 0;
		}
		if(currentFrame == numFrames) {
			currentFrame = 0;
			timesPlayed++;
		}
		
	}
	
	public int getFrame() { return currentFrame; }
	public int getCount() { return count; }
	public BufferedImage getImage() { return frames[currentFrame]; }
	public boolean hasPlayedOnce() { return timesPlayed > 0; }
	public boolean hasPlayed(int i) { return timesPlayed == i; }
	
}
