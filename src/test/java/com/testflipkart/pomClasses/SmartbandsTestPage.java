package com.testflipkart.pomClasses;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class SmartbandsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "smartbandspage.search.txt")
	private QAFWebElement smartbandspageSearchTxt;
	@FindBy(locator = "smartbands.brand.chkbx")
	private QAFWebElement smartbandsBrandChkbx;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSmartbandspageSearchTxt() {
		return smartbandspageSearchTxt;
	}

	public QAFWebElement getSmartbandsBrandChkbx() {
		return smartbandsBrandChkbx;
	}
	
	public void verifySmartBandsTestPage()
	{
		
	}
	
	public void sendSearchItem(String item)
	{
		getSmartbandspageSearchTxt().waitForVisible();
		getSmartbandspageSearchTxt().sendKeys(item);
		
	}
	
	public void clickBrandCheckBox(String brand)
	{
		QAFExtendedWebElement clickBrand=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("smartbands.brand.chkbx"), brand));
		clickBrand.waitForVisible();
		clickBrand.click();
		Validator.verifyThat("Verify SamrtBands Page", driver.getTitle(),Matchers.containsString("Smart Band - Buy Products Online at Best Price in India | Flipkart.com"));
	}

}
