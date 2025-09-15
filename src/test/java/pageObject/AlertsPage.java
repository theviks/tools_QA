package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {

	public AlertsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='Alerts']") WebElement clickAlert;
	
	@FindBy(xpath="//button[@id='alertButton']") WebElement alerBtn;
	
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void selectAlert() {
		js.executeScript("arguments[0].scrollIntoView();", clickAlert);
		clickAlert.click();
	}
	
	public void clickAlertBrtn() {
		alerBtn.click();
	}
	
	
}
