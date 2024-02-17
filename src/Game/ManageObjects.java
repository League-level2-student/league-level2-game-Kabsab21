package Game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ManageObjects implements ActionListener {
	Player player;
	ArrayList<Fells> felli = new  ArrayList<Fells>();
	Random random = new Random();
	int score = 0;

	int getScore() {
		return score;
	}
	

 ManageObjects(Player player){
	this.player = player;
}
 
 void checkCollison() {
		for( int i = felli.size()-1; i >= 0; i-- ) {
			Fells ij = (Fells) felli.get(i);
			if(player.collisionBox.intersects(ij.collisionBox) == true) {
				ij.isActive = false;
				score++;
				System.out.println("notactivesss");
			}
		}
	}
 
 void addFell() {
	 felli.add(new Fells(random.nextInt(Game.WIDTH),0,50,50));
	 }
 
 //Focus for next class. Make sure commands are correct. 
 void kindaneedmetyhodIguess(Graphics g) {
	 for( int i = felli.size()-1; i >= 0; i-- ) {
	 	Fells ij = (Fells) felli.get(i);
	 	ij.update();
	 	if( ij.y > Game.HEIGHT ) {
	 		ij.isActive = false;
	 		System.out.println("notactivesss");
	 	}
	 	
	 	ij.draw(g);
	 	System.out.println("drawn");

	 }
 }
 
 void update() {
		checkCollison();
		purgeObjects();
	}

	 void draw(Graphics g){
		 player.draw(g);
		
		 System.out.println("drawn in MO");
		 player.update();
		 kindaneedmetyhodIguess(g);
	}
	 
	 void purgeObjects() {
		 for( int i = felli.size()-1; i > 0; i-- ) {
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
	}

}