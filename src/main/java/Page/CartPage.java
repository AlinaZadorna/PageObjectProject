package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By ProductNameColumn = By.xpath("//th[contains(text(), 'Product')]");
    private final By addedToCartTShirt = By.xpath("//a[contains(text(), 'pink drop shoulder oversized t shirt - Pink')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean elementIsPresent() {
        scrollUnderElement(ProductNameColumn);
        return getElement(addedToCartTShirt).isDisplayed();
    }
}

