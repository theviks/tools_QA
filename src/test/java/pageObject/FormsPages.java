package pageObject;

import java.util.List;

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
	
	@FindBy(xpath="//div[@class='css-1g6gooi']/div/input[@id='subjectsInput']") WebElement selectSubject;
	

	public void selectPractice() {
		formPractice.click();
	}
	
	public void userFirstName(String fName) {
		firName.sendKeys(fName);
	}
	
	public void userLastName(String lName) {
		lasName.sendKeys(lName);
	}
	
	public void userEmail(String email) {
		usrEmail.sendKeys(email);
	}
	
	public void radSelect() {
		radMale.click();
	}
	
	public void phoneNo(String no) {
		usrPhone.sendKeys(no);
	}
	
	// Date of Birth Selecting using DropDown and Table
	public void dateOfBirth() {
		dob.click();
	}
	public void dobMonth(String dMonth) {
		Select se = new Select(month);
		se.selectByVisibleText(dMonth);
	}
	public void dobYear(String dYear) {
		Select se = new Select(year);
		se.selectByVisibleText(dYear);
	}
	
	public void dateSelect(String date) {
		for(WebElement day : dates) {
			if(day.getText().equals(date)) {
				day.click();
				break;
			}
		}
	}
	
	public void subjectSelection(String sub) {
		selectSubject.sendKeys(sub);
	}
}
