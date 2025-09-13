package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ElementsPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_E3 extends BaseClass {

	@Test	
	public void selectRadio() {
		
		logger.info("*** Starting TC_E3 ***");
		
		HomePage hp = new HomePage(driver);
		hp.clickElement();
		
		ElementsPage ep = new ElementsPage(driver);
		ep.selectRadioBtn();
		ep.yes();
		
		logger.info("*** Verifying Radio Button Selection ***");
		Assert.assertEquals(true, ep.verifyRadioClick());
		
		logger.info("*** Completed Testing for TC_E3");
	}
}
