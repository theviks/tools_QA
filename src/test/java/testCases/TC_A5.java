package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AlertsPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_A5 extends BaseClass {

	@Test
	public void windows() throws InterruptedException {
		logger.info("*** Starting TC_A5 ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickAlert();
		AlertsPage ap = new AlertsPage(driver);
		
		ap.selectWindows();
		ap.clickNewWindows();
		logger.info("*** Verfication for TC_A5 ***");
		Assert.assertEquals(ap.verifyWindows(), "This is a sample page");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		logger.info("*** Testing Completed for TC_A5 ***");
	}
}
