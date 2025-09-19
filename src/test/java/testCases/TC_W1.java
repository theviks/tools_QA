package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.WidgetsPage;
import testBase.BaseClass;

public class TC_W1 extends BaseClass {

	@Test
	public void datePicker() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.clickWidge();
		
		WidgetsPage wp = new WidgetsPage(driver);
		wp.clickDatePicker();
		wp.selectDate("August", "1996", "30");
		Assert.assertEquals(wp.verify(), "07/30/1996");
	}
}
