package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


/********* 
 * 
 * This contains the implementation of different methods that can be handy while writing scripts.
 * I. Methods for actions like click, type,check if available, refresh etc
 * II. Methods for different kind of waits
 * III. Methods for different kind of alerts
 * IV. Methods using JAVASCRIPT
 * V. Methods for SELECT class
 * VI. Methods using ROBOT keys
 *  
 **********/

public class Methods extends baseTest implements MethodList {
	
	/*SOME IMPORTANT DECLAIRATIONS USED IN FORTHCOMING METHODS*/
	
	public WebDriverWait wait = null;
	public ArrayList<String> windows=new ArrayList<>();
	
	
	//I. Methods for actions like click, type,check if available, refresh etc
	
	public By get_element(String strategy, String path) {
		switch(strategy) {
		
		case "xpath":	
			return By.xpath(path);
		case "id":	
			return By.id(path);
		case "cssSelector":	
			return By.cssSelector(path);
		case "className":	
			return By.className(path);
		case "linkText":	
			return By.linkText(path);
		case "name":	
			return By.name(path);
		case "partialLinkText":	
			return By.partialLinkText(path);
		case "tagName":	
			return By.tagName(path);
		default:
			return null;
		}
	}
	
	
	//Passing Xpath as argument
	public  WebElement get_element(String xpath) {
		try {
			WebElement element=driver.findElement(By.xpath(xpath));
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Passing WebElement as argument
	public  void click_element(WebElement ele) {
		try {
			ele.click();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Passing xpath as argument
	public void click_element(String xpath) {
		try {
			get_element(xpath).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Passing text to text field with WebElement as argument
	public void type_text(String text, WebElement ele) {
		try {
			ele.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Passing text to text field with Xpath
	public void type_text(String text, String xpath) {
		try {
			driver.findElement(By.xpath(xpath)).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Clearing text from a text field with WebElement as argument
	public void clear_text(String text, WebElement ele) {
		try {
			ele.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	//Clearing text from a text field with Xpath
	public void clear_text(String text, String xpath) {
		try {
			driver.findElement(By.xpath(xpath)).clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Getting text from an element with webelement as argument
	public String get_text(WebElement ele) {
		try {
			return ele.getText();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	
	// Getting text from an element with Xpath as argument
	public String get_text(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath)).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	
	// Getting text from an element with Xpath as argument
		public String get_title() {
			try {
				return driver.getTitle();
			} catch (Exception e) {
				e.printStackTrace();
				return "Error";
			}
		}
	
	
	
	// Checking if an element is available with webelement as argument
	public boolean check_if_available(WebElement ele) {
		try {
			return ele.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Checking if an element is available with Xpath as argument
	public boolean check_if_available(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath)).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Getting attribute of an element with Xpath as argument
	public String get_attribute(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath)).getAttribute(xpath);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	
	//Refresh the page
	public void refresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Going to one page back/previous page
	public void back_page() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Going to one page forward/next page
	public void next_page() {
		try {
			driver.navigate().forward();
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Verify the page title
	public boolean verify_page_title(String expected_title) {
		try {
			// wait_for_the_page_to_be_loaded();
			String actual_title = driver.getTitle();
			if (expected_title.equals(actual_title)) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Verify the page title using Assert class
	public void assert_page_title(String expected_title) {
		try {
			// wait_for_the_page_to_be_loaded();
			SoftAssert sa=new SoftAssert();
			String actual_title = driver.getTitle();
			sa.assertEquals(actual_title, expected_title);
			sa.assertAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	// Checking if an element is available with webelement as argument
	public boolean check_if_enabled(WebElement ele) {
		try {
			return ele.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Checking if an element is available with xpath as argument
	public boolean check_if_enabled(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath)).isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Capturing Screenshot
		public void getScreenShot() throws IOException {
			try {
				Date currentDate = new Date();
				String ssfileName=currentDate.toString().replace(" ","-").replace(":","-");
				//File  ssfileName+"Report"= new File(".//screenshot"); 
				File screenShot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenShot, new File(".//screenshot//"+ssfileName+".png"));
			} catch (WebDriverException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	/*END OF STANDARD SELENIUM FUNCTIONS*/
	
	/*II. METHODS FOR DIFFERENT KIND OF "WAITS" */
	
	//Implementing explicit wait
		public void wait(int second) {
				try {
					long duration = second * 1000;
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	
		//Creating wait with WebDriverWait
		public void set_wait(int second) {
			wait=new WebDriverWait(driver, Duration.ofSeconds(second));
			
		}
		
		//Creating and waiting with WebDriverWait
		public WebDriverWait set_wait_time_and_wait(int second) {
			set_wait(second);
			return wait;
		}
	
		//Wait for the element to be visible 
		public void wait_for_element_to_be_visible(WebElement ele,  int second) {
			 set_wait_time_and_wait(second).until(ExpectedConditions.visibilityOf(ele));
		}
		
		public void wait_for_element_to_be_visible(String xpath,  int second) {
			 set_wait_time_and_wait(second).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		}
		
		public void wait_for_element_to_be_visible(WebElement ele) {
			wait_for_element_to_be_visible(ele,120);
		}
		
		public void wait_for_element_to_be_visible(String xpath) {
			wait_for_element_to_be_visible(xpath,120);
		}
		
	//Wait for the element to be invisible 
		public void wait_for_element_to_be_invisible(WebElement ele, int second) {
			set_wait_time_and_wait(second).until(ExpectedConditions.invisibilityOf(ele));
		}
	
		public void wait_for_element_to_be_invisible(String xpath, int second) {
			set_wait_time_and_wait(second).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		}
	
		public void wait_for_element_to_be_invisible(WebElement ele) {
			wait_for_element_to_be_invisible(ele, 120);
		}
	
		public void wait_for_element_to_be_invisible(String xpath) {
			wait_for_element_to_be_invisible(xpath, 120);
		}
	
	// Wait for the element to be clickable
		public void wait_for_element_to_be_clickable(WebElement ele, int second) {
			set_wait_time_and_wait(second).until(ExpectedConditions.elementToBeClickable(ele));
		}
	
		public void wait_for_element_to_be_clickable(String xpath, int second) {
			set_wait_time_and_wait(second).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		}
	
		public void wait_for_element_to_be_clickable(WebElement ele) {
			wait_for_element_to_be_invisible(ele, 120);
		}
	
		public void wait_for_element_to_be_clickable(String xpath) {
			wait_for_element_to_be_invisible(xpath, 120);
		}
		
	// Wait for the element to be clickable
		public void wait_for_refreshed_element_to_be_clickable(WebElement ele, int second) {
			set_wait_time_and_wait(second).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ele)));
		}

		public void wait_for_refreshed_element_to_be_clickable(String xpath, int second) {
			set_wait_time_and_wait(second).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(get_element(xpath))));
		}

		public void wait_for_refreshed_element_to_be_clickable(WebElement ele) {
			wait_for_refreshed_element_to_be_clickable(ele, 120);
		}

		public void wait_for_refreshed_element_to_be_clickable(String xpath) {
			wait_for_refreshed_element_to_be_clickable(xpath, 120);
		}

		// Wait for the other window to be visible & switch
		// Switch to another window
		public void switch_to_window(int window) {
			if(windows.size()<1) {
				windows.add(0, driver.getWindowHandle());
			}
			
			Set<String> childWindow=driver.getWindowHandles();
			if(window<windows.size()) {
				windows.remove(window+1);
			}
			for(Object obj: childWindow) {
				String popUpHandle=obj.toString();
				if(!windows.contains(popUpHandle)) {
					windows.add(windows.size(), popUpHandle);
				}
			}
			driver.switchTo().window(windows.get(window));
			driver.manage().window().maximize();
			
		}
		
		public void wait_for_windows(int second, int windows) {
			set_wait_time_and_wait(second)
					.until(ExpectedConditions.numberOfWindowsToBe(windows));
		}
		
		public void wait_for_windows(int windows) {
			wait_for_windows(120, windows);
		}
		
		public void wait_and_switch_to_child_windows() {
			wait_for_windows(120, 2);
			switch_to_window(1);
		}

		/*END OF "WAIT" SELENIUM FUNCTIONS*/
		
		/*III. METHODS FOR DIFFERENT KIND OF "ALERTS" */
		
		public void wait_for_alert_to_be_present() {
			set_wait_time_and_wait(120).until(ExpectedConditions.alertIsPresent());
		}
		
		public void wait_and_accept_alert() {
			driver.switchTo().alert().accept();
		}
		
		public boolean is_alert_present() {
			try {
				wait_and_accept_alert();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		/*END OF "ALERTS" SELENIUM METHODS*/
		
		
		
		/*IV. METHODS USING "JAVASCRIPT"*/
		
		//Clicking an element using Javascript
		public void js_click(WebElement ele) {
			try {
				((JavascriptExecutor)driver).executeScript("$(arguments[0]).click()", ele);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void js_click(String xpath) {
			try {
				js_click(get_element(xpath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void js_wait_and_click(WebElement ele) {
			try {
				wait_for_element_to_be_visible(ele);
				js_click(ele);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Hovering over a element using Javascript
		public void js_mouse_hover(WebElement ele) {
			try {
				((JavascriptExecutor)driver).executeScript("$(arguments[0]).mouseover()", ele);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void js_mouse_hover(String xpath) {
			try {
				js_mouse_hover(get_element(xpath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Hovering over a element using Javascript
		public void js_scroll_to_element(WebElement ele) {
			try {
				((JavascriptExecutor) driver).executeScript("$(arguments[0]).scrollIntoView(true)", ele);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void js_scroll_to_element(String xpath) {
			try {
				js_scroll_to_element(get_element(xpath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Highlight an element using Javascript
		public void js_highlight_element(WebElement ele) {
			try {
				((JavascriptExecutor) driver).executeScript("$(arguments[0]).style.backgroundColor= 'yellow';", ele);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void js_highlight_element(String xpath) {
			try {
				js_highlight_element(get_element(xpath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*END OF "JAVASCRIPT" SELENIUM FUNCTIONS*/


		

		
		/*V. METHODS USING "SELECT" CLASS*/
		public Select select_element(WebElement ele) {
			return new Select(ele);
		}
		
		public Select select_element(String xpath) {
			return select_element(get_element(xpath));
		}
		
		public void select_by_visible_text(String xpath, String text) {
			select_element(xpath).selectByVisibleText(text);
		}
		
		//Choosing value from a drop down by value
		public void select_by_value(String xpath, String value) {
			select_element(xpath).selectByValue(value);
		}
		
		public void select_by_value(WebElement ele, String value) {
			select_element(ele).selectByValue(value);
		}
		
		// Choosing value from a drop down by index
		public void select_by_index(String xpath, int index) {
			select_element(xpath).selectByIndex(index);;
		}

		public void select_by_index(WebElement ele, int index) {
			select_element(ele).selectByIndex(index);
		}
		
		// Get the text of a selected option 
		public String get_selected_option_text(WebElement ele) {
			return select_element(ele).getFirstSelectedOption().getText();
			
		}

		public String get_selected_option_text(String xpath) {
			return select_element(xpath).getFirstSelectedOption().getText();
		}
		
		
		/*END OF METHODS USING "SELECT" CLASS*/
		
		
		
		/*VI. METHODS USING "ROBOT" KEYS*/
		
		//Copying to clip-board
		public void copy_to_clipboard(String text) {
			StringSelection stringselection=new StringSelection(text);
			Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringselection, stringselection);
		}
		
		// Pressing enter
		public void enter_Robot() {
			try {
				Robot rb = new Robot();
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}

		}
		
		//Copying
		public void copy_Robot() {
			try {
				Robot rb=new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_C);
				rb.keyRelease(KeyEvent.VK_C);
				rb.keyRelease(KeyEvent.VK_CONTROL);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
		}
		
		//Pasting
		public void paste_Robot() {
			try {
				Robot rb=new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_CONTROL);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
		}
		
		//Zooming in
		public void zoom_in_Robot() {
			try {
				Robot rb=new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_PLUS);
				rb.keyRelease(KeyEvent.VK_PLUS);
				rb.keyRelease(KeyEvent.VK_CONTROL);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
		}
		//Zooming out
		public void zoom_out_Robot() {
			try {
				Robot rb=new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_MINUS);
				rb.keyRelease(KeyEvent.VK_MINUS);
				rb.keyRelease(KeyEvent.VK_CONTROL);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
		}
		
		//Going to a text field using tabs
		public void send_tab_robot(int num) throws InterruptedException {
			try {
				Robot rb=new Robot();
				for(int i=0;i<num;i++) {
					rb.keyPress(KeyEvent.VK_TAB);
					rb.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(2000);
				}
				
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
		}
		
		//Going down using key
		public void send_down_robot(int num) throws InterruptedException {
			try {
				Robot rb=new Robot();
				for(int i=0;i<num;i++) {
					rb.keyPress(KeyEvent.VK_DOWN);
					rb.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(2000);
				}
				
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
		}
		
		//Going right using key
		public void send_right_robot(int num) throws InterruptedException {
			try {
				Robot rb=new Robot();
				for(int i=0;i<num;i++) {
					rb.keyPress(KeyEvent.VK_RIGHT);
					rb.keyRelease(KeyEvent.VK_RIGHT);
					Thread.sleep(2000);
				}
				
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
		}
		
		
		/*END OF METHODS USING "ROBOT" KEYS*/
	
		/**************************************END*********************************************/
	
	
	
	
	
	
	
	

}
