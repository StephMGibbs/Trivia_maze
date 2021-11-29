/**
 * 
 */
/**
 * 
 */
package maze;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

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
	
	Scanner scanner = new Scanner(System.in);
	
	String selectionBuffer = null;
	
	int trueSelection = 0;
	
	Maze m1;
	
	while (trueSelection != 1 && trueSelection!= 2) {
	do {
	System.out.print("Select an option:\n"
					+ "New Game: 1\n"
					+ "Continue: 2\n");
	selectionBuffer = scanner.next();
	} while(!isInteger(selectionBuffer));
	trueSelection = Integer.parseInt(selectionBuffer);
	}
	
	
	
	if (trueSelection == 2) {
		File file = new File("Maze.ser");
		if (file.length() != 0) {
			m1 = Serializer.deserialize();
			m1.startMaze();
			again = m1.endMaze();
		}
		else {
			System.out.println("No save data found, starting New Game.");
		}
	}
	  
	while (again) {
	System.out.println("\nNew game started!\n");
    m1 = new Maze();
    m1.startMaze();
    again = m1.endMaze();
	}
    
  }

  public static boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch(NumberFormatException e ) {
	        return false;
	    }
	}
  
}
