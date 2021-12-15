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
	
	private boolean correctAnswer = false; //default false
	
	
	public Question(String theQuestion, boolean isTom, String theAnswer) {
		this.myQuestion = theQuestion;
		this.myTom =  isTom;
		this.myAnswer = theAnswer;
	}
	
	public void setCorrectAnswer(final boolean theAns) {
	  this.correctAnswer = theAns;
	}
	
	/**
	 * Gets the correct answer for test question.
	 *
	 * @return the correct answer
	 */
	public boolean getCorrectAnswer() {
		return correctAnswer;
	}
	
	/**
	 * Gets the question from SQLite database question set.
	 *
	 * @return the question
	 */
	public String getQuestion() {
		return myQuestion;
	}
	
	/**
	 * Gets the answer for SQLite question.
	 *
	 * @return the answer
	 */
	public String getAnswer() {
		return myAnswer;
	}
	
	/**
	 * Gets the tom boolean value (checks if question for tom class or not).
	 *
	 * @return the tom
	 */
	public boolean getTom() {
		return myTom;
	}
	
	//abstract void queryFromTable();
	
	public void displayQuestion() {
		System.out.println("Question: " + getQuestion());
		System.out.println("Answer: " + getAnswer());
		System.out.println("isTom Question: " + getTom() + "\n");
	}

	/**
	 * Question prompt MC for test question.
	 *
	 * @param theResponse the the response
	 * @return true, if successful
	 */
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
					//correctAnswer = false;
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
	
//	public boolean questionPromptMC(final Scanner theResponse) {
//      MultipleChoiceQuestion mc = null;
//      getQuestion();
//      boolean done = false;
//
//      //added try block. Will catch InputMismatchException when user enters the word answer instead of the answer number.
//      try {
//          while (done == false) {
//              String enter = theResponse.next();
//              if (enter == getAnswer()) {
//                  correctAnswer = true;
//                  done = true;
//              } else if (enter == mc.getMyWrongAns1() || enter == mc.getMyWrongAns2() || enter == mc.getMyWrongAns3()) {
//                  correctAnswer = false;
//                  done = true;
//              } else {
//                  System.out.println("invalid response; try again.");
//              }
//          }
//      } catch (InputMismatchException e) {
//          System.out.println("Please enter the number of the answer.");
//      }
//      
//      return correctAnswer;
//  }

}
