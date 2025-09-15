package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]") WebElement ele;
	
	@FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[2]") WebElement forms;
	
	@FindBy(xpath="//h5[normalize-space()='Alerts, Frame & Windows']") WebElement alerts;
	
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void clickElement() {
		ele.click();
	}
	
	public void clickForms() {
		forms.click();
	}
	
	public void clickAlert() {
		js.executeScript("arguments[0].scrollIntoView();", alerts);
		alerts.click();
	}
}
