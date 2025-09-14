package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.FormsPages;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_F1 extends BaseClass{

	@Test
	public void formsPages() throws InterruptedException {
		try {
			logger.info("*** Starting Test TC_E4 ***");	
		HomePage hp = new HomePage(driver);
		hp.clickForms();
		
		FormsPages fp = new FormsPages(driver);
		fp.selectPractice();
		fp.userName("John","terac");
		fp.userEmail("johmterac@gmail.com");
		fp.gender();
		fp.phoneNo("9874563210");
		fp.dateOfBirth("July", "2001", "13");
		fp.subjectSelection("Maths");
		fp.hobbies();
		fp.address("India","Uttar Pradesh","Agra");
		fp.submit();
		logger.info("*** Verifying for TC_E4 Success ***");
		Assert.assertEquals(true, fp.verifySubmition());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Testing for TC_E4 Completed ***");
	}
}
