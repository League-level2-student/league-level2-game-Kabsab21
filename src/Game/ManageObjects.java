package Game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class ManageObjects implements ActionListener, KeyListener {
	Player player;
	ArrayList<Fells> felli = new  ArrayList<Fells>();
	Random random = new Random();
	static Boolean lose = false;
	int score = 0;

	int getScore() {
		return score;
	}


	ManageObjects(Player player){
		this.player = player;
	}

	void checkCollison() {
		

		for( int i = felli.size()-1; i >-1 ; i-- ) {
			Fells ij = (Fells) felli.get(i);
			

			if(player.collisionBox.intersects(ij.collisionBox) == true) {

				ij.isActive = false;
				score++;
				System.out.println(score);

			}
			
			if(ij.y > Game.HEIGHT) {
				lose = true;
				ij.isActive = false;
			} else {
				lose = false;
			}

		}
	}
	

	void addFell() {
		felli.add(new Fells(random.nextInt(Game.WIDTH -10),0,50,50));
	}

	//Focus for next class. Make sure commands are correct. 
	void kindaneedmetyhodIguess(Graphics g) {
		for( int i = felli.size()-1; i >= 0; i-- ) {
			Fells ij = (Fells) felli.get(i);
			ij.update();
			if( ij.y > Game.HEIGHT ) {
				ij.isActive = false;
				//System.out.println("notactivesss");
			}

			ij.draw(g);
			//System.out.println("drawn");

		}
	}

	void update() {
		//System.out.println("checUpdate being called");
		checkCollison();
		purgeObjects();
	}

	void draw(Graphics g){
		player.draw(g);
		player.update();
		kindaneedmetyhodIguess(g);
	}

	void purgeObjects() {
		for( int i = felli.size()-1; i >= 0; i-- ) {
			Fells ij = (Fells) felli.get(i);
			if( ij.isActive == false) {
				felli.remove(i);
			}			
		} 
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// TODO Auto-generated method stub
		addFell();
	//	System.out.println("Fell added");
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
