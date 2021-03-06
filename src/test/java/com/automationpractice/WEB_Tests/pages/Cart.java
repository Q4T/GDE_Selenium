package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.automationpractice.WEB_Tests.utilities.Utilities;

public class Cart extends PageBase {
	Utilities u;
	String cellContents;

	private By totalProducts = By.xpath("//tfoot/tr/td[3]");										
	private By totalShipping = By.xpath("//tfoot/tr[3]/td[2]");
	private By totalPreTax = By.xpath("//tfoot/tr[5]/td[2]");
	private By totalTax = By.xpath("//tfoot/tr[6]/td[2]");
	private By grandTotal = By.xpath("//tfoot/tr[7]/td[2]/span");
	private By TotalCost = By.cssSelector("td[id='total_product']");
	private By cartCost1 = By.xpath("//tbody/tr[1]/td[4]/span/span");
	private By cartCost2 = By.xpath("//tbody/tr[2]/td[4]/span/span");
	private By cartProductSize1  = By.xpath("//tbody/tr[1]/td[2]//small[2]/a");
	private By cartProductSize2 =  By.xpath("//tbody/tr[2]/td[2]//small[2]/a");
	private By proceedToCheckoutBttn = By.cssSelector("a[class='button btn btn-default standard-checkout button-medium']");

	public Cart () {
		if(u==null) {
			u = new Utilities();
		}
	}
	
	public void clickProceedToCheckout() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("javascript:window.scrollBy(0,600)");
		System.out.println("scrolled down");
		u.waitTillElementVisible(proceedToCheckoutBttn, 20);
		WebElement proceed = driver.findElement(proceedToCheckoutBttn);
		proceed.click();
	}
	
	public String getTotalPrice() {
		WebElement cost = driver.findElement(TotalCost);
		String Totalprice = cost.getText();
		return Totalprice;		
	}
	
	public void waitForPageToLoad() {
		u.waitTillElementVisible(TotalCost, 30);
	}
	
	
	public String getProduct1Details() {      
		String prod1Details = driver.findElement(cartProductSize1).getText();
		return prod1Details;
	}
	
	public String getProduct2Details() {      
		String prod2Details = driver.findElement(cartProductSize2).getText();
		return prod2Details;
	}
	
	public Boolean compareProductDetails(String expectedText, String capturedText ) {
		String exp = expectedText;
		String cap = capturedText;
		Boolean txtAreTheSame = false;
		
		
		System.out.println("expected txt is "+exp);
		txtAreTheSame = cap.equalsIgnoreCase(exp);               

		return txtAreTheSame;
		
	}
	
	public String CaptureProductDetails(By locator) {     
		By loc = locator;
		WebElement element = driver.findElement(loc);
		String capturedText = element.getText();
		return capturedText;
	}
	
	
	public String getProductOneCost() {
		return CaptureProductDetails (cartCost1);
	}
		
		public String getProductTwoCost() {
			return CaptureProductDetails (cartCost2);
	}
	
	public String getTotalShipping() {
		return CaptureProductDetails (totalShipping);
	}
			
	public String getTotalProducts() {
		 String value = CaptureProductDetails (totalProducts);
		value = u.removeDollarSign(value); 
		return value;
	}
	
	public String getTotalPreTax() {
		String value = CaptureProductDetails (totalPreTax);
		value = u.removeDollarSign(value);
		return value;
	}
	
	public String getTax() {
		return CaptureProductDetails (totalTax);	}
	
	
	public String getGrandTotal() {
		return CaptureProductDetails (grandTotal);
	}	
}
