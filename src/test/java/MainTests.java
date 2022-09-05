import Page.CartPage;
import Page.HomePage;
import Page.ProductPage;
import Page.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTests extends BaseTest {

//    B) в задании использовать паттерн page object
//1. Open shop.demoqa.com
//2. Favorite Tokyo-Talkies (Add to Wishlist)
//3. Open wishlist
//4. Verify that Tokyo-Talkies is present in wishlist

    @Test
    public void addingToWishlist() {
        webDriver.get("https://shop.demoqa.com/");
        HomePage homePage = new HomePage(webDriver);
        homePage.clickDismissButton();
        homePage.addToFavorite();
        homePage.openMyWishlist();

        WishlistPage wishlistPage = new WishlistPage(webDriver);
        Assert.assertTrue(wishlistPage.elementIsPresent());
    }

    //    C) в задании использовать паттерн page object
//1. Open shop.demoqa.com
//2. Choose “PINK DROP SHOULDER OVERSIZED T SHIRT”
//3. Change Color to Pink
//4. Change size to 37
//5. Change quantity to 3
//6. Add to cart
//7. Navigate to cart and verify that product present in cart

    @Test
    public void correctProductAddedToCart() {
        webDriver.get("https://shop.demoqa.com/");
        HomePage homePage = new HomePage(webDriver);
        ProductPage productPage = new ProductPage(webDriver);
        homePage.openProduct();
        productPage.changeProductColor();
        productPage.changeProductSize();
        productPage.changeProductQuantity();
        productPage.addToCart();
        productPage.openCart();

        CartPage cartPage = new CartPage(webDriver);
        Assert.assertTrue(cartPage.elementIsPresent());
    }
}
