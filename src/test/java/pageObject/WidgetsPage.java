package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WidgetsPage extends BasePage {

	public WidgetsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='Date Picker']") WebElement datePicker;
	@FindBy(xpath="//input[@id='datePickerMonthYearInput']") WebElement date;
	@FindBy(xpath="//select[@class='react-datepicker__month-select']") WebElement month;
	@FindBy(xpath="//select[@class='react-datepicker__year-select']") WebElement year;
	@FindBy(xpath="//div[@role='listbox']/descendant::div") List<WebElement> day;
	@FindBy(xpath="//input[@id='datePickerMonthYearInput']") WebElement verifyDate;
	
	
	public void clickDatePicker() {
		datePicker.click();
	}
	
	//First Date Picker 
	public void selectDate(String mon, String yer,String da) {
		date.click();
		//Month
		month.click();
		Select sc = new Select(month);
		sc.selectByVisibleText(mon);
		//Year
		year.click();
		sc = new Select(year);
		sc.selectByVisibleText(yer);
		
		for(WebElement days : day) {
			if(days.getText().equalsIgnoreCase(da)) {
				days.click();
				break;
			}
		}
	}
	
	public String verify() {
		return verifyDate.getAttribute("value");
	}
	
	
}
