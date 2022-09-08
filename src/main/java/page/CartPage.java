package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By productNameColumn = By.xpath("//th[contains(text(), 'Product')]");
    private final By addedToCartTShirt = By.xpath("//a[contains(text(), 'pink drop shoulder oversized t shirt - Pink')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean elementIsPresent() {
        scrollUnderElement(productNameColumn);
        return getElement(addedToCartTShirt).isDisplayed();
    }
}

