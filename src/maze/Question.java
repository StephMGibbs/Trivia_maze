/**
 * 
 */
package maze;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author stephg02, mtaesc
 *
 */
public class Question {
	// Question source: https://icebreakerideas.com/video-game-trivia/

	private String myQuestion;
	private boolean myTom;
	private String myAnswer;
	private boolean correctAnswer;
	
	
	public Question(String theQuestion, boolean isTom, String theAnswer) {
		this.myQuestion = theQuestion;
		this.myTom =  isTom;
		this.myAnswer = theAnswer;
	}
	
	public boolean getCorrectAnswer() {
		return correctAnswer;
	}
	
	public String getQuestion() {
		return myQuestion;
	}
	
	public String getAnswer() {
		return myAnswer;
	}
	
	public boolean getTom() {
		return myTom;
	}
	
	//abstract void queryFromTable();

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

}
