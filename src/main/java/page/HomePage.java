package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By tokyoTalkiesProduct = By.xpath("//a[contains(text(),'Tokyo Talkies')]");
    private final By addToWishlist = By.xpath("(//a[contains(@href, 'https://shop.demoqa.com/product/tokyo-talkies/')])[1]/following-sibling::div//div[contains(@class, 'yith-wcwl-add-button')]");
    private final By dismissButton = By.xpath("//a[contains(text(), 'Dismiss')]");
    private final By myWishlistButton = By.xpath("//a[contains(text(), 'My Wishlist')]");
    private final By productAdded = By.xpath("//div[contains(text(),'Product added!')]");
    private final By pinkDropShoulderOversizeTShortProduct = By.xpath("//a[contains(text(), 'pink drop shoulder oversized t shirt')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickDismissButton() {
        clickOnVisibleElement(dismissButton, 10);
    }

    @Step
    public void addToFavorite() {
        scrollToElement(tokyoTalkiesProduct);
        hoverVisibleElement(tokyoTalkiesProduct, 10);
        clickOnVisibleElement(addToWishlist, 10);
        waitForElementVisibility(productAdded, 10);
    }

    @Step
    public void openMyWishlist() {
        clickOnVisibleElement(myWishlistButton, 10);
    }

    @Step
    public void openProduct() {
        scrollToElement(pinkDropShoulderOversizeTShortProduct);
        clickOnVisibleElement(pinkDropShoulderOversizeTShortProduct, 10);
    }
}
