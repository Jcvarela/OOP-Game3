package Controller;

import Model.Model;

/**
 * Created by jcvarela on 3/17/2016.
 */
public abstract class Controller {

    protected Model model;

    public Controller(Model model){
        this.model = model;
    }

    public abstract void init();

    public abstract void update();

}
