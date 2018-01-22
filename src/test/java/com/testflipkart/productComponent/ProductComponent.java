package com.testflipkart.productComponent;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductComponent extends QAFWebComponent {
	
	public ProductComponent(String locator)
	{
		super(locator);
	}

	@FindBy(locator ="searchresultpage.productname.lnk")
	private QAFWebElement searchresultpageproductnamelnk;
	
	@FindBy(locator="searchresultpage.productprice.lnk")
	private QAFWebElement searchresultpageproductpricelnk;
	
	@FindBy(locator="searchresultpage.productratings.lnk")
	private QAFWebElement searchresultpageproductratingslnk;
	
	@FindBy(locator="searchresultpage.productratingscount.lnk")
	private QAFWebElement searchresultpageproductratingscountlnk;
	
	public QAFWebElement getSearchresultpageproductratingscountlnk() {
		return searchresultpageproductratingscountlnk;
	}

	public QAFWebElement getSearchresultpageproductratingslnk() {
		return searchresultpageproductratingslnk;
	}

	public QAFWebElement getsearchresultpageproductname() {
		return searchresultpageproductnamelnk;
	}

	public QAFWebElement getsearchresultpageproductprice() {
		return searchresultpageproductpricelnk;
	}
	
}
