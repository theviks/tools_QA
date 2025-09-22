package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.WidgetsPage;
import testBase.BaseClass;

public class TC_W4 extends BaseClass {

	@Test
	public void progressBar(){
		logger.info("*** Testing Begin for TC_W4 ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickWidge();
		
		WidgetsPage wp = new WidgetsPage(driver);
		wp.clickPgBar();
		wp.clickStart();
		Assert.assertEquals(wp.verifyPb(), "100%");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Testing Completed for TC_W4 ***");
	}
}
