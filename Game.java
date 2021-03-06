
//////////////////////////////////////////////////////////////
//
// Pong game: This class builds the Game and its functions
//
// Author: Sydney Lyon
// Updated: 4/30/2016
//
//////////////////////////////////////////////////////////////

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import java.util.*;

public class Game
    extends JPanel
    implements ActionListener, KeyListener{
    private int score = 0;
    private boolean gameOver = false;
    private Timer timer;
    private Paddle paddle = new Paddle();
    private Ball ball = new Ball();

    public Game(){

	// choose background color for panel, dark green
	this.setBackground(new Color(30, 100, 30));

	// create a new timer and start it
	this.timer = new Timer(10, this);
	this.timer.start();
    }

    public void paintComponent(Graphics g){

	super.paintComponent(g);
	// paint scoreboard
	g.setColor(Color.black);
	g.drawString("Score: " + this.score, 20, 20);

	// draw ball and paddle using their public draw functions
	this.ball.draw(g);
	this.paddle.draw(g);

	// if gameOver is true, run quit function
	if(this.gameOver){
	    this.quit(g);
	}

    }

    public void actionPerformed(ActionEvent e){

	// performs this function on tick of timer
	this.onTick();

    }

    
    // this function controls the balls movement througout the frame
    public void onTick(){

	this.ball.move();

	if(this.ball.x() <= 0){

	    // if ball hits left, start moving right
	    this.ball.revDx();

	}else if(this.ball.x() >= Table.FWIDTH - this.ball.DIAMETER){

	    // if ball hits right, start moving left
	    this.ball.revDx();

	}else if(this.ball.y() <= 0){

	    // if ball hits top, start moving down
	    this.ball.revDy();

	}else if(this.ball.x() + this.ball.DIAMETER > this.paddle.x()
		 && this.ball.x() < this.paddle.x() + Paddle.PWIDTH
		 && this.ball.y() + this.ball.DIAMETER>= this.paddle.y()){

	    // if ball hits paddle, start moving up and add to score
	    this.ball.revDy();
	    this.score += 1;

	}else if (this.ball.y() >= Table.FHEIGHT){
	    
	    // end game if ball exits lower boundry of frame
	    this.gameOver = true;
	    
	}

	//repaint scene on every tick
	this.repaint();

    }


    // this function controls the movement of Paddle
    public void keyPressed(KeyEvent e){

	switch(e.getKeyCode()){
	case KeyEvent.VK_RIGHT:
	    this.paddle.moveRight(); break;
	case KeyEvent.VK_LEFT:
	    this.paddle.moveLeft(); break;
	default: break;
	}
	this.repaint();
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    public void quit(Graphics g){

	// stop timer
	this.timer.stop();

	// TO-DO:  CREATE A POP UP WINDOW
	g.setColor(Color.black);
	JOptionPane.showMessageDialog(null, "Game Over");
    }

}
