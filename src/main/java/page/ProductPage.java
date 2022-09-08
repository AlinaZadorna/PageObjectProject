package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private final By colorDropdown = By.id("pa_color");
    private final By sizeDropdown = By.id("pa_size");
    private final By productQuantitySelector = By.xpath("//span[contains(text(), 'QTY')]");
    private final By plusIcon = By.xpath("//i[contains(@class, 'icon_plus')]");
    private final By addToCartButton = By.xpath("//button[contains(text(), 'Add to cart')]");
    private final By cartIcon = By.xpath("//i[contains(@class, 'icon_bag_alt')]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void changeProductColor() {
        scrollToElement(colorDropdown);
        selectDropdownOption(colorDropdown, "Pink");
    }

    @Step
    public void changeProductSize() {
        scrollToElement(sizeDropdown);
        selectDropdownOption(sizeDropdown, "37");
    }

    @Step
    public void changeProductQuantity() {
        scrollToElement(productQuantitySelector);
        clickElement(plusIcon);
        clickElement(plusIcon);
    }

    @Step
    public void addToCart() {
        clickElement(addToCartButton);
    }

    @Step
    public void openCart() {
        clickOnVisibleElement(cartIcon, 10);
    }
}
