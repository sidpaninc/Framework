package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readProperties {
	
	public Properties getProperties() throws IOException {
		FileReader file= new FileReader(System.getProperty("user.dir")+ "/src/test/resources/configfiles/config.properties");
		Properties prop= new Properties();
		prop.load(file);
		return prop;
	} 
	
	private String browser;
	private String url;
	
	public String getBrowser() throws IOException {
		Properties prop=getProperties();
		this.browser=prop.getProperty("browser");
		return browser;
	}

	public String getUrl() throws IOException {
		Properties prop= getProperties();
		this.url=prop.getProperty("url");
		return url;
	}
	
}
