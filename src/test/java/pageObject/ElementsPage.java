package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

	public ElementsPage(WebDriver driver){
		super(driver);
	}
	
	//TextBox
	@FindBy(xpath="//span[normalize-space()='Text Box']") WebElement textBox;
	@FindBy(xpath="//input[@id='userName']") WebElement usrName;
	@FindBy(xpath="//input[@id='userEmail']") WebElement usrEmail;
	@FindBy(xpath="//textarea[@id='currentAddress']") WebElement currAddress;
	@FindBy(xpath="//textarea[@id='permanentAddress']") WebElement perAddress;
	@FindBy(xpath="//button[@id='submit']") WebElement submitBtn;
	@FindBy(xpath="//div[@id='output']/div") WebElement verify;
	
	// CheckBox
	@FindBy(xpath="//span[normalize-space()='Check Box']") WebElement checkBox;
	@FindBy(css=".rct-icon.rct-icon-uncheck") WebElement chkBox;
	@FindBy(xpath="//div[@id='result']") WebElement verifyClick;
	
	// Radio Button
	@FindBy(xpath="//span[normalize-space()='Radio Button']") WebElement radioBtn;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement yesBtn;
	@FindBy(xpath="//p[@class='mt-3']") WebElement verifyRadio;
	
	
	//TextBox
	public void selectTextBox() {
		textBox.click();
	}
	
	public void selectUsrName(String name) {
		usrName.sendKeys(name);
	}
	
	public void selectUsrEmail(String email) {
		usrEmail.sendKeys(email);
	}
	
	public void selectCurrAddress(String curAd) {
		currAddress.sendKeys(curAd);
	}
	
	public void selectPerAddress(String perAd) {
		perAddress.sendKeys(perAd);
	}
	public void submitBt() {
		submitBtn.click();
	}
	public boolean verifySubmit() {
		return(verify.isDisplayed());
	}
	
	// CheckBox
	public void selectCheckBox() {
		checkBox.click();
	}
	
	public void clickChkBox() {
		chkBox.click();
	}
	
	public boolean verifyCheck() {
		return(verifyClick.isDisplayed());
	}
	
	//Radio Button
	public void selectRadioBtn() {
		radioBtn.click();
	}
	
	public void yes() {
		yesBtn.click();
	}
	
	public boolean verifyRadioClick() {
		return(verifyRadio.isDisplayed());	
	}
	
	
	
	
}
