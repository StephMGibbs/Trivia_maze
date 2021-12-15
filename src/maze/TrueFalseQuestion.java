package maze;

public class TrueFalseQuestion extends Question {
	
	private final String myFalseAns;

	public TrueFalseQuestion(final String theQuestion, final boolean isTom, final String theCorrectAns, final String theFalseAns) {
		super(theQuestion, isTom, theCorrectAns);
		this.myFalseAns = theFalseAns;	
	}
	
	public String getFalseAns() {
		return myFalseAns;
	}
}
