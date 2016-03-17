package Controller.ImputController;

import Controller.Controller;
import Manager.Keys;
import Model.Model;
import Model.BasicMovementInterface;
import Model.BasicSelectInterface;

/**
 * Created by jcvarela on 3/17/2016.
 */
public class BasicInputController extends Controller{

    public BasicInputController(Model model) {
        super(model);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

        if(model instanceof BasicMovementInterface){
            BasicMovementInterface temp = (BasicMovementInterface) model;

            if(Keys.isDown(Keys.DOWN)){
                temp.moveDown();
            }
            if(Keys.isDown(Keys.UP)){
                temp.moveUp();
            }
            if(Keys.isDown(Keys.LEFT)){
                temp.moveLeft();
            }
            if(Keys.isDown(Keys.RIGHT)){
                temp.moveRight();
            }
        }

        if(model instanceof BasicSelectInterface){
            BasicSelectInterface temp = (BasicSelectInterface)model;

            if(Keys.isDown(Keys.ENTER)){
                temp.select();
            }
            if(Keys.isDown(Keys.ESCAPE)){
                temp.back();
            }
        }

    }

}
