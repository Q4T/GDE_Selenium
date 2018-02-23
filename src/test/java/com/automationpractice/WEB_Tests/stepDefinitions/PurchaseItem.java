package com.automationpractice.WEB_Tests.stepDefinitions;

import java.math.BigDecimal;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.automationpractice.WEB_Tests.data.GlobalData;
import com.automationpractice.WEB_Tests.pages.*;
import com.automationpractice.WEB_Tests.utilities.Utilities;


public class PurchaseItem{

	private Utilities u;
	private String url = GlobalData.URL;
	private String email = GlobalData.EMAIL;
	private String password = GlobalData.PASSWORD;
	private LandingPage land;
	private LoginPage login;
	private MyAccountPage myAccount;
	private WomenPage women;
	private QuickViewPage  quick;
	private CartInfo cartInfo;
	private String cost1;
	private String cost2;
	private String totalProducts;																																									
	private ShippingPage shipping;
	private AddressesPage addresses;
	private PaymentMethodPage payment;
	private OrderSummaryPage orderSummary;
	private OrderConfirmationPage	orderConfirmation;	
	private Cart cart;
	private String totalPrice;
	private Toolbar toolbar;
	private OrderHistoryPage orderHistory;
	private String dressSizeValue = "2"; 
	private String messageValue = "3";
	private String printedDressDetails = "Color : Orange, Size : M";	//trim out for just size if have time
	private String blouseDetails = "Color : Black, Size : S";			//trim out for just size if have time
	static String PURCHASE_DATE;
	private Scenario scenario;

	
	public PurchaseItem() {
		if(u==null) {
		u = new Utilities(); 
			}
	}
	
	@Before
	public void setUp() {
		u.TestSetUp();
	}
	
	@Given("^the user user is logged into the site$")
		public void the_user_user_is_logged_into_the_site() throws Throwable {		      	
		
			toolbar = u.getToolbar(toolbar);    
			toolbar.ClickSignIn();		
			login = u.getLoginPage(login);
			login.Login(email, password);
		}		
		
		@When("^the user changes the size of an item$")
		public void the_user_changes_the_size_of_an_item() throws Throwable {
			myAccount = u.getMyAccount(myAccount);
			myAccount.WaitForMyAccountPageToLoad();
			myAccount.ClickWomenButton();
			
			// select  a dress
			women = u.getWomenPage(women);
			women.selectStripedTopDress();
			
			// select item size
				quick = u.getQuickViewPage(quick);         
				quick.selectSize(dressSizeValue);
		}
		
		@When("^adds it to their basket$")
		public void adds_it_to_their_basket() throws Throwable {
			quick.AddItemToCart();
			cartInfo = u.getCartInfo(cartInfo);
			cartInfo.waitForPriceToLoad();
			cost1 = cartInfo.getPrice();
			cartInfo.ClickContinueShopping();
		}
		
		@And  ("^adds another item to the basket$")
		public void adds_another_item_to_the_basket()  throws Throwable{
			women.selectBlouse();
			quick.waitForQuickPagetoLoad();
			quick.switchToQuickViewFrame();
			quick.AddItemToCart();
			cartInfo.waitForPriceToLoad();
			cost2 = cartInfo.getPrice();
			cartInfo.waitForProceedBttn();
			cartInfo.ClickProceedBttn();
		}
		
		@Then ("^the sizes and cost calculations are correct$")
		public void the_sizes_and_cost_calculations_are_correct() throws Throwable {
			 Boolean figuresAreCorrect = false;
			 Boolean Prod1SizeIsCorrect = false;
			 Boolean prod2SizeIsCorrect = false;
			 cart = u.getCart(cart);
			 
//			 confirm that the items are of the size you selected
			 String details1 = cart.getProduct1Details();    
			 String details2 = cart.getProduct2Details();
			 Prod1SizeIsCorrect = details1.equalsIgnoreCase(printedDressDetails);
			 prod2SizeIsCorrect = details2.equalsIgnoreCase(blouseDetails);
			 Assert.assertTrue(Prod1SizeIsCorrect);
			 Assert.assertTrue(prod2SizeIsCorrect);
			 
//			 their prices are correct
			 String cartCost1 = cart.getProductOneCost();
			 boolean ProdCost1Compare = cart.compareProductDetails(cost1, cartCost1);
			 Assert.assertTrue(ProdCost1Compare);
			 
			 // compare item2 prices
			 String cartCost2 = cart.getProductTwoCost();
			 boolean ProdCost2Compare = cart.compareProductDetails(cost2, cartCost2);
			 Assert.assertTrue(ProdCost2Compare);
			 
//			 Total Products is the sum of the two items
			 totalProducts = cart.getTotalProducts();
			 BigDecimal SummedCosts = u.sumTwoDollarAmounts(cost1, cost2);
			 String strSummedCosts = SummedCosts.toString();
			 Boolean totalCostisCorrect = strSummedCosts.equalsIgnoreCase(totalProducts);
			 Assert.assertTrue(totalCostisCorrect);
			 
//			 ‘Total’ (subTotal) equals the Total Products + Shipping 
			 String subTotal = cart.getTotalPreTax();
			 String shipping = cart.getTotalShipping();
			 BigDecimal totalPlusShipping = u.sumTwoDollarAmounts(totalProducts, shipping);
			 String strTotalProductsPlusShipping = totalPlusShipping.toString();
			 Boolean subTotalEqualsProdusctsPlusShipping = strTotalProductsPlusShipping.equalsIgnoreCase(subTotal);
			 Assert.assertTrue(subTotalEqualsProdusctsPlusShipping);
			   								
		}
		
		@And  ("^the user can purchase the items$")
		public void the_user_can_purchase_the_items() {
		
				u.scrollDown();
				cart.clickProceedToCheckout();
				
				addresses = u.getAdressesPage(addresses);

				u.scrollToBottomofPage();
				addresses.clickProceedToCheckoutBttn();
			
				shipping = u.getShippingPage(shipping);

				u.scrollToBottomofPage();
				shipping.checkTermsOfService();
				shipping.clickProceedToCheckoutBttn();
				
				payment = u.getPaymentMethodPage(payment );
				payment.clickPaymentMethodPage();
						 
				orderSummary = u.getOrderSummaryPage(orderSummary);
				u.scrollToBottomofPage();
				orderSummary.clickconfirmOrderBttn();
				// capture date
				PURCHASE_DATE = u.getDate();				
				toolbar = u.getToolbar(toolbar);
				toolbar.ClickSignOut();
		}
		
		@After
		public void tearDown(Scenario scenario) {
		    if (scenario.isFailed()) {
		    	 WebDriver driver = PageBase.driver;
			      // Take a screenshot...
			      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			      scenario.embed(screenshot, "image/png");
		    }
		    u.testTearDown();
		}
}	
