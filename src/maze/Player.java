/**
 * 
 */
package maze;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author stephg02
 *
 */
public class Player implements Serializable {
  
	private static final long serialVersionUID = 1327082729610563013L;
	
	//https://www.geeksforgeeks.org/check-destination-reachable-source-two-movements-allowed/
	
	 public final Scanner SCNR;
	 private int myMoveX_axis;
	 private int myMoveY_axis;
	 
	 
	 /** The back tracker; stack that holds every move made by player. */
 	Stack<Integer> backTracker;
  
	 public Player() {
	
		 myMoveX_axis = 1;
  
		 myMoveY_axis = 1;
  
		 SCNR = new Scanner(System.in);
  
		 backTracker = new Stack<Integer>();
		 
		 backTracker.push(-1); //-1 is initial value, if reached then reached end of player move history
	}
  
  public int getX() {
    return myMoveX_axis;
  }
  
  public int getY() {
    return myMoveY_axis;
  }
  
  public int playerMove() {
    //boolean done = false;
    int legalMove = -1;
    String playerInput = "";
    String[] moves = {"up", "right", "down", "left", "save"};
    
    while (legalMove == -1) {
      System.out.println("Move: up, right, down, left, or save");
      
      playerInput = SCNR.next();
      
      legalMove = Arrays.asList(moves).indexOf(playerInput.toLowerCase());
    }
      return legalMove;
    
  }
  
  /**
   * Direction player moves added to backTracker stack & update x/y axis in direction to move.
   *
   * @param move the move
   */
  public void moveSuccess(int move) {
	  
	 backTracker.push(move);
	  
	  switch (move) {
	  		case 0:
			    myMoveY_axis--;
	  			break;
	  		case 1:
	  			myMoveX_axis++;
	  			break;
	  		case 2:
	  			myMoveY_axis++;
	  			break;
	  		case 3:
	  			myMoveX_axis--;
	  			break;
	  }
  }
  public void moveUp() {
	  
  }
  
  public void moveRight() {
	  
  }
  
  public void moveDown() {
	  
  }
  
  public void moveLeft() {
	  
  }
  
  public boolean directionReachable(int theRowPos, int theColPos, int theX, int theY) {
    boolean reachable = false;
    Maze m1 = new Maze();
    
    theRowPos = m1.getRows();
    theColPos = m1.getColumns();
    theX = myMoveX_axis;
    theY = myMoveY_axis;
    
    System.out.println("rows: " + theRowPos + ", cols: " + theColPos + ", x: " + theX + ", y: " + theY);
    
    if (theRowPos > theX || theColPos > theY) {
      reachable = false;
    }
    
    if (theRowPos == theX && theColPos == theY) {
      reachable = true;
    }
    
    return reachable;
  }
}
