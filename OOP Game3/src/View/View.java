package View;

import Main.Game;
import Model.Model;

import java.awt.Graphics2D;


/**
 * Created by jcvarela on 3/17/2016.
 */
public abstract class View {
    protected static final int WIDTH = Game.WIDTH;
    protected static final int HEIGHT = Game.HEIGHT;

    protected Model model;

    public View(Model model){
        this.model = model;
    }

    public abstract void render(Graphics2D g);
    
    public abstract Model getModel();

}
