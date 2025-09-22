package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.WidgetsPage;
import testBase.BaseClass;

public class TC_W2 extends BaseClass {

	@Test
	public void sliderAction() {
		logger.info("*** Starting TC_W2 ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickWidge();
		WidgetsPage wp = new WidgetsPage(driver);
		wp.clickSlide();
		wp.moveSlider();
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Completed TC_W2 ***");
	}
}
