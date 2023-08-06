
package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface MethodList {
	
	   				/*********I. METHODS FOR BASIC SELENIUM ACTIONS LIKE CLICK, TYPE,REFRESH ETC*********/

	// Getting an element using different stratgies
	By get_element(String strategy, String path);

	// Passing Xpath as argument
	WebElement get_element(String xpath);

	// Passing WebElement as argument
	public void click_element(WebElement ele);

	// Passing xpath as argument
	public void click_element(String xpath);

	// Passing text to text field with WebElement as argument
	public void type_text(String text, WebElement ele);

	// Passing text to text field with Xpath
	public void type_text(String text, String xpath);

	// Clearing text from a text field with WebElement as argument
	public void clear_text(String text, WebElement ele);

	// Clearing text from a text field with Xpath
	public void clear_text(String text, String xpath);

	// Getting text from an element with webelement as argument
	public String get_text(WebElement ele);

	// Getting text from an element with Xpath as argument
	public String get_text(String xpath);

	// Checking if an element is available with webelement as argument
	public boolean check_if_available(WebElement ele);

	// Checking if an element is available with Xpath as argument
	public boolean check_if_available(String xpath);

	// Getting attribute of an element with Xpath as argument
	public String get_attribute(String xpath);

	// Refresh the page
	public void refresh();

	// Going to one page back/previous page
	public void back_page();

	// Going to one page forward/next page
	public void next_page();

	// Verify the page title
	public boolean verify_page_title(String expected_title);

	// Verify the page title using Assert class
	public void assert_page_title(String expected_title);

	// Checking if an element is available with webelement as argument
	public boolean check_if_enabled(WebElement ele);

	// Checking if an element is available with xpath as argument
	public boolean check_if_enabled(String xpath);

							/********* II. METHODS FOR DIFFERENT KIND OF "WAITS" *********/

	// Implementing explicit wait
	public void wait(int second);

	// Creating wait with WebDriverWait
	public void set_wait(int second);

	// Creating and waiting with WebDriverWait
	public WebDriverWait set_wait_time_and_wait(int second);

	// Wait for the element to be visible
	public void wait_for_element_to_be_visible(WebElement ele, int second);

	public void wait_for_element_to_be_visible(String xpath, int second);

	public void wait_for_element_to_be_visible(WebElement ele);

	public void wait_for_element_to_be_visible(String xpath);

	// Wait for the element to be invisible
	public void wait_for_element_to_be_invisible(WebElement ele, int second);

	public void wait_for_element_to_be_invisible(String xpath, int second);

	public void wait_for_element_to_be_invisible(WebElement ele);

	public void wait_for_element_to_be_invisible(String xpath);

	// Wait for the element to be clickable
	public void wait_for_element_to_be_clickable(WebElement ele, int second);

	public void wait_for_element_to_be_clickable(String xpath, int second);

	public void wait_for_element_to_be_clickable(WebElement ele);

	public void wait_for_element_to_be_clickable(String xpath);

	// Wait for the element to be clickable
	public void wait_for_refreshed_element_to_be_clickable(WebElement ele, int second);

	public void wait_for_refreshed_element_to_be_clickable(String xpath, int second);

	public void wait_for_refreshed_element_to_be_clickable(WebElement ele);

	public void wait_for_refreshed_element_to_be_clickable(String xpath);

	// Switch to another window
	public void switch_to_window(int window);

	public void wait_for_windows(int windows);

	public void wait_and_switch_to_child_windows();

							/********* III. METHODS FOR DIFFERENT KIND OF "ALERTS" *********/

	public void wait_for_alert_to_be_present();

	public void wait_and_accept_alert();

	public boolean is_alert_present();

								/*********  IV. METHODS USING "JAVASCRIPT" *********/

	// Clicking an element using Javascript
	public void js_click(WebElement ele);

	public void js_click(String xpath);

	public void js_wait_and_click(WebElement ele);

	// Hovering over a element using Javascript
	public void js_mouse_hover(WebElement ele);

	public void js_mouse_hover(String xpath);

	// Hovering over a element using Javascript
	public void js_scroll_to_element(WebElement ele);

	public void js_scroll_to_element(String xpath);

	// Highlight an element using Javascript
	public void js_highlight_element(WebElement ele);

	public void js_highlight_element(String xpath);

										/******** V. METHODS USING "SELECT" CLASS ********/

	public Select select_element(WebElement ele);

	public Select select_element(String xpath);

	// Selecting a value from the visible text
	public void select_by_visible_text(String xpath, String text);

	// Choosing value from a drop down by value
	public void select_by_value(String xpath, String value);

	public void select_by_value(WebElement ele, String value);

	// Choosing value from a drop down by index
	public void select_by_index(String xpath, int index);

	public void select_by_index(WebElement ele, int index);

	// Get the text of a selected option
	public String get_selected_option_text(WebElement ele);

	public String get_selected_option_text(String xpath);

										/*********VI. METHODS USING "ROBOT" KEYS ********/

	// Copying to clip-board
	public void copy_to_clipboard(String text);

	// Pressing enter
	public void enter_Robot();

	// Copying
	public void copy_Robot();

	// Pasting
	public void paste_Robot();

	// Zooming in
	public void zoom_in_Robot();

	// Zooming out
	public void zoom_out_Robot();

	// Going to a text field using tabs
	public void send_tab_robot(int num) throws InterruptedException;

	// Going down using key
	public void send_down_robot(int num) throws InterruptedException;

	// Going right using key
	public void send_right_robot(int num) throws InterruptedException;

				/**************************************END*********************************************/

}