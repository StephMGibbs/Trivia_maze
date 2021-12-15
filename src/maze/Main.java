/**
 * 
 */
/**
 * 
 */
package maze;

import java.io.File;
import java.io.IOException;
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
	
	Maze myMaze;
	
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
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (file.length() != 0) {
			myMaze = Serializer.deserialize();
			myMaze.getMyPlayer().scannerReset();
			again = runMaze(myMaze);
		}
		else {
			System.out.println("No save data found, starting New Game.");
		}
	}
	  
	while (again) {
	System.out.println("\nNew game started!\n");
    myMaze = new Maze();
    again = runMaze(myMaze);
	}
	
	scanner.close();
    
  }
  
  public static boolean runMaze(Maze myMaze) {
	  String result = "";
	  while ((!result.equals("complete")) && (!result.equals("incomplete"))) {
		  result = myMaze.startMaze();
		  if (result.equals("save")) {
			  Serializer.serialize(myMaze);
		  }
	  }
	  
	  return myMaze.endMaze();
	  
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
