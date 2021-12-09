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
  public boolean myDoorLock;
  
  private Question myQuestion;
  
  private String doorView;
  
  /**
   * Gets the door status after answering questions.
   *
   * @return the door status
   */
  
  public Door(Question theQuestion) {
	  this.myQuestion = theQuestion;
	  doorView = "| |";
  }
  
  public Door(Question theQuestion, boolean locked) {
	  this.myQuestion = theQuestion;
	  myDoorLock = locked;
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
    return myDoorLock;
  }
  
  public void openDoorQuestion() {
    Scanner scnr = new Scanner(System.in);
    q.questionPromptMC(scnr);
    
    myDoorStatus = q.getCorrectAnswer();
    
  }
  
  public void doorOpenOrLocked() {
    if (getDoorStatus() == true) {
      //System.out.println("Door is open!");
      myDoorLock = false;
    } else {
      //System.out.println("Door is closed!");
      myDoorLock = true;
    }
  }
  
  public Question getQuestion() {
	  return q;
  }
  
}