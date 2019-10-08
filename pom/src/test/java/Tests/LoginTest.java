package Tests;

import org.testng.annotations.Test;

import BaseClass.BaseClass;

public class LoginTest extends BaseClass {

	@Test
	public void getUrl(){
		initialize();
		driver.navigate().refresh();
		
	}
	
}
