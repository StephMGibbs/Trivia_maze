/**
 * 
 */
package maze;


/**
 * @author stephg02
 *
 */
public class Maze {
  
  private int myRows = 3;
  
  private int myColumns = 3;
  
  private String[][] my2DMaze;
  
  private int myRoomCount = 0;
  
  private Room myRoom;
  
  private Door myDoor;
  
  private Player myPlayer;
  
  public Maze() {
    myRoom = new Room();
    myDoor = new Door();
    myPlayer = new Player();
  }
  
  
  public int getRows() {
    return myRows;
  }
  
  public int getColumns() {
    return myColumns;
  }
  
  public void makeMazeOfRooms() {
    
    my2DMaze = new String[myRows + 2][myColumns + 2]; // makes 2D array w/ rows and columns
    // +2 for a buffer
    
    for (int r = 1; r < my2DMaze.length - 1; r++) { // row 1 because buffer
      // starts at row 0 & plus 1 to print the last row
      //final String enterField = SCNR.next();

      for (int c = 0; c < myColumns; c++) { // column
         //TODO: add methods to check for certain positions in maze
        closedRoomInMaze(r, c);
        
      }
      
      //after check if start/end was called
      if (myPlayer.getX() == 1 && myPlayer.getY() == 1 && myRoomCount == 1) { //starting
        my2DMaze[1][1] = myRoom.displayPlayerInRoom();
        myRoomCount++;
        
      } else if (myRoomCount == 5) { //ending
        my2DMaze[myRows][myColumns] = myRoom.displayPlayerInRoom();
      }
      
      //System.out.println(); //goes next row after column done
    }
    System.out.println();
    
  }
  
  public void closedRoomInMaze(final int r, final int c) {
    if (myDoor.getDoorLock() == true) { //true = locked
      my2DMaze[r][c + 1] = myRoom.displayClosedRoom();
    }else {
      my2DMaze[r][c + 1] = myRoom.displayEmptyRoom();
    }
  }
  
  public void startMaze() {
    myRoomCount++;
    makeMazeOfRooms();
  }
  
  public void endMaze() {
    myRoomCount = 5;
    makeMazeOfRooms();
  }
  
  public void displayMaze() {
    
    for (int n = 1; n < my2DMaze.length - 1; n++) { // n = 1 to not include
      // buffer whitespace
      for (int m = 1; m < my2DMaze[0].length - 1; m++) { // m = 1 to not
        // include buffer        
        System.out.print(my2DMaze[n][m]);                
      }
      
      System.out.println(); // next row starts printing
    }
    System.out.println();
  }
  
}
