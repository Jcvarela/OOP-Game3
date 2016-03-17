package View.StateViewport;

import GameState.IntroState;
import Model.Model;
import Model.StateModel.IntroStateModel;
import View.View;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by jcvarela on 3/17/2016.
 */
public class IntroStateViewport extends View{


    public IntroStateViewport(IntroStateModel model) {
        super(model);
    }

    @Override
    public void init() {
    }

    @Override
    public void render(Graphics2D g) {
        g.setBackground(new Color((int)(Math.random()*256),0,0));
        g.drawRect(0,0,WIDTH,HEIGHT);

        BufferedImage im = getModel().getIntroImage();
        g.drawImage(im,0,0,null);
    }

    @Override
    protected IntroStateModel getModel() {
        return (IntroStateModel)model;
    }
}
