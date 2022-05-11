package LogInTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.UserManagementPage;


public class LoginTest {

	public static void main(String[] args) throws InterruptedException {

		//initializations
		//---------------------------------------------------------------------------------------------------------
		String user = null;
		System.setProperty("webdriver.chrome.driver","/home/ghassen/Desktop/Selenium Setup/chromedriver");   
		WebDriver driver = new ChromeDriver();
		UserManagementPage UMP = new UserManagementPage(driver,user);
		String baseURL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		driver.get(baseURL);
		
		//---------------------------------------------------------------------------------------------------------

		String currentPage = LoginPage.LoginOperation(driver);
		boolean loginStatus;
		
		loginStatus = LoginPage.loginCheck(driver,currentPage);	
		
		if (loginStatus == true) {
		//Uncomment the following block to search a user in DB
		UMP.SearchUser(UMP,driver,"Alice_Duval");


		//Uncomment the following block to add a user to DB	         
		//UMP.clickAddButton();
		//AddingUsersPage.setUserParameters(UMP, driver, "ada", "Usrname", "1234", "1234", "ESS", "Enabled");

		Thread.sleep(500);

		CloseChrome(driver);
		}
		else //driver.close();
		
		
		CloseChrome(driver);
	}

	
	public static void CloseChrome(WebDriver driver) {
		driver.close();
	}
}
