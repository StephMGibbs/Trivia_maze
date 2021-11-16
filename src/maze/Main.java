/**
 * 
 */
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
	
	boolean again = true;
	  
	while (again) {
    Maze m1 = new Maze();
    m1.startMaze();
    again = m1.endMaze();
	}
    
  }

}
