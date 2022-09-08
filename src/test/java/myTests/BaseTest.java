package myTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        setWebDriver(webDriver);
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void killDriver(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("*****Taking Screenshot on failure****");
            saveScreenshotPNG();
        }
        getWebDriver().quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Step("{0}")
    public void log(String message) {
        System.out.println(message);
        saveScreenshotPNG();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
