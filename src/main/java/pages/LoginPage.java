package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	private WebDriver driver;
	private By emailField = By.xpath("//*[@id='example-input-group-1']/input");
	private By passwordField = By.xpath("//*[@id='example-input-group-2']/input");
	private By loginButton = By.xpath("//button[contains(text(), 'Sign In')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage(WebDriver driver, String format) {
	}

	public void setEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	
	public DashboardPage clickLoginButton() {
		setEmail("cctestuser4@yopmail.com");
		setPassword("CCTest@2021");
		driver.findElement(loginButton).click();
		return new DashboardPage(driver);
	}
}