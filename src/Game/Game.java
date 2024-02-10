package Game;

import javax.swing.JFrame;

public class Game {
	
	JFrame frame = new JFrame();
	public final static int WIDTH = 500;
	public final static int HEIGHT = 800;
	Panelgame punal = new Panelgame();
	
	public static void main(String[] args) {
		Game objew = new Game();
		objew.setup();
	}
	
	void setup(){
		
		punal = new Panelgame();
		frame.addKeyListener(punal);
		frame.add(punal);
		frame.setVisible(true);
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
