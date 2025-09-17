package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AlertsPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_A4 extends BaseClass {

	@Test
	public void frame() {
		logger.info("*** Testing started for TC_A4 ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickAlert();
		
		AlertsPage ap = new AlertsPage(driver);
		ap.switchToFrame();
		
//		System.out.println(ap.resultFrames());
		logger.info("*** Verification for TC_A4 ***");
		Assert.assertEquals(ap.resultFrames(), "This is a sample page");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Testing completed for TC_A4 ***");
	}
}
