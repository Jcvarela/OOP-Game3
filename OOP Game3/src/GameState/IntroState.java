package GameState;

import Controller.ImputController.BasicInputController;
import Manager.GameStateManager;
import Model.StateModel.IntroStateModel;
import View.StateViewport.IntroStateViewport;

import java.awt.*;

/**
 * Created by jcvarela on 3/17/2016.
 */
public class IntroState extends GameState{

    private IntroStateModel model;
    private BasicInputController controller;
    private IntroStateViewport view;

    public IntroState(GameStateManager gsm){
        super(gsm);
        init();
    }

    @Override
    public void init(){
        model = new IntroStateModel();
        controller = new BasicInputController(model);
        view = new IntroStateViewport(model);
    }
    @Override
    public void update(){
        handleInput();
    }

    @Override
    public void render(Graphics2D g){
        view.render(g);
    }

    @Override
    public void handleInput(){
        controller.update();
    }
}
