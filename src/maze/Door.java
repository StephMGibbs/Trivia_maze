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
  public boolean myDoorIsLocked;
  
  private Question myQuestion;
  
  private String doorView;
  
  /**
   * Gets the door status after answering questions, instantiates question & door open.
   *
   * @param theQuestion the the question
   * @return the door status
   */
  
  public Door() { //Question theQuestion
	  //this.myQuestion = theQuestion;
	  doorView = "| |";
  }
  
  /**
   * Instantiates a new door; locks door closed (true), else open (false).
   *
   * @param theQuestion the the question
   * @param locked the locked
   */
  public Door(boolean locked) { //Question theQuestion,
	  //this.myQuestion = theQuestion;
	  myDoorIsLocked = locked;
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
    return myDoorIsLocked;
  }
  
  public void openDoorQuestion() {
    Scanner scnr = new Scanner(System.in);
    //Test question stuff
    //q.questionPromptMC(scnr);
    //myDoorStatus = q.getCorrectAnswer();
    
    //SQL stuff
    myQuestion.getQuestion();
    String response = scnr.next();
    if (response == myQuestion.getAnswer()) {
      myQuestion.setCorrectAnswer(true);
    }
    
    myDoorStatus = myQuestion.getCorrectAnswer();
  }
  
  public void doorOpenOrLocked() {
    if (getDoorStatus() == true) {
      //System.out.println("Door is open!");
      myDoorIsLocked = false;
    } else {
      //System.out.println("Door is closed!");
      myDoorIsLocked = true;
    }
  }
  
  
//  public Question getQuestion() {
//	  return q;
//  }
  
}