package com.testflipkart.pomClasses;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;
import com.testflipkart.flipkartBeanClasses.ProductInfoBean;
import com.testflipkart.productComponent.ProductComponent;
import com.testflipkart.resuableMethods.CommonUtils;

public class AddtocartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "addtocart.productdetails.lnk")
	private List<ProductComponent> addtocartProductdetailsLnk;


	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<ProductComponent> getAddtocartProductdetailsLnk() {
		return addtocartProductdetailsLnk;
	}
	
	public void verifyProductAddToCart()
    {
		getAddtocartProductdetailsLnk().get(0).waitForVisible();
        Validator.verifyThat(getAddtocartProductdetailsLnk().size(),Matchers.greaterThan(0));
        HashMap<String, ProductInfoBean> productInfo3 = CommonUtils.getProductItems();
        for(String key: productInfo3.keySet())
        {
            ProductInfoBean productDetails = productInfo3.get(key);
            
            for(ProductComponent ProductComponent: getAddtocartProductdetailsLnk())
            {
            	Validator.verifyThat(ProductComponent.getsearchresultpageproductname().getText(),Matchers.containsString(productDetails.getProductName()));
                Validator.verifyThat(ProductComponent.getsearchresultpageproductprice().getText(), Matchers.containsString(productDetails.getProductPrice()));
            }
        }
                    
    }
	
	
}
