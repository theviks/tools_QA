package testCases;

import org.testng.annotations.Test;

import pageObject.FormsPages;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_E4 extends BaseClass{

	@Test
	public void formsPages() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clickForms();
		
		FormsPages fp = new FormsPages(driver);
		fp.selectPractice();
		fp.userFirstName("John");
		fp.userLastName("terac");
		fp.userEmail("johmterac@gmail.com");
		fp.radSelect();
		fp.phoneNo("9874563210");
		fp.dateOfBirth();
		fp.dobMonth("July");
		fp.dobYear("2001");
		fp.dateSelect("13");
		fp.subjectSelection("Maths");
		
	}
}
