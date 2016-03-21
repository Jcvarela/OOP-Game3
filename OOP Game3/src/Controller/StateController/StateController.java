package Controller.StateController;

import java.awt.Graphics2D;

import Controller.Controller;
import Manager.GameStateManager;
import Model.Model;
import View.View;

public abstract class StateController extends Controller{
	
	protected View view;
	protected GameStateManager gsm;
	
	public StateController(GameStateManager gsm,Model model, View view) {
		super(model);
		this.view = view;
		this.gsm = gsm;
	}
	
	public abstract void update();
	
	public void render(Graphics2D g){
		view.render(g);
	}
	
	protected abstract View getView();
}
