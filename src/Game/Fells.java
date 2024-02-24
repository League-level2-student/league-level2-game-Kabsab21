package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fells {

	 int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 Boolean isActive = true;
	 Rectangle collisionBox;
	 
	 Fells( int x, int y, int width, int height){
		  this.x = x;
		  this.y = y;
		  this.width = width;
		  this.height = height;
		  this.collisionBox = new Rectangle(x,y,width, height);
		  speed = 5;
	 }
	 
	 void update() {
		 y+=speed;
		 collisionBox.setBounds(x, y, width, height);
	 }
	 
	 void draw(Graphics g) {
		 
				g.setColor(Color.RED);
	        g.fillRect(x, y, width, height);
	        
	        
	 }
}
