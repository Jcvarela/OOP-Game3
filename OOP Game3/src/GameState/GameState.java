package GameState;

import java.awt.Graphics2D;

import Controller.Controller;
import Manager.GameStateManager;

public abstract class GameState {

	protected GameStateManager gsm;

	public GameState(GameStateManager gsm){
		this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void render(Graphics2D g);
}
