package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormsPages extends BasePage {
	
	public FormsPages(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='Practice Form']") WebElement formPractice;
	@FindBy(xpath="//input[@id='firstName']") WebElement firName;
	@FindBy(xpath="//input[@id='lastName']") WebElement lasName;
	@FindBy(xpath="//input[@id='userEmail']") WebElement usrEmail;
	@FindBy(css="label[for='gender-radio-1']") WebElement radMale;
	@FindBy(xpath="//input[@id='userNumber']") WebElement usrPhone;
	@FindBy(xpath="//input[@id='dateOfBirthInput']") WebElement dob;
	@FindBy(xpath="//select[@class='react-datepicker__month-select']") WebElement month;
	@FindBy(xpath="//select[@class='react-datepicker__year-select']") WebElement year;
	@FindBy(xpath="//div[@role='listbox']//div/div") List<WebElement> dates;
	
	//Subject
	@FindBy(xpath="//div[@class='css-1g6gooi']/div/input[@id='subjectsInput']") WebElement selectSubject;
	@FindBy(xpath="//div[@class='subjects-auto-complete__menu css-26l3qy-menu']//div/div") List<WebElement> subList;
	
	//Hobbies
	@FindBy(xpath="//div[@class='col-md-9 col-sm-12']//div[@class='custom-control custom-checkbox custom-control-inline']") List<WebElement> selectHobbies;
	
	//Address
	@FindBy(xpath="//textarea[@id='currentAddress']") WebElement currAdd;
	@FindBy(xpath="//div//div[@class=' css-1hwfws3']//div[text()='Select State']") WebElement selectState;
	@FindBy(xpath="//div//div[@class=' css-11unzgr']/div") List<WebElement> 	state;	
	@FindBy(xpath=" //div/div[@class=' css-1wa3eu0-placeholder']") 	WebElement selectCity;
	@FindBy(xpath="//div/div[@class=' css-11unzgr']/div") List<WebElement> 	city;

	//Submit Button
	@FindBy(xpath="//button[@id='submit']") WebElement btnSubmit;
	@FindBy(xpath="//div[@class='modal-header']") WebElement verify;


	public void selectPractice() {
		formPractice.click();
	}
//Name	
	public void userName(String fName,String lName) {
		firName.sendKeys(fName);
		lasName.sendKeys(lName);
	}
//Email	
	public void userEmail(String email) {
		usrEmail.sendKeys(email);
	}
	
//Gender 
	public void gender() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", radMale);
		radMale.click();
	}
	
//Mobile Number	
	public void phoneNo(String no) {
		usrPhone.sendKeys(no);
	}
	
// Date of Birth Selecting using DropDown and Table
	public void dateOfBirth(String dMonth, String dYear, String date) {
		dob.click();
		//Month
		Select se = new Select(month);
		se.selectByVisibleText(dMonth);
		//Year
		 se = new Select(year);
		se.selectByVisibleText(dYear);
		//Date
		for(WebElement day : dates) {
			if(day.getText().equals(date)) {
				day.click();
				break;
			}
		}
		
	}
	
//Selecting subject from Hidden DropDrown 
	public void subjectSelection(String sub) {
		selectSubject.sendKeys(sub);
		
		for(WebElement subL:subList) {
			if(subL.getText().equalsIgnoreCase(sub)) {
				subL.click();
				break;
			}
		}
	}
	
// Hobbies	
	public void hobbies() {
		for(WebElement hob:selectHobbies) {
			hob.click();
			break;
		}
	}
	
//Address	
	public void address(String address,String stateName,String cityName) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", currAdd);
		
		currAdd.sendKeys(address);
		//State
		selectState.click();
		
		for(WebElement states : state) {
			if(states.getText().equalsIgnoreCase(stateName)){
				states.click();
				break;
			}
		}
		
		//City
		selectCity.click();
		
		for(WebElement citys : city) {
			if(citys.getText().equalsIgnoreCase(cityName)) {
				citys.click();
				break;
			}
		}		
	}

	
	public void submit() {
		btnSubmit.click();
	}
	
	public boolean verifySubmition() {
		return verify.isDisplayed();
	}
	
	
}
