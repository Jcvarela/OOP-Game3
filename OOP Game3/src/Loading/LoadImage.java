package Loading;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;

import Entity.Entity;
import ID.ID;
import Other.Animation;
import ID.AnimationID;
import ID.AnimationID.ActionID;
import ID.AnimationID.DirectionID;

public class LoadImage {
	private static BufferedImage nullImage;
	private LoadImage singleton = new LoadImage();
	
	private LoadImage() {
		nullImage = new BufferedImage(100,100 , 1);
	}

	private static final String START_READING = "/start.txt";

	
	public static void loadEntitySprites(String path, Entity entity) {
		File file = new File(path + START_READING);

		try {
			Scanner in = new Scanner(file);

			// get actions
			String[] actionName = new String[in.nextInt()];
			for (int i = 0; i < actionName.length; i++) {
				actionName[i] = in.next();
			}
			// get directions
			String[] directionName = new String[in.nextInt()];
			for (int i = 0; i < directionName.length; i++) {
				directionName[i] = in.next();
			}

			// get Width and height
			int picWidth = in.nextInt();
			int picHeight = in.nextInt();

			for (int i = 0; i < actionName.length; i++) {

				String folder = path + "/" + actionName[i];

				for (int j = 0; j < directionName.length; j++) {

					File temp = new File(folder + "/" + directionName[j] + ".png");
					BufferedImage image = ImageIO.read(temp);

					BufferedImage[] sprite = new BufferedImage[image.getWidth() / picWidth];

					int x = 0;
					int y = 0;
					for (int k = 0; k < sprite.length; k++) {
						sprite[k] = image.getSubimage(x, y, picWidth, picHeight);
						x += picWidth;
					}
					int animationID = AnimationID.getID(ActionID.getValue(actionName[i]),
							DirectionID.getValue(directionName[j]));
					entity.addAnimation(animationID, sprite);
				}
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public static HashMap<Integer,Animation> loadAnimationSet(String path, ID id){
		//TODO: make fix this one 

		return null;
	}
	
	public static BufferedImage[] loadAnimation(String path,int width){		
		BufferedImage temp = loadBufferedImage(path);
		
		BufferedImage[] image = new BufferedImage[temp.getWidth()/width];
		
		int x =0, y = 0;
		
		for (int i = 0; i < image.length; i++) {
			image[i] = temp.getSubimage(x, y, width, temp.getHeight());
			x += width;
		}
		
		return image;
	}
	
	public static BufferedImage loadBufferedImage(String path){
		BufferedImage image = null;
		
		File temp = new File(path);
		try {
			image = ImageIO.read(temp);
		} catch (IOException e) {
			//image = copyImage(nullImage);
			e.printStackTrace();
		}
		
		return image;
	}
	
	public static BufferedImage copyImage(BufferedImage image){
		ColorModel cm = image.getColorModel();
		boolean isAlphaPremulitiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = image.copyData(image.getRaster().createCompatibleWritableRaster());
		return new BufferedImage(cm, raster, isAlphaPremulitiplied,null);
	}
}
