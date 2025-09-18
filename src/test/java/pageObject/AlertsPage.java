package pageObject;

import java.util.Set;

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
	@FindBy(xpath="//div[@id='framesWrapper']//div[@id='frame1Wrapper']/iframe") WebElement frame1;
	@FindBy(xpath="//h1[@id='sampleHeading']") WebElement framesResult;
	
	// New Window
	@FindBy(xpath="//span[normalize-space()='Browser Windows']") WebElement selectBrowserWindows;
	@FindBy(xpath="//button[@id='windowButton']") WebElement newWindows;
	@FindBy(xpath="//h1[@id='sampleHeading']") WebElement verifyText;
 	
	
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
		js.executeScript("arguments[0].scrollIntoView();", frames);
		frames.click();
		driver.switchTo().frame(frame1);
	}
	
	public String resultFrames() {
		
		return framesResult.getText();
	}
	
	//Windows
	public void selectWindows() {
		js.executeScript("arguments[0].scrollIntoView();", selectBrowserWindows);
		selectBrowserWindows.click();	
	}
	
	public void clickNewWindows() {
		newWindows.click();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String windowHandle : allWindows) {
		    if (!windowHandle.equals(parentWindow)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
	}
	
	public String verifyWindows() {
		return verifyText.getText();
	}

	
	
}
