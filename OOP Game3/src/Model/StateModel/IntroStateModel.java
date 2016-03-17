package Model.StateModel;

import Manager.GameStateManager;
import Model.BasicSelectInterface;
import Model.Model;
import Other.Animation;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;


/**
 * Created by jcvarela on 3/17/2016.
 */
public class IntroStateModel implements Model, BasicSelectInterface {

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

        BufferedImage image = new BufferedImage(temp.getWidth(),temp.getHeight(),BufferedImage.TRANSLUCENT);
        Graphics2D g = image.createGraphics();

        float[] scales = {1f,1f,1f,this.alpha};
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales,offsets,null);
        g.drawImage(temp,rop,0,0);

        return image;
    }


    public void loadIntroImage(BufferedImage[] image){
        loadIntroImage(new Animation(image));

    }
    public void loadIntroImage(Animation image){
        this.introImage = image;
    }

    public int getNextStageID(){
        return NEXT_STAGE_ID;
    }
    public boolean canItSwitchState(){
        return switchState;
    }



    @Override
    public void init(){
        startTime = System.currentTimeMillis();
        alpha = 0f;
        switchState = false;
    }

    @Override
    public void update(){
        long temp = System.currentTimeMillis() - startTime;

        if(temp < FADE_IN){
            alpha = (float)(temp/FADE_IN);
        }
        else if(temp < STAY){
            alpha = 1f;
        }
        else if (temp < FADE_OUT) {
            alpha = 1f - (float)((temp - STAY)/(FADE_OUT - STAY));
        }
        else {
            alpha = 0f;
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
}
