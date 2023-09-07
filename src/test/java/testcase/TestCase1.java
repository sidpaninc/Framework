package testcase;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.DataProviderHolder;

import base.baseTest;
import base.Xpaths;
import base.Methods;
import utilities.readData;

public class TestCase1 extends baseTest {
	
	//@Test(dataProviderClass =utilities.readData.class, dataProvider = "testData")
	@Test(dataProvider = "testData1")
	public static void login_test(String username, String password) {
		try {
			Methods m=new Methods();
			Xpaths x=new Xpaths();
			SoftAssert sa=new SoftAssert();
			
			
			Thread.sleep(3000);
			
			//Finding username & sending value
			if (m.check_if_available(x.username)) {
				WebElement user_name = m.get_element(x.username);
				m.click_element(user_name);
				m.type_text(username, user_name);
				System.out.println("User name typed");
				m.set_wait_time_and_wait(3);
				Reporter.log("User name typed");
			}
			
			//Finding the password field & sending password
			if (m.check_if_available(x.password)) {
				WebElement pass_word = m.get_element(x.password);
				m.click_element(pass_word);
				m.type_text(password, pass_word);
				System.out.println("Password typed");
				m.set_wait_time_and_wait(3);
				Reporter.log("Password typed");
			}
			
			//Finding the password field & sending password
			if (m.check_if_enabled(x.login_button)) {
				WebElement log_in = m.get_element(x.login_button);
				m.click_element(log_in);
				System.out.println("Logged in!!!!");
				m.set_wait_time_and_wait(3);
				Reporter.log("Logged in!!!!");
			}
			
			//Verifying the page name
			String exp_title="Swag Labs";
			String actual_title=m.get_title();
			sa.assertEquals(actual_title, exp_title, "");
			sa.assertAll();
			Reporter.log("Page title verified");
			
			
			//Finding the MENU & clicking it
			WebElement menu_button = m.get_element(x.menu_button);
			m.click_element(menu_button);
			System.out.println("Menu clicked");
			m.set_wait_time_and_wait(3);
			Reporter.log("Menu clicked to log out!!");
			
			
			//Logging out
			m.set_wait_time_and_wait(3);
			if (m.check_if_available(x.logout)) {
				WebElement logout = m.get_element(x.logout);
				m.click_element(logout);
				System.out.println("Logged out!!!!!!");
				m.set_wait_time_and_wait(3);
				Reporter.log("Logged out!!");
			}
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	//Supplying data using Data provider in testNG
		@DataProvider(name="testData1")
		public Object[][] dataset1() {
			return new Object[][] {
				{"standard_user","secret_sauce"},
				{"problem_user","secret_sauce"},
				{"performance_glitch_user","secret_sauce"}
				};
			}

}
