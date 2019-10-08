package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public BaseClass(){
		 try {
			fis =new FileInputStream("C://Users//Vallabhaneni//git//pom//pom//resources//config.properties");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 prop = new Properties();
		 try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialize(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
}
