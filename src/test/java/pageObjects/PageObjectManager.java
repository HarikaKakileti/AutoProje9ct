package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LandingPage landingpage;
	public OffersPage offerspage;
	
	public CheckoutPage checkoutPage;
	public WebDriver driver;
	
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LandingPage getLandingPage()
	{
		landingpage=new LandingPage(driver);
		return landingpage;
	}
	
	
	public OffersPage getOffersPage()
	{
		offerspage=new OffersPage(driver);
		return offerspage;
	}
	
	public CheckoutPage getCheckoutPage()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
