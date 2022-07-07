package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private final WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[@class='pricing-iframe']")
    WebElement pricingFrame;
    @FindBy(xpath = "//select[@name='accountType']")
    WebElement drpdwnAccountType;
    @FindBy(xpath = "//select[@name='subscriptionLength']")
    WebElement drpdwnDuration;
    @FindBy(xpath = "//select[@name='numberOfUsers']")
    WebElement drpdwnNumerOfUsers;
    @FindBy(xpath = "//div[@class='total-cost']/p/span")
    WebElement totalCostValue;
    @FindBy(xpath = "//label[@for='USD']")
    WebElement bttnDolar;
    @FindBy(xpath = "//label[@for='EUR']")
    WebElement bttnEuro;

    public void switchToFrame() {
        driver.switchTo().frame(pricingFrame);
    }

    public void selectAccountType() {
        Select select = new Select(drpdwnAccountType);
        select.selectByValue("LSP");
    }

    public void selectSubscriptionLenght() {
        Select select = new Select(drpdwnDuration);
        select.selectByValue("3");
    }

    public void selectNumberOfUsers() {
        Select select = new Select(drpdwnNumerOfUsers);
        select.selectByValue("7");
    }

    public void waitTillPriceBeAvailable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(totalCostValue, "£1 164,00"));
    }

    public String getPriceValue() {
        return totalCostValue.getText();
    }

    public void switchtoDolar() {
        bttnDolar.click();
    }

    public void switchtoEuro() {
        bttnEuro.click();
    }
}
