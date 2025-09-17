package testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AlertsPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_A3 extends BaseClass {

	@Test
	public void promtAlertBtn() {
		logger.info("*** Starting TC_A2 ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickAlert();
		
		AlertsPage ap = new AlertsPage(driver);
		ap.selectAlert();
		ap.clickPromptAlert();
		
		Alert myAlert = driver.switchTo().alert();
		String s = "john";
		myAlert.sendKeys(s);
		myAlert.accept();
		
		logger.info("*** Verification for TC_A2 ***");
		Assert.assertEquals(ap.resultPrompt(), "You entered "+s);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Testing Completed for TC_A2 ***");
	}
	
}
