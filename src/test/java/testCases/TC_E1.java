package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ElementsPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_E1 extends BaseClass {

	@Test(priority=0)
	public void textSelection() throws InterruptedException {
		logger.info("*** Starting TC-E1 ***");
		
		try {
		HomePage hp = new HomePage(driver);
		logger.info("*** clicking elements on Home page ***");
//		Thread.sleep(5000);
		hp.clickElement();
		
		ElementsPage ep = new ElementsPage(driver);
		logger.info("*** Selecting TextBox ***");
		//TextBox
		ep.selectTextBox();
		ep.selectUsrName("peter");
		ep.selectUsrEmail("peter@hotmail.com");
		ep.selectCurrAddress("Toronto");
		ep.selectPerAddress("Toronto");
		ep.submitBt();
		
		logger.info("*** Verifying Submition ***");
		Assert.assertEquals(true, ep.verifySubmit());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Testing for TC_E1 Completed ");
	}
}

