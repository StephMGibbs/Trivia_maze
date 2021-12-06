/**
 * 
 */
package maze;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author stephg02
 *
 */
public class Player {
	 public final Scanner SCNR;
	 private int myMoveX_axis;
	 private int myMoveY_axis;
	 Stack<Integer> backTracker;
  
	 public Player() {
	
		 myMoveX_axis = 1;
  
		 myMoveY_axis = 1;
  
		 SCNR = new Scanner(System.in);
  
		 backTracker = new Stack<Integer>();
		 
		 backTracker.push(-1);
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
    String[] moves = {"up", "right", "down", "left"};
    
    while (legalMove == -1) {
      System.out.println("Move: up, right, down, or left");
      
      playerInput = SCNR.next();
      
      legalMove = Arrays.asList(moves).indexOf(playerInput.toLowerCase());
    }
      return legalMove;
    
  }
  
  public void moveSuccess(int move) {
	  
	 backTracker.push(move);
	  
	  switch (move) {
	  		case 0: //up
			    myMoveY_axis--;
	  			break;
	  		case 1: //right
	  			myMoveX_axis++;
	  			break;
	  		case 2: //down
	  			myMoveY_axis++;
	  			break;
	  		case 3: //left
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
