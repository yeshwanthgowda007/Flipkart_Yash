package com.testflipkart.scripts;

import org.testng.annotations.Test;

import com.testflipkart.pomClasses.FlipkarthomeTestPage1;
import com.testflipkart.pomClasses.ProductdetailsTestPage;
import com.testflipkart.pomClasses.SearchresultTestPage;
import com.testflipkart.pomClasses.SmartbandsTestPage;

public class FlipKartOrderVerificationTestPage {
	
	@Test
	public void verifyOrder()
	{
		FlipkarthomeTestPage1 flipkarthometestpage=new FlipkarthomeTestPage1();
		flipkarthometestpage.openApplication();
		flipkarthometestpage.verifyFlipkartHomePage();
		flipkarthometestpage.closePopup();
		flipkarthometestpage.clickCategory("Men");
		flipkarthometestpage.clickSubCategory();
		
		SmartbandsTestPage smartbandstestpage=new SmartbandsTestPage();
		smartbandstestpage.verifySmartBandsTestPage();
		smartbandstestpage.sendSearchItem("Mi");
		smartbandstestpage.clickBrandCheckBox("Mi");
		
		SearchresultTestPage searchresulttestpage=new SearchresultTestPage();
//		searchresulttestpage.clickSortByPriceLowToHigh();
//		searchresulttestpage.verifySortByLowToHigh(0);
		searchresulttestpage.selectProductByIndex(1);
		searchresulttestpage.verifyProductList();
		
		
		ProductdetailsTestPage productdetailstestpage=new ProductdetailsTestPage();
		productdetailstestpage.verifyProductDetailsPage();
		productdetailstestpage.addProductIfAvailOrNotifyMe("abc123@gmail.com");
		
				
//		productdetailstestpage.sendEmailId("abc123@gmail.com");
//		productdetailstestpage.clickNotifyMe();
//		productdetailstestpage.verifyNotification();
		
	}
}
