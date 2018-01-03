package quizCards;

public class QuizCard {
	private String question;
	private String answer;
	
	public QuizCard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return "QuizCard [question=" + question + ", answer=" + answer + "]";
	}
}
