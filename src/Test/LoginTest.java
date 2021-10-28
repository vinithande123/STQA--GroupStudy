package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import quiz.Ui;

class LoginTest {

	@Test
	public void validLoginTest() {
		String username = "vinit";
		String password = "vinit";
		
		Assert.assertEquals(true,Ui.login(username, password));
		System.out.println("Login test case passed\n");
	}
	
	@Test
	public void invalidLoginTest() {
		String username = "vinit";
		String password = "rushabh";
		
		Assert.assertEquals(false,Ui.login(username, password));
		System.out.println("Invalid Login credentials test case passed\n");
	}
	
}
