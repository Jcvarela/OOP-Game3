package Manager;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Keys {
	public static final int UP = 0;
	public static final int LEFT = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	public static final int SPACE = 4;
	public static final int ENTER = 5;
	public static final int ESCAPE = 6;
	public static final int F1 = 7;
	
	
	
	private static int numOfKeys;
	private static boolean[] keyState;
	private static boolean[] prevKeyState;
	private static HashMap<Integer, Integer> keyBinding;
	
	private static Keys singleton = new Keys();
	
	private Keys(){
		loadKeyBinding();
	}
	
	private static void loadKeyBinding(){
		keyBinding = new HashMap<>();
		
		//mapping keys
		keyBinding.put(KeyEvent.VK_UP, UP);
		keyBinding.put(KeyEvent.VK_LEFT,LEFT);
		keyBinding.put(KeyEvent.VK_DOWN, DOWN);
		keyBinding.put(KeyEvent.VK_RIGHT, RIGHT);
		
		keyBinding.put(KeyEvent.VK_SPACE, SPACE);
		
		keyBinding.put(KeyEvent.VK_ENTER, ENTER);
		keyBinding.put(KeyEvent.VK_ESCAPE, ESCAPE);
		
		keyBinding.put(KeyEvent.VK_F1, F1);
		
		
		//keep track if keys are been press
		numOfKeys = keyBinding.size();
		keyState = new boolean[numOfKeys];
		prevKeyState = new boolean[numOfKeys];
	}
	
	
	public static void setKey(int i, boolean b) {
		if(keyBinding.containsKey(i)){
			keyState[keyBinding.get(i)] = b;
		}
	}
	
	public static void update() {
		for(int i = 0; i < numOfKeys; i++) {
			prevKeyState[i] = keyState[i];
		}
	}
	
	
	public static boolean isDown(int i) {
		return keyState[i];
	}
	
	public static boolean anyKeyDown() {
		for(int i = 0; i < numOfKeys; i++) {
			if(keyState[i]) return true;
		}
		return false;
	}
	
	public static boolean isPressed(int i) {
		return keyState[i] && !prevKeyState[i];
	}
	
	public static boolean anyKeyPress() {
		for(int i = 0; i < numOfKeys; i++) {
			if(keyState[i] && !prevKeyState[i]) return true;
		}
		return false;
	}
	public static int getNumOfKeys(){
		return numOfKeys;
	}
}
