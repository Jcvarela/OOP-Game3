package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import Manager.FileDirectory;
import Loading.LoadImage;
import Other.Animation;

public class Entity {
	
	private HashMap<Integer,Animation> sprites;
	private int activeSprite;
	
	public Entity(){
		sprites = new HashMap<>();
	}
	
	//TODO:remove this functions
	public void init(){
		LoadImage.loadEntitySprites(FileDirectory.AVATAR, this);
		activeSprite = 0;
	}

	public void update(){
		sprites.get(activeSprite).update();
	}
	public void render(Graphics2D g){
		g.drawImage(sprites.get(activeSprite).getImage(),0,0,100,100,null);
	}
	public void setActive(int animationID){
		activeSprite = animationID;
	}
	
	//---------------------------
	
	public void addAnimation(int animationID, BufferedImage[] frames){
		addAnimation(animationID, new Animation(frames));
	}
	
	public void addAnimation(int animationID,Animation ani){
		sprites.put(animationID, ani);
	}
	public void removeAnimation(int animationID){
		sprites.remove(animationID);
	}
}
