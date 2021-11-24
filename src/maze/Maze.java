package maze;

import java.util.Scanner;

/**
 * @author stephg02
 *
 */
public class Maze {
  
  public int myRows = 3;
  
  public int myColumns = 3;
  
  public Room[][] my2DMaze;
  
  private Player p1;
  
  public int myRoomCount = 1;
  
  public final Scanner SCNR = new Scanner(System.in);
  
  public Maze() {
	  p1 = new Player();
	  my2DMaze = new Room[myRows + 2][myColumns + 2]; // makes 2D array w/ rows and columns
	    // +2 for a buffer
	  
	  makeMazeOfRooms();
	  
	  
  }
  
  public int getRows() {
    return myRows;
  }
  
  public int getColumns() {
    return myColumns;
  }
  
  public void makeMazeOfRooms() {
    
    for (int i = 1; i <= myRows+1; i++)
    {
       for (int j = 1; j <= myColumns+1; j++)
       {
          my2DMaze[i][j] = new Room(j, i, i/myRows, j/myColumns);
       }
    }
    
    my2DMaze[1][1].displayPlayerInRoom();
  }
  
  public void startMaze() {
	  
	  boolean stillPossible = true;
	  
	  while (!(my2DMaze[myRows][myColumns].ifPlayer.equals("[o]")) && stillPossible) {
	      
	      displayMaze();
	      
	      my2DMaze[p1.getY()][p1.getX()].displayEmptyRoom();
	      
	      int move = p1.playerMove();
	      
	      if (!my2DMaze[p1.getY()][p1.getX()].doorLocked(move)) {
	    	  
	    	  Door dr = my2DMaze[p1.getY()][p1.getX()].cardinalDoors[move];
	      
	    	  dr.openDoorQuestion();
	    	  dr.doorOpenOrLocked();
	    	  
	    	  adjacentRoom(move).cardinalDoors[moveInverter(move)] = dr;
	      
	      System.out.println("Your answer was: " + dr.getDoorStatus());
	      if (dr.getDoorLock() == true) {
	        System.out.println("Door is locked permenantly; try a different door!");
	        mazeSolver solver = new mazeSolver(my2DMaze);
	        stillPossible = solver.solveMaze();
	        displayLockout(move);
	      } else {
	        System.out.println("Door is opened! Continue to next room!");
	       p1.moveSuccess(move);
	      }
	      my2DMaze[p1.getY()][p1.getX()].displayPlayerInRoom();
	      
	      }
	      
	      else {
	    	  System.out.println("The path is blocked.");
	    	  my2DMaze[p1.getY()][p1.getX()].displayPlayerInRoom();
	      }
	    }
	  if (stillPossible) {
		  System.out.println("Reached end of the maze! Congrats");
	  }
	  else {
		  System.out.println("You have locked yourself from reaching the exit, good luck next time!");
	  }
	  
  }
  
  public boolean endMaze() {
	  Scanner scanner = new Scanner(System.in);
	  System.out.print("Would you like to play again? y/n ");
	  String answer = scanner.next();
	  if (answer.equals("Y") || answer.equals("y")) {
		  return true;
	  }
	  return false;
  }
  
  public void displayLockout(int move) {
	  switch (move) {
	  	case 0: my2DMaze[p1.getY()-1][p1.getX()].displayClosedRoom();
	  		break;
	  	case 1: my2DMaze[p1.getY()][p1.getX()+1].displayClosedRoom();
	  		break;
	  	case 2: my2DMaze[p1.getY()+1][p1.getX()].displayClosedRoom();
	  		break;
	  	case 3: my2DMaze[p1.getY()][p1.getX()-1].displayClosedRoom();
	  }
  }
  
  public void displayMaze() {
	  for (int r = 1; r < my2DMaze.length - 1; r++) { // row 1 because buffer
	      // starts at row 0 & plus 1 to print the last row
	      //final String enterField = SCNR.next();

	      for (int c = 0; c < myColumns; c++) { // column
	         
	        
	          System.out.print(my2DMaze[r][c + 1].ifPlayer);

	      }
	      System.out.println();
	    }
	    System.out.println();
  }
  
  public int moveInverter(int move) {
	  int inversion = 0;
	  
	  switch (move) {
	  case 0: 
		  inversion = 2;
		  break;
	  case 1:
		  inversion = 3;
		  break;
	  case 2:
		  inversion = 0;
		  break;
	  case 3:
		  inversion = 1;
	  }
	  return inversion;
  }
  
  public Room adjacentRoom(int move) {
	  
	  Room adjacent = null;
	  
	  switch (move) {
	  case 0: 
		 return my2DMaze[p1.getY()-1][p1.getX()];
	  case 1:
		  return my2DMaze[p1.getY()][p1.getX()+1];
	  case 2:
		  return my2DMaze[p1.getY()+1][p1.getX()];
	  case 3:
		  return my2DMaze[p1.getY()][p1.getX()-1];
	  }
	  
	  return adjacent;
  }
  
}
