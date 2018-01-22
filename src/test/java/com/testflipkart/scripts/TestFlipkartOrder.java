package com.testflipkart.scripts;

import org.testng.annotations.Test;

import com.testflipkart.pomClasses.FlipkarthomeTestPage1;
import com.testflipkart.pomClasses.ProductdetailsTestPage;
import com.testflipkart.pomClasses.SearchresultTestPage;
import com.testflipkart.pomClasses.SmartbandsTestPage;

public class TestFlipkartOrder {
	
	@Test
	public void verifyOrder1()
	{
		FlipkarthomeTestPage1 flipkarthometestpage=new FlipkarthomeTestPage1();
		flipkarthometestpage.openApplication();
		flipkarthometestpage.verifyFlipkartHomePage();
		flipkarthometestpage.closePopup();
		flipkarthometestpage.clickCategory("Men");
		flipkarthometestpage.clickSubCategory();
		
		SmartbandsTestPage smartbandstestpage=new SmartbandsTestPage();
		smartbandstestpage.verifySmartBandsTestPage();
//		smartbandstestpage.sendSearchItem("Mi");
//		smartbandstestpage.clickBrandCheckBox("Mi");
		
		SearchresultTestPage searchresulttestpage=new SearchresultTestPage();
		searchresulttestpage.clickSortByPriceLowToHigh();
		searchresulttestpage.verifySortedByPrice();
		searchresulttestpage.verifyProductList();
		searchresulttestpage.selectProductByIndex(1);
		
		
		ProductdetailsTestPage productdetailstestpage=new ProductdetailsTestPage();
		productdetailstestpage.verifyProductDetailsPage();
		productdetailstestpage.addProductIfAvailOrNotifyMe("abc123@gmail.com");
	}

}
