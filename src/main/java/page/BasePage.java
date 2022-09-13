package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void clickElement(By locator) {
        getElement(locator).click();
    }

    public void waitForElementVisibility(By locator, int time) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(time));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickOnVisibleElement(By locator, int time) {
        waitForElementVisibility(locator, time);
        clickElement(locator);
    }

    public void hoverVisibleElement(By locator, int time) {
        waitForElementVisibility(locator, time);
        Actions action = new Actions(driver);
        action.moveToElement(getElement(locator)).perform();
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void scrollUnderElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void selectDropdownOption(By locator, String text) {
        Select drpUserName = new Select(getElement(locator));
        drpUserName.selectByVisibleText(text);
    }
}
