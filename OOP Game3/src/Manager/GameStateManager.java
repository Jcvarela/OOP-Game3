package Manager;

import java.awt.Graphics2D;
import java.util.HashMap;

import GameState.*;

public class GameStateManager {
	
	public static final int NUM_STATE = 1;
	public static final int INTRO = 0;
	public static final int TEST = 1;

	private static final int START_STATE = INTRO;

	private void loadGameState(int i) {
		switch (i) {
			case TEST:
				gameStates = new TestState(this);
				break;
			case INTRO:
				gameStates = new IntroState(this);
				break;
		}
	}



	private GameState gameStates;
	private int currentState;
	private int previousState;

	public GameStateManager() {

		// JukeBox.init();

		setState(START_STATE);

	}
	


	public void setState(int i) {

		if (i >= 0 && i < NUM_STATE) {
			previousState = currentState;
			unloadState(previousState);
			currentState = i;

			loadGameState(i);

			gameStates.init();
		} else {
			// TODO: go to error state
		}
	}



	public void unloadState(int i) {
		gameStates = null;
	}

	public void update() {
		//TODO: function can throw error
		if(gameStates != null) {
			gameStates.update(); }
		 
	}


	public void render(Graphics2D g) {
		//TODO: function can throw error
		if(gameStates != null) {
			gameStates.render(g); }
		 
	}
}
