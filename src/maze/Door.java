/**
 * 
 */
package maze;

import java.util.Scanner;

/**
 * @author stephg02
 *
 */
public class Door {
  
  /** When the user answers a question, it is true (correct answer) or false (wrong answer).
   * Used to help myDoorHasLocked figure out when to close the door. 
   */
  private boolean myAnswer;
  
  /** The door lock; false = open & true = closed. */
  private boolean myDoorHasLocked;
  
  /**
   * Instantiates a new door constructor. All doors default open (false).
   */
  public Door() {
    this.myDoorHasLocked = false;
  }
  
  /**
   * Gets the door lock; sees if closed or open.
   *
   * @return the door lock
   */
  public boolean getDoorLock() {
    return myDoorHasLocked;
  }
  
  public void openDoorQuestion() {
    Scanner scnr = new Scanner(System.in);
    Question q = new Question();
    q.questionPromptMC(scnr);
    
    myAnswer = q.getAnswer();
    
  }
  
  public void doorOpenOrLocked() { //myDoorHasLocked setter essentially
    if (myAnswer == true) {
//      System.out.println("Your answer was Correct!");
      System.out.println("Door is opened! Continue to next room!");
      myDoorHasLocked = false;
    } else {
//      System.out.println("Your answer was Wrong!");
      System.out.println("Door is locked permentatly; try a different door!");
      myDoorHasLocked = true;
    }
  }
  
}
