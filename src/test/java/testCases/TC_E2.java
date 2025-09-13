package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ElementsPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_E2 extends BaseClass {
 
	@Test
	public void chkSelection() {
		logger.info("*** Starting TC_E2 ***");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickElement();
		
		ElementsPage ep = new ElementsPage(driver);
		
		ep.selectCheckBox();
		ep.clickChkBox();
		logger.info("*** Verifying Check Click ***");
		Assert.assertEquals(true, ep.verifyCheck());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Test Compeleted for TC_E2 ***");
	}
	
}
