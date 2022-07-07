package testSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalculatorPage;
import pages.HomePage;

import java.time.Duration;

public class CalculatePriceTest {
    private HomePage homePage;
    private CalculatorPage calculatorPage;
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver3.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://xtm.cloud/");
    }

    @Test
    public void cacluclateAccountCost() {
        homePage = new HomePage(driver);
        homePage.dealWithCookies();
        homePage.openCalculator();
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.switchToFrame();
        calculatorPage.selectAccountType();
        calculatorPage.selectNumberOfUsers();
        calculatorPage.selectSubscriptionLenght();
        calculatorPage.waitTillPriceBeAvailable();
        String priceInPounds = calculatorPage.getPriceValue();
        calculatorPage.switchtoDolar();
        System.out.println(calculatorPage.getPriceValue() + " > $");
        calculatorPage.switchtoEuro();
        System.out.println(calculatorPage.getPriceValue() + " > €");
        Assert.assertEquals("Price not expected", "£1 164,00", priceInPounds);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

}
