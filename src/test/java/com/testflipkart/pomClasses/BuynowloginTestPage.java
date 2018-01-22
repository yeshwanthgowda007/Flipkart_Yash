package com.testflipkart.pomClasses;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class BuynowloginTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "buynowlogin.emial.txt")
	private QAFWebElement buynowloginEmialTxt;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getBuynowloginEmialTxt() {
		return buynowloginEmialTxt;
	}
	
	public void verifybuynowpage()
	{
		getBuynowloginEmialTxt().waitForVisible();
		getBuynowloginEmialTxt().verifyVisible();
		Validator.verifyThat("Buy now page verification", driver.getTitle(),Matchers.containsString("Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order"));
	}

}
