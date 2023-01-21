package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import wait.CustomConditions;

public class PhonePage extends AbstractPage {
	private static final String FIRST_URL_PATH = "https://catalog.onliner.by/mobile/";
	@FindBy(className = "product-aside__offers-list")
	private WebElement shopsList;
	private String url;
	
	public PhonePage( WebDriver driver ) {
		super(driver);

	}

	public OrderPage BuyPhoneByShop(String shopKey) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//div/a[@data-shop-id='" + shopKey + "'][1]")));
		return new OrderPage(this.driver);
	}
	@Override
	protected AbstractPage openPage() {
		throw new RuntimeException("Please check your step twice");
	}

	public PhonePage openPage(String params) {
		this.url = FIRST_URL_PATH + params;
		driver.get(url);
		new WebDriverWait(this.driver, Duration.ofSeconds(10)).until(CustomConditions.jQueryAJAXsCompleted());
		return this;
	}
	
}
