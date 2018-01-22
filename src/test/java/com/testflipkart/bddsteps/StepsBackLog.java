
package com.testflipkart.bddsteps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.testflipkart.pomClasses.FlipkarthomeTestPage1;
import com.testflipkart.pomClasses.ProductdetailsTestPage;
import com.testflipkart.pomClasses.SearchresultTestPage;
import com.testflipkart.pomClasses.SmartbandsTestPage;

public class StepsBackLog {

	FlipkarthomeTestPage1 flipkarthometestpage = new FlipkarthomeTestPage1();
	SmartbandsTestPage smartbandstestpage = new SmartbandsTestPage();
	SearchresultTestPage searchresulttestpage = new SearchresultTestPage();
	ProductdetailsTestPage productdetailstestpage = new ProductdetailsTestPage();

	@QAFTestStep(description = "user opens flipkart application")
	public void userOpensFlipkartApplication() {
		flipkarthometestpage.openApplication();
	}

	@QAFTestStep(description = "user gets the flipkart home page")
	public void userGetsTheFlipkartHomePage() {
		flipkarthometestpage.verifyFlipkartHomePage();
		flipkarthometestpage.closePopup();
	}

	@QAFTestStep(description = "user selects {0} from catogories")
	public void userSelectsFromCatogories(String category) {
		flipkarthometestpage.clickCategory(category);
	}

	@QAFTestStep(description = "user selects Smart Bands from the subcatogories")
	public void userSelectsSmartBandsFromTheSubcatogories() {
		flipkarthometestpage.clickSubCategory();
	}

	@QAFTestStep(description = "user gets the products page")
	public void userGetsTheProductsPage() {
		smartbandstestpage.verifySmartBandsTestPage();
	}

	@QAFTestStep(description = "user search for {0} in the products page")
	public void userSearchForInTheProductsPage(String brand) {
		smartbandstestpage.sendSearchItem(brand);
	}

	@QAFTestStep(description = "user selects {0} from the search list")
	public void userSelectsFromTheSearchList(String str) {
		smartbandstestpage.clickBrandCheckBox(str);
	}

	@QAFTestStep(description = "user gets the search result page")
	public void userGetsTheSearchResultPage() {
		searchresulttestpage.verifyProductList();
	}

	@QAFTestStep(description = "user selects {0} from the search result page")
	public void userSelectsFromTheSearchResultPage(String str0) {
		searchresulttestpage.selectProductByIndex(Integer.parseInt(str0));
	}

	@QAFTestStep(description = "user gets the product details page")
	public void userGetsTheProductDetailsPage() {
		productdetailstestpage.verifyProductDetailsPage();
	}

	@QAFTestStep(description = "user enter the mail address {0} in the email text box")
	public void userEnterTheMailAddressInTheEmailTextBox(String email) {
		productdetailstestpage.sendEmailId(email);
	}

	@QAFTestStep(description = "click on notify me button")
	public void clickOnNotifyMeButton() {
		productdetailstestpage.clickNotifyMe();
	}

	@QAFTestStep(description = "user should get the notification")
	public void userShouldGetTheNotification() {
		productdetailstestpage.verifyNotification();
	}

}
