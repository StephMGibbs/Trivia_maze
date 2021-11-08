/**
 * 
 */
package maze;

import java.util.Scanner;

/**
 * @author stephg02
 *
 */
public class Player {
  //https://www.geeksforgeeks.org/check-destination-reachable-source-two-movements-allowed/
  
  public int myMoveX_axis = 1;
  
  public int myMoveY_axis = 1;
  
  public final Scanner SCNR = new Scanner(System.in);
  
  public int getX() {
    return myMoveX_axis;
  }
  
  public int getY() {
    return myMoveY_axis;
  }
  
  public int playerMove() {
    boolean done = false;
    int moveMade = 0;
    
    while (done == false) {
      System.out.println("Move: up, right, down, or left");
      String playerInput = SCNR.next();
      
      if (playerInput.equalsIgnoreCase("up")) {
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
    
    return moveMade;
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
