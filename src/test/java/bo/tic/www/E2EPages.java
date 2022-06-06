package bo.tic.www;

import org.openqa.selenium.By;

import org.openqa.selenium.remote.RemoteWebDriver;

public class E2EPages extends Wrapper  {
	
	
	//pag1
	By homePageTypeaheadSearchLocator = By.id("react-select-homepageTypeaheadSearch-input");	
	By homePageDateRangePickerLocator = By.xpath("//*[@class='date-range-picker-wrapper pl-1 text-left pl-4 calendar-icon-only md-in-modal']");	
	By homePageDateRangeTodayLocator = By.xpath("//*[contains (@class,'picker_day_selectable_dates')]//*[contains (@class,'picker__day picker__day--infocus picker__day--today picker__day--highlighted')]");		
	By homePageDateRangeApplyDatesLocator = By.xpath("//*[@class='picker__box hover_active']//*[@data-automation='apply-dates']");
	By productPageTypeaheadSearchLocator = By.id("productName0");
	
	//pag2
	By experienceListPagePrductLocator = By.id("productName0");    
	By experienceListPageNumberOfTravelersLocator = By.xpath("//*[@aria-label='Number of travelers']");
	By experienceListPageTourGradeLocator = By.xpath("//*[@data-automation='tour-grade-1']");
	By experienceListPageTourGradeBuyLocator = By.xpath("//*[@data-automation='tour-grade-buy-now-button']");	
	
	//pag3
	By checkoutPagePrivacityAcceptButtonLocator 	= By.id("_evidon-accept-button");	
	By checkoutPageFirstNameLocator 				= By.id("itineraryDTO.itineraryItemDTOs[0].travelers[0].firstName");
	By checkoutPageLastNameLocator 					= By.id("itineraryDTO.itineraryItemDTOs[0].travelers[0].lastName");
	By checkoutPageTourLanguageLocator 				= By.id("tourLanguageOption-0");
	
	///credit card option
	By checkoutPageCreditCardOptionLocator 		= By.id("creditCardOption");
	By checkoutPageCreditButtonLocator 			= By.xpath("//*[@class='bookNow btn btn-secondary btn-lg btn-block col-12 mx-auto font-weight-semi-bold d-block']");
		
	//credit card	
	By checkoutPageCreditCardNumberLocator 			= By.xpath("//*[@id='creditCard']");
	By checkoutPageExpiryDateMonthLocator 			= By.xpath("//*[@id='expiryDateMonth']");
	By checkoutPageExpiryDateYearLocator 			= By.xpath("//*[@id='expiryDateYear']");	
	By checkoutPageSecurityCodeLocator 				= By.xpath("//*[@id='securityCode']");
	
	///paypal option card option
    By checkoutPagePaypalOptionLocator 				= By.id("paypalOption");	
    By checkoutPagePaypalButtonLocator 				= By.xpath("//*[contains(@class,'paypal-button-container paypal-button-layout-horizontal paypal-button-shape-rect paypal-button-number-single paypal-button-env-production')]");    
	By checkoutPageContactInfoEmailLocator			= By.id("contactInfoEmail");
	By checkoutPagePhoneNumberLocator 				= By.id("phoneNumber");
	
	//errors
	//input fields
	By checkoutPageFirstNameErrorLocator 				= By.xpath("//*[@class='parsley-required'and text()='Traveler first name is required.']");
	By checkoutPageLastNameErrorLocator  				= By.xpath("//*[@class='parsley-required'and text()='Traveler last name is required.']");	
	By checkoutPageEmailErrorLocator 					= By.xpath("//*[@class='parsley-required'and text()='Email address is required.']");
	By checkoutPagePhoneErrorLocator 					= By.xpath("//*[@class='parsley-required'and text()='Phone number is required.']");
	
	//Credict Card 
	By checkoutPageCreditCardFullnameErrorLocator 		= By.xpath("//*[@class='parsley-required'and text()='Credit card full name is required.']");
	By checkoutPageCreditcardCardNumberLocator 			= By.xpath("//*[@id='creditCardError' and text()='Enter a valid card number']");
    By checkoutPageSecurityCodeErrorLocator 			= By.xpath("//*[@id='securityCodeError' and text()='Enter a valid security code']");
	
		
	
	public E2EPages(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void searchExperience(String city) throws InterruptedException {		
		
		//pag1
		if(isDisplayed(homePageTypeaheadSearchLocator)) {
		
		type(city,homePageTypeaheadSearchLocator);
		Thread.sleep(1000);
		
		sendEnter(homePageTypeaheadSearchLocator);
		Thread.sleep(2000);
		
		click(homePageDateRangePickerLocator);
		Thread.sleep(1000);
		
		click(homePageDateRangeTodayLocator);
		Thread.sleep(1000);
		
		click(homePageDateRangeApplyDatesLocator);
		Thread.sleep(1000);
		}
		else {
			System.out.println("Page not found");
		}		
	
	}
	
public void chooseExperience() throws InterruptedException {		
		
	if(isDisplayed(experienceListPagePrductLocator)) {
		
		Thread.sleep(1000);	
		click(experienceListPagePrductLocator);
		Thread.sleep(1000);	
		
		chooseTab(1);
		Thread.sleep(1000);
		
		click(experienceListPageNumberOfTravelersLocator);
		Thread.sleep(1000);	
		
		nextActiveElemet (5);
		Thread.sleep(1000);		
		
		ClickActiveElemet();
		Thread.sleep(1000);
		
		click(experienceListPageTourGradeLocator);
		Thread.sleep(1000);
		
		click(experienceListPageTourGradeBuyLocator);
		Thread.sleep(3000);			
		
		}
		else {
			System.out.println("Page not found");
		}			
	
	}

public void verifyCreditCardMandatoryCheckOutInputFields() throws InterruptedException {	
	
	Thread.sleep(1000);
	click(checkoutPagePrivacityAcceptButtonLocator);
	Thread.sleep(1000);		
    
	click(checkoutPagePaypalOptionLocator);
	Thread.sleep(1000);		
	
	click(checkoutPageCreditCardOptionLocator);
	Thread.sleep(1000);	
	
	isDisplayed(checkoutPageFirstNameLocator);	 				
	isDisplayed(checkoutPageLastNameLocator);	 					
	isDisplayed(checkoutPageTourLanguageLocator);	 	

	isDisplayed(checkoutPageCreditCardOptionLocator);	
	isDisplayed(checkoutPagePaypalOptionLocator);
	isDisplayed(checkoutPageCreditButtonLocator);	 			
	
	isDisplayed(checkoutPageCreditCardNumberLocator);
	Thread.sleep(100);	
	
	//isDisplayed(checkoutPageExpiryDateMonthLocator);
	//Thread.sleep(100);	
	
	//isDisplayed(checkoutPageExpiryDateYearLocator);	
	//Thread.sleep(100);	
	
	//isDisplayed(checkoutPageSecurityCodeLocator);
	//Thread.sleep(100);	
		
	click(checkoutPageCreditButtonLocator);
	Thread.sleep(500);
	
	//ClickActiveElemet();
	Thread.sleep(1000);
	
	isDisplayed(checkoutPageFirstNameErrorLocator);			
	isDisplayed(checkoutPageLastNameErrorLocator);	
	isDisplayed(checkoutPageEmailErrorLocator);	 					
	isDisplayed(checkoutPagePhoneErrorLocator);				
	
	}
		

}
