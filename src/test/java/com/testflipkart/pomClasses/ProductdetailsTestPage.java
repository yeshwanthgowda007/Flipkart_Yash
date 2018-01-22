package com.testflipkart.pomClasses;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.testflipkart.flipkartBeanClasses.ProductInfoBean;
import com.testflipkart.resuableMethods.CommonUtils;

public class ProductdetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "productdetailspage.productname.lnk")
	private QAFWebElement productdetailspageProductnameLnk;
	@FindBy(locator = "productdetailspage.productprice.lnk")
	private QAFWebElement productdetailspageProductpriceLnk;
	@FindBy(locator = "productdetailspage.productratings.lnk")
	private QAFWebElement productdetailspageProductratingsLnk;
	@FindBy(locator = "productdetailspage.productraingscount.lnk")
	private QAFWebElement productdetailspageProductraingscountLnk;
	@FindBy(locator = "productdetailspage.notification.lnk")
	private QAFWebElement productdetailspagenotificationLnk;
	@FindBy(locator = "productdetailspage.email.txt")
	private QAFWebElement productdetailspageemailLnk;
	@FindBy(locator = "productdetailspage.notifyme.btn")
	private QAFWebElement productdetailspagenotifymebtn;
	@FindBy(locator = "productdetailspage.addtocart.btn")
	private QAFWebElement productdetailspageaddtocartbtn;
	
	@FindBy(locator = "productdetailspage.sizeregular.lnk")
	private QAFWebElement productdetailspagesizebtn;
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getProductdetailspageProductnameLnk() {
		return productdetailspageProductnameLnk;
	}
	
	public QAFWebElement getProductdetailspageProductpriceLnk() {
		return productdetailspageProductpriceLnk;
	}

	public QAFWebElement getProductdetailspageProductratingsLnk() {
		return productdetailspageProductratingsLnk;
	}

	public QAFWebElement getProductdetailspageProductraingscountLnk() {
		return productdetailspageProductraingscountLnk;
	}
	
	public QAFWebElement getProductdetailspagenotificationLnk() {
		return productdetailspagenotificationLnk;
	}
	
	public QAFWebElement getProductdetailspagemailLnk() {
		return productdetailspageemailLnk;
	}
	
	public QAFWebElement getProductdetailspagenotifyme() {
		return productdetailspagenotifymebtn;
	}
	
	public QAFWebElement getProductdetailspageaddtocart() {
		return productdetailspageaddtocartbtn;
	}
	

	
	public QAFWebElement getProductdetailspagesizebtn() {
		return productdetailspagesizebtn;
	}
	
	public void verifyProductDetailsPage()
	{
		if(driver.getWindowHandles().size()>1)
		{
			CommonUtils.swtichToWindow(driver);
		}
		getProductdetailspageProductnameLnk().waitForVisible();
		HashMap<String,ProductInfoBean>productInfo2=CommonUtils.getProductItems();
		for(String key: productInfo2.keySet())
		{
			ProductInfoBean details=productInfo2.get(key);
			
			Validator.verifyThat(getProductdetailspageProductnameLnk().getText(), Matchers.containsString(details.getProductName()));
			Validator.verifyThat(getProductdetailspageProductpriceLnk().getText(), Matchers.containsString(details.getProductPrice()));
//			Validator.verifyThat(getProductdetailspageProductraingscountLnk().getText(), Matchers.containsString(details.getProductRatingsCount()));
//			Validator.verifyThat(getProductdetailspageProductratingsLnk().getText(), Matchers.containsString(details.getProductRating()));
		}
	}
	
	public void addToCart() {
		getProductdetailspageaddtocart().click();
	}
	
	public void clickSize()
	{
		try
		{
			getProductdetailspagesizebtn().click();
		}
		catch(Exception e)
		{
			
		}
	}
	

	public void addProductIfAvailOrNotifyMe(String email) {
		if(email!=null || !(email.isEmpty()))
		{
			if(getProductdetailspagenotifyme().isPresent()&&getProductdetailspagenotifyme().isDisplayed()) {
				sendEmailId(email);
				clickNotifyMe();
				verifyNotification();
			}
		else {
				
				clickSize();
				addToCart();
				AddtocartTestPage addtocarttestpage=new AddtocartTestPage();
				addtocarttestpage.verifyProductAddToCart();
			}
		}
	}
	
	public void sendEmailId(String email)
	{
		getProductdetailspagemailLnk().sendKeys(email);
	}
	
	public void clickNotifyMe()
	{
		getProductdetailspagenotifyme().click();
	}
	
	public void verifyNotification()
	{
		getProductdetailspagenotificationLnk().waitForVisible();
		getProductdetailspagenotificationLnk().verifyVisible();
		if(getProductdetailspagenotificationLnk().isDisplayed())
		{
			Reporter.log("notification message is displayed",true);
		}
		else
		{
			Reporter.log("notification message is not displayed",true);
		}
	}

}
