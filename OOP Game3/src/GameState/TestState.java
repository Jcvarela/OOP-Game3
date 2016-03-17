package GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import Entity.Entity;
import Manager.FileDirectory;
import Manager.GameStateManager;
import Manager.Keys;
import Manager.LoadManager;
import Other.Animation;
import Other.AnimationID;
import Other.AnimationID.ActionID;
import Other.AnimationID.DirectionID;

public class TestState extends GameState{
	
	Entity e;
	
	public TestState(GameStateManager gsm) {
		super(gsm);
		
		e = new Entity();
	}

	@Override
	public void init() {
		LoadManager.loadEntitySprites(FileDirectory.AVATAR,e);
	}

	@Override
	public void update() {
		handleInput();
		e.update();
	}
	DirectionID d = DirectionID.Down;
	
	@Override
	public void handleInput() {
		if(Keys.isDown(Keys.UP)){
			e.setActive(AnimationID.getID(ActionID.Move, DirectionID.Up));
			d =DirectionID.Up;
		}
		if(Keys.isDown(Keys.DOWN)){
			e.setActive(AnimationID.getID(ActionID.Move, DirectionID.Down));
			d =DirectionID.Down;
		}
		if(Keys.isDown(Keys.LEFT)){
			e.setActive(AnimationID.getID(ActionID.Move, DirectionID.Left));
			d =DirectionID.Left;
		}
		if(Keys.isDown(Keys.RIGHT)){
			e.setActive(AnimationID.getID(ActionID.Move, DirectionID.Right));
			d =DirectionID.Right;
		}
		if(Keys.isDown(Keys.SPACE))
			e.setActive(AnimationID.getID(ActionID.Attack1, d));
		if(Keys.isDown(Keys.ENTER))
			e.setActive(AnimationID.getID(ActionID.Stand, d));
		if(Keys.isDown(Keys.ESCAPE))
			e.setActive(AnimationID.getID(ActionID.Hit, d));
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 1000);
		e.render(g);
	}

}
