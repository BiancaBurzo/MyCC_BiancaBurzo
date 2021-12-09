package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private WebDriver driver;
	private By statusAlert = By.id("flash");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	  public String getAlertText(){
	        return driver.findElement(statusAlert).getText();
	    }
}

