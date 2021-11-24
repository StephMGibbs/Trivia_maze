/**
 * 
 */
package maze;

import java.util.Scanner;

/**
 * @author stephg02
 *
 */
public class Question {
  //Question source: https://icebreakerideas.com/video-game-trivia/
  
  public boolean correctAnswer;
  
  public boolean questionPromptMC(final Scanner theResponse) {
    System.out.println("What's the first commercially successful video game?: \n1.Pong \n2.Tank \n3.Spacewar! \n4.Tennis for Two \n");
    boolean done = false;
    //boolean correctAnswer = false;
    
    while (done == false) {
      int enter = theResponse.nextInt();
    
      if (enter == 1) {
        correctAnswer = true;
        done = true;
      } else if (enter == 2 || enter == 3 || enter == 4) {
        correctAnswer = false;
        done = true;
      } else {
        System.out.println("invalid response; try again.");
      }
    }
    
    //System.out.println("Your answer was: " + correctAnswer);
    
    return correctAnswer;
  }
  
  public boolean getAnswer() {
    return correctAnswer;
  }
  
}
