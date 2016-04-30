/////////////////////////////////////////////
//
// Pong game: This class builds the Frame
//
// Author: Sydney Lyon
// Updated: 4/30/2016
//
/////////////////////////////////////////////


import javax.swing.JFrame;

class Table extends JFrame{
    // desired height and width of frame
    public static final int FHEIGHT = 600;
    public static final int FWIDTH = 600;

    // constructor
    public Table(){
	// makes frame visible
	this.setVisible(true);
	// sets the desired height and width of frame
	this.setSize(FWIDTH, FHEIGHT);
	// make a new Game to put on table
	Game game = new Game();
	// puts the game on the table
	this.add(game);
	// add key listener to our game for user input
	this.addKeyListener(game);
    }

    public static void main(String[] args){
	// creates a new table when Class is run
	Table table = new Table();
    }


}
