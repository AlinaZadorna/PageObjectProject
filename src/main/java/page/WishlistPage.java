package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {

    private final By tableColumnProductName = By.xpath("//span[contains(text(), 'Product name')]");
    private final By addedToWishlistTokyoTalkiesProduct = By.xpath("//a[contains(text(), 'Tokyo Talkies')]");

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean elementIsPresent() {
        scrollUnderElement(tableColumnProductName);
        return getElement(addedToWishlistTokyoTalkiesProduct).isDisplayed();
    }
}
