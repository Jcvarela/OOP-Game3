package GameState;

import Controller.ImputController.BasicInputController;
import Controller.StateController.IntroStateController;
import Manager.GameStateManager;
import Model.StateModel.IntroStateModel;
import Model.StateModel.StateModel;
import View.StateViewport.IntroStateViewport;

import java.awt.*;

/**
 * Created by jcvarela on 3/17/2016.
 */
public class IntroState extends GameState{

    private IntroStateController controller;

    public IntroState(GameStateManager gsm){
        super(gsm);
        init();
    }

    @Override
    public void init(){
    	controller = new IntroStateController(gsm, new IntroStateModel());
    }
    
    @Override
    public void update(){
    	controller.update();
    }

    @Override
    public void render(Graphics2D g){
        controller.render(g);
    }
}
