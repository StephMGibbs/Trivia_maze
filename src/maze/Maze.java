package maze;

import java.io.Serializable;
import java.util.Scanner;

/**
 * @author stephg02
 *
 */
public class Maze implements Serializable { 
  
  private static final long serialVersionUID = -4086095372506263454L;

  private int myRows = 3;
  
  private int myColumns = 3;
  
  private Room[][] my2DMaze;
  
  private Player myPlayer;
  
  //private transient final Scanner SCNR = new Scanner(System.in);
  
  public Maze() {
	  myPlayer = new Player();
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
  
  public String startMaze() {
	  
	  boolean stillPossible = true;
	  
	  while (!(my2DMaze[myRows][myColumns].ifPlayer.equals("[o]")) && stillPossible) {
	      
	      displayMaze();
	      
	      my2DMaze[myPlayer.getY()][myPlayer.getX()].displayEmptyRoom();
	      
	      int move = myPlayer.playerMove();
	      
	      if (move > 3) {
	    	  
	    	  my2DMaze[myPlayer.getY()][myPlayer.getX()].displayPlayerInRoom();
	    	  return "save";
	      }
	      
	      if (my2DMaze[myPlayer.getY()][myPlayer.getX()].cardinalDoors[move].getDoorStatus()) {
	    	  myPlayer.moveSuccess(move);
	      }
	      else if (!my2DMaze[myPlayer.getY()][myPlayer.getX()].doorLocked(move)) {
	    	  
	    	  Door dr = my2DMaze[myPlayer.getY()][myPlayer.getX()].cardinalDoors[move];
	      
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
	       myPlayer.moveSuccess(move);
	      }
	      
	      }
	      
	      else {
	    	  if (move < 4) System.out.println("The path is blocked.");
	    	  if (move == 4) saveGame();
	      }
	      my2DMaze[myPlayer.getY()][myPlayer.getX()].displayPlayerInRoom();
	    }
	  if (stillPossible) {
		  System.out.println("Reached end of the maze! Congrats");
		  return "complete";
	  }
	  else {
		  System.out.println("You have locked yourself from reaching the exit, good luck next time!");
		  return "incomplete";
	  }
	  
  }
  
  public Player getMyPlayer() {
	return myPlayer;
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
	  	case 0: my2DMaze[myPlayer.getY()-1][myPlayer.getX()].displayClosedRoom();
	  		break;
	  	case 1: my2DMaze[myPlayer.getY()][myPlayer.getX()+1].displayClosedRoom();
	  		break;
	  	case 2: my2DMaze[myPlayer.getY()+1][myPlayer.getX()].displayClosedRoom();
	  		break;
	  	case 3: my2DMaze[myPlayer.getY()][myPlayer.getX()-1].displayClosedRoom();
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
		 return my2DMaze[myPlayer.getY()-1][myPlayer.getX()];
	  case 1:
		  return my2DMaze[myPlayer.getY()][myPlayer.getX()+1];
	  case 2:
		  return my2DMaze[myPlayer.getY()+1][myPlayer.getX()];
	  case 3:
		  return my2DMaze[myPlayer.getY()][myPlayer.getX()-1];
	  }
	  
	  return adjacent;
  }
  
  public void saveGame() {
	  Serializer.serialize(this);
  }
  
}
