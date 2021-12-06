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
  
  /** The door status; false = closed & true = open. */
  public boolean myDoorStatus;
  
  /** The door lock; false = open & true = closed. */
  public boolean isDoorLocked;
  
  private Question q;
  
  private String doorView;
  
  /**
   * Gets the door status after answering questions.
   *
   * @return the door status
   */
  
  public Door() {
	  q = new Question();
	  doorView = "| |";
  }
  
  public Door(boolean locked) {
	  q = new Question();
	  isDoorLocked = locked;
	  doorView = "|X|";
  }
  
  public boolean getDoorStatus() {
    return myDoorStatus;
  }
  
  /**
   * Gets the door lock; sees if closed or open.
   *
   * @return the door lock
   */
  public boolean getDoorLock() {
    return isDoorLocked;
  }
  
  public void openDoorQuestion() {
    Scanner scnr = new Scanner(System.in);
    q.questionPromptMC(scnr);
    
    myDoorStatus = q.getAnswer();
    
  }
  
  public void doorOpenOrLocked() {
    if (getDoorStatus() == true) {
      //System.out.println("Door is open!");
      isDoorLocked = false;
    } else {
      //System.out.println("Door is closed!");
      isDoorLocked = true;
    }
  }
  
  public Question getQuestion() {
	  return q;
  }
  
}