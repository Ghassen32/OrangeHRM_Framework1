package Pages;

import org.junit.Assert;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserManagementPage {

	WebDriver driver;
	String user;
	
	public UserManagementPage(WebDriver driver, String user){
	this.driver = driver;
	this.user = user;
	}

	public WebElement Admin() {
		return driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/a/b"));
	}                                       ///html/body/div[1]/div[2]/ul/li[1]/a/b
	                                   
	
	public WebElement UsernameField() {
		return driver.findElement(By.name("searchSystemUser[userName]"));
	}
	
	public WebElement AddButton() {
		return driver.findElement(By.name("btnAdd"));
	}

	public WebElement DeleteButton() {
		return driver.findElement(By.id("btnDelete"));
	}

	public WebElement SearchButton() {
		return driver.findElement(By.id("searchBtn"));
	}

	public WebElement ResetButton() {
		return driver.findElement(By.id("resetBtn"));
	}

	public void clickAddButton() {
		Admin().click();
		AddButton().click();
	}
	
	public void SearchUser(UserManagementPage UMP, WebDriver driver, String user){
		
		UMP.Admin().click();
		UMP.UsernameField().sendKeys(user);
		UMP.SearchButton().click();
	       
		
		if (driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr/td[2]/a")).isDisplayed())
			JOptionPane.showMessageDialog(null, "User found!","Information",JOptionPane.INFORMATION_MESSAGE);
		else 
			JOptionPane.showMessageDialog(null, "User NOT found!","Error",JOptionPane.ERROR_MESSAGE);
			 
		driver.close();
	}

}

	/*
	 public void setUserParameters(String UsrRole, String Status) {
		if (UsrRole == ("Admin") && Status == ("Enabled")) {

		}
	 */

