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
	
	@FindBy(xpath="//button[@id='confirmButton']") WebElement cnfAlertBtn;
	@FindBy(xpath="//span[@id='confirmResult']") WebElement confirmResult;
	@FindBy(xpath="//button[@id='promtButton']") WebElement promtAlert;
	@FindBy(xpath="//span[@id='promptResult']") WebElement promtResult;
	
	//Frames
	@FindBy(xpath="//span[normalize-space()='Frames']") WebElement frames;
	@FindBy(xpath="//div[@id='framesWrapper']") WebElement frame1;
	@FindBy(xpath="//h1[@id='sampleHeading']") WebElement framesResult;
	
	
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void selectAlert() {
		js.executeScript("arguments[0].scrollIntoView();", clickAlert);
		clickAlert.click();
	}
	
	public void clickAlertBrtn() {
		alerBtn.click();
	}
	
	public void clickConfirmAlert() {
		cnfAlertBtn.click();
	}
	
	public String result() {
		return confirmResult.getText();
	}
	
	public void clickPromptAlert() {
		promtAlert.click();
	}
	
	public String resultPrompt() {
		return promtResult.getText();
	}
	
	//Frames
	public void switchToFrame() {
		frames.click();
//		driver.switchTo().frame(frame1);
	}
	
	public String resultFrames() {
		return framesResult.getText();
	}
	
	
}
