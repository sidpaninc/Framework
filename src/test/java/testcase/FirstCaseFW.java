package testcase;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.baseTest;
import utilities.readXLSData;
import base.Xpaths;
import base.Methods;

public class FirstCaseFW extends baseTest {
	
	@Test(dataProviderClass =readXLSData.class, dataProvider = "testData")
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
			}
			
			//Finding the password field & sending password
			if (m.check_if_available(x.password)) {
				WebElement pass_word = m.get_element(x.password);
				m.click_element(pass_word);
				m.type_text(password, pass_word);
				System.out.println("Password typed");
				m.set_wait_time_and_wait(3);
			}
			
			//Finding the password field & sending password
			if (m.check_if_enabled(x.login_button)) {
				WebElement log_in = m.get_element(x.login_button);
				m.click_element(log_in);
				System.out.println("Logged in!!!!");
				m.set_wait_time_and_wait(3);
			}
			
			//Verifying the page name
			String exp_title="Swag Labs";
			String actual_title=m.get_title();
			sa.assertEquals(actual_title, exp_title, "");
			sa.assertAll();
			
			//Finding the MENU & clicking it
			if (m.check_if_available(x.menu_button)) {
				WebElement menu_button = m.get_element(x.menu_button);
				m.click_element(menu_button);
				System.out.println("Menu clicked");
				m.set_wait_time_and_wait(3);
			}
			
			//Logging out
			if (m.check_if_available(x.logout)) {
				WebElement logout = m.get_element(x.logout);
				m.click_element(logout);
				System.out.println("Logged out!!!!!!");
				m.set_wait_time_and_wait(3);
			}
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
