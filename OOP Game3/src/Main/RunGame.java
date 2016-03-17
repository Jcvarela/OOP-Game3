package Main;


import javax.swing.JFrame;

public class RunGame {
	
	public static void main(String[] args) {
		
		JFrame gameFrame = new JFrame();
		gameFrame.setTitle("The Unwanted....... maybe");
		
		gameFrame.add(new Game());
		
		gameFrame.setResizable(false);
		gameFrame.pack();
		
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}
