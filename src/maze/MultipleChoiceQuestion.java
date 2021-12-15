package maze;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleChoiceQuestion extends Question {
	
	private final String myWrongAns1;
	private final String myWrongAns2;
	private final String myWrongAns3;
	
	public MultipleChoiceQuestion(final String theQuestion, final boolean isTom, final String theAnswer, final String theWrongAns1, final String theWrongAns2, final String theWrongAns3) {
		super(theQuestion, isTom, theAnswer);
		this.myWrongAns1 = theWrongAns1;
		this.myWrongAns2 = theWrongAns2;
		this.myWrongAns3 = theWrongAns3;
	}
	
	public String getMyWrongAns1() {
		return myWrongAns1;
	}

	public String getMyWrongAns2() {
		return myWrongAns2;
	}

	public String getMyWrongAns3() {
		return myWrongAns3;
	}
	
	
}
