package com.testflipkart.pomClasses;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.testflipkart.flipkartBeanClasses.ProductInfoBean;
import com.testflipkart.productComponent.ProductComponent;
import com.testflipkart.resuableMethods.CommonUtils;

public class SearchresultTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "searchresultpage.productdetails.lnk")
	private List<ProductComponent> searchresultpageProductdetailsLnk;
	
	@FindBy(locator = "searchresultpage.sortbylowtohigh.lnk")
	private QAFWebElement searchresultpagesortbylowtohighlnk;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<ProductComponent> getSearchresultpageProductdetailsLnk() {
		return searchresultpageProductdetailsLnk;
	}
	
	public QAFWebElement getSearchresultpageSortByPriceLowToHighLnk() {
		return searchresultpagesortbylowtohighlnk;
	}
	
	public void verifyProductList()
	{
		Validator.verifyThat(getSearchresultpageProductdetailsLnk().size(),Matchers.greaterThan(0));
		getSearchresultpageProductdetailsLnk().get(1).waitForVisible();
			
	}
	
	public void selectProductName(int index)
	{
		ProductInfoBean productinfobean=new ProductInfoBean();
		productinfobean.setProductName(getSearchresultpageProductdetailsLnk().get(index).getsearchresultpageproductname().getText());
		productinfobean.setProductPrice(getSearchresultpageProductdetailsLnk().get(index).getsearchresultpageproductprice().getText());
//		productinfobean.setProductRating(getSearchresultpageProductdetailsLnk().get(index).getSearchresultpageproductratingslnk().getText());
//		productinfobean.setProductRatingsCount(getSearchresultpageProductdetailsLnk().get(index).getSearchresultpageproductratingscountlnk().getText().replace("(", "").replace(")", "").trim());
		HashMap<String,ProductInfoBean>productInfo=new HashMap<String,ProductInfoBean>();
		productInfo.put(productinfobean.productName, productinfobean);
		
		getSearchresultpageProductdetailsLnk().get(index).getsearchresultpageproductname().click();
		CommonUtils.setProductItem(productInfo);
		QAFTestBase.pause(3000);
	}
	
	public void selectProductByIndex(int index) {
		selectProductName((index-1));
	}
	
	public void verifySortedByPrice()
	{
		TreeSet<String> tree=new TreeSet<String>();
		QAFTestBase.pause(4000);
		for(int i=0;i<getSearchresultpageProductdetailsLnk().size();i++)
		{
			getSearchresultpageProductdetailsLnk().get(i).getsearchresultpageproductprice().waitForVisible();
			String str=getSearchresultpageProductdetailsLnk().get(i).getsearchresultpageproductprice().getText();
			String price=(str.substring(1,str.length()));
			tree.add(price);
			Reporter.log("Sorted price is "+tree.first(),true);
		}
//		Iterator<String> itr=tree.iterator();
//		while ( itr.hasNext() )
//		{
//		  System.out.println( itr.next());
//		  
//		}
		Validator.verifyThat("Price is sorted",getSearchresultpageProductdetailsLnk().get(0).getsearchresultpageproductprice().getText(),Matchers.containsString((tree.first())));
	}
	
	public void clickSortByPriceLowToHigh()
	{
		getSearchresultpageSortByPriceLowToHighLnk().waitForVisible();
		getSearchresultpageSortByPriceLowToHighLnk().click();
	}
	
	
}
