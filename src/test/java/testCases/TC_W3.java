package testCases;

import java.util.List;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.WidgetsPage;
import testBase.BaseClass;

public class TC_W3 extends BaseClass {

	@Test
	public void autoComplete(){
		logger.info("*** Starting TC_W3 ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickWidge();
		WidgetsPage wp = new WidgetsPage(driver);
		wp.clickAutoComplete();
		//For Passing colors in input method used array
		String[] myArr = {"green","blue","red"};
		wp.inputs(myArr);
		List<String> allColors = wp.verifyAutoComp();
		System.out.println(allColors);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		logger.info("*** Completed TC_W3 ***");
	}
}
