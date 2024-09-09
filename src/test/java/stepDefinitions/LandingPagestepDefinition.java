package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPagestepDefinition {
	public WebDriver driver;
	public String LandingPageproductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public LandingPage landingPage;

	public LandingPagestepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("user is on greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		//testContextSetup.driver = new ChromeDriver();
		 

		//testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

	}

	@When("^user searched with shortname (.+) and extracted actual  name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		// LandingPage landingpage = new LandingPage(testContextSetup.driver);
		//PageObjectManager pageObjectManager = new PageObjectManager(testContextSetup.driver);
		
		landingPage.searchItem(shortName);
		// testContextSetup.driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(shortName);
		// testContextSetup.LandingPageproductName =
		// testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText()
		// .split("_")[0].trim();
		Thread.sleep(2000);
		testContextSetup.LandingPageproductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.LandingPageproductName + "is extracted from home page");
		
	}
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
	


}
