package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panelgame extends JPanel implements ActionListener, KeyListener{
	
	public final int MENU = 0;
	public final int GAME = 2;
	public final int LARN = 1;
	public final int END = 3;
	Timer frameDraw ;
	int currentState = 0;
	Font TitleFont = new Font("Arial", Font.PLAIN, 30);
	Font TextFont = new Font("Arial", Font.PLAIN, 20);
	Player plays = new Player(250,700, 100, 100);
	Timer fallexisting;
	ManageObjects bang = new ManageObjects(plays);
	
	void startGame(){
	    fallexisting = new Timer(1000 , bang );
	    fallexisting.start();
	}


	Panelgame(){
		
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	   
	}
	
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == LARN){
		    drawLarnState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	void updateMenuState( ) { 
		currentState = MENU;
		
	}
	void updateGameState() {  
		currentState = GAME;
		bang.update();
		if( plays.isActive == false) {
			updateEndState();
		}
		
	}
	void updateLarnState() {  
		currentState = LARN;
		
	}
	void updateEndState()  { 
		currentState = END;

	}
	void drawMenuState(Graphics g) { 
		g.setColor(Color.cyan);
		g.fillRect(0, 0,Game.WIDTH, Game.HEIGHT);
		g.setFont(TitleFont);
		g.setColor(Color.BLUE);
		g.drawString("cool game title name thingy", 100, 200);
		g.setFont(TextFont);
		g.drawString("Press enter to start", 150, 300);
	}
	void drawGameState(Graphics g) { 
		
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0,Game.WIDTH, Game.HEIGHT);
		plays.draw(g);
		bang.draw(g);
	}
	void drawLarnState(Graphics g) { 
		g.setColor(Color.magenta);
		g.fillRect(0, 0,Game.WIDTH, Game.HEIGHT);
		g.setColor(Color.BLUE);
		g.drawString("      how play", 100, 200);
		
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.GRAY);
		g.fillRect(0, 0,Game.WIDTH, Game.HEIGHT);
		g.setFont(TitleFont);
		g.setColor(Color.BLUE);
		g.drawString("      GAME LOST???", 100, 200);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {

		    if (currentState == END) {
		    	 plays = new Player(250,700, 100, 100);
		        currentState = MENU;   
		        bang = new ManageObjects(plays);
		    }else {
		        currentState++;
		    }
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			plays.left();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			plays.right();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		    
		 //   System.out.println("action  "+currentState);
		}else if(currentState == GAME){
		    updateGameState();
		    
		 
		//    System.out.println("action "+currentState);
		}else if(currentState == LARN){
		    updateLarnState();
		    
		//    System.out.println("action "+currentState);
		    
		}else if(currentState == END){
		    updateEndState();
		    
		   
		//    System.out.println("action "+currentState);
		}
		
//	System.out.println("action");
		repaint();
		
		
	}

	

}
