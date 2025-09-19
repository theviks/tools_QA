package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.WidgetsPage;
import testBase.BaseClass;

public class TC_W1 extends BaseClass {

	@Test
	public void datePicker() throws InterruptedException {
		logger.info("*** Testing started for TC_W1 ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickWidge();
		
		WidgetsPage wp = new WidgetsPage(driver);
		wp.clickDatePicker();
		wp.selectDate("August", "1996", "30");
		Assert.assertEquals(wp.verify(), "07/30/1996");
		wp.clickDateAndTime();
		wp.selectDates("July", "1996", "24","13:00");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Testing Completed for TC_W1 ***");
	}
}
