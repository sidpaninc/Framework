package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readProperties {

	public static void main(String[] args) {
		 try {
			FileReader file= new FileReader("C:\\Users\\user\\eclipse-workspace\\automation_framework\\seleniumFramework\\src\\test\\resources\\configfiles\\config.properties");
			Properties prop= new Properties();
			
			prop.load(file);
			System.out.println(prop.getProperty("browser"));
			System.out.println(prop.getProperty("url"));
			
		 } catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
