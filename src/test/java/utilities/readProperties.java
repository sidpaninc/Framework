package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readProperties {
	
	private String browser;
	private String url;
	
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public void fetchProperty() {
		 try {
			 
			//For windows
				//reader=new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\config.properties");
				//For AWS
			FileReader file= new FileReader(System.getProperty("user.dir")+ "/src/test/resources/configfiles/config.properties");
			Properties prop= new Properties();
			
			prop.load(file);
			
			setBrowser(prop.getProperty("browser"));
			setUrl(prop.getProperty("url"));
			
			//System.out.println(prop.getProperty("browser"));
			//System.out.println(prop.getProperty("url"));
			
		 } catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
