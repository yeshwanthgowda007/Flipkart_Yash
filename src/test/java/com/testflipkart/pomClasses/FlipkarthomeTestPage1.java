package com.testflipkart.pomClasses;

import org.hamcrest.Matchers;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FlipkarthomeTestPage1 extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "flipkarthomepage.category.lnk")
	private QAFWebElement flipkartHomepageCategoryLnk;
	@FindBy(locator = "flipkarthomepage.subcategory.lnk")
	private QAFWebElement flipkartHomepageSubCategoryLnk;
	@FindBy(locator = "flipkarthomepage.popup.btn")
	private QAFWebElement flipkartHomepagepopupbtn;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getFlipkartHomepageLnkCategory() {
		return flipkartHomepageCategoryLnk;
	}

	public QAFWebElement getFlipkartHomepageLnkSubCategory() {
		return flipkartHomepageSubCategoryLnk;
	}
	
	public void clickCategory(String menuName)
	{
		driver.manage().window().maximize();
		QAFExtendedWebElement categoryName=new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("flipkarthomepage.category.lnk"),menuName));
		categoryName.waitForVisible();

		Actions action=new Actions(driver);
		action.moveToElement(categoryName).perform();
	}
	
	public void clickSubCategory()
	{
		getFlipkartHomepageLnkSubCategory().waitForVisible();
		getFlipkartHomepageLnkSubCategory().click();
	}
	
	public void openApplication()
	{
		driver.get("/");
	}
	
	public void verifyFlipkartHomePage()
	{
		Validator.verifyThat("Flipkart Home Page verification", driver.getTitle(), Matchers.containsString("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More"));
	}
	
	public void closePopup()
	{
		try
		{
			flipkartHomepagepopupbtn.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
