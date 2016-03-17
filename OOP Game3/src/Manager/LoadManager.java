package Manager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import Entity.Entity;
import Other.AnimationID;
import Other.AnimationID.ActionID;
import Other.AnimationID.DirectionID;

public class LoadManager {
	
	
	private static final String START_READING = "/start.txt";
	
	
	
	public static void loadEntitySprites(String path, Entity entity){
		File file = new File(path + START_READING);
		
		try{
			Scanner in = new Scanner(file);
			
			//get actions
			String[] actionName = new String[in.nextInt()];
			for (int i = 0; i < actionName.length; i++) {
				actionName[i] = in.next();
			}
			//get directions 
			String[] directionName = new String[in.nextInt()];
			for (int i = 0; i < directionName.length; i++) {
				directionName[i] = in.next();
			}
			
			//get Width and height
			int picWidth = in.nextInt();
			int picHeight = in.nextInt();
			
			for (int i = 0; i < actionName.length; i++) {
				
				String folder = path + "/" + actionName[i];
				
				for (int j = 0; j < directionName.length; j++) {
					
					File temp = new File(folder + "/"+directionName[j] + ".png");
					BufferedImage image = ImageIO.read(temp);
					
					BufferedImage[] sprite = new BufferedImage[image.getWidth()/picWidth];
					
					int x =0;
					int y =0;
					for (int k = 0; k < sprite.length; k++) {
						sprite[k] = image.getSubimage(x, y, picWidth, picHeight);
						x+= picWidth;
					}
					int animationID = AnimationID.getID(ActionID.getValue(actionName[i]), DirectionID.getValue(directionName[j]));
					entity.addAnimation(animationID, sprite);
				}
			}
			
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	public static void loadModelSprite(){

	}

}
