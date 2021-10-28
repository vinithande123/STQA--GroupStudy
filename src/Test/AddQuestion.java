package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import quiz.GenerateQuiz;

class AddQuestion {

	@Test
	public void validAddQuestionTest() {
		String question = "capital of india";
		String option1 = "delhi";
		String option2 = "pune";
		String option3 = "mumbai";
		String option4 = "kolkata";
		String answer = "A";
		
		Assert.assertEquals(true,GenerateQuiz.addQuestion(question, option1, option2, option3, option4, answer));
		System.out.println("Add Question test case passed\n");
	}
	
	@Test
	public void invalidAddQuestionTest() {
		String question = "capital of india";
		String option1 = "delhi";
		String option2 = "pune";
		String option3 = "mumbai";
		String option4 = "kolkata";
		String answer = "D";
		
		Assert.assertEquals(false,GenerateQuiz.addQuestion(question, option1, option2, option3, option4, answer));
		System.out.println("Invalid Add question test case passed\n");
	}

}
