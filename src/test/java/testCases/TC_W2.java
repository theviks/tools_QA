package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.WidgetsPage;
import testBase.BaseClass;

public class TC_W2 extends BaseClass {

	@Test
	public void sliderAction() {
		HomePage hp = new HomePage(driver);
		hp.clickWidge();
		WidgetsPage wp = new WidgetsPage(driver);
		wp.clickSlide();
		wp.moveSlider();
		
	}
}
