package com.testflipkart.resuableMethods;

import java.util.HashMap;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.testflipkart.flipkartBeanClasses.ProductInfoBean;

public class CommonUtils {
	
	public static void setProductItem(HashMap<String, ProductInfoBean>productList)
	{
		ConfigurationManager.getBundle().addProperty("product.information", productList);
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, ProductInfoBean> getProductItems()
	{
		HashMap<String,ProductInfoBean> productList;
		if(ConfigurationManager.getBundle().containsKey("product.information"))
		{
			productList=((HashMap<String,ProductInfoBean>)ConfigurationManager.getBundle().getProperty("product.information"));
		}
		else
		{
			productList=new HashMap<String,ProductInfoBean>();
			ConfigurationManager.getBundle().addProperty("product.information", productList);
		}
		return productList;
	}
	
	public static void swtichToWindow(QAFWebDriver driver)
	{
		for(String handle: driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
	}
}
