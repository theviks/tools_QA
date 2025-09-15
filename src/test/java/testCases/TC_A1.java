package testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AlertsPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_A1 extends BaseClass {

	@Test
	public void alertTesting() {
		logger.info("*** Starting TC_A1 ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickAlert();
		
		AlertsPage ap = new AlertsPage(driver);
		ap.selectAlert();
		ap.clickAlertBrtn();
		
		Alert myAlert = driver.switchTo().alert();
		
		logger.info("*** Verification TC_A1 alert appers with correct message ***");
		Assert.assertEquals(myAlert.getText(), "You clicked a button");
		myAlert.accept();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		logger.info("*** Testing for TC_A1 Completed ***");
		
	}
}
