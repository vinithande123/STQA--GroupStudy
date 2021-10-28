package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import quiz.Ui1;

class SignUp {

	
	@Test
	public void validSignUpTest() {
		String username = "vinit";
		String password = "vinit";
		String mobile="7448050960";
		String email="v@gmail.com";
		Assert.assertEquals(true,Ui1.signUp(username, password,mobile,email));
		System.out.println("SignUp test case passed\n");
	}
	
	@Test
	public void invalidSignUpTest() {
		String username = "rushabh";
		String password = "rushabh";
		String mobile="7448050960";
		String email="r@gmail.com";
		Assert.assertEquals(false,Ui1.signUp(username, password,mobile,email));
		System.out.println("Invalid SignUp credentials test case passed\n");
	}
	

}
