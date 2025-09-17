package testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AlertsPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_A2 extends BaseClass {

	@Test
	public void confirmAlertBtn() {
		logger.info("*** Starting TC_A2 ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickAlert();
		
		AlertsPage ap = new AlertsPage(driver);
		ap.selectAlert();
		ap.clickConfirmAlert();
		
		Alert myAlert = driver.switchTo().alert();
		myAlert.accept();
		
		logger.info("*** Verification for TC_A2 ***");
		Assert.assertEquals(ap.result(), "You selected Ok");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Testing Completed for TC_A2 ***");
	}
	
}
