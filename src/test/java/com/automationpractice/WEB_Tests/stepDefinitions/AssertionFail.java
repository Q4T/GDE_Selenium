package com.automationpractice.WEB_Tests.stepDefinitions;

//import static org.junit.Assert.fail;
import com.automationpractice.WEB_Tests.pages.*;
import com.automationpractice.WEB_Tests.utilities.Utilities;
import org.junit.Assert;

//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import pages.LoginPage;
//import pages.MyAccountPage;
//import pages.OrderHistoryPage;
//import pages.Toolbar;
//import utilities.DriverFactory;
//import utilities.Utilities;


public class AssertionFail {
	Utilities u;
	private LoginPage login;
	private Toolbar toolbar;
	private OrderHistoryPage orders;
	private String message = "This will cause the asertion to fail.";
	private boolean assertFlag;
	private MyAccountPage account;
	
	
	public  AssertionFail() {
//		driver = DriverFactory.getDriver();	
		if(u==null) {
			u = new Utilities(); 
			}
	}
	
	@Given("^there is an assertion fail$") 
	public void there_is_an_assertion_fail(){
		toolbar = u.getToolbar(toolbar);
		toolbar.ClickSignIn();
		login = u.getLoginPage(login);
		login.validLogin();
	}
	
	
	@When ("^the failure occurs$")
	public void the_failure_occurs() {
		account = u.getMyAccount(account);
		account.ClickOrderHistoryBttn();	
	}
		

	@Then ("^a screenshot is taken$")
	public void a_screenshot_is_taken() {
		orders = u.getOrderHistoryPage();
		Assert.fail();
	}
	
	
	
}
