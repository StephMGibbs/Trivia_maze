/**
 * 
 */
package maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author stephg02, mtaesc
 *
 */
public class Question {
	// Question source: https://icebreakerideas.com/video-game-trivia/
	
	private static ArrayList<Question> questionArray = new ArrayList<>();
	
	private static Queue<Question> questionQueue = new LinkedList<Question>();

	private String myQuestion;
	
	private boolean myTom;
	
	private int myAnswer;
	
	private boolean correctAnswer = false; //default false
	
	
	public Question(String theQuestion, boolean isTom, int theAnswer) {
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
	public int getAnswer() {
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
	
	public static void randomizeQuestions() {
		Collections.shuffle(questionArray);
		for (int i = 0; i < questionArray.size(); i++) {
			Question q = questionArray.get(i);
			questionQueue.add(q);
		}
	}

	public static Question getRandQuestion() {
		Question randQ = questionQueue.poll();
		questionQueue.add(randQ);
		return randQ;
	}

	/**
	 * Question prompt MC for test question.
	 *
	 * @param theResponse the the response
	 * @return true, if successful
	 */
	public boolean questionPromptMC(final Scanner theResponse) {
//		System.out.println(
//				"What's the first commercially successful video game?: \n1.Pong \n2.Tank \n3.Spacewar! \n4.Tennis for Two \n");
		System.out.println("Question: " + getQuestion());
		boolean done = false;

		//added try block. Will catch InputMismatchException when user enters the word answer instead of the answer number.
		try {
			while (done == false) {
				int input = theResponse.nextInt();
				int answer = getAnswer();
				if (input == answer) {
					correctAnswer = true;
					done = true;
				} else if (input != answer) {//TODO: FIXME 
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