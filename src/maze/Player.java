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
  //https://www.geeksforgeeks.org/check-destination-reachable-source-two-movements-allowed/
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
    boolean done = false;
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
     /* if (playerInput.equalsIgnoreCase("up")) {
        System.out.println("Moved up door.");
        myMoveY_axis--;
        moveMade = myMoveY_axis;
        done = true;
        
      } else if (playerInput.equalsIgnoreCase("right")) {
        System.out.println("Moved to right door.");
        myMoveX_axis++;
        moveMade = myMoveX_axis;
        done = true;
        
      } else if (playerInput.equalsIgnoreCase("down")) {
        System.out.println("Moved down door.");
        myMoveY_axis++;
        moveMade = myMoveY_axis;
        done = true;
        
      } else if (playerInput.equalsIgnoreCase("left")) {
        System.out.println("Moved to left door.");
        myMoveX_axis--;
        moveMade = myMoveX_axis;
        done = true;
        
      } else {
        System.out.println("Not valid direction; re-enter direction.");
      }
      System.out.println();
    }
  } */
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
