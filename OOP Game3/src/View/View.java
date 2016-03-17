package View;

import Main.Game;
import Model.Model;

import java.awt.Graphics2D;


/**
 * Created by jcvarela on 3/17/2016.
 */
public abstract class View {
    protected int WIDTH = Game.WIDTH;
    protected int HEIGHT = Game.HEIGHT;

    protected Model model;

    public View(Model model){
        this.model = model;
    }

    public  abstract void init();

    public abstract void render(Graphics2D g);

    protected abstract Model getModel();
}
