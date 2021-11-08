/**
 * 
 */
package maze;

//import java.util.Scanner;

/**
 * @author stephg02
 *
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    //boolean done = false;
    int loop = 0;
    Maze m1 = new Maze();
    Door dr = new Door();
    Player p1 = new Player();
    
    
    while (loop != 5) {
      System.out.println("# rows: " + m1.getRows() + ", # columns: " + m1.getColumns());
      
      if (loop == 0) {
        m1.startMaze();
      } else {
        m1.makeMazeOfRooms();
      }
      
      
        m1.displayMaze();
      
      //System.out.println("");
      p1.playerMove();
      
//      if (m1.get2DMaze()[m1.getRows()][m1.getColumns()] == rm.displayPlayerInRoom()) {
//        //player in last room
//        System.out.println("Reached end of the maze! Congrats");
//        break; //exits the while loop
//      }
      
      dr.openDoorQuestion();
      dr.doorOpenOrLocked();
      
      loop++;
    }
    
  }

}
