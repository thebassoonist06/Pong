
//////////////////////////////////////////////////////////////
//
// Pong game: This class builds the Paddle
//
// Author: Sydney Lyon
// Updated: 4/30/2016
//
//////////////////////////////////////////////////////////////

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
    public static final int PWIDTH = 50;
    public static final int PHEIGHT = 20;
    private int x = 275;//Table.FWIDTH/2 - PWIDTH/2;
    private int y = 560;//Table.FHEIGHT - PHEIGHT;

    // moves paddle right
    public void moveRight(){
	this.x += 10;
    }

    // moves paddle left
    public void moveLeft(){
	this.x -= 10;
    }

    // returns current x value of paddle
    public int x(){
	return this.x;
    }

    // returns current y value of paddle
    public int y(){
	return this.y;
    }

    // draws our paddle
    public void draw(Graphics g){
	g.setColor(Color.black);
	g.fillRect(this.x, this.y, PWIDTH, PHEIGHT);
    }

  
}
