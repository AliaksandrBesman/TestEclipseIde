package page;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wait.CustomConditions;

public class OrderPage extends AbstractPage{
	@FindBy(className = "cart-form__total-box")
	private WebElement orderedItemsInfo;
	private static final String START_XPATH_ITEM_CONDITION = "//div[contains(@class, 'cart-form__total-box')]//div[contains(@class, 'cart-form__description-part_1') and contains(text(),'";
	private static final String END_XPATH_ITEM_CONDITION ="')]";
	
	public OrderPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean itemIsOrdered(String itemDescription )
	{
		new WebDriverWait(this.driver, Duration.ofSeconds(10)).until(CustomConditions.jQueryAJAXsCompleted());
		new WebDriverWait(this.driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(START_XPATH_ITEM_CONDITION + itemDescription + END_XPATH_ITEM_CONDITION )));
		return orderedItemsInfo.findElement(By.xpath(START_XPATH_ITEM_CONDITION + itemDescription + END_XPATH_ITEM_CONDITION )) == null ? false:true;
	}

	@Override
	protected AbstractPage openPage() {
		throw new RuntimeException("Please check your step twice");
	}

	@Override
	protected AbstractPage openPage(String params) {
		throw new RuntimeException("Please check your step twice");
	}
}
