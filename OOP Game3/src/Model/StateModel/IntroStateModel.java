package Model.StateModel;

import Manager.FileDirectory;
import Manager.GameStateManager;
import Model.BasicSelectInterface;
import Other.Animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import Loading.LoadImage;


/**
 * Created by jcvarela on 3/17/2016.
 */
public class IntroStateModel implements StateModel, BasicSelectInterface {

    //TIME IN MILLISECONDS
    private final long FADE_IN = 3000;
    private final long STAY = 2000 + FADE_IN;
    private final long FADE_OUT = 3000 + STAY;

    private final int NEXT_STAGE_ID = GameStateManager.TEST;

    private Animation introImage;
    private long startTime;
    private float alpha;
    private boolean switchState;

    public IntroStateModel(){
        init();
    }


    public BufferedImage getIntroImage(){
        if(introImage == null) {
            System.err.println("IntroStateModel error: introImage was not loaded");
            return null;
        }
        
        BufferedImage temp = this.introImage.getImage();
        int width = temp.getWidth();
        int height = temp.getHeight();
        
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.drawImage(temp,0,0,width,height,null);
        
        g.setColor(new Color(0f,0f,0f,this.alpha));
        g.fillRect(0, 0, width, height);
        
        return image;
    }


    public void loadIntroImage(BufferedImage[] image){
        loadIntroImage(new Animation(image));

    }
    public void loadIntroImage(Animation image){
        this.introImage = image;
    }



    @Override
    public void init(){
        startTime = System.currentTimeMillis();
        alpha = 0f;
        switchState = false;
        
        introImage = new Animation(LoadImage.loadBufferedImage(FileDirectory.INTRO_STATE));
    }

    @Override
    public void update(){
        long temp = System.currentTimeMillis() - startTime;

        if(temp < FADE_IN){
            alpha = 1f - (float)temp/FADE_IN;
        }
        else if(temp < STAY){
            alpha = 0f;
        }
        else if (temp < FADE_OUT) {
            alpha =(((float)temp - STAY)/(FADE_OUT - STAY));
        }
        else {
            alpha = 1f;
            switchState = true;
        }
    }

    @Override
    public void select() {
       switchState = true;
    }

    @Override
    public void back() {

    }


	@Override
	public int nextState() {
		return (switchState)? NEXT_STAGE_ID: -1;
	}
}
