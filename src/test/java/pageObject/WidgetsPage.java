package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WidgetsPage extends BasePage {

	 private JavascriptExecutor js;
	 private Actions act; 
	
	public WidgetsPage(WebDriver driver) {
		super(driver);
		 this.driver = driver;
	     this.js = (JavascriptExecutor) driver;
	     this.act = new Actions(driver);
	}
	
	/*-------------------------------------------------------Date and Time Picker ------------------------------------------------------------------------*/
	void selectYearFuture(int myYear) {
        String targetYear = String.valueOf(myYear);

        while (true) {
            boolean found = false;
            for (WebElement year : yearsList) {
                if (year.getText().equals(targetYear)) {
                    year.click();
                    found = true;
                    break;
                }
            }
            if (found) break;
            upcoming.click(); // go forward
        }
    }
	
	 void selectYearPast(int myYear) {
	        String targetYear = String.valueOf(myYear);

	        while (true) {
	            boolean found = false;
	            for (WebElement year : yearsList) {
	                if (year.getText().equals(targetYear)) {
	                    year.click();
	                    found = true;
	                    break;
	                }
	            }
	            if (found) break;
	            js.executeScript("arguments[0].scrollIntoView();", previous);
	            previous.click(); // go backward
	        }
	    }

	@FindBy(xpath="//span[normalize-space()='Date Picker']") WebElement datePicker;
	@FindBy(xpath="//input[@id='datePickerMonthYearInput']") WebElement date;
	@FindBy(xpath="//select[@class='react-datepicker__month-select']") WebElement month;
	@FindBy(xpath="//select[@class='react-datepicker__year-select']") WebElement year;
	@FindBy(xpath="//div[@role='listbox']/descendant::div") List<WebElement> day;
	@FindBy(xpath="//input[@id='datePickerMonthYearInput']") WebElement verifyDate;
	
	//Date and Time Picker
	@FindBy(xpath="//input[@id='dateAndTimePickerInput']") WebElement dateAndTime;
	
	//Months
	@FindBy(xpath="//span[contains(@class,'month-read-view--down-arrow')]") WebElement monthDropDown;
	@FindBy(xpath="//div[@class='react-datepicker__month-dropdown']/div") List<WebElement> months;
	@FindBy(xpath="//span[contains(@class,'view--selected-month')]") WebElement currentMonth;
	
	//Years
	@FindBy(xpath="//span[contains(@class,'view--selected-year')]") WebElement currentYear;
	@FindBy(xpath="//span[contains(@class,'year-read-view--down-arrow')]") WebElement yearsDropDown;
	@FindBy(xpath="//a[contains(@class,'years-upcoming')]") WebElement upcoming;
	@FindBy(xpath="//a[contains(@class,'years-previous')]") WebElement previous;
	@FindBy(xpath="//div[@class='react-datepicker__year-dropdown']//div[position()>=2 and position() <= 12]") List<WebElement> yearsList;
	
	//DaySelection
	@FindBy(xpath="//div[@role='listbox']//div") List<WebElement> selectDay;
 	//Time
	@FindBy(xpath="//ul[contains(@class,'time-list')]/li") List<WebElement> time;
	
	//Methods for Operations
	public void clickDatePicker() {
		datePicker.click();
	}
	
	//Date Picker 
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
	//Verify Date Picker Output
	public String verify() {
		return verifyDate.getAttribute("value");
	}
	
	//Date & Time Picker
	public void clickDateAndTime() {
		dateAndTime.click();
	}
	
	public void selectDates(String mon,String yer,String day,String hours) {
		
		//Month
		monthDropDown.click();
		for(WebElement mont : months) {
			if(mont.getText().equalsIgnoreCase(mon)) {
				mont.click();
				break;
			}
		}
		
		String currYear = currentYear.getText();
		//Year
		yearsDropDown.click();
		if(currYear.equals(yer)) {
			for(WebElement years : yearsList) {
				years.click();
				break;
			}
		}else {
			Integer curYear = Integer.parseInt(currYear);
			Integer myYear = Integer.parseInt(yer);
			if(curYear < myYear) {
				selectYearFuture( myYear);
			}
			else {
				selectYearPast(myYear);
			}
		}
		
		//date
		for(WebElement days : selectDay) {
			if(days.getText().equals(day)) {
				days.click();
				break;
			}
		}
		//Time
		for(WebElement times : time) {
			if(times.getText().equalsIgnoreCase(hours)) {
				times.click();
				break;
			}
		}
		
		
	}
	/*--------------------------------------------------------------------Slider-----------------------------------------------------------------------------*/
	@FindBy(xpath="//span[normalize-space()='Slider']") WebElement slider;
	@FindBy(xpath="//input[@type='range']") WebElement sliderBar;
	@FindBy(xpath="//input[@id='sliderValue']") WebElement value;
	
	public void clickSlide() {
		slider.click();
	};
	
	public void moveSlider() {
	    act.dragAndDropBy(slider, 150, 0).perform();
	    System.out.println(value.getAttribute("value"));
	}
	
	
	
	
	
	
}
