package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import quiz.Ui2;

class ExamRegistration {

	
	@Test
	public void validExamRegistrationTest() {
		String firstName = "vinit";
		String lastName = "hande";
		String age = "20";
		String gender = "Male";
		String address = "amravati";
		String city = "amravati";
		String state = "maharashtra";
		String country = "india";
		
		Assert.assertEquals(true,Ui2.registration(firstName, lastName,age, gender,address, city,state, country));
		System.out.println("Exam Registration test case passed\n");
	}
	
	@Test
	public void invalidExamRegistrationTest() {
		String firstName = "vinit";
		String lastName = "hande";
		String age = "21";
		String gender = "Male";
		String address = "amravati";
		String city = "nagpur";
		String state = "karnataka";
		String country = "india";
		
		Assert.assertEquals(false,Ui2.registration(firstName, lastName,age, gender,address, city,state, country));
		System.out.println("Invalid Exam Registration test case passed\n");
	}
	

}
