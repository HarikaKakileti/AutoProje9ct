package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPagestepDefinition {
	public TestContextSetup testContextSetup;
	public String offerPageProductName;

	public OfferPagestepDefinition(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;

	}

	@Then("^user searched with same shortname (.+) in offers page$")
	public void user_searched_with_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		switchtoOfferspage();
		
		//OffersPage offerspage=new OffersPage(testContextSetup.driver);
		OffersPage offerspage =testContextSetup.pageObjectManager.getOffersPage();
		offerspage.searchItem(shortName);
		
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		//offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		offerPageProductName=offerspage.getProductName();
		System.out.println(offerPageProductName + "is extracted from offers page");
	}

	

	public void switchtoOfferspage() {
	//	if(	testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"));
		
		//LandingPage landingpage= new LandingPage(testContextSetup.driver);
		LandingPage landingpage=testContextSetup.pageObjectManager.getLandingPage();
		landingpage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowtochild();
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		//Set<String> s1 = testContextSetup.driver.getWindowHandles();
		//Iterator<String> it = s1.iterator();
		//String parentwindow = it.next();

		//String childwindow = it.next();
		//testContextSetup.driver.switchTo().window(childwindow);
	}

	@Then("validate the product name in offers page  matches  with landing page")
	public void validate_the_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.LandingPageproductName, offerPageProductName);
		
	}
}
