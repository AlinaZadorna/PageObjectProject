import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @Test
    public void addToCart() {
        open("https://demo.nopcommerce.com/build-your-own-computer");
        $(By.id("product_attribute_2")).selectOption("8GB [+$60.00]");
        $(By.id("product_attribute_3_6")).click();
        $(By.id("product_attribute_4_8")).click();
        $(By.id("add-to-cart-button-1")).click();
        $(By.xpath("//a[contains(text(),'shopping cart')]")).click();

        $(By.xpath("(//div[contains(@class,'attributes')])[2]")).shouldHave(Condition.text("RAM: 8GB"));
        $(By.xpath("(//div[contains(@class,'attributes')])[2]")).shouldHave(Condition.text("HDD: 320 GB"));
    }
}
