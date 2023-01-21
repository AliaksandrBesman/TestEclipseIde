package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparingPage extends AbstractPage {
	private static final String FIRST_URL_PATH = "https://catalog.onliner.by/compare/";
	private WebElement removingItemButton;
	private String url;
	
	public ComparingPage(WebDriver driver) {
		super(driver);
	}
		
	public ComparingPage removeItemFromComparingList(String itemKey) {
		removingItemButton =driver.findElement(By.xpath("//th/div/a[@data-key='" + itemKey + "']"));
		removingItemButton.click();
		return this;
	}

@Override
protected AbstractPage openPage() {
	throw new RuntimeException("Please check your step twice");
}

public ComparingPage openPage(String params) {
	this.url = FIRST_URL_PATH + params;
	driver.get(url);
	return this;
}
}
