package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddingUsersPage {

	WebDriver driver;
	
	public AddingUsersPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public  Select UserRole() {
		Select Role = new Select(driver.findElement(By.id("systemUser_userType")));
		return Role;
	}

	public WebElement EmployeeName() {
		return driver.findElement(By.name("systemUser[employeeName][empName]"));
	}

	public WebElement UserName() {
		return driver.findElement(By.name("systemUser[userName]"));
	}

	public Select Status() {
		Select status = new Select(driver.findElement(By.name("systemUser[status]")));
		return status;
	}

	public WebElement Password() {
		return driver.findElement(By.name("systemUser[password]"));
	}

	public WebElement ConfirmPassword() {
		return driver.findElement(By.name("systemUser[confirmPassword]"));
	}

	public WebElement SaveButton() {
		return driver.findElement(By.id("btnSave"));
	}

	public WebElement CancelButton() {
		return driver.findElement(By.id("btnCanel"));
	}
	
	static public void setUserParameters(UserManagementPage UMP, WebDriver driver, String Empname, String Usrname, String password, String confirmPassword, String UsrRole, String Status) {
		AddingUsersPage addUser = new AddingUsersPage(driver);
		addUser.EmployeeName().sendKeys(Empname);
		addUser.EmployeeName().sendKeys(Keys.ENTER);
		addUser.UserName().sendKeys(Usrname);
		addUser.Password().sendKeys(password);
		addUser.ConfirmPassword().sendKeys(confirmPassword);
		
		if (UsrRole == ("Admin") && Status == ("Enabled")) {
			addUser.UserRole().selectByVisibleText("Admin");
			addUser.Status().selectByVisibleText("Enabled");
		}
		else if (UsrRole == ("Admin") && Status == ("Disabled")) {
			addUser.UserRole().selectByVisibleText("Admin");
			addUser.Status().selectByVisibleText("Disabled");
		}
		else if (UsrRole == ("ESS") && Status == ("Enabled")) {
			addUser.UserRole().selectByVisibleText("ESS");
			addUser.Status().selectByVisibleText("Enabled");
		}
		else if (UsrRole == ("ESS") && Status == ("Disabled")) {
			addUser.UserRole().selectByVisibleText("ESS");
			addUser.Status().selectByVisibleText("Disabled");
		}
		
	}

}
