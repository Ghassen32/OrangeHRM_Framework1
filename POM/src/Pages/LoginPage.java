package Pages;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {

	static WebDriver driver;
	static WebElement ErrorMsg ;
	
	
	static public WebElement Usernamefield(WebDriver driver) {
		return driver.findElement(By.id("txtUsername"));
	}
	
	static public WebElement Passwordfield(WebDriver driver) {
		return driver.findElement(By.id("txtPassword"));
	}
	
	static public WebElement LoginButton(WebDriver driver) {
		return driver.findElement(By.name("Submit"));
	}
	
	static public String LoginOperation(WebDriver driver){
		LoginPage.Usernamefield(driver).sendKeys("Admin");
		LoginPage.Passwordfield(driver).sendKeys("admin123");
		LoginPage.LoginButton(driver).click();
		return driver.getCurrentUrl();
		
		//ErrorMsg = driver.findElement(By.xpath("//*[@id=\"spanMessage\"]"));
	}
	
	static public boolean loginCheck(WebDriver driver, String currentPage) {
		//LoginOperation(driver);
		String mainPage = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		
		int retry = 0;
		if (currentPage.equals(mainPage)) {
			//driver.close();
			return true;
			
		}
		else {
			do {
				LoginOperation(driver);
				retry ++;
			}
			while(retry <2);
			JOptionPane.showMessageDialog(null, "Wrong Credentials, Please check your credentials!");
			//driver.close();
			return false;
			
		} 
	
			
		
	}
	
}

