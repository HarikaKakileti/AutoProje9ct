package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	By Search = By.xpath("//input[@class='search-keyword']");
	By productName = By.cssSelector("h4.product-name");
	By topdeals = By.linkText("Top Deals");
	By increment = By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String name) {
		driver.findElement(Search).sendKeys(name);
	}

	public void getSearchText() {
		driver.findElement(Search).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void selectTopDealsPage() {
		driver.findElement(topdeals).click();
	}

	public String getTitleLandingPage() {
		return driver.getTitle();
	}

	public void incrementQuantity(int quantity) {
		int i = quantity - 1;
		while (i > 0) {
			driver.findElement(increment).click();
			i--;
		}

	}

	public void addToCart() {
		driver.findElement(addToCart).click();
	}

}
