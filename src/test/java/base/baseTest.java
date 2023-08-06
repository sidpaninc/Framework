package base;

//import org.openqa.selenium.;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest{
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static FileReader reader;
	LocalDateTime myObj ;
	
	@BeforeTest
	public void set_up() throws IOException, InterruptedException {
			System.out.println("This is start of the test case at "+LocalDateTime.now());
			//For windows
			//reader=new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\config.properties");
			//For AWS
			reader=new FileReader(System.getProperty("user.dir")+ "/src/test/resources/configfiles/config.properties");
			prop.load(reader);
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
			
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
	}
	
	
	@AfterTest
	public void tear_down() {
		//driver.close();
		driver.quit();
	}
	
	

}
