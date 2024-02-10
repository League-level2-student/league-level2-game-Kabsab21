package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {

	 int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 Boolean isActive = true;
	 Rectangle collisionBox;
	 
	 Player( int x, int y, int width, int height){
		  this.x = x;
		  this.y = y;
		  this.width = width;
		  this.height = height;
		  speed = 10;
		  this.collisionBox = new Rectangle(x,y,width, height);
	 }
	 
	 void update() {
		 collisionBox.setBounds(x, y, width, height);
	 }
	 
	 void draw(Graphics g) {
				g.setColor(Color.BLUE);
				g.fillRect(x, y, width, height);
	 }
	 
	 void left() {
		  x-=speed;
		  if( x > 500 ) {
			  x = 499;
		  }
		  if( x <  0 ) {
			  x = 1;
		  }
	 }
	 void right() {
		  x+=speed;
		  
		  if( x > 400 ) {
			  x = 399;
		  }
		  if( x <  0 ) {
			  x = 1;
		  }
	 }
}
