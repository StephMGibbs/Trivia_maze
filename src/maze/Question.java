/**
 * 
 */
package maze;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author stephg02
 *
 */
public class Question implements Serializable {
	// Question source: https://icebreakerideas.com/video-game-trivia/

	private static final long serialVersionUID = -2669902720185681207L;
	
	public boolean correctAnswer;

	public boolean questionPromptMC(final Scanner theResponse) {
		System.out.println(
				"What's the first commercially successful video game?: \n1.Pong \n2.Tank \n3.Spacewar! \n4.Tennis for Two \n");
		boolean done = false;

		//added try block. Will catch InputMismatchException when user enters the word answer instead of the answer number.
		try {
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
		} catch (InputMismatchException e) {
			System.out.println("Please enter the number of the answer.");
		}
		
		return correctAnswer;
	}

	public boolean getAnswer() {
		return correctAnswer;
	}

}
