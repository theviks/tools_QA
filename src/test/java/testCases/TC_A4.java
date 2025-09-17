package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AlertsPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_A4 extends BaseClass {

	@Test
	public void frame() {
		HomePage hp = new HomePage(driver);
		hp.clickAlert();
		
		AlertsPage ap = new AlertsPage(driver);
		ap.switchToFrame();
		
		Assert.assertEquals(ap.resultFrames(), "This is a sample page");
	}
}
