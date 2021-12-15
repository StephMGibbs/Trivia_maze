package maze;

public class TrueFalse extends Question {
	
	private int myFalseAns;
	
	public TrueFalse(String theQuestion, boolean isTom, int theAnswer, int theFalseAns) {
		super(theQuestion, isTom, theAnswer);
		this.myFalseAns = theFalseAns;
	}
	
	public int getFalseAns() {
		return myFalseAns;
	}
	
	@Override
	public void displayQuestion() {
		System.out.println("Question: " + getQuestion());
		System.out.println("Answer: " + getAnswer());
		System.out.println("Wrong Answer: " + getFalseAns());
		System.out.println("isTom Question: " + getTom() + "\n");
	}
}
