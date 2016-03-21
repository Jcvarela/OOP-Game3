package GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import Entity.Entity;
import ID.AnimationID;
import ID.AnimationID.ActionID;
import ID.AnimationID.DirectionID;
import Manager.FileDirectory;
import Manager.GameStateManager;
import Manager.Keys;
import Loading.LoadImage;
import Other.Animation;

public class TestState extends GameState{
	
	Entity e;
	
	public TestState(GameStateManager gsm) {
		super(gsm);
		
		e = new Entity();
	}

	@Override
	public void init() {
		LoadImage.loadEntitySprites(FileDirectory.AVATAR,e);
	}

	@Override
	public void update() {
		handleInput();
		e.update();
	}
	DirectionID d = DirectionID.Down;
	
	
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
